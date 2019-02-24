package schr0.damascus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDamascusFireball extends EntityFireball
{

	private static final float SIZE_WIDTH = 0.5F;
	private static final float SIZE_HEIGHT = 0.5F;
	private static final int LIFE_TIME_LIMIT = (10 * 20);

	private static final String TAG = DamascusMob.MOD_ID + ".";
	private static final String TAG_LIFE_TIME = TAG + "life_time";

	private static final DataParameter<Integer> LIFE_TIME = EntityDataManager.<Integer> createKey(EntityDamascusFireball.class, DataSerializers.VARINT);

	public EntityDamascusFireball(World worldIn)
	{
		super(worldIn);

		this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
	}

	public EntityDamascusFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
	{
		super(worldIn, shooter, accelX, accelY, accelZ);

		this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
	}

	public EntityDamascusFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
	{
		super(worldIn, x, y, z, accelX, accelY, accelZ);

		this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
	}

	public EntityDamascusFireball(World worldIn, EntityLivingBase shootingEntity, double x, double y, double z, double accelX, double accelY, double accelZ)
	{
		this(worldIn, x, y, z, accelX, accelY, accelZ);

		this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
		this.shootingEntity = shootingEntity;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.getDataManager().register(LIFE_TIME, Integer.valueOf(0));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);

		compound.setInteger(TAG_LIFE_TIME, this.getLifeTime());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);

		this.setLifeTime(compound.getInteger(TAG_LIFE_TIME));
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return false;
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		return false;
	}

	@Override
	protected boolean isFireballFiery()
	{
		return false;
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		this.growLifeTime(1);

		if (LIFE_TIME_LIMIT < this.getLifeTime())
		{
			this.onImpact(new RayTraceResult(this));
		}
	}

	@Override
	protected void onImpact(RayTraceResult result)
	{
		if (this.world.isRemote)
		{
			return;
		}

		this.world.newExplosion(this, this.posX, this.posY, this.posZ, 2.5F, true, false);

		this.spawnEntityMiasma();

		this.setDead();
	}

	// TODO /* ======================================== DATAMANAGER START =====================================*/

	public int getLifeTime()
	{
		return ((Integer) this.getDataManager().get(LIFE_TIME)).intValue();
	}

	protected void setLifeTime(int amount)
	{
		amount = Math.max(amount, 0);

		this.getDataManager().set(LIFE_TIME, amount);
	}

	public void growLifeTime(int amount)
	{
		this.setLifeTime(this.getLifeTime() + amount);
	}

	// TODO /* ======================================== MOD START =====================================*/

	private void spawnEntityMiasma()
	{
		EntityDamascusMiasma entityDamascusMiasma = new EntityDamascusMiasma(this.world, this.posX, this.posY, this.posZ, this.shootingEntity);

		BlockPos spawnBlockPos = BlockPos.ORIGIN;
		double rangeOrigin = 0;

		for (EntityLivingBase aroundEntityLivingBase : this.world.<EntityLivingBase> getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().grow(4.0D, 4.0D, 4.0D)))
		{
			double range = this.getDistanceSq(aroundEntityLivingBase);

			if ((range < rangeOrigin) || (rangeOrigin == 0))
			{
				rangeOrigin = range;

				spawnBlockPos = aroundEntityLivingBase.getPosition();
			}
		}

		if (spawnBlockPos != BlockPos.ORIGIN)
		{
			entityDamascusMiasma.setPosition(spawnBlockPos.getX(), spawnBlockPos.getY(), spawnBlockPos.getZ());
		}

		this.world.spawnEntity(entityDamascusMiasma);
	}

}

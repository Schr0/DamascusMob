package schr0.damascus;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fml.common.FMLLog;

public class EntityDamascus extends EntityTameable implements IDamascusMob, IRangedAttackMob, IJumpingMount
{

	private static final float SIZE_WIDTH = 1.5F;
	private static final float SIZE_HEIGHT = 2.5F;
	private static final double ENTITY_HEALTH = 200.0D;
	private static final double ENTITY_MOVEMENT_SPEED = 0.25D;
	private static final double ENTITY_ATTACK_DAMAGE = 8.0D;
	private static final int LIMIT_HUNGER_AMOUNT = 64;
	private static final int LIMIT_ANGER_AMOUNT = 20;
	private static final int LIMIT_SLEEP_TIMER = ((1 * 60) * 20);
	private static final int LIMIT_ROAR_TIMER = (10 * 20);
	private static final int LIMIT_COOLDOWN_TIMER = ((1 * 60) * 20);
	private static final int LIMIT_EMPTY_SHELL_DAMAGE = 5;

	private static final DataParameter<Byte> ACTION_STATUS = EntityDataManager.<Byte> createKey(EntityDamascus.class, DataSerializers.BYTE);
	private static final DataParameter<Byte> ATTACK_TYPE = EntityDataManager.<Byte> createKey(EntityDamascus.class, DataSerializers.BYTE);
	private static final DataParameter<Integer> ANGER_AMOUNT = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> HUNGER_AMOUNT = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> SLEEP_TIMER = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> ROAR_TIMER = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> COOLDOWN_TIMER = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);
	private static final DataParameter<Byte> EMPTY_SHELL = EntityDataManager.<Byte> createKey(EntityDamascus.class, DataSerializers.BYTE);
	private static final DataParameter<Integer> EMPTY_SHELL_DAMAGE = EntityDataManager.<Integer> createKey(EntityDamascus.class, DataSerializers.VARINT);

	private static final String TAG = DamascusMob.MOD_ID + ".";
	private static final String TAG_ANGER_AMOUNT = TAG + "anger_amount";
	private static final String TAG_HUNGER_AMOUNT = TAG + "hunger_amount";
	private static final String TAG_SLEEP_TIMER = TAG + "sleep_timer";
	private static final String TAG_ROAR_TIMER = TAG + "roar_timer";
	private static final String TAG_COOLDOWN_TIMER = TAG + "cooldown_timer";
	private static final String TAG_EMPTY_SHELL = TAG + "empty_shell";
	private static final String TAG_EMPTY_SHELL_DAMAGE = TAG + "empty_shell_damage";

	private boolean isRidingJump;
	private float ridingJumpPower;

	public EntityDamascus(World worldIn)
	{
		super(worldIn);

		this.setSize(SIZE_WIDTH, SIZE_HEIGHT);
		this.setPathPriority(PathNodeType.WATER, -1.0F);
		this.setPathPriority(PathNodeType.LAVA, 8.0F);
		this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
		this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
		this.isImmuneToFire = true;
		this.stepHeight = 1.0F;
		this.onGround = true;
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();

		this.getDataManager().register(ACTION_STATUS, Byte.valueOf((byte) 0));
		this.getDataManager().register(ATTACK_TYPE, Byte.valueOf((byte) 0));
		this.getDataManager().register(ANGER_AMOUNT, Integer.valueOf(0));
		this.getDataManager().register(HUNGER_AMOUNT, Integer.valueOf(0));
		this.getDataManager().register(SLEEP_TIMER, Integer.valueOf(0));
		this.getDataManager().register(ROAR_TIMER, Integer.valueOf(0));
		this.getDataManager().register(COOLDOWN_TIMER, Integer.valueOf(0));
		this.getDataManager().register(EMPTY_SHELL, Byte.valueOf((byte) 0));
		this.getDataManager().register(EMPTY_SHELL_DAMAGE, Integer.valueOf(0));
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(ENTITY_HEALTH);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(ENTITY_MOVEMENT_SPEED);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(ENTITY_ATTACK_DAMAGE);
	}

	@Override
	protected void initEntityAI()
	{
		super.initEntityAI();

		EntityAIBase aiSwimming = new EntityDamascusAISwimming(this);
		EntityAIBase aiRoar = new EntityDamascusAIRoar(this);
		EntityAIBase aiAttack = new EntityDamascusAIAttack(this);
		EntityAIBase aiSleep = new EntityDamascusAISleep(this);
		EntityAIBase aiEat = new EntityDamascusAIEat(this);
		EntityAIBase aiWander = new EntityDamascusAIWander(this);
		EntityAIBase aiWatchClosest = new EntityDamascusAIWatchClosest(this);

		aiSwimming.setMutexBits(0);
		aiRoar.setMutexBits(1);
		aiAttack.setMutexBits(1);
		aiSleep.setMutexBits(1);
		aiEat.setMutexBits(1);
		aiWander.setMutexBits(1);
		aiWatchClosest.setMutexBits(1);

		this.tasks.addTask(1, aiSwimming);
		this.tasks.addTask(2, aiRoar);
		this.tasks.addTask(3, aiAttack);
		this.tasks.addTask(4, aiSleep);
		this.tasks.addTask(5, aiEat);
		this.tasks.addTask(6, aiWander);
		this.tasks.addTask(7, aiWatchClosest);

		this.targetTasks.addTask(1, new EntityDamascusAIHurtByTarget(this));
		// this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCow.class, false));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);

		compound.setInteger(TAG_ANGER_AMOUNT, this.getAngerAmount());
		compound.setInteger(TAG_HUNGER_AMOUNT, this.getHugerAmount());
		compound.setInteger(TAG_SLEEP_TIMER, this.getSleepTimer());
		compound.setInteger(TAG_ROAR_TIMER, this.getRoarTimer());
		compound.setInteger(TAG_COOLDOWN_TIMER, this.getCooldownTimer());
		compound.setBoolean(TAG_EMPTY_SHELL, this.isEmptyShell());
		compound.setInteger(TAG_EMPTY_SHELL_DAMAGE, this.getEmptyShellDamage());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);

		this.setAngerAmount(compound.getInteger(TAG_ANGER_AMOUNT));
		this.setHugerAmount(compound.getInteger(TAG_HUNGER_AMOUNT));
		this.setSleepTimer(compound.getInteger(TAG_SLEEP_TIMER));
		this.setRoarTimer(compound.getInteger(TAG_ROAR_TIMER));
		this.setCooldownTimer(compound.getInteger(TAG_COOLDOWN_TIMER));
		this.setEmptyShell(compound.getBoolean(TAG_EMPTY_SHELL));
		this.setEmptyShellDamage(compound.getInteger(TAG_EMPTY_SHELL_DAMAGE));
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.35F;
	}

	@Override
	protected float getSoundPitch()
	{
		return 0.35F;
	}

	@Override
	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_ENDERDRAGON_AMBIENT;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.ENTITY_POLAR_BEAR_HURT;
	}

	@Override
	protected SoundEvent getDeathSound()
	{
		return SoundEvents.ENTITY_POLAR_BEAR_DEATH;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_COW_STEP, 0.15F, 1.0F);
	}

	@Nullable
	protected ResourceLocation getLootTable()
	{
		return null;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable)
	{
		return null;
	}

	@Override
	public boolean isBreedingItem(ItemStack stack)
	{
		return false;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{
		// none
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		float amount = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

		if (entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), amount))
		{
			if (entityIn instanceof EntityLivingBase)
			{
				((EntityLivingBase) entityIn).knockBack(this, 2.0F, (double) MathHelper.sin(this.rotationYaw * 0.017453292F), (double) (-MathHelper.cos(this.rotationYaw * 0.017453292F)));

				entityIn.motionY += 1.25D;
			}
		}

		return true;
	}

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor)
	{
		this.faceEntity(target, 30.0F, 30.0F);

		Vec3d ownerLookVec = this.getLookVec();
		double spawnPosX = (this.posX + (ownerLookVec.x * 1.5D));
		double spawnPosY = ((this.posY + (this.height * 0.7F)) + (ownerLookVec.y * 1.5D));
		double spawnPosZ = (this.posZ + (ownerLookVec.z * 1.5D));
		double ownerVecX = (target.posX - this.posX);
		double ownerVecY = (target.posY - (this.posY + (double) (this.height / 2.0F)));
		double ownerVecZ = (target.posZ - this.posZ);
		double distanceSqrt = (double) MathHelper.sqrt(ownerVecX * ownerVecX + ownerVecY * ownerVecY + ownerVecZ * ownerVecZ);
		double accelerationX = (ownerVecX / distanceSqrt * 0.1D);
		double accelerationY = (ownerVecY / distanceSqrt * 0.1D);
		double accelerationZ = (ownerVecZ / distanceSqrt * 0.1D);

		EntityDamascusFireball entityDamascusFireball = new EntityDamascusFireball(this.world, this, spawnPosX, spawnPosY, spawnPosZ, accelerationX, accelerationY, accelerationZ);

		this.world.spawnEntity(entityDamascusFireball);

		this.world.playEvent((EntityPlayer) null, 1016, this.getPosition(), 0);
	}

	@Override
	public void setSwingingArms(boolean swingingArms)
	{
		// none
	}

	@Override
	public boolean isEntityInvulnerable(DamageSource source)
	{
		return (super.isEntityInvulnerable(source) || source.isExplosion() || (this.getActionStatus() == ActionStatus.ROAR));
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isEmptyShell())
		{
			this.growEmptyShellDamage(1);

			for (int k = 0; k < 20; ++k)
			{
				double d2 = this.rand.nextGaussian() * 0.02D;
				double d0 = this.rand.nextGaussian() * 0.02D;
				double d1 = this.rand.nextGaussian() * 0.02D;
				this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, this.posY + (double) (this.rand.nextFloat() * this.height), this.posZ + (double) (this.rand.nextFloat() * this.width * 2.0F) - (double) this.width, d2, d0, d1);
			}

			if (this.isEmptyShellBreak() && !this.world.isRemote)
			{
				this.setDead();
			}

			return false;
		}

		this.growAngerAmount((int) amount);

		return super.attackEntityFrom(source, amount);
	}

	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio)
	{
		// none
	}

	@Override
	public boolean isSitting()
	{
		return false;
	}

	@Override
	public void setSitting(boolean sitting)
	{
		// none
	}

	@Override
	public boolean isOwner(EntityLivingBase entityIn)
	{
		if (!(entityIn instanceof EntityPlayer))
		{
			return false;
		}

		EntityPlayer entityPlayer = (EntityPlayer) entityIn;
		UUID uuid = entityPlayer.getUniqueID();
		UUID uuidOwner = this.getOwnerId();

		if ((uuid != null && uuidOwner != null) && uuid.equals(uuidOwner))
		{
			return true;
		}

		return false;
	}

	@Override
	public double getMountedYOffset()
	{
		return ((double) this.height * 0.60D);
	}

	@Override
	@Nullable
	public Entity getControllingPassenger()
	{
		if (this.getPassengers().isEmpty())
		{
			return (Entity) null;
		}

		return (Entity) this.getPassengers().get(0);
	}

	@Override
	public boolean canBeSteered()
	{
		if (this.getControllingPassenger() instanceof EntityLivingBase)
		{
			return this.isOwner((EntityLivingBase) this.getControllingPassenger());
		}

		return false;
	}

	@Override
	public void setJumpPower(int jumpPowerIn)
	{
		if (jumpPowerIn < 0)
		{
			jumpPowerIn = 0;
		}

		if (90 <= jumpPowerIn)
		{
			this.ridingJumpPower = 1.0F;
		}
		else
		{
			this.ridingJumpPower = 0.4F + (0.4F * (float) jumpPowerIn / 90.0F);
		}
	}

	@Override
	public boolean canJump()
	{
		return true;
	}

	@Override
	public void handleStartJump(int p_184775_1_)
	{
		// none
	}

	@Override
	public void handleStopJump()
	{
		// none
	}

	@Override
	public void travel(float strafe, float vertical, float forward)
	{
		if (this.isRaidingOnwer())
		{
			EntityLivingBase entitylivingbase = (EntityLivingBase) this.getControllingPassenger();
			this.rotationYaw = entitylivingbase.rotationYaw;
			this.prevRotationYaw = this.rotationYaw;
			this.rotationPitch = (entitylivingbase.rotationPitch * 0.5F);
			this.setRotation(this.rotationYaw, this.rotationPitch);
			this.renderYawOffset = this.rotationYaw;
			this.rotationYawHead = this.renderYawOffset;
			strafe = (entitylivingbase.moveStrafing * 0.5F);
			forward = entitylivingbase.moveForward;

			if (forward <= 0.0F)
			{
				forward *= 0.25F;
			}

			if ((0.0F < this.ridingJumpPower) && !this.isRidingJump && this.onGround)
			{
				this.motionY = (1.0D * (double) this.ridingJumpPower);

				if (this.isPotionActive(MobEffects.JUMP_BOOST))
				{
					this.motionY += (double) ((float) (this.getActivePotionEffect(MobEffects.JUMP_BOOST).getAmplifier() + 1) * 0.1F);
				}

				this.isRidingJump = true;
				this.isAirBorne = true;

				if (forward > 0.0F)
				{
					float f = MathHelper.sin(this.rotationYaw * 0.017453292F);
					float f1 = MathHelper.cos(this.rotationYaw * 0.017453292F);
					this.motionX += (double) (-0.4F * f * this.ridingJumpPower);
					this.motionZ += (double) (0.4F * f1 * this.ridingJumpPower);
				}

				this.ridingJumpPower = 0.0F;
			}

			this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

			if (this.canPassengerSteer())
			{
				this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());

				super.travel(strafe, vertical, forward);
			}
			else if (entitylivingbase instanceof EntityPlayer)
			{
				this.motionX = 0.0D;
				this.motionY = 0.0D;
				this.motionZ = 0.0D;
			}

			if (this.onGround)
			{
				this.ridingJumpPower = 0.0F;
				this.isRidingJump = false;
			}

			this.prevLimbSwingAmount = this.limbSwingAmount;
			double d1 = (this.posX - this.prevPosX);
			double d0 = (this.posZ - this.prevPosZ);
			float f2 = (MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F);

			if (1.0F < f2)
			{
				f2 = 1.0F;
			}

			this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		else
		{
			this.jumpMovementFactor = 0.02F;
			super.travel(strafe, vertical, forward);
		}
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		if ((hand == EnumHand.OFF_HAND) || this.isAnger() || this.isEmptyShell() || (this.getActionStatus() == ActionStatus.ATTACK) || (this.getActionStatus() == ActionStatus.SLEEP) || (this.getActionStatus() == ActionStatus.EAT))
		{
			return false;
		}

		boolean isServerWorld = !this.getEntityWorld().isRemote;
		ItemStack stackHeldItem = player.getHeldItem(hand);

		if (this.isTamed())
		{
			if (!this.isOwner(player))
			{
				return false;
			}

			player.rotationYaw = this.rotationYaw;
			player.rotationPitch = this.rotationPitch;

			if (isServerWorld)
			{
				this.isJumping = false;
				this.navigator.clearPath();
				player.startRiding(this);
			}

			return true;
		}
		else
		{
			if (isServerWorld)
			{
				if (stackHeldItem.getItem() instanceof ItemBlock)
				{
					ItemBlock itemBlock = (ItemBlock) stackHeldItem.getItem();
					EatableOre eatableBlockOre = EatableOre.byBlock(itemBlock.getBlock());

					if (eatableBlockOre != EatableOre.NONE)
					{
						boolean success = (this.getRNG().nextInt(18 - eatableBlockOre.getFoodLevel()) == 0);

						this.growHugerAmount(eatableBlockOre.getFoodLevel());

						if (success && !ForgeEventFactory.onAnimalTame(this, player))
						{
							this.setTamedBy(player);
							this.navigator.clearPath();
							this.playTameEffect(true);
							this.world.setEntityState(this, (byte) 7);
						}
						else
						{
							this.playTameEffect(false);
							this.world.setEntityState(this, (byte) 6);
						}
					}
				}
			}

			return true;
		}
	}

	@Override
	public void updatePassenger(Entity passenger)
	{
		super.updatePassenger(passenger);

		if (this.isNotControlling())
		{
			passenger.dismountRidingEntity();
		}
	}

	@Override
	protected void updateLeashedState()
	{
		super.updateLeashedState();

		if (this.isNotControlling())
		{
			this.clearLeashed(true, true);
		}
	}

	@Override
	public void onLivingUpdate()
	{
		if (this.isEmptyShell())
		{
			this.rotationYaw = this.prevRotationYaw;
			this.rotationPitch = this.prevRotationPitch;
		}

		super.onLivingUpdate();

		if (!this.onGround && (this.motionY < 0.0D))
		{
			this.motionY *= 0.5D;
		}

		if (!this.getEntityWorld().isRemote)
		{
			FMLLog.info("Status : %d", this.getActionStatus().getNumber());

			if (this.isAnger())
			{
				if (this.getAttackTarget() != null)
				{
					this.startCooldownTimer();
				}
				else
				{
					if (this.isCooldownTime())
					{
						this.shrinkCooldownTimer(1);
					}
					else
					{
						this.resetAngerAmount();
					}
				}

				DamascusMobParticles.spawnParticleAngerAura(this);
			}

			if (this.isFlying())
			{
				if (this.ticksExisted % 10 == 0)
				{
					this.playSound(SoundEvents.ENTITY_ENDERDRAGON_FLAP, 0.25F, 1.0F);
				}
			}

			if (this.isOwnerAttacking())
			{
				DamascusMobParticles.spawnParticleRangedAttacking(this);
			}
		}
	}

	// TODO /* ======================================== DATAMANAGER START =====================================*/

	public ActionStatus getActionStatus()
	{
		int number = (int) this.getDataManager().get(ACTION_STATUS).byteValue();

		return ActionStatus.byNumber(number);
	}

	public void setActionStatus(ActionStatus actionStatus)
	{
		switch (actionStatus)
		{
			case SWIM :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.SWIM.getNumber()));

				break;

			case ROAR :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.ROAR.getNumber()));

				break;

			case SLEEP :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.SLEEP.getNumber()));

				break;
			case EAT :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.EAT.getNumber()));

				break;

			case ATTACK :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.ATTACK.getNumber()));

				break;

			case WONDER :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.WONDER.getNumber()));

				break;

			case WATCH_CLOSEST :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.WATCH_CLOSEST.getNumber()));

				break;

			default :

				this.getDataManager().set(ACTION_STATUS, Byte.valueOf((byte) actionStatus.IDLE.getNumber()));

				break;
		}
	}

	public AttackType getAttackType()
	{
		int number = (int) this.getDataManager().get(ATTACK_TYPE).byteValue();

		return AttackType.byNumber(number);
	}

	public void setAttackType(AttackType attackType)
	{
		switch (attackType)
		{
			case MELEE :

				this.getDataManager().set(ATTACK_TYPE, Byte.valueOf((byte) attackType.MELEE.getNumber()));

				break;

			default :

				this.getDataManager().set(ATTACK_TYPE, Byte.valueOf((byte) attackType.RANGED.getNumber()));

				break;
		}
	}

	public int getAngerAmount()
	{
		return ((Integer) this.getDataManager().get(ANGER_AMOUNT)).intValue();
	}

	protected void setAngerAmount(int amount)
	{
		amount = Math.max(amount, 0);

		if ((LIMIT_ANGER_AMOUNT <= amount) && !this.isAnger())
		{
			this.startRoarTimer();
			this.startCooldownTimer();
		}

		this.getDataManager().set(ANGER_AMOUNT, amount);
	}

	public boolean isAnger()
	{
		int amount = this.getAngerAmount();

		if (LIMIT_ANGER_AMOUNT <= amount)
		{
			return true;
		}

		return false;
	}

	public void growAngerAmount(int amount)
	{
		this.setAngerAmount(this.getAngerAmount() + amount);
	}

	public void resetAngerAmount()
	{
		this.setAngerAmount(0);
	}

	public int getHugerAmount()
	{
		return ((Integer) this.getDataManager().get(HUNGER_AMOUNT)).intValue();
	}

	protected void setHugerAmount(int amount)
	{
		amount = Math.max(amount, 0);

		if ((LIMIT_HUNGER_AMOUNT <= amount) && !this.isSatiety())
		{
			this.startSleepTimer();
		}

		this.getDataManager().set(HUNGER_AMOUNT, amount);
	}

	public boolean isSatiety()
	{
		int amount = this.getHugerAmount();

		if (LIMIT_HUNGER_AMOUNT <= amount)
		{
			return true;
		}

		return false;
	}

	public void growHugerAmount(int amount)
	{
		this.setHugerAmount(this.getHugerAmount() + amount);
	}

	public void resetHugerAmount()
	{
		this.setHugerAmount(0);
	}

	public int getSleepTimer()
	{
		return ((Integer) this.getDataManager().get(SLEEP_TIMER)).intValue();
	}

	protected void setSleepTimer(int amount)
	{
		amount = Math.max(amount, 0);

		this.getDataManager().set(SLEEP_TIMER, amount);
	}

	public boolean isSleepTime()
	{
		int amount = this.getSleepTimer();

		if (0 < amount)
		{
			return true;
		}

		return false;
	}

	public void startSleepTimer()
	{
		this.setSleepTimer(LIMIT_SLEEP_TIMER);
	}

	public void shrinkSleepTimer(int amount)
	{
		this.setSleepTimer(this.getSleepTimer() - amount);
	}

	public int getRoarTimer()
	{
		return ((Integer) this.getDataManager().get(ROAR_TIMER)).intValue();
	}

	protected void setRoarTimer(int amount)
	{
		amount = Math.max(amount, 0);

		this.getDataManager().set(ROAR_TIMER, amount);
	}

	public boolean isRoarTime()
	{
		int amount = this.getRoarTimer();

		if (0 < amount)
		{
			return true;
		}

		return false;
	}

	public void startRoarTimer()
	{
		this.setRoarTimer(LIMIT_ROAR_TIMER);
	}

	public void shrinkRoarTimer(int amount)
	{
		this.setRoarTimer(this.getRoarTimer() - amount);
	}

	public int getCooldownTimer()
	{
		return ((Integer) this.getDataManager().get(COOLDOWN_TIMER)).intValue();
	}

	protected void setCooldownTimer(int amount)
	{
		amount = Math.max(amount, 0);

		this.getDataManager().set(COOLDOWN_TIMER, amount);
	}

	public boolean isCooldownTime()
	{
		int amount = this.getCooldownTimer();

		if (0 < amount)
		{
			return true;
		}

		return false;
	}

	public void startCooldownTimer()
	{
		this.setCooldownTimer(LIMIT_COOLDOWN_TIMER);
	}

	public void shrinkCooldownTimer(int amount)
	{
		this.setCooldownTimer(this.getCooldownTimer() - amount);
	}

	public boolean isEmptyShell()
	{
		return (this.getDataManager().get(EMPTY_SHELL).byteValue() == 1);
	}

	public void setEmptyShell(boolean isEmptyShell)
	{
		byte b0 = ((Byte) this.getDataManager().get(EMPTY_SHELL)).byteValue();

		if (isEmptyShell)
		{
			this.getDataManager().set(EMPTY_SHELL, Byte.valueOf((byte) 1));
		}
		else
		{
			this.getDataManager().set(EMPTY_SHELL, Byte.valueOf((byte) 0));
		}
	}

	public EntityDamascus getEmptyShell()
	{
		EntityDamascus emptyShell = new EntityDamascus(this.getEntityWorld());

		emptyShell.setEmptyShell(true);
		emptyShell.setNoAI(true);
		emptyShell.setSilent(true);
		emptyShell.setPositionAndRotation(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);

		return emptyShell;
	}

	public int getEmptyShellDamage()
	{
		return this.getDataManager().get(EMPTY_SHELL_DAMAGE).byteValue();
	}

	public void setEmptyShellDamage(int amount)
	{
		amount = Math.max(amount, 0);

		this.getDataManager().set(EMPTY_SHELL_DAMAGE, amount);
	}

	public void growEmptyShellDamage(int amount)
	{
		this.setEmptyShellDamage((this.getEmptyShellDamage() + amount));
	}

	public boolean isEmptyShellBreak()
	{
		int amount = this.getEmptyShellDamage();

		if (LIMIT_EMPTY_SHELL_DAMAGE < amount)
		{
			return true;
		}

		return false;
	}

	// TODO /* ======================================== MOD START =====================================*/

	public boolean canBlockBeSeen(BlockPos pos)
	{
		World world = this.getEntityWorld();
		IBlockState state = world.getBlockState(pos);

		if (state == Blocks.AIR.getDefaultState())
		{
			return false;
		}

		Vec3d entityVec3d = new Vec3d(this.posX, this.posY + this.getEyeHeight(), this.posZ);
		Vec3d targetVec3d = new Vec3d(((double) pos.getX() + 0.5D), ((double) pos.getY() + (state.getCollisionBoundingBox(world, pos).minY + state.getCollisionBoundingBox(world, pos).maxY) * 0.9D), ((double) pos.getZ() + 0.5D));
		RayTraceResult rayTraceResult = world.rayTraceBlocks(entityVec3d, targetVec3d);

		if ((rayTraceResult != null) && (rayTraceResult.typeOfHit == RayTraceResult.Type.BLOCK))
		{
			if (rayTraceResult.getBlockPos().equals(pos))
			{
				return true;
			}
		}

		return false;
	}

	public boolean isRaidingOnwer()
	{
		return (this.isBeingRidden() && this.canBeSteered());
	}

	public boolean isFlying()
	{
		if (this.isSwimming())
		{
			return false;
		}

		return !this.onGround;
	}

	public boolean isSwimming()
	{
		double underGrowValue = -3.0D;
		double shrinkValue = 0.001D;

		if (this.world.handleMaterialAcceleration(this.getEntityBoundingBox().grow(0.0D, underGrowValue, 0.0D).shrink(shrinkValue), Material.WATER, this))
		{
			return true;
		}

		if (this.world.handleMaterialAcceleration(this.getEntityBoundingBox().grow(0.0D, underGrowValue, 0.0D).shrink(shrinkValue), Material.LAVA, this))
		{
			return true;
		}

		return (this.isInWater() || this.isInLava());
	}

	public boolean isNotControlling()
	{
		if (this.isAnger() || (this.getActionStatus() == ActionStatus.SLEEP))
		{
			return true;
		}

		return false;
	}

	public boolean isOwnerAttacking()
	{
		if (this.isRaidingOnwer())
		{
			return (this.getOwner().getActiveItemStack().getItem() == DamascusMobItems.DAMASCUS_ROD);
		}

		return false;
	}

	public void jumpBackwardTargetEntity(Entity target)
	{
		this.faceEntity(target, 30.0F, 30.0F);

		this.motionY += 0.15D;

		double ownerVecX = (target.posX - this.posX);
		double ownerVecY = (target.posY - (this.posY + (double) (this.height / 2.0F)));
		double ownerVecZ = (target.posZ - this.posZ);
		double distanceSqrt = (double) MathHelper.sqrt(ownerVecX * ownerVecX + ownerVecY * ownerVecY + ownerVecZ * ownerVecZ);
		double accelerationX = (ownerVecX / distanceSqrt * 0.1D);
		double accelerationY = (ownerVecY / distanceSqrt * 0.1D);
		double accelerationZ = (ownerVecZ / distanceSqrt * 0.1D);

		this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D, this.posZ);

		this.posX += this.motionX;
		this.posY += this.motionY;
		this.posZ += this.motionZ;
		ProjectileHelper.rotateTowardsMovement(this, 0.05F);

		this.motionX -= accelerationX;
		this.motionY -= accelerationY;
		this.motionZ -= accelerationZ;

		float speed = 8.0F;
		this.motionX *= (double) speed;
		this.motionY *= (double) speed;
		this.motionZ *= (double) speed;
		this.setPosition(this.posX, this.posY, this.posZ);
	}

}

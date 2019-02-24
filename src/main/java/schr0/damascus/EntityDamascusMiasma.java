package schr0.damascus;

import java.util.List;

import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityDamascusMiasma extends EntityAreaEffectCloud
{

	public EntityDamascusMiasma(World worldIn)
	{
		super(worldIn);

		int duration = (10 * 20);

		this.setColor(EnumDyeColor.PURPLE.getColorValue());
		this.setDuration(duration);
		this.setRadius(1.0F);
		this.setRadiusPerTick(0.025F);
		this.addEffect(new PotionEffect(MobEffects.SLOWNESS, duration, 0, false, false));
		this.addEffect(new PotionEffect(MobEffects.WEAKNESS, duration, 0, false, false));
		this.addEffect(new PotionEffect(MobEffects.MINING_FATIGUE, duration, 0, false, false));
		this.addEffect(new PotionEffect(MobEffects.HUNGER, duration, 0, false, false));
		this.addEffect(new PotionEffect(MobEffects.BLINDNESS, duration, 0, false, false));
		this.addEffect(new PotionEffect(MobEffects.NAUSEA, duration, 0, false, false));
	}

	public EntityDamascusMiasma(World worldIn, double x, double y, double z)
	{
		this(worldIn);

		this.setPosition(x, y, z);
	}

	public EntityDamascusMiasma(World worldIn, double x, double y, double z, EntityLivingBase owner)
	{
		this(worldIn, x, y, z);

		this.setOwner(owner);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		List<EntityLivingBase> list = this.world.<EntityLivingBase> getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox());

		for (EntityLivingBase aroundEntityLivingBase : list)
		{
			if (aroundEntityLivingBase instanceof IDamascusMob)
			{
				aroundEntityLivingBase.heal(0.1F);
			}
			else
			{
				aroundEntityLivingBase.attackEntityFrom(DamascusMobDamageSources.MIASMA, 1.0F);
			}
		}
	}

}

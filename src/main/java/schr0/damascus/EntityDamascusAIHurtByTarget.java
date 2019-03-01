package schr0.damascus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;

public class EntityDamascusAIHurtByTarget extends EntityAIHurtByTarget
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAIHurtByTarget(EntityDamascus entityDamascus)
	{
		super(entityDamascus, true, new Class[0]);

		this.entityDamascus = entityDamascus;
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.entityDamascus.isAnger())
		{
			return super.shouldExecute();
		}

		return false;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (this.entityDamascus.isAnger())
		{
			EntityLivingBase attackTarget = this.entityDamascus.getAttackTarget();

			if ((attackTarget != null) && attackTarget.isEntityAlive())
			{
				return true;
			}
		}

		return false;
	}

}

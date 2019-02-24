package schr0.damascus;

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

}

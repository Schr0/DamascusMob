package schr0.damascus;

import net.minecraft.entity.ai.EntityAIWanderAvoidWater;

public class EntityDamascusAIWander extends EntityAIWanderAvoidWater
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAIWander(EntityDamascus entityDamascus)
	{
		super(entityDamascus, 1.0D);

		this.entityDamascus = entityDamascus;
	}

	@Override
	public void resetTask()
	{
		super.resetTask();

		this.entityDamascus.setActionStatus(ActionStatus.IDLE);
	}

	@Override
	public void updateTask()
	{
		super.updateTask();

		this.entityDamascus.setActionStatus(ActionStatus.WONDER);
	}

}

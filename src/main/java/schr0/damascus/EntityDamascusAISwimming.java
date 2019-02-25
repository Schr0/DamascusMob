package schr0.damascus;

import net.minecraft.entity.ai.EntityAISwimming;

public class EntityDamascusAISwimming extends EntityAISwimming
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAISwimming(EntityDamascus entityDamascus)
	{
		super(entityDamascus);

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
		this.entityDamascus.setActionStatus(ActionStatus.SWIM);

		super.updateTask();
	}

}

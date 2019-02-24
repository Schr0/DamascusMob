package schr0.damascus;

public class EntityDamascusAISwimming extends EntityDamascusAI
{

	public EntityDamascusAISwimming(EntityDamascus entityDamascus)
	{
		super(entityDamascus);
	}

	@Override
	public boolean shouldExecute()
	{
		return this.getAIOwner().isSwimming();
	}

	@Override
	public void updateTask()
	{
		this.getAIOwner().setActionStatus(ActionStatus.SWIM);

		if (this.getAIOwner().getRNG().nextFloat() < 0.8F)
		{
			this.getAIOwner().getJumpHelper().setJumping();
		}
	}

}

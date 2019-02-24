package schr0.damascus;

public class EntityDamascusAIRoar extends EntityDamascusAI
{

	private final int TIME_START = (1 * 20);

	public EntityDamascusAIRoar(EntityDamascus entityDamascus)
	{
		super(entityDamascus);
	}

	@Override
	public boolean shouldExecute()
	{
		return this.getAIOwner().isRoarTime();
	}

	public void updateTask()
	{
		this.getAIOwner().setActionStatus(ActionStatus.ROAR);

		this.getAIOwner().shrinkRoarTimer(1);

		int roarTimer = this.getAIOwner().getRoarTimer();

		if (roarTimer == 20)
		{
			EntityDamascusMiasma entityDamascusMiasma = new EntityDamascusMiasma(this.getWorld(), this.getAIOwner().posX, this.getAIOwner().posY, this.getAIOwner().posZ, this.getAIOwner());

			this.getWorld().spawnEntity(entityDamascusMiasma);
		}

		if (TIME_START < roarTimer)
		{
			if (roarTimer % 10 == 0)
			{
				this.getAIOwner().playLivingSound();

				this.getWorld().newExplosion(this.getAIOwner(), this.getAIOwner().posX, this.getAIOwner().posY, this.getAIOwner().posZ, 2.5F, false, false);
			}
		}
	}

}

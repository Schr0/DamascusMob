package schr0.damascus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIWatchClosest;

public class EntityDamascusAIWatchClosest extends EntityAIWatchClosest
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAIWatchClosest(EntityDamascus entityDamascus)
	{
		super(entityDamascus, EntityLivingBase.class, 8.0F);

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

		this.entityDamascus.setActionStatus(ActionStatus.WATCH_CLOSEST);
	}

}

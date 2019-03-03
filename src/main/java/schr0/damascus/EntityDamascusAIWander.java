package schr0.damascus;

import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.util.math.Vec3d;

public class EntityDamascusAIWander extends EntityAIWanderAvoidWater
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAIWander(EntityDamascus entityDamascus)
	{
		super(entityDamascus, 1.0D);

		this.entityDamascus = entityDamascus;
		this.setExecutionChance(80);
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

		Vec3d vec3d = this.entityDamascus.getNavigator().getPath().getCurrentPos();

		if (vec3d != vec3d.ZERO)
		{
			this.entityDamascus.getLookHelper().setLookPosition(vec3d.x, vec3d.y, vec3d.z, (float) this.entityDamascus.getHorizontalFaceSpeed(), (float) this.entityDamascus.getVerticalFaceSpeed());
		}
	}

}

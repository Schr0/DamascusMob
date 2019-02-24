package schr0.damascus;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public abstract class EntityDamascusAI extends EntityAIBase
{

	private final EntityDamascus entityDamascus;

	public EntityDamascusAI(EntityDamascus entityDamascus)
	{
		this.entityDamascus = entityDamascus;
	}

	@Override
	public void startExecuting()
	{
		this.entityDamascus.getNavigator().clearPath();
		this.entityDamascus.setActionStatus(ActionStatus.IDLE);
	}

	@Override
	public void resetTask()
	{
		this.entityDamascus.getNavigator().clearPath();
		this.entityDamascus.setActionStatus(ActionStatus.IDLE);
	}

	// TODO /* ======================================== MOD START =====================================*/

	public EntityDamascus getAIOwner()
	{
		return this.entityDamascus;
	}

	public World getWorld()
	{
		return this.entityDamascus.getEntityWorld();
	}

	public double getMoveSpeed()
	{
		return 1.25D;
	}

	public Random getRandom()
	{
		return this.entityDamascus.getEntityWorld().rand;
	}

}

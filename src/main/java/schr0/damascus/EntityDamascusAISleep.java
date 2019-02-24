package schr0.damascus;

import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityDamascusAISleep extends EntityDamascusAI
{

	private static final double SEARCH_POS_XYZ = 8;
	private BlockPos targetBlockPos;

	public EntityDamascusAISleep(EntityDamascus entityDamascus)
	{
		super(entityDamascus);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.getAIOwner().isSleepTime())
		{
			this.targetBlockPos = this.getCanBeSleepBlockPos();

			if (this.targetBlockPos != BlockPos.ORIGIN)
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (this.getAIOwner().isSleepTime())
		{
			return this.isCanBeSleepBlock(this.targetBlockPos);
		}

		return false;
	}

	public void updateTask()
	{
		if (!this.isCanBeSleepBlock(this.targetBlockPos))
		{
			return;
		}

		if (this.isArrivalTargetBlockPos(this.targetBlockPos))
		{
			this.getAIOwner().setActionStatus(ActionStatus.SLEEP);

			this.getAIOwner().shrinkSleepTimer(1);

			if (!this.getAIOwner().isSleepTime())
			{
				this.getAIOwner().setActionStatus(ActionStatus.IDLE);

				// TODO

				return;
			}

			DamascusMobParticles.spawnParticleSleeping(this.getAIOwner());
		}
		else
		{
			this.getAIOwner().setActionStatus(ActionStatus.IDLE);

			BlockPos targetUpBlockPos = this.targetBlockPos.up();

			this.getAIOwner().getNavigator().tryMoveToXYZ(targetUpBlockPos.getX(), targetUpBlockPos.getY(), targetUpBlockPos.getZ(), this.getMoveSpeed());
			this.getAIOwner().getLookHelper().setLookPosition(targetUpBlockPos.getX(), targetUpBlockPos.getY(), targetUpBlockPos.getZ(), 10.0F, this.getAIOwner().getVerticalFaceSpeed());
		}
	}

	// TODO /* ======================================== MOD START =====================================*/

	private boolean isCanBeSleepBlock(BlockPos pos)
	{
		World world = this.getWorld();

		if (world.getBlockState(pos).getBlock() == Blocks.OBSIDIAN)
		{
			int lavaCount = 0;

			for (BlockPos aroundBlockPos : BlockPos.getAllInBox(pos.add(-1, 0, -1), pos.add(1, 0, 1)))
			{
				if (pos == aroundBlockPos)
				{
					continue;
				}

				if (world.getBlockState(aroundBlockPos).getBlock() == Blocks.LAVA)
				{
					++lavaCount;
				}
			}

			if (4 <= lavaCount)
			{
				if (world.isAirBlock(pos.up(1)) && world.isAirBlock(pos.up(2)) && world.isAirBlock(pos.up(3)))
				{
					return this.getAIOwner().canBlockBeSeen(pos);
				}
			}
		}

		return false;
	}

	private BlockPos getCanBeSleepBlockPos()
	{
		BlockPos ownerBlockPos = this.getAIOwner().getPosition();

		for (BlockPos aroundBlockPos : BlockPos.getAllInBox(ownerBlockPos.add(-this.SEARCH_POS_XYZ, -this.SEARCH_POS_XYZ, -this.SEARCH_POS_XYZ), ownerBlockPos.add(this.SEARCH_POS_XYZ, this.SEARCH_POS_XYZ, this.SEARCH_POS_XYZ)))
		{
			if (this.isCanBeSleepBlock(aroundBlockPos))
			{
				return aroundBlockPos;
			}
		}

		return BlockPos.ORIGIN;
	}

	private boolean isArrivalTargetBlockPos(BlockPos pos)
	{
		List<EntityDamascus> list = this.getWorld().<EntityDamascus> getEntitiesWithinAABB(EntityDamascus.class, (new AxisAlignedBB(pos).expand(0, 1, 0)));

		for (EntityDamascus aroundEntityDamascus : list)
		{
			if (aroundEntityDamascus.isEntityEqual(this.getAIOwner()))
			{
				return true;
			}
		}

		return false;
	}

}

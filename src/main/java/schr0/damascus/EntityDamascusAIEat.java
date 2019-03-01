package schr0.damascus;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

public class EntityDamascusAIEat extends EntityDamascusAI
{

	private static final double SEARCH_POS_XYZ = 8;
	private static final int EATTING_TIME = (3 * 20);
	private BlockPos targetBlockPos;
	private int eatTime;

	public EntityDamascusAIEat(EntityDamascus entityDamascus)
	{
		super(entityDamascus);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.getAIOwner().isSatiety())
		{
			return false;
		}
		else
		{
			this.targetBlockPos = this.getEatableBlockPos();

			if (this.targetBlockPos != BlockPos.ORIGIN)
			{
				this.eatTime = EATTING_TIME;

				return true;
			}
		}

		return false;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (this.getAIOwner().isSatiety())
		{
			return false;
		}
		else
		{
			return this.isEatableBlock(this.targetBlockPos);
		}
	}

	public void updateTask()
	{
		if (!this.isEatableBlock(this.targetBlockPos))
		{
			return;
		}

		if (this.isArrivalTargetBlockPos(this.targetBlockPos))
		{
			this.getAIOwner().setActionStatus(ActionStatus.EAT);

			--this.eatTime;

			if (this.eatTime < 0)
			{
				this.getAIOwner().setActionStatus(ActionStatus.IDLE);

				this.onEaten(this.targetBlockPos);

				this.shouldExecute();

				return;
			}
			else
			{
				if (this.eatTime % 10 == 0)
				{
					this.getWorld().playEvent(2001, this.targetBlockPos, Block.getStateId(this.getWorld().getBlockState(this.targetBlockPos)));
				}
			}
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

	private boolean isEatableBlock(BlockPos pos)
	{
		Block block = this.getWorld().getBlockState(pos).getBlock();

		if (EatableOre.byBlock(block) != EatableOre.NONE)
		{
			if (this.getWorld().isAirBlock(pos.up(1)) && this.getWorld().isAirBlock(pos.up(2)) && this.getWorld().isAirBlock(pos.up(3)))
			{
				return this.getAIOwner().canBlockBeSeen(pos);
			}
		}

		return false;
	}

	private BlockPos getEatableBlockPos()
	{
		BlockPos ownerBlockPos = this.getAIOwner().getPosition();

		for (BlockPos aroundBlockPos : BlockPos.getAllInBox(ownerBlockPos.add(-this.SEARCH_POS_XYZ, -this.SEARCH_POS_XYZ, -this.SEARCH_POS_XYZ), ownerBlockPos.add(this.SEARCH_POS_XYZ, this.SEARCH_POS_XYZ, this.SEARCH_POS_XYZ)))
		{
			if (this.isEatableBlock(aroundBlockPos))
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

	private void onEaten(BlockPos pos)
	{
		Block block = this.getWorld().getBlockState(pos).getBlock();
		EatableOre eatableBlockOre = EatableOre.byBlock(block);

		if (eatableBlockOre == EatableOre.NONE)
		{
			return;
		}

		this.getAIOwner().growHugerAmount(eatableBlockOre.getFoodLevel());

		this.getWorld().destroyBlock(pos, false);
	}

}

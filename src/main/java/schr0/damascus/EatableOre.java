package schr0.damascus;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public enum EatableOre
{

	NONE(Blocks.AIR, 0),
	COAL(Blocks.COAL_ORE, 1),
	IRON(Blocks.IRON_ORE, 2),
	GOLD(Blocks.GOLD_ORE, 4),
	DIAMOND(Blocks.DIAMOND_ORE, 8),
	EMERALD(Blocks.EMERALD_ORE, 16);

	private final Block block;
	private final int foodLevel;

	private EatableOre(Block block, int foodLevel)
	{
		this.block = block;
		this.foodLevel = foodLevel;
	}

	public Block getBlock()
	{
		return this.block;
	}

	public int getFoodLevel()
	{
		return this.foodLevel;
	}

	public static EatableOre byBlock(Block block)
	{
		if (block == Blocks.COAL_ORE)
		{
			return COAL;
		}

		if (block == Blocks.IRON_ORE)
		{
			return IRON;
		}

		if (block == Blocks.GOLD_ORE)
		{
			return GOLD;
		}

		if (block == Blocks.DIAMOND_ORE)
		{
			return DIAMOND;
		}

		if (block == Blocks.EMERALD_ORE)
		{
			return EMERALD;
		}

		return NONE;
	}

}

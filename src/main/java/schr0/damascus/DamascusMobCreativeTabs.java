package schr0.damascus;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class DamascusMobCreativeTabs
{

	public static final CreativeTabs ITEM = new CreativeTabs(DamascusMob.MOD_ID + "." + "item")
	{

		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(DamascusMobItems.DAMASCUS_STEEL);
		}

	};

}

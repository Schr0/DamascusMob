package schr0.damascus;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = DamascusMob.MOD_ID, name = DamascusMob.MOD_NAME, version = DamascusMob.MOD_VERSION)
public class DamascusMob
{

	@Mod.Instance(DamascusMob.MOD_ID)
	public static DamascusMob instance;

	/**
	 * ModのID.
	 */
	public static final String MOD_ID = "schr0damascusmob";

	/**
	 * Modの名前.
	 */
	public static final String MOD_NAME = "DamascusMob";

	/**
	 * Modのバージョン.
	 */
	public static final String MOD_VERSION = "1.0.0";

	/**
	 * ResourceLocationのDomain.
	 */
	public static final String MOD_RESOURCE_DOMAIN = MOD_ID + ":";

	/**
	 * 初期・設定イベント.
	 */
	@Mod.EventHandler
	public void construction(FMLConstructionEvent event)
	{
		MinecraftForge.EVENT_BUS.register(this);

		if (event.getSide().isClient())
		{
			(new DamascusMobEntitys()).registerRenders();
		}
	}

	/**
	 * 事前・設定イベント.
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// none

		if (event.getSide().isClient())
		{
			// none
		}
	}

	/**
	 * 事中・設定イベント.
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		// none

		if (event.getSide().isClient())
		{
			(new DamascusMobMessages()).registerClient();
		}
	}

	/**
	 * 事後・設定イベント.
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// none

		if (event.getSide().isClient())
		{
			// none
		}
	}

	// TODO /* ======================================== MOD START =====================================*/

	/**
	 * Itemの登録.
	 */
	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		IForgeRegistry<Item> registry = event.getRegistry();

		(new DamascusMobItems()).registerItems(registry);
	}

	/**
	 * Item / Blockモデルの登録.
	 */
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event)
	{
		(new DamascusMobItems()).registerModels();
	}

	/**
	 * Entityの登録.
	 */
	@SubscribeEvent
	public void registerEntitys(RegistryEvent.Register<EntityEntry> event)
	{
		(new DamascusMobEntitys()).registerEntitys();
	}

}

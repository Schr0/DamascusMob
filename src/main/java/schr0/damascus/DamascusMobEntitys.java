package schr0.damascus;

import java.util.Iterator;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderAreaEffectCloud;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DamascusMobEntitys
{

	public static final String NAME_DAMASCUS = "damascus";
	public static final int ID_DAMASCUS = 0;
	public static final int EGG_PRIMARY_DAMASCUS = 0x696969;
	public static final int EGG_SECONDARY_DAMASCUS = 0x000000;

	public static final String NAME_DAMASCUS_FIREBALL = "damascus_fireball";
	public static final int ID_DAMASCUS_FIREBALL = 1;

	public static final String NAME_DAMASCUS_MIASMA = "damascus_miasma";
	public static final int ID_DAMASCUS_MIASMA = 2;

	private static final int TRACKING_RANGE = 250;
	private static final int UPDATE_FREQUENCY = 1;
	private static final boolean SENDS_VELOCITY_UPDATES = true;

	public void registerEntitys()
	{
		registerEntity(EntityDamascus.class, NAME_DAMASCUS, ID_DAMASCUS, DamascusMob.instance, TRACKING_RANGE, UPDATE_FREQUENCY, SENDS_VELOCITY_UPDATES, EGG_PRIMARY_DAMASCUS, EGG_SECONDARY_DAMASCUS);
		registerEntity(EntityDamascusFireball.class, NAME_DAMASCUS_FIREBALL, ID_DAMASCUS_FIREBALL, DamascusMob.instance, TRACKING_RANGE, UPDATE_FREQUENCY, SENDS_VELOCITY_UPDATES);
		registerEntity(EntityDamascusMiasma.class, NAME_DAMASCUS_MIASMA, ID_DAMASCUS_MIASMA, DamascusMob.instance, TRACKING_RANGE, UPDATE_FREQUENCY, SENDS_VELOCITY_UPDATES);

		Iterator<Biome> biomes = Biome.REGISTRY.iterator();
		while (biomes.hasNext())
		{
			Biome biome = biomes.next();

			if (canSpawn(biome))
			{
				EntityRegistry.addSpawn(EntityDamascus.class, 6, 2, 6, EnumCreatureType.CREATURE, biome);
			}
		}
	}

	private boolean canSpawn(Biome biome)
	{
		if (biome == null)
		{
			return false;
		}

		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN))
		{
			return true;
		}

		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDamascus.class, new IRenderFactory()
		{
			@Override
			public Render createRenderFor(RenderManager renderManager)
			{
				return new RenderDamascus(renderManager, new ModelDamascus(), 0.5F);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityDamascusFireball.class, new IRenderFactory()
		{
			@Override
			public Render createRenderFor(RenderManager renderManager)
			{
				return new RenderDamascusFireball(renderManager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityDamascusMiasma.class, new IRenderFactory()
		{
			@Override
			public Render createRenderFor(RenderManager renderManager)
			{
				return new RenderAreaEffectCloud(renderManager);
			}
		});
	}

	// TODO /* ======================================== MOD START =====================================*/

	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates, int eggPrimary, int eggSecondary)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(DamascusMob.MOD_ID, entityName), entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates, eggPrimary, eggSecondary);
	}

	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, Object mod, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(DamascusMob.MOD_ID, entityName), entityClass, entityName, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
	}

}

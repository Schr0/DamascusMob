package schr0.damascus;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDamascus extends RenderLiving<EntityDamascus>
{

	private static final ResourceLocation RES_ENTITY = new ResourceLocation(DamascusMob.MOD_RESOURCE_DOMAIN + "textures/entity/damascus.png");
	private static final ResourceLocation RES_ENTITY_ANGER = new ResourceLocation(DamascusMob.MOD_RESOURCE_DOMAIN + "textures/entity/damascus_anger.png");
	private static final ResourceLocation RES_EMPTYSHELL = new ResourceLocation(DamascusMob.MOD_RESOURCE_DOMAIN + "textures/entity/damascus_emptyshell.png");

	public RenderDamascus(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
	{
		super(renderManagerIn, modelBaseIn, shadowSizeIn);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityDamascus entity)
	{
		if (entity.isEmptyShell())
		{
			return RES_EMPTYSHELL;
		}

		if (entity.isAnger())
		{
			return RES_ENTITY_ANGER;
		}

		return RES_ENTITY;
	}

}

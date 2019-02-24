package schr0.damascus;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDamascusFireBall extends ModelBase
{

	private static final int WIDTH = 64;
	private static final int HEIGHT = 32;
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer shape4;
	public ModelRenderer shape5;
	public ModelRenderer shape6;
	public ModelRenderer shape7;

	public ModelDamascusFireBall()
	{
		this.textureWidth = WIDTH;
		this.textureHeight = HEIGHT;

		this.shape3 = new ModelRenderer(this, 48, 0);
		this.shape3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape3.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape3, 0.0F, 0.5462880558742251F, -1.0471975511965976F);
		this.shape4 = new ModelRenderer(this, 0, 16);
		this.shape4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape4.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape4, -0.7740535232594852F, -0.31869712141416456F, 0.0F);
		this.shape6 = new ModelRenderer(this, 32, 16);
		this.shape6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape6.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape6, 1.2292353921796064F, -0.5462880558742251F, -1.3658946726107624F);
		this.shape7 = new ModelRenderer(this, 48, 16);
		this.shape7.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape7.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape7, -0.8546877347016232F, -2.504198410761464F, -1.3203415791337103F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape1.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		this.shape2 = new ModelRenderer(this, 32, 0);
		this.shape2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape2.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape2, 0.7740535232594852F, -1.1383037381507017F, 0.0F);
		this.shape5 = new ModelRenderer(this, 16, 16);
		this.shape5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shape5.addBox(-2.0F, -6.0F, -2.0F, 4, 12, 4, 0.0F);
		this.setRotateAngleXYZ(shape5, -1.6390387005478748F, -0.6373942428283291F, -0.091106186954104F);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

		this.shape3.render(scale);
		this.shape4.render(scale);
		this.shape6.render(scale);
		this.shape7.render(scale);
		this.shape1.render(scale);
		this.shape2.render(scale);
		this.shape5.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
	}

	// TODO /* ======================================== MOD START =====================================*/

	private void setRotateAngleXYZ(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

}

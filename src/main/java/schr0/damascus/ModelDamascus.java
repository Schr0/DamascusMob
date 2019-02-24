package schr0.damascus;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.google.common.collect.Lists;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelDamascus extends ModelBase
{

	private static final int WIDTH = 256;
	private static final int HEIGHT = 256;
	private List<ModelRenderer> neckModels = Lists.<ModelRenderer> newArrayList();
	private List<ModelRenderer> tailModels = Lists.<ModelRenderer> newArrayList();

	public ModelRenderer armL1;
	public ModelRenderer armL2;
	public ModelRenderer armL3;
	public ModelRenderer armR1;
	public ModelRenderer armR2;
	public ModelRenderer armR3;
	public ModelRenderer body;
	public ModelRenderer bodySpine;
	public ModelRenderer eyeL;
	public ModelRenderer eyeR;
	public ModelRenderer feetClowL1;
	public ModelRenderer feetClowL2;
	public ModelRenderer feetClowL3;
	public ModelRenderer feetClowL4;
	public ModelRenderer feetClowR1;
	public ModelRenderer feetClowR2;
	public ModelRenderer feetClowR3;
	public ModelRenderer feetClowR4;
	public ModelRenderer feetFingerL1;
	public ModelRenderer feetFingerL2;
	public ModelRenderer feetFingerR1;
	public ModelRenderer feetFingerR2;
	public ModelRenderer feetL;
	public ModelRenderer feetR;
	public ModelRenderer handCrowL1;
	public ModelRenderer handCrowL2;
	public ModelRenderer handCrowR1;
	public ModelRenderer handCrowR2;
	public ModelRenderer handL;
	public ModelRenderer handR;
	public ModelRenderer head;
	public ModelRenderer headFang1;
	public ModelRenderer headFang2;
	public ModelRenderer headFang3;
	public ModelRenderer headFang4;
	public ModelRenderer headFang5;
	public ModelRenderer headFang6;
	public ModelRenderer headTop;
	public ModelRenderer headUnder;
	public ModelRenderer hip;
	public ModelRenderer hipSpine;
	public ModelRenderer hone1;
	public ModelRenderer hone2;
	public ModelRenderer honeL1;
	public ModelRenderer honeL2;
	public ModelRenderer honeL3;
	public ModelRenderer honeL4;
	public ModelRenderer honeL5;
	public ModelRenderer honeL6;
	public ModelRenderer honeR1;
	public ModelRenderer honeR2;
	public ModelRenderer honeR3;
	public ModelRenderer honeR4;
	public ModelRenderer honeR5;
	public ModelRenderer honeR6;
	public ModelRenderer jaw;
	public ModelRenderer jawFang1;
	public ModelRenderer jawFang2;
	public ModelRenderer jawFang3;
	public ModelRenderer jawFang4;
	public ModelRenderer jawFang5;
	public ModelRenderer jawFang6;
	public ModelRenderer legL1;
	public ModelRenderer legL2;
	public ModelRenderer legL3;
	public ModelRenderer legR1;
	public ModelRenderer legR2;
	public ModelRenderer legR3;
	public ModelRenderer neck1;
	public ModelRenderer neck1Spine;
	public ModelRenderer neck2;
	public ModelRenderer neck2Spine;
	public ModelRenderer neck3;
	public ModelRenderer neck3Spine;
	public ModelRenderer shoulder;
	public ModelRenderer shoulderSpine;
	public ModelRenderer tail1;
	public ModelRenderer tail1Spine;
	public ModelRenderer tail2;
	public ModelRenderer tail3;
	public ModelRenderer tail3Spine;
	public ModelRenderer tail4;
	public ModelRenderer tail5;
	public ModelRenderer tail5Spine;
	public ModelRenderer tail6;
	public ModelRenderer tail7;
	public ModelRenderer tail8;
	public ModelRenderer tail8Cube1;
	public ModelRenderer tail8Cube2;
	public ModelRenderer tail8Cube3;
	public ModelRenderer wingL;
	public ModelRenderer wingR;

	public ModelDamascus()
	{
		this.textureWidth = WIDTH;
		this.textureHeight = HEIGHT;

		this.hone1 = new ModelRenderer(this, 152, 0);
		this.hone1.setRotationPoint(0.0F, -2.0F, -8.0F);
		this.hone1.addBox(-1.5F, -7.0F, -2.0F, 3, 8, 4, 0.0F);
		this.armR3 = new ModelRenderer(this, 59, 64);
		this.armR3.setRotationPoint(0.0F, -2.0F, 15.0F);
		this.armR3.addBox(-0.5F, -20.0F, -3.0F, 1, 24, 4, 0.0F);
		this.setRotateAngleXYZ(armR3, -0.3883357585687383F, 0.0F, 0.0F);
		this.eyeR = new ModelRenderer(this, 134, 0);
		this.eyeR.setRotationPoint(-4.0F, -1.0F, -3.0F);
		this.eyeR.addBox(-0.5F, -1.5F, -1.5F, 1, 3, 3, 0.0F);
		this.feetClowL4 = new ModelRenderer(this, 242, 124);
		this.feetClowL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL4.addBox(1.5F, 1.0F, -6.0F, 1, 2, 2, 0.0F);
		this.neck3Spine = new ModelRenderer(this, 195, 0);
		this.neck3Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck3Spine.addBox(-0.5F, -4.0F, -2.0F, 1, 4, 3, 0.0F);
		this.shoulder = new ModelRenderer(this, 85, 24);
		this.shoulder.setRotationPoint(0.0F, -13.0F, -1.5F);
		this.shoulder.addBox(-6.0F, -4.0F, -4.0F, 12, 8, 8, 0.0F);
		this.setRotateAngleXYZ(shoulder, -0.2617993877991494F, 0.0F, 0.0F);
		this.feetL = new ModelRenderer(this, 224, 112);
		this.feetL.setRotationPoint(0.0F, -0.5F, -9.5F);
		this.feetL.addBox(-3.5F, -1.0F, -4.0F, 7, 4, 7, 0.0F);
		this.setRotateAngleXYZ(feetL, -0.5235987755982988F, 0.0F, 0.0F);
		this.feetFingerL2 = new ModelRenderer(this, 233, 124);
		this.feetFingerL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerL2.addBox(-1.0F, 0.0F, 3.0F, 2, 3, 2, 0.0F);
		this.hone2 = new ModelRenderer(this, 167, 0);
		this.hone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hone2.addBox(-0.5F, -8.0F, -3.0F, 1, 10, 4, 0.0F);
		this.wingL = new ModelRenderer(this, 198, 64);
		this.wingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingL.addBox(-1.0F, -20.5F, -7.0F, 1, 18, 28, 0.0F);
		this.tail3 = new ModelRenderer(this, 50, 48);
		this.tail3.setRotationPoint(0.0F, 2.0F, 3.0F);
		this.tail3.addBox(-3.0F, -1.0F, -2.0F, 6, 5, 5, 0.0F);
		this.feetFingerR2 = new ModelRenderer(this, 105, 124);
		this.feetFingerR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerR2.addBox(-1.0F, 0.0F, 3.0F, 2, 3, 2, 0.0F);
		this.honeL6 = new ModelRenderer(this, 178, 0);
		this.honeL6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL6.addBox(3.0F, -3.0F, 10.5F, 4, 4, 4, 0.0F);
		this.honeL1 = new ModelRenderer(this, 178, 0);
		this.honeL1.setRotationPoint(3.0F, -1.0F, -2.0F);
		this.honeL1.addBox(-2.0F, -2.0F, 0.5F, 4, 4, 4, 0.0F);
		this.honeR6 = new ModelRenderer(this, 178, 0);
		this.honeR6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR6.addBox(-7.0F, -3.0F, 10.5F, 4, 4, 4, 0.0F);
		this.feetR = new ModelRenderer(this, 96, 112);
		this.feetR.setRotationPoint(0.0F, -0.5F, -9.5F);
		this.feetR.addBox(-3.5F, -1.0F, -4.0F, 7, 4, 7, 0.0F);
		this.setRotateAngleXYZ(feetR, -0.5235987755982988F, 0.0F, 0.0F);
		this.handCrowL2 = new ModelRenderer(this, 144, 64);
		this.handCrowL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowL2.addBox(-1.0F, -1.5F, 2.3F, 2, 2, 3, 0.0F);
		this.honeR2 = new ModelRenderer(this, 178, 0);
		this.honeR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR2.addBox(-3.0F, -3.0F, 2.5F, 4, 4, 4, 0.0F);
		this.jaw = new ModelRenderer(this, 43, 0);
		this.jaw.setRotationPoint(0.0F, 3.0F, 1.0F);
		this.jaw.addBox(-4.0F, -1.5F, -13.0F, 8, 3, 13, 0.0F);
		this.jawFang4 = new ModelRenderer(this, 43, 0);
		this.jawFang4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang4.addBox(1.0F, -2.0F, -13.5F, 2, 4, 2, 0.0F);
		this.jawFang6 = new ModelRenderer(this, 43, 0);
		this.jawFang6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang6.addBox(2.5F, -2.0F, -5.5F, 2, 4, 2, 0.0F);
		this.legL2 = new ModelRenderer(this, 165, 112);
		this.legL2.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.legL2.addBox(-2.0F, -2.0F, -2.5F, 6, 11, 5, 0.0F);
		this.setRotateAngleXYZ(legL2, 0.39269908169872414F, 0.0F, 0.0F);
		this.headFang2 = new ModelRenderer(this, 0, 0);
		this.headFang2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang2.addBox(-4.5F, -2.0F, -11.5F, 2, 4, 2, 0.0F);
		this.legL1 = new ModelRenderer(this, 128, 112);
		this.legL1.setRotationPoint(7.5F, 0.0F, 0.0F);
		this.legL1.addBox(-3.5F, -3.0F, -4.0F, 7, 6, 11, 0.0F);
		this.setRotateAngleXYZ(legL1, 0.39269908169872414F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 86, 0);
		this.head.setRotationPoint(0.0F, -0.5F, -1.0F);
		this.head.addBox(-3.5F, -3.9F, -6.5F, 7, 5, 6, 0.0F);
		this.setRotateAngleXYZ(head, 0.3490658503988659F, 0.0F, 0.0F);
		this.tail8Cube3 = new ModelRenderer(this, 188, 48);
		this.tail8Cube3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8Cube3.addBox(-2.5F, -2.5F, 0.5F, 5, 5, 5, 0.0F);
		this.honeL2 = new ModelRenderer(this, 178, 0);
		this.honeL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL2.addBox(-1.0F, -3.0F, 2.5F, 4, 4, 4, 0.0F);
		this.jawFang5 = new ModelRenderer(this, 43, 0);
		this.jawFang5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang5.addBox(2.5F, -2.0F, -9.5F, 2, 4, 2, 0.0F);
		this.honeL4 = new ModelRenderer(this, 178, 0);
		this.honeL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL4.addBox(1.0F, -5.0F, 6.5F, 4, 4, 4, 0.0F);
		this.feetClowR2 = new ModelRenderer(this, 114, 124);
		this.feetClowR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR2.addBox(-0.5F, 1.0F, 4.0F, 1, 2, 2, 0.0F);
		this.neck2Spine = new ModelRenderer(this, 195, 0);
		this.neck2Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck2Spine.addBox(-0.5F, -5.0F, 1.0F, 1, 4, 3, 0.0F);
		this.armL2 = new ModelRenderer(this, 142, 64);
		this.armL2.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.armL2.addBox(-1.0F, -3.0F, -3.0F, 2, 4, 20, 0.0F);
		this.setRotateAngleXYZ(armL2, -2.1816615649929116F, 0.0F, 0.0F);
		this.feetClowR4 = new ModelRenderer(this, 114, 124);
		this.feetClowR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR4.addBox(1.5F, 1.0F, -6.0F, 1, 2, 2, 0.0F);
		this.tail8 = new ModelRenderer(this, 163, 48);
		this.tail8.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.tail8.addBox(-4.0F, -2.0F, -2.0F, 8, 4, 4, 0.0F);
		this.neck2 = new ModelRenderer(this, 23, 24);
		this.neck2.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.neck2.addBox(-4.0F, -3.5F, -3.0F, 8, 5, 6, 0.0F);
		this.armL3 = new ModelRenderer(this, 187, 64);
		this.armL3.setRotationPoint(0.0F, -2.0F, 15.0F);
		this.armL3.addBox(-0.5F, -20.0F, -3.0F, 1, 24, 4, 0.0F);
		this.setRotateAngleXYZ(armL3, -0.3883357585687383F, 0.0F, 0.0F);
		this.legR1 = new ModelRenderer(this, 0, 112);
		this.legR1.setRotationPoint(-7.5F, 0.0F, 0.0F);
		this.legR1.addBox(-3.5F, -3.0F, -4.0F, 7, 6, 11, 0.0F);
		this.setRotateAngleXYZ(legR1, 0.39269908169872414F, 0.0F, 0.0F);
		this.wingR = new ModelRenderer(this, 70, 64);
		this.wingR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingR.addBox(-0.1F, -20.5F, -7.0F, 1, 18, 28, 0.0F);
		this.feetClowR1 = new ModelRenderer(this, 114, 124);
		this.feetClowR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR1.addBox(-0.5F, 1.0F, -7.0F, 1, 2, 2, 0.0F);
		this.legL3 = new ModelRenderer(this, 188, 112);
		this.legL3.setRotationPoint(1.0F, 7.5F, 0.0F);
		this.legL3.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 13, 0.0F);
		this.setRotateAngleXYZ(legL3, -0.24434609527920614F, 0.0F, 0.0F);
		this.feetFingerL1 = new ModelRenderer(this, 224, 124);
		this.feetFingerL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerL1.addBox(-1.0F, 0.0F, -6.0F, 2, 3, 2, 0.0F);
		this.hipSpine = new ModelRenderer(this, 195, 0);
		this.hipSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hipSpine.addBox(-0.5F, -5.0F, 2.0F, 1, 4, 3, 0.0F);
		this.feetClowL1 = new ModelRenderer(this, 242, 124);
		this.feetClowL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL1.addBox(-0.5F, 1.0F, -7.0F, 1, 2, 2, 0.0F);
		this.armR2 = new ModelRenderer(this, 14, 64);
		this.armR2.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.armR2.addBox(-1.0F, -3.0F, -3.0F, 2, 4, 20, 0.0F);
		this.setRotateAngleXYZ(armR2, -2.1816615649929116F, 0.0F, 0.0F);
		this.tail6 = new ModelRenderer(this, 117, 48);
		this.tail6.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail6.addBox(-2.5F, -1.0F, -2.0F, 5, 5, 5, 0.0F);
		this.tail8Cube2 = new ModelRenderer(this, 188, 48);
		this.tail8Cube2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8Cube2.addBox(2.0F, -3.5F, -2.5F, 5, 5, 5, 0.0F);
		this.jawFang2 = new ModelRenderer(this, 43, 0);
		this.jawFang2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang2.addBox(-4.5F, -2.0F, -9.5F, 2, 4, 2, 0.0F);
		this.armR1 = new ModelRenderer(this, 0, 64);
		this.armR1.setRotationPoint(-4.0F, -2.0F, 0.0F);
		this.armR1.addBox(-1.5F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		this.setRotateAngleXYZ(armR1, 0.0F, 0.0F, 0.7853981633974483F);
		this.tail8Cube1 = new ModelRenderer(this, 188, 48);
		this.tail8Cube1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8Cube1.addBox(-7.0F, -3.5F, -2.5F, 5, 5, 5, 0.0F);
		this.headFang6 = new ModelRenderer(this, 0, 0);
		this.headFang6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang6.addBox(2.5F, -2.0F, -7.5F, 2, 4, 2, 0.0F);
		this.honeR5 = new ModelRenderer(this, 178, 0);
		this.honeR5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR5.addBox(-6.0F, -4.0F, 8.5F, 4, 4, 4, 0.0F);
		this.feetClowL2 = new ModelRenderer(this, 242, 124);
		this.feetClowL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL2.addBox(-0.5F, 1.0F, 4.0F, 1, 2, 2, 0.0F);
		this.shoulderSpine = new ModelRenderer(this, 240, 9);
		this.shoulderSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulderSpine.addBox(-0.5F, -8.0F, -0.5F, 1, 4, 3, 0.0F);
		this.armL1 = new ModelRenderer(this, 128, 64);
		this.armL1.setRotationPoint(4.0F, -2.0F, 0.0F);
		this.armL1.addBox(-1.5F, 0.0F, -2.0F, 3, 13, 4, 0.0F);
		this.setRotateAngleXYZ(armL1, 0.0F, 0.0F, -0.7853981633974483F);
		this.legR3 = new ModelRenderer(this, 60, 112);
		this.legR3.setRotationPoint(1.0F, 7.5F, 0.0F);
		this.legR3.addBox(-2.0F, -2.0F, -10.0F, 4, 4, 13, 0.0F);
		this.setRotateAngleXYZ(legR3, -0.24434609527920614F, 0.0F, 0.0F);
		this.honeL3 = new ModelRenderer(this, 178, 0);
		this.honeL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL3.addBox(0.0F, -4.0F, 4.5F, 4, 4, 4, 0.0F);
		this.tail4 = new ModelRenderer(this, 73, 48);
		this.tail4.setRotationPoint(0.0F, 1.1F, 3.0F);
		this.tail4.addBox(-2.5F, -1.0F, -2.0F, 5, 5, 5, 0.0F);
		this.legR2 = new ModelRenderer(this, 37, 112);
		this.legR2.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.legR2.addBox(-2.0F, -2.0F, -2.5F, 6, 11, 5, 0.0F);
		this.setRotateAngleXYZ(legR2, 0.39269908169872414F, 0.0F, 0.0F);
		this.honeR1 = new ModelRenderer(this, 178, 0);
		this.honeR1.setRotationPoint(-3.0F, -1.0F, -2.0F);
		this.honeR1.addBox(-2.0F, -2.0F, 0.5F, 4, 4, 4, 0.0F);
		this.jawFang3 = new ModelRenderer(this, 43, 0);
		this.jawFang3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang3.addBox(-3.0F, -2.0F, -13.5F, 2, 4, 2, 0.0F);
		this.tail5 = new ModelRenderer(this, 94, 48);
		this.tail5.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail5.addBox(-3.0F, -1.0F, -2.0F, 6, 5, 5, 0.0F);
		this.feetClowL3 = new ModelRenderer(this, 242, 124);
		this.feetClowL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL3.addBox(-2.5F, 1.0F, -6.0F, 1, 2, 2, 0.0F);
		this.hip = new ModelRenderer(this, 159, 24);
		this.hip.setRotationPoint(0.0F, 11.0F, 0.0F);
		this.hip.addBox(-5.0F, -4.0F, -4.0F, 10, 8, 8, 0.0F);
		this.headTop = new ModelRenderer(this, 0, 0);
		this.headTop.setRotationPoint(0.0F, -4.0F, -4.0F);
		this.headTop.addBox(-4.0F, -1.5F, -13.0F, 8, 3, 13, 0.0F);
		this.handR = new ModelRenderer(this, 16, 70);
		this.handR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handR.addBox(-1.5F, -2.0F, -1.5F, 3, 6, 5, 0.0F);
		this.setRotateAngleXYZ(handR, -0.7853981633974483F, 0.0F, 0.0F);
		this.handL = new ModelRenderer(this, 144, 70);
		this.handL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handL.addBox(-1.5F, -2.0F, -1.5F, 3, 6, 5, 0.0F);
		this.setRotateAngleXYZ(handL, -0.7853981633974483F, 0.0F, 0.0F);
		this.headUnder = new ModelRenderer(this, 113, 0);
		this.headUnder.setRotationPoint(0.0F, -3.0F, -5.0F);
		this.headUnder.addBox(-2.5F, 0.1F, -2.5F, 5, 5, 5, 0.0F);
		this.body = new ModelRenderer(this, 126, 24);
		this.body.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.body.addBox(-4.0F, -14.0F, -5.0F, 8, 14, 8, 0.0F);
		this.setRotateAngleXYZ(body, 0.2617993877991494F, 0.0F, 0.0F);
		this.tail2 = new ModelRenderer(this, 27, 48);
		this.tail2.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail2.addBox(-2.5F, -1.0F, -2.0F, 5, 5, 6, 0.0F);
		this.tail1Spine = new ModelRenderer(this, 195, 0);
		this.tail1Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail1Spine.addBox(-0.5F, -4.0F, 5.0F, 1, 4, 3, 0.0F);
		this.honeL5 = new ModelRenderer(this, 178, 0);
		this.honeL5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL5.addBox(2.0F, -4.0F, 8.5F, 4, 4, 4, 0.0F);
		this.handCrowL1 = new ModelRenderer(this, 144, 64);
		this.handCrowL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowL1.addBox(-1.0F, 1.0F, 3.5F, 2, 2, 3, 0.0F);
		this.tail3Spine = new ModelRenderer(this, 195, 0);
		this.tail3Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail3Spine.addBox(-0.5F, -2.0F, 1.0F, 1, 4, 3, 0.0F);
		this.jawFang1 = new ModelRenderer(this, 43, 0);
		this.jawFang1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang1.addBox(-4.5F, -2.0F, -5.5F, 2, 4, 2, 0.0F);
		this.handCrowR2 = new ModelRenderer(this, 16, 64);
		this.handCrowR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowR2.addBox(-1.0F, -1.5F, 2.3F, 2, 2, 3, 0.0F);
		this.feetClowR3 = new ModelRenderer(this, 114, 124);
		this.feetClowR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR3.addBox(-2.5F, 1.0F, -6.0F, 1, 2, 2, 0.0F);
		this.tail1 = new ModelRenderer(this, 0, 48);
		this.tail1.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.tail1.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 7, 0.0F);
		this.headFang3 = new ModelRenderer(this, 0, 0);
		this.headFang3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang3.addBox(-3.0F, -2.0F, -13.5F, 2, 4, 2, 0.0F);
		this.headFang1 = new ModelRenderer(this, 0, 0);
		this.headFang1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang1.addBox(-4.5F, -2.0F, -7.5F, 2, 4, 2, 0.0F);
		this.eyeL = new ModelRenderer(this, 143, 0);
		this.eyeL.setRotationPoint(3.0F, 2.0F, -6.0F);
		this.eyeL.addBox(0.5F, -4.5F, 1.5F, 1, 3, 3, 0.0F);
		this.headFang4 = new ModelRenderer(this, 0, 0);
		this.headFang4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang4.addBox(1.0F, -2.0F, -13.5F, 2, 4, 2, 0.0F);
		this.neck3 = new ModelRenderer(this, 0, 24);
		this.neck3.setRotationPoint(0.0F, -2.0F, -1.5F);
		this.neck3.addBox(-2.5F, -3.0F, -4.0F, 5, 5, 6, 0.0F);
		this.honeR3 = new ModelRenderer(this, 178, 0);
		this.honeR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR3.addBox(-4.0F, -4.0F, 4.5F, 4, 4, 4, 0.0F);
		this.neck1 = new ModelRenderer(this, 52, 24);
		this.neck1.setRotationPoint(0.0F, -3.0F, -2.5F);
		this.neck1.addBox(-5.0F, -3.0F, -3.0F, 10, 5, 6, 0.0F);
		this.tail7 = new ModelRenderer(this, 138, 48);
		this.tail7.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail7.addBox(-2.0F, -1.5F, -2.0F, 4, 3, 8, 0.0F);
		this.handCrowR1 = new ModelRenderer(this, 16, 64);
		this.handCrowR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowR1.addBox(-1.0F, 1.0F, 3.5F, 2, 2, 3, 0.0F);
		this.bodySpine = new ModelRenderer(this, 195, 0);
		this.bodySpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.bodySpine.addBox(-0.5F, -11.0F, 0.5F, 1, 4, 3, 0.0F);
		this.honeR4 = new ModelRenderer(this, 178, 0);
		this.honeR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR4.addBox(-5.0F, -5.0F, 6.5F, 4, 4, 4, 0.0F);
		this.neck1Spine = new ModelRenderer(this, 195, 0);
		this.neck1Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck1Spine.addBox(-0.5F, -2.5F, 2.0F, 1, 4, 3, 0.0F);
		this.headFang5 = new ModelRenderer(this, 0, 0);
		this.headFang5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang5.addBox(2.5F, -2.0F, -11.5F, 2, 4, 2, 0.0F);
		this.tail5Spine = new ModelRenderer(this, 195, 0);
		this.tail5Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail5Spine.addBox(-0.5F, -2.0F, 1.0F, 1, 4, 3, 0.0F);
		this.feetFingerR1 = new ModelRenderer(this, 96, 124);
		this.feetFingerR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerR1.addBox(-1.0F, 0.0F, -6.0F, 2, 3, 2, 0.0F);
		this.headTop.addChild(this.hone1);
		this.armR2.addChild(this.armR3);
		this.headTop.addChild(this.eyeR);
		this.feetL.addChild(this.feetClowL4);
		this.neck3.addChild(this.neck3Spine);
		this.body.addChild(this.shoulder);
		this.legL3.addChild(this.feetL);
		this.feetL.addChild(this.feetFingerL2);
		this.hone1.addChild(this.hone2);
		this.armL2.addChild(this.wingL);
		this.tail2.addChild(this.tail3);
		this.feetR.addChild(this.feetFingerR2);
		this.honeL5.addChild(this.honeL6);
		this.headTop.addChild(this.honeL1);
		this.honeR5.addChild(this.honeR6);
		this.legR3.addChild(this.feetR);
		this.handL.addChild(this.handCrowL2);
		this.honeR1.addChild(this.honeR2);
		this.headUnder.addChild(this.jaw);
		this.jaw.addChild(this.jawFang4);
		this.jaw.addChild(this.jawFang6);
		this.legL1.addChild(this.legL2);
		this.headTop.addChild(this.headFang2);
		this.hip.addChild(this.legL1);
		this.neck3.addChild(this.head);
		this.tail8.addChild(this.tail8Cube3);
		this.honeL1.addChild(this.honeL2);
		this.jaw.addChild(this.jawFang5);
		this.honeL3.addChild(this.honeL4);
		this.feetFingerR2.addChild(this.feetClowR2);
		this.neck2.addChild(this.neck2Spine);
		this.armL1.addChild(this.armL2);
		this.feetR.addChild(this.feetClowR4);
		this.tail7.addChild(this.tail8);
		this.neck1.addChild(this.neck2);
		this.armL2.addChild(this.armL3);
		this.hip.addChild(this.legR1);
		this.armR2.addChild(this.wingR);
		this.feetFingerR1.addChild(this.feetClowR1);
		this.legL2.addChild(this.legL3);
		this.feetL.addChild(this.feetFingerL1);
		this.hip.addChild(this.hipSpine);
		this.feetFingerL1.addChild(this.feetClowL1);
		this.armR1.addChild(this.armR2);
		this.tail5.addChild(this.tail6);
		this.tail8.addChild(this.tail8Cube2);
		this.jaw.addChild(this.jawFang2);
		this.shoulder.addChild(this.armR1);
		this.tail8.addChild(this.tail8Cube1);
		this.headTop.addChild(this.headFang6);
		this.honeR4.addChild(this.honeR5);
		this.feetFingerL2.addChild(this.feetClowL2);
		this.shoulder.addChild(this.shoulderSpine);
		this.shoulder.addChild(this.armL1);
		this.legR2.addChild(this.legR3);
		this.honeL2.addChild(this.honeL3);
		this.tail3.addChild(this.tail4);
		this.legR1.addChild(this.legR2);
		this.headTop.addChild(this.honeR1);
		this.jaw.addChild(this.jawFang3);
		this.tail4.addChild(this.tail5);
		this.feetL.addChild(this.feetClowL3);
		this.head.addChild(this.headTop);
		this.armR3.addChild(this.handR);
		this.armL3.addChild(this.handL);
		this.head.addChild(this.headUnder);
		this.hip.addChild(this.body);
		this.tail1.addChild(this.tail2);
		this.tail1.addChild(this.tail1Spine);
		this.honeL4.addChild(this.honeL5);
		this.handL.addChild(this.handCrowL1);
		this.tail3.addChild(this.tail3Spine);
		this.jaw.addChild(this.jawFang1);
		this.handR.addChild(this.handCrowR2);
		this.feetR.addChild(this.feetClowR3);
		this.hip.addChild(this.tail1);
		this.headTop.addChild(this.headFang3);
		this.headTop.addChild(this.headFang1);
		this.headTop.addChild(this.eyeL);
		this.headTop.addChild(this.headFang4);
		this.neck2.addChild(this.neck3);
		this.honeR2.addChild(this.honeR3);
		this.shoulder.addChild(this.neck1);
		this.tail6.addChild(this.tail7);
		this.handR.addChild(this.handCrowR1);
		this.body.addChild(this.bodySpine);
		this.honeR3.addChild(this.honeR4);
		this.neck1.addChild(this.neck1Spine);
		this.headTop.addChild(this.headFang5);
		this.tail5.addChild(this.tail5Spine);
		this.feetR.addChild(this.feetFingerR1);

		this.neckModels.add(this.neck1);
		this.neckModels.add(this.neck2);
		this.neckModels.add(this.neck3);

		this.tailModels.add(this.tail1);
		this.tailModels.add(this.tail2);
		this.tailModels.add(this.tail3);
		this.tailModels.add(this.tail4);
		this.tailModels.add(this.tail5);
		this.tailModels.add(this.tail6);
		this.tailModels.add(this.tail7);
		this.tailModels.add(this.tail8);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

		this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);

		if (this.isChild)
		{
			GL11.glPushMatrix();
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(0.0F, (24.0F * scale), 0.0F);

			this.hip.render(scale);

			GL11.glPopMatrix();
		}
		else
		{
			this.hip.render(scale);
		}
	}

	// TODO /* ======================================== setRotationAngles START =====================================*/

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
	{
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);

		if (!(entityIn instanceof EntityDamascus))
		{
			return;
		}

		this.initModelsRotate();

		EntityDamascus damascus = (EntityDamascus) entityIn;
		float srcHeadAngleX = this.head.rotateAngleX;
		float srcHipAngleX = this.hip.rotateAngleX;
		float srcBodyAngleX = this.body.rotateAngleX;
		float srcShoulderAngleX = this.shoulder.rotateAngleX;
		float srcArm1AngleX = this.armR1.rotateAngleX;
		float srcArmR1AngleZ = this.armR1.rotateAngleZ;
		float srcArmL1AngleZ = this.armL1.rotateAngleZ;
		float srcLeg1AngleX = this.legR1.rotateAngleX;
		float srcLeg2AngleX = this.legR2.rotateAngleX;
		float srcLeg3AngleX = this.legR3.rotateAngleX;
		float srcfeetAngleX = this.feetR.rotateAngleX;
		float livingMotion = MathHelper.cos(ageInTicks * 0.015F * (float) Math.PI) * (0.015F * (float) Math.PI);

		this.headTop.rotateAngleX = -livingMotion;
		this.jaw.rotateAngleX = livingMotion;
		this.armR1.rotateAngleZ = (livingMotion + srcArmR1AngleZ);
		this.armL1.rotateAngleZ = (-livingMotion + srcArmL1AngleZ);

		this.head.rotateAngleX = (headPitch * 0.018F) + srcHeadAngleX;
		this.head.rotateAngleY = (netHeadYaw * 0.018F);

		if (!damascus.isFlying())
		{
			this.armR1.rotateAngleX = ((MathHelper.cos(limbSwing * 0.25F + (float) Math.PI) * (0.15F * limbSwingAmount)) + srcArm1AngleX);
			this.armL1.rotateAngleX = ((MathHelper.cos(limbSwing * 0.25F) * (0.15F * limbSwingAmount)) + srcArm1AngleX);

			this.legR1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * (0.7F * limbSwingAmount)) + srcLeg1AngleX;
			this.legR2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * (0.5F * limbSwingAmount)) + srcLeg2AngleX;
			this.legR3.rotateAngleX = -(MathHelper.cos(limbSwing * 0.25F) * (0.3F * limbSwingAmount)) + srcLeg3AngleX;
			this.feetR.rotateAngleX = -(MathHelper.cos(limbSwing * 0.25F) * (0.7F * limbSwingAmount)) + srcfeetAngleX;

			this.legL1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float) Math.PI) * (0.7F * limbSwingAmount)) + srcLeg1AngleX;
			this.legL2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float) Math.PI) * (0.5F * limbSwingAmount)) + srcLeg2AngleX;
			this.legL3.rotateAngleX = -(MathHelper.cos(limbSwing * 0.25F + (float) Math.PI) * (0.3F * limbSwingAmount)) + srcLeg3AngleX;
			this.feetL.rotateAngleX = -(MathHelper.cos(limbSwing * 0.25F + (float) Math.PI) * (0.7F * limbSwingAmount)) + srcfeetAngleX;
		}

		for (ModelRenderer tailModel : this.tailModels)
		{
			tailModel.rotateAngleY = livingMotion;
		}

		if (damascus.getActionStatus() == ActionStatus.ROAR)
		{
			float growlingNecksAngleX = -0.35F;
			float growlingHeadTopAngleX = -0.17453292519943295F;
			float growlingJawAngleX = 0.9599310885968813F;
			float growlingArm1AngleX = -0.5235987755982988F;
			float growlingArmR1AngleY = 0.7853981633974483F;
			float growlingArmL1AngleY = -growlingArmR1AngleY;
			float growlingLegR1AngleY = 0.5235987755982988F;
			float growlingLegL1AngleY = -growlingLegR1AngleY;
			float growlingTailsAngleX = 0.25F;

			this.head.rotateAngleX = srcHeadAngleX;
			this.head.rotateAngleY = 0.0F;

			for (ModelRenderer neckModel : this.neckModels)
			{
				neckModel.rotateAngleX = growlingNecksAngleX;
			}

			this.headTop.rotateAngleX = growlingHeadTopAngleX;
			this.jaw.rotateAngleX = growlingJawAngleX;

			this.armR1.rotateAngleX = growlingArm1AngleX;
			this.armL1.rotateAngleX = growlingArm1AngleX;
			this.armR1.rotateAngleY = growlingArmR1AngleY;
			this.armL1.rotateAngleY = growlingArmL1AngleY;
			this.legR1.rotateAngleY = growlingLegR1AngleY;
			this.legL1.rotateAngleY = growlingLegL1AngleY;

			for (ModelRenderer tailModel : this.tailModels)
			{
				tailModel.rotateAngleX = (livingMotion + growlingTailsAngleX);
				tailModel.rotateAngleY = 0.0F;
			}

			return;
		}

		if (damascus.getActionStatus() == ActionStatus.EAT)
		{
			float eatingAngleX = 0.15F;
			float eatMotion = MathHelper.cos(ageInTicks * 0.50F * (float) Math.PI) * (0.015F * (float) Math.PI);

			this.body.rotateAngleX = (eatingAngleX + srcBodyAngleX);
			this.shoulder.rotateAngleX = (eatingAngleX + srcShoulderAngleX);

			for (ModelRenderer neckModel : this.neckModels)
			{
				neckModel.rotateAngleX = eatingAngleX;
			}

			this.headTop.rotateAngleX = -eatMotion;
			this.jaw.rotateAngleX = eatMotion;

			return;
		}

		if (damascus.getActionStatus() == ActionStatus.SLEEP)
		{
			float sleepingUpperBodyAngleX = 0.15F;
			float sleepingArmRAngleZ = 0.65F;
			float sleepingArmLAngleZ = -sleepingArmRAngleZ;

			this.body.rotateAngleX = (sleepingUpperBodyAngleX + srcBodyAngleX);
			this.shoulder.rotateAngleX = (sleepingUpperBodyAngleX + srcShoulderAngleX);

			for (ModelRenderer neckModel : this.neckModels)
			{
				neckModel.rotateAngleX = sleepingUpperBodyAngleX;
			}

			this.armR1.rotateAngleZ = sleepingArmRAngleZ;
			this.armL1.rotateAngleZ = sleepingArmLAngleZ;

			return;
		}

		if (damascus.getActionStatus() == ActionStatus.ATTACK)
		{
			if (damascus.getAttackType() == AttackType.RANGED)
			{
				float rangedAttackHeadTopAngleX = -0.17453292519943295F;
				float rangedAttackJawAngleX = 0.9599310885968813F;

				this.headTop.rotateAngleX = rangedAttackHeadTopAngleX;
				this.jaw.rotateAngleX = rangedAttackJawAngleX;
			}

			if (damascus.getAttackType() == AttackType.MELEE)
			{
				float meleeAttackAngleX = 0.10F;

				this.hip.rotateAngleX = (meleeAttackAngleX + srcHipAngleX);
				this.body.rotateAngleX = (meleeAttackAngleX + srcBodyAngleX);
				this.shoulder.rotateAngleX = (meleeAttackAngleX + srcShoulderAngleX);

				for (ModelRenderer neckModel : this.neckModels)
				{
					neckModel.rotateAngleX = meleeAttackAngleX;
				}
			}

			float attackingArm1AngleX = -0.5235987755982988F;
			float attackingTailsAngleX = 0.25F;

			this.armR1.rotateAngleX = (livingMotion + attackingArm1AngleX);
			this.armL1.rotateAngleX = (livingMotion + attackingArm1AngleX);

			for (ModelRenderer tailModel : this.tailModels)
			{
				tailModel.rotateAngleX = (livingMotion + attackingTailsAngleX);
				tailModel.rotateAngleY = 0.0F;
			}
		}

		if (damascus.isFlying())
		{
			float flyingArmRAngleZ = 1.0471975511965976F;
			float flyingArmLAngleZ = -flyingArmRAngleZ;
			float flyingLegR1AngleY = 0.2617993877991494F;
			float flyingLegL1AngleY = -flyingLegR1AngleY;
			float flyingLeg3AngleX = 0.5235987755982988F;
			float flyingTailsAngleX = -0.25F;

			this.armR1.rotateAngleZ = (MathHelper.cos(ageInTicks * 0.3F) * 0.40F) + flyingArmRAngleZ;
			this.armR2.rotateAngleZ = (MathHelper.cos(ageInTicks * 0.3F) * 0.405F);
			this.armL1.rotateAngleZ = -(MathHelper.cos(ageInTicks * 0.3F) * 0.40F) + flyingArmLAngleZ;
			this.armL2.rotateAngleZ = -(MathHelper.cos(ageInTicks * 0.3F) * 0.405F);

			this.legR1.rotateAngleY = flyingLegR1AngleY;
			this.legL1.rotateAngleY = flyingLegL1AngleY;

			this.legR3.rotateAngleX = flyingLeg3AngleX;
			this.legL3.rotateAngleX = flyingLeg3AngleX;

			for (ModelRenderer tailModel : this.tailModels)
			{
				tailModel.rotateAngleX = (livingMotion + flyingTailsAngleX);
				tailModel.rotateAngleY = 0.0F;
			}
		}
	}

	// TODO /* ======================================== MOD START =====================================*/

	private void setRotateAngleXYZ(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	private void initModelsRotate()
	{
		this.armL1.setRotationPoint(4.0F, -2.0F, 0.0F);
		this.armL2.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.armL3.setRotationPoint(0.0F, -2.0F, 15.0F);
		this.armR1.setRotationPoint(-4.0F, -2.0F, 0.0F);
		this.armR2.setRotationPoint(0.0F, 6.0F, 0.0F);
		this.armR3.setRotationPoint(0.0F, -2.0F, 15.0F);
		this.body.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.bodySpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.eyeL.setRotationPoint(3.0F, 2.0F, -6.0F);
		this.eyeR.setRotationPoint(-4.0F, -1.0F, -3.0F);
		this.feetClowL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetClowR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetFingerR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.feetL.setRotationPoint(0.0F, -0.5F, -9.5F);
		this.feetR.setRotationPoint(0.0F, -0.5F, -9.5F);
		this.handCrowL1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowR1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handCrowR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.handR.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.head.setRotationPoint(0.0F, -0.5F, -1.0F);
		this.headFang1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headFang6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.headTop.setRotationPoint(0.0F, -4.0F, -4.0F);
		this.headUnder.setRotationPoint(0.0F, -3.0F, -5.0F);
		this.hip.setRotationPoint(0.0F, 11.0F, 0.0F);
		this.hipSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.hone1.setRotationPoint(0.0F, -2.0F, -8.0F);
		this.hone2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL1.setRotationPoint(3.0F, -1.0F, -2.0F);
		this.honeL2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeL6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR1.setRotationPoint(-3.0F, -1.0F, -2.0F);
		this.honeR2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.honeR6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jaw.setRotationPoint(0.0F, 3.0F, 1.0F);
		this.jawFang1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang4.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang5.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.jawFang6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.legL1.setRotationPoint(7.5F, 0.0F, 0.0F);
		this.legL2.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.legL3.setRotationPoint(1.0F, 7.5F, 0.0F);
		this.legR1.setRotationPoint(-7.5F, 0.0F, 0.0F);
		this.legR2.setRotationPoint(-1.0F, 0.0F, 0.0F);
		this.legR3.setRotationPoint(1.0F, 7.5F, 0.0F);
		this.neck1.setRotationPoint(0.0F, -3.0F, -2.5F);
		this.neck1Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck2.setRotationPoint(0.0F, -1.0F, -2.0F);
		this.neck2Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.neck3.setRotationPoint(0.0F, -2.0F, -1.5F);
		this.neck3Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.shoulder.setRotationPoint(0.0F, -13.0F, -1.5F);
		this.shoulderSpine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail1.setRotationPoint(0.0F, 0.0F, 1.0F);
		this.tail1Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail2.setRotationPoint(0.0F, 0.0F, 6.0F);
		this.tail3.setRotationPoint(0.0F, 2.0F, 3.0F);
		this.tail3Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail4.setRotationPoint(0.0F, 1.1F, 3.0F);
		this.tail5.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail5Spine.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail6.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail7.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.tail8.setRotationPoint(0.0F, 0.0F, 5.0F);
		this.tail8Cube1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8Cube2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.tail8Cube3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingL.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.wingR.setRotationPoint(0.0F, 0.0F, 0.0F);

		List<ModelRenderer> modelList = Lists.<ModelRenderer> newArrayList();
		modelList.addAll(this.boxList);

		for (ModelRenderer model : modelList)
		{
			this.setRotateAngleXYZ(model, 0.0F, 0.0F, 0.0F);
		}

		this.setRotateAngleXYZ(armL1, 0.0F, 0.0F, -0.7853981633974483F);
		this.setRotateAngleXYZ(armL2, -2.1816615649929116F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(armL3, -0.3883357585687383F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(armR1, 0.0F, 0.0F, 0.7853981633974483F);
		this.setRotateAngleXYZ(armR2, -2.1816615649929116F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(armR3, -0.3883357585687383F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(body, 0.2617993877991494F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(feetL, -0.5235987755982988F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(feetR, -0.5235987755982988F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(handL, -0.7853981633974483F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(handR, -0.7853981633974483F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(head, 0.3490658503988659F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legL1, 0.39269908169872414F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legL2, 0.39269908169872414F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legL3, -0.24434609527920614F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legR1, 0.39269908169872414F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legR2, 0.39269908169872414F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(legR3, -0.24434609527920614F, 0.0F, 0.0F);
		this.setRotateAngleXYZ(shoulder, -0.2617993877991494F, 0.0F, 0.0F);
	}

}

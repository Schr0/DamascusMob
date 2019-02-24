package schr0.damascus;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemDamascusSteel extends Item
{

	private static final int COOLDOWN_TIME = (3 * 20);

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return COOLDOWN_TIME;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.BOW;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack itemstack = playerIn.getHeldItem(handIn);

		if ((handIn == EnumHand.MAIN_HAND) && (playerIn.getRidingEntity() instanceof EntityDamascus))
		{
			playerIn.setActiveHand(handIn);

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
		}

		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		if ((entityLiving.getActiveHand() == EnumHand.MAIN_HAND) && (entityLiving.getRidingEntity() instanceof EntityDamascus))
		{
			EntityDamascus entityDamascus = (EntityDamascus) entityLiving.getRidingEntity();

			Vec3d ownerLookVec = entityLiving.getLookVec();
			double lookDistance = 144.0D;
			double ownerLookVecX = (ownerLookVec.x * lookDistance);
			double ownerLookVecY = (ownerLookVec.y * lookDistance);
			double ownerLookVecZ = (ownerLookVec.z * lookDistance);
			double distanceSqrt = (double) MathHelper.sqrt(ownerLookVecX * ownerLookVecX + ownerLookVecY * ownerLookVecY + ownerLookVecZ * ownerLookVecZ);
			double accelerationX = (ownerLookVecX / distanceSqrt * 0.1D);
			double accelerationY = (ownerLookVecY / distanceSqrt * 0.1D);
			double accelerationZ = (ownerLookVecZ / distanceSqrt * 0.1D);
			double spawnPosX = (entityDamascus.posX + ownerLookVec.x * 1.5D);
			double spawnPosY = (entityDamascus.posY + entityDamascus.getEyeHeight() + ownerLookVec.y * 1.5D);
			double spawnPosZ = (entityDamascus.posZ + ownerLookVec.z * 1.5D);

			EntityDamascusFireball entityDamascusFireball = new EntityDamascusFireball(worldIn, entityDamascus, spawnPosX, spawnPosY, spawnPosZ, accelerationX, accelerationY, accelerationZ);

			if (!worldIn.isRemote)
			{
				worldIn.spawnEntity(entityDamascusFireball);
			}

			entityLiving.swingArm(EnumHand.MAIN_HAND);

			if (entityLiving instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) entityLiving;

				player.getCooldownTracker().setCooldown(this, COOLDOWN_TIME);
			}
		}

		return stack;
	}

}

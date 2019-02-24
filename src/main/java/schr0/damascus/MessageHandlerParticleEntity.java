package schr0.damascus;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MessageHandlerParticleEntity implements IMessageHandler<MessageParticleEntity, IMessage>
{

	@Override
	public IMessage onMessage(MessageParticleEntity message, MessageContext ctx)
	{
		World world = FMLClientHandler.instance().getClient().world;
		Entity entity = message.getEntity(world);

		if (entity != null)
		{
			switch (message.getParticleType())
			{
				case DamascusMobParticles.RANGED_ATTACKING :

					particleRangedAttacking(world, world.rand, entity);

					break;

				case DamascusMobParticles.ANGER_AURA :

					particleAngerAura(world, world.rand, entity);

					break;

				case DamascusMobParticles.SLEEPING :

					particleSleeping(world, world.rand, entity);

					break;
			}
		}

		return (IMessage) null;
	}

	// TODO /* ======================================== MOD START =====================================*/

	private static void particleRangedAttacking(World world, Random random, Entity entity)
	{
		Vec3d ownerLookVec = entity.getLookVec();
		double spawnPosX = (entity.posX + (ownerLookVec.x * 1.5D));
		double spawnPosY = ((entity.posY + (entity.height * 0.7F)) + (ownerLookVec.y * 1.5D));
		double spawnPosZ = (entity.posZ + ownerLookVec.z * 1.5D);
		double randX = random.nextGaussian() * 0.02D;
		double randY = random.nextGaussian() * 0.02D;
		double randZ = random.nextGaussian() * 0.02D;

		if (random.nextInt(2) == 0)
		{
			world.spawnParticle(EnumParticleTypes.FLAME, spawnPosX, spawnPosY, spawnPosZ, randX, randY, randZ, new int[0]);
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, spawnPosX, spawnPosY, spawnPosZ, randX, randY, randZ, new int[0]);
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, spawnPosX, spawnPosY, spawnPosZ, randX, randY, randZ, new int[0]);
		}
	}

	private static void particleAngerAura(World world, Random random, Entity entity)
	{
		double pX = entity.posX + (double) (random.nextFloat() * entity.width * 2.0F) - (double) entity.width;
		double pY = entity.posY + (double) (random.nextFloat() * entity.height);
		double pZ = entity.posZ + (double) (random.nextFloat() * entity.width * 2.0F) - (double) entity.width;

		if (random.nextInt(5) == 0)
		{
			world.spawnParticle(EnumParticleTypes.FLAME, pX, pY, pZ, 0.0D, 0.0D, 0.0D, new int[0]);
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pX, pY, pZ, 0.0D, 0.0D, 0.0D, new int[0]);
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, pX, pY, pZ, 0.0D, 0.0D, 0.0D, new int[0]);
		}
	}

	private static void particleSleeping(World world, Random random, Entity entity)
	{
		Vec3d ownerLookVec = entity.getLookVec();
		double spawnPosX = (entity.posX + (ownerLookVec.x * 1.5D));
		double spawnPosY = ((entity.posY + (entity.height * 0.7F)) + (ownerLookVec.y * 1.5D));
		double spawnPosZ = (entity.posZ + ownerLookVec.z * 1.5D);
		double randX = random.nextGaussian() * 0.02D;
		double randY = random.nextGaussian() * 0.02D;
		double randZ = random.nextGaussian() * 0.02D;

		if (random.nextInt(2) == 0)
		{
			world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, spawnPosX, spawnPosY, spawnPosZ, randX, randY, randZ, new int[0]);
		}
	}

}

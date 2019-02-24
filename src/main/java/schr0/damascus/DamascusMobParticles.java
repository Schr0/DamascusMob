package schr0.damascus;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DamascusMobParticles
{
	public static final int RANGED_ATTACKING = 0;
	public static final int ANGER_AURA = 1;
	public static final int SLEEPING = 2;

	public static void spawnParticleRangedAttacking(Entity target)
	{
		DamascusMobMessages.DISPATCHER.sendToAll(new MessageParticleEntity(target, DamascusMobParticles.RANGED_ATTACKING));
	}

	public static void spawnParticleAngerAura(Entity target)
	{
		DamascusMobMessages.DISPATCHER.sendToAll(new MessageParticleEntity(target, DamascusMobParticles.ANGER_AURA));
	}

	public static void spawnParticleSleeping(Entity target)
	{
		DamascusMobMessages.DISPATCHER.sendToAll(new MessageParticleEntity(target, DamascusMobParticles.SLEEPING));
	}

}

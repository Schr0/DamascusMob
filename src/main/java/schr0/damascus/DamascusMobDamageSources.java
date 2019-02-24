package schr0.damascus;

import net.minecraft.util.DamageSource;

public class DamascusMobDamageSources
{
	private static final String DAMAGE_TYPE_MIASMA = DamascusMob.MOD_ID + "_" + "miasma";

	public static final DamageSource MIASMA = (new DamageSource(DAMAGE_TYPE_MIASMA)).setDamageBypassesArmor().setMagicDamage();

}

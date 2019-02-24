package schr0.damascus;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DamascusMobMessages
{

	public static final String CHANNEL_NAME = DamascusMob.MOD_ID;
	public static final SimpleNetworkWrapper DISPATCHER = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL_NAME);

	public static final int ID_PARTICLE_ENTITY = 0;

	public void register()
	{
		// none
	}

	@SideOnly(Side.CLIENT)
	public void registerClient()
	{
		DISPATCHER.registerMessage(MessageHandlerParticleEntity.class, MessageParticleEntity.class, ID_PARTICLE_ENTITY, Side.CLIENT);
	}

}

package xy177.alexsmobsdelightlegacy.common.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;

public final class AMDNetwork {
    private static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel(AlexsMobsDelightLegacy.MODID);

    private AMDNetwork() {
    }

    public static void register() {
        CHANNEL.registerMessage(PacketDeathRollAnimation.Handler.class, PacketDeathRollAnimation.class, 0, Side.CLIENT);
    }

    public static void sendDeathRollAnimation(EntityPlayerMP player) {
        PacketDeathRollAnimation packet = new PacketDeathRollAnimation(player.getEntityId(), 20);
        CHANNEL.sendTo(packet, player);
        CHANNEL.sendToAllAround(packet, new NetworkRegistry.TargetPoint(player.dimension, player.posX, player.posY, player.posZ, 64.0D));
    }
}

package xy177.alexsmobsdelightlegacy.common.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xy177.alexsmobsdelightlegacy.client.render.DeathRollAnimationTracker;

public class PacketDeathRollAnimation implements IMessage {
    private int entityId;
    private int ticks;

    public PacketDeathRollAnimation() {
    }

    public PacketDeathRollAnimation(int entityId, int ticks) {
        this.entityId = entityId;
        this.ticks = ticks;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        entityId = buf.readInt();
        ticks = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(entityId);
        buf.writeInt(ticks);
    }

    public static class Handler implements IMessageHandler<PacketDeathRollAnimation, IMessage> {
        @Override
        @SideOnly(Side.CLIENT)
        public IMessage onMessage(PacketDeathRollAnimation message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> DeathRollAnimationTracker.start(message.entityId, message.ticks));
            return null;
        }
    }
}

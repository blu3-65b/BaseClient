package git.blu3.baseclient.mixin.mixins;

import git.blu3.baseclient.event.events.EventReadPacket;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static git.blu3.baseclient.BaseClient.EVENT_BUS;

@Mixin({NetworkManager.class})
public class MixinNetworkManager
{
    @Inject(
            method = {"channelRead0(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet<?> p_channelRead0_2_, CallbackInfo info)
    {
        EventReadPacket event = new EventReadPacket(p_channelRead0_2_);
        EVENT_BUS.post(event);
        if (event.isCancelled()) info.cancel();
    }
}

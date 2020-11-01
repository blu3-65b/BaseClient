package git.blu3.baseclient.mixin.mixins;

import git.blu3.baseclient.event.events.EventSendPacket;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static git.blu3.baseclient.BaseClient.EVENT_BUS;

@Mixin({NetHandlerPlayClient.class})
public class MixinNetHandlerPlayClient
{

    @Inject(
            method = {"sendPacket(Lnet/minecraft/network/Packet;)V"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void sendPacket(Packet<?> packetIn, CallbackInfo info) {


        EventSendPacket event = new EventSendPacket(packetIn);
        EVENT_BUS.post(event);
        if (event.isCancelled()) info.cancel();

    }
}
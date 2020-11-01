package git.blu3.baseclient.event.events;


import git.blu3.baseclient.event.Event;
import net.minecraft.network.Packet;

/**
 * @author sl
 */
public class EventReadPacket extends Event {
    private Packet<?> packet;

    public EventReadPacket(Packet<?> packet) {
        this.packet = packet;
    }

    public Packet<?> getPacket() {
        return packet;
    }

    public void setPacket(Packet<?> packet) {
        this.packet = packet;
    }
}
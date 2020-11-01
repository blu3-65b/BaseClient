package git.blu3.baseclient;

import me.zero.alpine.fork.bus.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;


@Mod(modid = BaseClient.MODID, name = BaseClient.NAME, version = BaseClient.VERSION)
public class BaseClient
{
    public static final String MODID = "baseclient";
    public static final String NAME = "Base Client";
    public static final String VERSION = "0.1";

    public static final EventBus EVENT_BUS = new EventManager();

    // This is a base for a Minecraft client.
    // Nothing aside from the absolute basics have been written *yet*.

    // If I get to it, I will turn this into an actual base with modules, commands, a GUI, and settings.

    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
}

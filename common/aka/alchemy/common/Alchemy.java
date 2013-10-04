package aka.alchemy.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import aka.alchemy.common.blocks.ModBlocks;
import aka.alchemy.common.config.ConfigurationHandler;
import aka.alchemy.common.core.proxy.CommonProxy;
import aka.alchemy.common.creativetab.CreativeTabAlchemy;
import aka.alchemy.common.gen.AlchemyWorldGenerator;
import aka.alchemy.common.helper.LogHelper;
import aka.alchemy.common.items.ModItems;
import aka.alchemy.common.lib.Reference;
import aka.alchemy.core.handlers.events.EntityEventHandler;
import aka.alchemy.core.handlers.events.EntityLivingEventHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class Alchemy
{

    // The instance of your mod that Forge uses.
    @Instance(Reference.MOD_ID)
    public static Alchemy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    public CreativeTabs alchemyTab = new CreativeTabAlchemy(
            CreativeTabs.getNextID(), Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        // initialize the logger
        LogHelper.init();

        // Load config file
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        proxy.registerRenderers();

        ModBlocks.init();
        ModItems.init();

        AlchemyWorldGenerator.registerGenerators();

        // register event handlers
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        MinecraftForge.EVENT_BUS.register(new EntityLivingEventHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // Stub Method
    }
}
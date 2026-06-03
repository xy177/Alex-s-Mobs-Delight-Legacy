package xy177.alexsmobsdelightlegacy;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.SidedProxy;
import xy177.alexsmobsdelightlegacy.common.CommonProxy;
import xy177.alexsmobsdelightlegacy.common.config.AMDConfig;
import xy177.alexsmobsdelightlegacy.common.registry.AMDBlocks;
import xy177.alexsmobsdelightlegacy.common.registry.AMDCreativeTab;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEntities;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEffects;
import xy177.alexsmobsdelightlegacy.common.registry.AMDHuntingDropRegistry;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;
import xy177.alexsmobsdelightlegacy.common.registry.AMDRecipeRegistry;
import xy177.alexsmobsdelightlegacy.common.network.AMDNetwork;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntityAMDLargeFeast;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntityKiviak;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntitySteamedStuffedCrocodile;

@Mod(
    modid = AlexsMobsDelightLegacy.MODID,
    name = AlexsMobsDelightLegacy.NAME,
    version = AlexsMobsDelightLegacy.VERSION,
    dependencies = "required-after:farmersdelight;required-after:alexsmobs;required-after:citadel"
)
@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public class AlexsMobsDelightLegacy {
    public static final String MODID = "alexsmobsdelightlegacy";
    public static final String NAME = "Alex's Mobs Delight Legacy";
    public static final String VERSION = "1.0.0";
    public static final CreativeTabs CREATIVE_TAB = AMDCreativeTab.INSTANCE;

    @Mod.Instance(MODID)
    public static AlexsMobsDelightLegacy instance;

    private static Logger logger;

    @SidedProxy(
        clientSide = "xy177.alexsmobsdelightlegacy.client.ClientProxy",
        serverSide = "xy177.alexsmobsdelightlegacy.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        AMDConfig.load(event.getModConfigurationDirectory());
        AMDNetwork.register();
        AMDEntities.register();
        net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity(TileEntityAMDLargeFeast.class, MODID + ":large_feast");
        net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity(TileEntityKiviak.class, MODID + ":kiviak");
        net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity(TileEntitySteamedStuffedCrocodile.class, MODID + ":steamed_stuffed_crocodile");
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
        AMDRecipeRegistry.registerRuntimeRecipes();
        AMDHuntingDropRegistry.register();
        logger.info("{} initialized.", NAME);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        AMDBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        AMDItems.register(event.getRegistry());
        AMDBlocks.registerItemBlocks(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerPotions(RegistryEvent.Register<Potion> event) {
        AMDEffects.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void registerRecipes(RegistryEvent.Register<IRecipe> event) {
        AMDRecipeRegistry.registerCraftingRecipes(event.getRegistry());
    }

    public static Logger getLogger() {
        return logger;
    }
}

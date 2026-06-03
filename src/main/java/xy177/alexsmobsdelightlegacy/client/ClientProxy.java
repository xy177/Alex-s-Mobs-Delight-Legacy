package xy177.alexsmobsdelightlegacy.client;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownBanana;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownLobsterDart;
import xy177.alexsmobsdelightlegacy.client.render.RenderDeathRollPlayer;
import xy177.alexsmobsdelightlegacy.client.render.RenderThrownPointedItem;
import xy177.alexsmobsdelightlegacy.common.CommonProxy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDBlocks;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID, value = Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        registerProjectileRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        installProjectileRenderers(renderManager);
        try {
            Map<String, RenderPlayer> skinMap = ReflectionHelper.getPrivateValue(RenderManager.class, renderManager, "skinMap", "field_178636_l");
            skinMap.put("default", new RenderDeathRollPlayer(renderManager, false));
            skinMap.put("slim", new RenderDeathRollPlayer(renderManager, true));
        } catch (RuntimeException exception) {
            AlexsMobsDelightLegacy.getLogger().warn("Failed to replace player renderers for death roll animation; falling back to the ripple layer only.", exception);
            for (RenderPlayer renderer : renderManager.getSkinMap().values()) {
                renderer.addLayer(new xy177.alexsmobsdelightlegacy.client.render.LayerDeathRollAnim(renderer));
            }
        }
    }

    private static void registerProjectileRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(
            EntityThrownBanana.class,
            manager -> new RenderThrownPointedItem<>(manager, EntityThrownBanana::getRenderStack, -45.0F)
        );
        RenderingRegistry.registerEntityRenderingHandler(
            EntityThrownLobsterDart.class,
            manager -> new RenderThrownPointedItem<>(manager, EntityThrownLobsterDart::getRenderStack, -135.0F)
        );
    }

    private static void installProjectileRenderers(RenderManager renderManager) {
        renderManager.entityRenderMap.put(
            EntityThrownBanana.class,
            new RenderThrownPointedItem<>(renderManager, EntityThrownBanana::getRenderStack, -45.0F)
        );
        renderManager.entityRenderMap.put(
            EntityThrownLobsterDart.class,
            new RenderThrownPointedItem<>(renderManager, EntityThrownLobsterDart::getRenderStack, -135.0F)
        );
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
        AMDItems.registerModels();
        AMDBlocks.registerModels();
    }

    public static void registerItemModel(net.minecraft.item.Item item) {
        ModelLoader.setCustomModelResourceLocation(
            item,
            0,
            new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }
}

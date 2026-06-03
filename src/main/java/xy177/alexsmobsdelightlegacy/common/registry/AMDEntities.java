package xy177.alexsmobsdelightlegacy.common.registry;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownBanana;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownLobsterDart;

public final class AMDEntities {
    private static int nextId = 0;

    private AMDEntities() {
    }

    public static void register() {
        register("thrown_banana", EntityThrownBanana.class, 64, 10, true);
        register("thrown_lobster_dart", EntityThrownLobsterDart.class, 64, 20, true);
    }

    private static void register(String name, Class entityClass, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates) {
        EntityRegistry.registerModEntity(
            new ResourceLocation(AlexsMobsDelightLegacy.MODID, name),
            entityClass,
            name,
            nextId++,
            AlexsMobsDelightLegacy.instance,
            trackingRange,
            updateFrequency,
            sendsVelocityUpdates
        );
    }
}

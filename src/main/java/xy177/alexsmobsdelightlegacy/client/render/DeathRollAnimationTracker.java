package xy177.alexsmobsdelightlegacy.client.render;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID, value = Side.CLIENT)
public final class DeathRollAnimationTracker {
    private static final Map<Integer, Integer> ACTIVE_TICKS = new HashMap<>();

    private DeathRollAnimationTracker() {
    }

    public static void start(int entityId, int ticks) {
        ACTIVE_TICKS.put(entityId, Math.max(ticks, ACTIVE_TICKS.getOrDefault(entityId, 0)));
    }

    public static boolean isActive(int entityId) {
        Integer ticks = ACTIVE_TICKS.get(entityId);
        return ticks != null && ticks > 0;
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END || ACTIVE_TICKS.isEmpty()) {
            return;
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = ACTIVE_TICKS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int ticks = entry.getValue() - 1;
            if (ticks <= 0) {
                iterator.remove();
            } else {
                entry.setValue(ticks);
            }
        }
    }
}

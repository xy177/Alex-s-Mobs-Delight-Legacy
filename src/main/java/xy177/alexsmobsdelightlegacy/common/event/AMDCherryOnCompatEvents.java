package xy177.alexsmobsdelightlegacy.common.event;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDCherryOnCompatEvents {
    private static final String TREASURE_EVENT = "suike.suikecherry.event.CherryEvent$TreasureInitEvent";

    private AMDCherryOnCompatEvents() {
    }

    @SubscribeEvent
    public static void onCherryTreasureInit(Event event) {
        if (!Loader.isModLoaded("suikecherry") || !TREASURE_EVENT.equals(event.getClass().getName())) {
            return;
        }
        try {
            Class<?> structureClass = Class.forName("suike.suikecherry.data.TreasureData$Structure");
            Object oceanRuins = Enum.valueOf((Class<Enum>) structureClass.asSubclass(Enum.class), "OCEAN_RUINS");
            Method isTarget = event.getClass().getMethod("isTargetStructure", structureClass);
            if (!Boolean.TRUE.equals(isTarget.invoke(event, oceanRuins))) {
                return;
            }

            Class<?> treasureClass = Class.forName("suike.suikecherry.data.TreasureData");
            Constructor<?> constructor = treasureClass.getConstructor(ItemStack.class, float.class);
            Object treasure = constructor.newInstance(new ItemStack(AMDItems.SEAGULL_WAND), 0.1F);
            Object array = Array.newInstance(treasureClass, 1);
            Array.set(array, 0, treasure);
            Method addTreasure = event.getClass().getMethod("addTreasure", array.getClass());
            addTreasure.invoke(event, array);
        } catch (ReflectiveOperationException ex) {
            AlexsMobsDelightLegacy.getLogger().warn("Failed to add seagull wand to Cherry_on archaeology treasures.", ex);
        }
    }
}

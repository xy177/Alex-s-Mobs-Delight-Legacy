package xy177.alexsmobsdelightlegacy.common.event;

import com.github.alexthe666.alexsmobs.entity.EntityMantisShrimp;
import com.github.alexthe666.alexsmobs.misc.AMTagRegistry;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

public final class AMDMantisShrimpEvents {
    private static final String LAST_HELD_EGG = AlexsMobsDelightLegacy.MODID + ":last_mantis_shrimp_held_egg";

    private AMDMantisShrimpEvents() {
    }

    @Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
    public static class Handler {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void addEggsToShrimpFryables(LivingEvent.LivingUpdateEvent event) {
            if (event.getEntityLiving() instanceof EntityMantisShrimp) {
                ensureShrimpFryables();
            }
        }

        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
            if (event.getEntityLiving().world.isRemote || !(event.getEntityLiving() instanceof EntityMantisShrimp)) {
                return;
            }

            EntityMantisShrimp shrimp = (EntityMantisShrimp) event.getEntityLiving();
            NBTTagCompound data = shrimp.getEntityData();
            ItemStack held = shrimp.getHeldItemMainhand();
            boolean heldShrimpFriedRice = isItem(held, "alexsmobs:shrimp_fried_rice");

            if (data.getBoolean(LAST_HELD_EGG) && heldShrimpFriedRice) {
                held = new ItemStack(AMDItems.SHRIMP_FRIED_EGG);
                shrimp.setHeldItem(EnumHand.MAIN_HAND, held);
            }

            data.setBoolean(LAST_HELD_EGG, isEgg(held));
        }

        private static void ensureShrimpFryables() {
            AMTagRegistry.loadItemTagSetFor(AMTagRegistry.SHRIMP_RICE_FRYABLES);
            Set<Item> fryables = AMTagRegistry.ITEM_TAG_SETS.get(AMTagRegistry.SHRIMP_RICE_FRYABLES);
            if (fryables == null) {
                fryables = new HashSet<>();
                AMTagRegistry.ITEM_TAG_SETS.put(AMTagRegistry.SHRIMP_RICE_FRYABLES, fryables);
            }
            fryables.add(Items.EGG);
            for (ItemStack stack : OreDictionary.getOres("listAllEgg")) {
                if (!stack.isEmpty()) {
                    fryables.add(stack.getItem());
                }
            }
            for (ItemStack stack : OreDictionary.getOres("cropRice")) {
                if (!stack.isEmpty()) {
                    fryables.add(stack.getItem());
                }
            }
        }

        private static boolean isEgg(ItemStack stack) {
            if (stack.isEmpty()) {
                return false;
            }
            if (stack.getItem() == Items.EGG) {
                return true;
            }
            for (int oreId : OreDictionary.getOreIDs(stack)) {
                if ("listAllEgg".equals(OreDictionary.getOreName(oreId))) {
                    return true;
                }
            }
            return false;
        }

        private static boolean isItem(ItemStack stack, String id) {
            if (stack.isEmpty() || stack.getItem().getRegistryName() == null) {
                return false;
            }
            return new ResourceLocation(id).equals(stack.getItem().getRegistryName());
        }
    }
}

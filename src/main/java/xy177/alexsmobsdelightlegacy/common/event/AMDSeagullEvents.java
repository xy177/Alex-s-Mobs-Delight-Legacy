package xy177.alexsmobsdelightlegacy.common.event;

import com.github.alexthe666.alexsmobs.entity.EntitySeagull;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.common.item.AMDFoodItem;
import xy177.alexsmobsdelightlegacy.common.item.ItemEnchantedSeagullFood;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEffects;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy.MODID)
public final class AMDSeagullEvents {
    private static final String LAST_HELD_TAG = "AMDLastSeagullFood";
    private static final String ETERNAL_TAG = "AMDConsumedEternalFood";
    private static final String EFFECTS_TAG = "AMDConsumedFoodEffects";

    private AMDSeagullEvents() {
    }

    @SubscribeEvent
    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase living = event.getEntityLiving();
        if (!living.world.isRemote && living instanceof EntitySeagull) {
            trackSeagullFood((EntitySeagull) living);
        }

        Potion potion = AMDEffects.SEAGULL_ANOREXIA;
        if (potion == null || !living.isPotionActive(potion)) {
            return;
        }

        for (Entity entity : living.world.getEntitiesWithinAABB(EntitySeagull.class, living.getEntityBoundingBox().grow(16.0D))) {
            if (entity instanceof EntitySeagull) {
                ((EntitySeagull) entity).stealCooldown = Math.max(((EntitySeagull) entity).stealCooldown, 200);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event) {
        if (event.getEntityLiving().world.isRemote || !(event.getEntityLiving() instanceof EntitySeagull)) {
            return;
        }
        NBTTagCompound data = event.getEntityLiving().getEntityData();
        boolean eternal = data.getBoolean(ETERNAL_TAG);
        if (data.hasKey(EFFECTS_TAG, 9)) {
            ItemStack drop = new ItemStack(eternal ? AMDItems.ENCHANTED_ETERNAL_COOKED_SEAGULL : AMDItems.ENCHANTED_COOKED_SEAGULL);
            drop.setTagInfo(ItemEnchantedSeagullFood.EFFECTS_TAG, data.getTagList(EFFECTS_TAG, 10).copy());
            addDrop(event, drop);
        } else if (eternal) {
            addDrop(event, new ItemStack(AMDItems.ETERNAL_COOKED_SEAGULL));
        }
    }

    private static void trackSeagullFood(EntitySeagull seagull) {
        ItemStack held = seagull.getHeldItemMainhand();
        NBTTagCompound data = seagull.getEntityData();
        if (!held.isEmpty()) {
            data.setTag(LAST_HELD_TAG, held.copy().writeToNBT(new NBTTagCompound()));
            return;
        }
        if (!data.hasKey(LAST_HELD_TAG, 10)) {
            return;
        }
        ItemStack consumed = new ItemStack(data.getCompoundTag(LAST_HELD_TAG));
        data.removeTag(LAST_HELD_TAG);
        if (consumed.isEmpty()) {
            return;
        }
        if (consumed.getItem() == AMDItems.ETERNAL_COOKED_SEAGULL || consumed.getItem() == AMDItems.ENCHANTED_ETERNAL_COOKED_SEAGULL) {
            data.setBoolean(ETERNAL_TAG, true);
        }
        if (consumed.getItem() instanceof AMDFoodItem) {
            List<PotionEffect> effects = ((AMDFoodItem) consumed.getItem()).createAppliedEffects(seagull.world);
            if (!effects.isEmpty()) {
                ItemStack storage = new ItemStack(AMDItems.ENCHANTED_COOKED_SEAGULL);
                ItemEnchantedSeagullFood.writeStoredEffects(storage, effects);
                data.setTag(EFFECTS_TAG, storage.getTagCompound().getTagList(ItemEnchantedSeagullFood.EFFECTS_TAG, 10));
            }
        }
    }

    private static void addDrop(LivingDropsEvent event, ItemStack stack) {
        if (stack.isEmpty()) {
            return;
        }
        EntityLivingBase entity = event.getEntityLiving();
        event.getDrops().add(new EntityItem(entity.world, entity.posX, entity.posY, entity.posZ, stack));
    }
}

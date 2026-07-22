package xy177.alexsmobsdelightlegacy.common.registry;

import com.google.common.collect.ImmutableList;
import com.github.alexthe666.alexsmobs.entity.EntityMantisShrimp;
import com.wdcftgg.farmersdelightlegacy.api.recipe.knife.HuntingDropOutput;
import com.wdcftgg.farmersdelightlegacy.api.recipe.knife.HuntingDropRecipeApi;
import com.wdcftgg.farmersdelightlegacy.common.recipe.manager.HuntingDropRecipeManager;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;

public final class AMDHuntingDropRegistry {
    private static boolean registered;

    private AMDHuntingDropRegistry() {
    }

    public static void register() {
        if (registered) {
            return;
        }
        registered = true;
        registerAnyKillJei();
        registerKnifeDrops();
    }

    private static void registerAnyKillJei() {
        registerJei("grizzly_bear_raw", "alexsmobs:grizzly_bear", outputs(output(AMDItems.RAW_BEAR_MEAT, 1, 1.0F), output(AMDItems.RAW_BEAR_MEAT, 1, 0.66F), output(AMDItems.RAW_BEAR_MEAT, 1, 0.33F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("grizzly_bear_cooked", "alexsmobs:grizzly_bear", outputs(output(AMDItems.COOKED_BEAR_MEAT, 1, 1.0F), output(AMDItems.COOKED_BEAR_MEAT, 1, 0.66F), output(AMDItems.COOKED_BEAR_MEAT, 1, 0.33F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("polar_bear_raw", "minecraft:polar_bear", outputs(output(AMDItems.RAW_BEAR_MEAT, 1, 1.0F), output(AMDItems.RAW_BEAR_MEAT, 1, 0.5F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("polar_bear_cooked", "minecraft:polar_bear", outputs(output(AMDItems.COOKED_BEAR_MEAT, 1, 1.0F), output(AMDItems.COOKED_BEAR_MEAT, 1, 0.5F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("bison", "alexsmobs:bison", outputs(output(AMDItems.RAW_BISON_MEAT, 1, 1.0F), output(AMDItems.RAW_BISON_MEAT, 1, 0.5F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("bison_cooked", "alexsmobs:bison", outputs(output(AMDItems.COOKED_BISON_MEAT, 1, 1.0F), output(AMDItems.COOKED_BISON_MEAT, 1, 0.5F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("devils_hole_pupfish", "alexsmobs:devils_hole_pupfish", outputs(output(AMDItems.RAW_DEVILS_HOLE_PUPFISH, 1, 1.0F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("devils_hole_pupfish_cooked", "alexsmobs:devils_hole_pupfish", outputs(output(AMDItems.COOKED_DEVILS_HOLE_PUPFISH, 1, 1.0F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("seal", "alexsmobs:seal", outputs(output(AMDItems.SEAL_MEAT, 1, 1.0F), output(AMDItems.SEAL_MEAT, 1, 0.5F), output(AMDItems.SEAL_LEATHER_BROWN, 1, 0.5F), output(AMDItems.SEAL_LEATHER_GRAY, 1, 0.5F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("seal_cooked", "alexsmobs:seal", outputs(output(AMDItems.COOKED_SEAL_MEAT, 1, 1.0F), output(AMDItems.COOKED_SEAL_MEAT, 1, 0.5F), output(AMDItems.SEAL_LEATHER_BROWN, 1, 0.5F), output(AMDItems.SEAL_LEATHER_GRAY, 1, 0.5F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("cachalot_whale", "alexsmobs:cachalot_whale", outputs(output(AMDItems.WHALE_MEAT, 2, 1.0F), output(AMDItems.WHALE_MEAT, 1, 0.66F), output(AMDItems.WHALE_MEAT, 1, 0.33F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("cachalot_whale_cooked", "alexsmobs:cachalot_whale", outputs(output(AMDItems.COOKED_WHALE_MEAT, 2, 1.0F), output(AMDItems.COOKED_WHALE_MEAT, 1, 0.66F), output(AMDItems.COOKED_WHALE_MEAT, 1, 0.33F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("mantis_shrimp_tail", "alexsmobs:mantis_shrimp", shrimpTailOutputs(false), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("mantis_shrimp_tail_cooked", "alexsmobs:mantis_shrimp", outputs(output(AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 1, 1.0F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("lobster", "alexsmobs:lobster", outputs(output(AMDItems.LOBSTER_HEAD, 1, 1.0F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("seagull_raw", "alexsmobs:seagull", outputs(output(AMDItems.RAW_SEAGULL, 1, 1.0F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("seagull_cooked", "alexsmobs:seagull", outputs(output(AMDItems.COOKED_SEAGULL, 1, 1.0F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("tusklin_raw", "alexsmobs:tusklin", outputs(output(AMDItems.RAW_TUSKLIN_MEAT, 2, 1.0F), output(AMDItems.RAW_TUSKLIN_MEAT, 1, 0.66F), output(AMDItems.RAW_TUSKLIN_MEAT, 1, 0.33F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("tusklin_cooked", "alexsmobs:tusklin", outputs(output(AMDItems.COOKED_TUSKLIN_MEAT, 2, 1.0F), output(AMDItems.COOKED_TUSKLIN_MEAT, 1, 0.66F), output(AMDItems.COOKED_TUSKLIN_MEAT, 1, 0.33F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("mimic_octopus_raw", "alexsmobs:mimic_octopus", outputs(output(AMDItems.MIMIC_OCTOPUS_TENTACLE, 1, 1.0F), output(AMDItems.MIMIC_OCTOPUS_TENTACLE, 1, 0.66F), output(AMDItems.MIMIC_OCTOPUS_TENTACLE, 1, 0.33F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("mimic_octopus_cooked", "alexsmobs:mimic_octopus", outputs(output(AMDItems.COOKED_OCTOPUS_TENTACLE, 1, 1.0F), output(AMDItems.COOKED_OCTOPUS_TENTACLE, 1, 0.66F), output(AMDItems.COOKED_OCTOPUS_TENTACLE, 1, 0.33F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
        registerJei("crocodile_raw", "alexsmobs:crocodile", outputs(output(AMDItems.RAW_CROCODILE_MEAT, 1, 1.0F), output(AMDItems.RAW_CROCODILE_MEAT, 1, 0.75F), output(AMDItems.RAW_CROCODILE_MEAT, 1, 0.5F), output(AMDItems.RAW_CROCODILE_MEAT, 1, 0.25F)), false, "alexsmobsdelightlegacy.jei.hunting_drops.any_kill");
        registerJei("crocodile_cooked", "alexsmobs:crocodile", outputs(output(AMDItems.COOKED_CROCODILE_MEAT, 1, 1.0F), output(AMDItems.COOKED_CROCODILE_MEAT, 1, 0.75F), output(AMDItems.COOKED_CROCODILE_MEAT, 1, 0.5F), output(AMDItems.COOKED_CROCODILE_MEAT, 1, 0.25F)), true, "alexsmobsdelightlegacy.jei.hunting_drops.burning");
    }

    private static void registerKnifeDrops() {
        registerKnife("grizzly_bear_extra_raw", entity -> hasEntityId(entity, id("alexsmobs:grizzly_bear")) && !entity.isBurning(), id("alexsmobs:grizzly_bear"), outputs(output(AMDItems.RAW_BEAR_MEAT, 1, 0.5F)), false);
        registerKnife("grizzly_bear_extra_cooked", entity -> hasEntityId(entity, id("alexsmobs:grizzly_bear")) && entity.isBurning(), id("alexsmobs:grizzly_bear"), outputs(output(AMDItems.COOKED_BEAR_MEAT, 1, 0.5F)), true);
        registerKnife("giant_squid_lost_tentacle", "alexsmobs:giant_squid", outputs(output(stack("alexsmobs:lost_tentacle"), 1, 0.6F, 0.0625F)), false);
        registerKnife("moose_antler", "alexsmobs:moose", outputs(output(stack("alexsmobs:moose_antler"), 1, 0.3F, 0.0625F)), false);
        registerKnife("mantis_shrimp_hammer", entity -> hasEntityId(entity, id("alexsmobs:mantis_shrimp")) && shrimpVariant(entity) == 0, id("alexsmobs:mantis_shrimp"), outputs(output(AMDItems.MANTIS_SHRIMP_HAMMER, 1, 0.5F, 0.1F)), false);
        registerKnife("mantis_shrimp_shovel", entity -> hasEntityId(entity, id("alexsmobs:mantis_shrimp")) && shrimpVariant(entity) == 1, id("alexsmobs:mantis_shrimp"), outputs(output(AMDItems.MANTIS_SHRIMP_SHOVEL, 1, 0.5F, 0.1F)), false);
        registerKnife("mantis_shrimp_axe", entity -> hasEntityId(entity, id("alexsmobs:mantis_shrimp")) && shrimpVariant(entity) == 2, id("alexsmobs:mantis_shrimp"), outputs(output(AMDItems.MANTIS_SHRIMP_AXE, 1, 0.5F, 0.1F)), false);
        registerKnife("mantis_shrimp_scythe", entity -> hasEntityId(entity, id("alexsmobs:mantis_shrimp")) && shrimpVariant(entity) == 3, id("alexsmobs:mantis_shrimp"), outputs(output(AMDItems.MANTIS_SHRIMP_SCYTHE, 1, 0.5F, 0.1F)), false);
        if (!Loader.isModLoaded("suikecherry")) {
            registerKnife("seagull_wand", "alexsmobs:seagull", outputs(output(AMDItems.SEAGULL_WAND, 1, 0.1F)), false);
        }
        registerKnife("crocodile_parts_raw", entity -> hasEntityId(entity, id("alexsmobs:crocodile")) && !entity.isBurning(), id("alexsmobs:crocodile"), crocodilePartOutputs(false), false);
        registerKnife("crocodile_parts_cooked", entity -> hasEntityId(entity, id("alexsmobs:crocodile")) && entity.isBurning(), id("alexsmobs:crocodile"), crocodilePartOutputs(true), true);
    }

    private static void registerJei(String key, String entityId, List<HuntingDropOutput> outputs, boolean burning, String displayKey) {
        HuntingDropRecipeApi.registerRecipeAdvanceJei(recipeId(key), matcher(id(entityId)), outputs, burning, id(entityId), null, false, ImmutableList.of(displayKey));
    }

    private static void registerKnife(String key, String entityId, List<HuntingDropOutput> outputs, boolean burning) {
        registerKnife(key, matcher(id(entityId)), id(entityId), outputs, burning);
    }

    private static void registerKnife(String key, HuntingDropRecipeManager.HuntingTargetMatcher matcher, ResourceLocation entityId, List<HuntingDropOutput> outputs, boolean burning) {
        HuntingDropRecipeApi.registerRecipeAdvance(recipeId(key), matcher, outputs, burning, entityId, null, false, Collections.emptyList());
    }

    private static List<HuntingDropOutput> crocodilePartOutputs(boolean cooked) {
        Item claw = cooked ? AMDItems.COOKED_CROCODILE_CLAW : AMDItems.RAW_CROCODILE_CLAW;
        Item tail = cooked ? AMDItems.COOKED_CROCODILE_TAIL : AMDItems.RAW_CROCODILE_TAIL;
        return outputs(output(claw, 2, 1.0F), output(claw, 1, 0.66F), output(claw, 1, 0.33F), output(tail, 1, 1.0F));
    }

    private static List<HuntingDropOutput> shrimpTailOutputs(boolean cooked) {
        if (cooked) {
            return outputs(output(AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 1, 1.0F));
        }
        return outputs(
            output(AMDItems.MANTIS_SHRIMP_TAIL_RED, 1, 0.25F),
            output(AMDItems.MANTIS_SHRIMP_TAIL_GREEN, 1, 0.25F),
            output(AMDItems.MANTIS_SHRIMP_TAIL_LIME, 1, 0.25F),
            output(AMDItems.MANTIS_SHRIMP_TAIL_WHITE, 1, 0.25F)
        );
    }

    private static List<HuntingDropOutput> outputs(HuntingDropOutput... outputs) {
        return ImmutableList.copyOf(outputs);
    }

    private static HuntingDropOutput output(Item item, int count, float chance) {
        return output(item, count, chance, 0.0F);
    }

    private static HuntingDropOutput output(Item item, int count, float chance, float lootingBonus) {
        return output(item == null ? ItemStack.EMPTY : new ItemStack(item, count), chance, lootingBonus);
    }

    private static HuntingDropOutput output(ItemStack stack, int count, float chance, float lootingBonus) {
        ItemStack copy = stack.copy();
        copy.setCount(count);
        return output(copy, chance, lootingBonus);
    }

    private static HuntingDropOutput output(ItemStack stack, float chance, float lootingBonus) {
        return HuntingDropOutput.of(stack, chance, lootingBonus);
    }

    private static HuntingDropRecipeManager.HuntingTargetMatcher matcher(ResourceLocation entityId) {
        return entity -> hasEntityId(entity, entityId);
    }

    private static boolean hasEntityId(EntityLivingBase entity, ResourceLocation entityId) {
        ResourceLocation key = EntityList.getKey(entity);
        return entityId.equals(key);
    }

    private static int shrimpVariant(EntityLivingBase entity) {
        return entity instanceof EntityMantisShrimp ? ((EntityMantisShrimp) entity).getVariant() : 0;
    }

    private static ItemStack stack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(id(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    private static ResourceLocation id(String id) {
        return new ResourceLocation(id);
    }

    private static String recipeId(String path) {
        return AlexsMobsDelightLegacy.MODID + ":" + path;
    }
}

package xy177.alexsmobsdelightlegacy.common.registry;

import com.wdcftgg.farmersdelightlegacy.api.recipe.CookingPotRecipeApi;
import com.wdcftgg.farmersdelightlegacy.api.recipe.CuttingBoardRecipeApi;
import com.wdcftgg.farmersdelightlegacy.common.recipe.CampfireCookingRecipeManager;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public final class AMDRecipeRegistry {
    private static boolean registered;

    private AMDRecipeRegistry() {
    }

    public static void registerCraftingRecipes(IForgeRegistry<IRecipe> registry) {
        registerKiviakCrafting(registry);
        registerRawWholeCrocodileCrafting(registry);
        registerFoodCrafting(registry);
    }

    public static void registerRuntimeRecipes() {
        if (registered) {
            return;
        }
        registered = true;
        registerSmelting(AMDItems.RAW_BEAR_MEAT, AMDItems.COOKED_BEAR_MEAT, 0.35F);
        registerSmelting(AMDItems.RAW_BEAR_MEAT_SLICE, AMDItems.COOKED_BEAR_MEAT_SLICE, 0.35F);
        registerSmelting(AMDItems.RAW_BISON_MEAT, AMDItems.COOKED_BISON_MEAT, 0.35F);
        registerSmelting(AMDItems.RAW_BISON_MEAT_CUBES, AMDItems.COOKED_BISON_MEAT_CUBES, 0.35F);
        registerSmelting(AMDItems.RAW_KANGAROO_MEAT_SLICE, AMDItems.COOKED_KANGAROO_MEAT_SLICE, 0.35F);
        registerSmelting(AMDItems.RAW_MOOSE_RIB_PIECE, AMDItems.COOKED_MOOSE_RIB_PIECE, 0.35F);
        registerSmelting(AMDItems.RAW_SEAGULL, AMDItems.COOKED_SEAGULL, 0.35F);
        registerSmelting(AMDItems.MANTIS_SHRIMP_TAIL_RED, AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 0.35F);
        registerSmelting(AMDItems.MANTIS_SHRIMP_TAIL_GREEN, AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 0.35F);
        registerSmelting(AMDItems.MANTIS_SHRIMP_TAIL_LIME, AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 0.35F);
        registerSmelting(AMDItems.MANTIS_SHRIMP_TAIL_WHITE, AMDItems.COOKED_MANTIS_SHRIMP_TAIL, 0.35F);
        registerSmelting(AMDItems.RAW_TUSKLIN_MEAT, AMDItems.COOKED_TUSKLIN_MEAT, 0.35F);
        registerSmelting(AMDItems.RAW_TUSKLIN_MEAT_PIECE, AMDItems.COOKED_TUSKLIN_MEAT_PIECE, 0.35F);
        registerSmelting(AMDItems.RAW_DEVILS_HOLE_PUPFISH, AMDItems.COOKED_DEVILS_HOLE_PUPFISH, 0.35F);
        registerSmelting(AMDItems.RAW_DEVILS_HOLE_PUPFISH_SLICE, AMDItems.COOKED_DEVILS_HOLE_PUPFISH_SLICE, 0.35F);
        registerSmelting(AMDItems.RAW_CATFISH_SLICE, AMDItems.COOKED_CATFISH_SLICE, 0.35F);
        registerSmelting(AMDItems.RAW_CROCODILE_CLAW, AMDItems.COOKED_CROCODILE_CLAW, 0.35F);
        registerSmelting(AMDItems.RAW_CROCODILE_TAIL, AMDItems.COOKED_CROCODILE_TAIL, 0.35F);
        registerSmelting(AMDItems.RAW_CROCODILE_MEAT, AMDItems.COOKED_CROCODILE_MEAT, 0.35F);
        registerSmelting(AMDItems.MIMIC_OCTOPUS_TENTACLE, AMDItems.COOKED_OCTOPUS_TENTACLE, 0.35F);
        registerSmelting(AMDItems.WHALE_MEAT, AMDItems.COOKED_WHALE_MEAT, 0.35F);
        registerSmelting(AMDItems.SEAL_MEAT, AMDItems.COOKED_SEAL_MEAT, 0.35F);
        registerSmelting(AMDItems.SEAL_LEATHER_BROWN, Items.LEATHER, 0.35F);
        registerSmelting(AMDItems.SEAL_LEATHER_GRAY, Items.LEATHER, 0.35F);
        registerSmelting(AMDItems.RAW_TUSKLIN_SAUSAGE, AMDItems.SMOKED_TUSKLIN_SAUSAGE, 0.35F);
        registerCuttingBoardRecipes();
        registerCampfireRecipes();
        registerCookingPotRecipes();
    }

    private static void registerSmelting(net.minecraft.item.Item input, net.minecraft.item.Item output, float exp) {
        if (input != null && output != null) {
            GameRegistry.addSmelting(input, new ItemStack(output), exp);
        }
    }

    private static void registerSmelting(String inputId, Item output, float exp) {
        ItemStack input = stack(inputId);
        if (!input.isEmpty() && output != null) {
            GameRegistry.addSmelting(input, new ItemStack(output), exp);
        }
    }

    private static void registerCuttingBoardRecipes() {
        CuttingBoardRecipeApi.registerRecipe(id("raw_bear_meat_slice"), id("raw_bear_meat"), null, id("raw_bear_meat_slice"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_bison_meat_cubes"), id("raw_bison_meat"), null, id("raw_bison_meat_cubes"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("minced_beef_from_bison_meat_cubes"), id("raw_bison_meat_cubes"), null, "farmersdelight:minced_beef", 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_devils_hole_pupfish_slice"), id("raw_devils_hole_pupfish"), null, id("raw_devils_hole_pupfish_slice"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_tusklin_meat_piece"), id("raw_tusklin_meat"), null, id("raw_tusklin_meat_piece"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_bacon_from_tusklin_meat"), id("raw_tusklin_meat_piece"), null, "farmersdelight:bacon", 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("cooked_tusklin_meat_piece"), id("cooked_tusklin_meat"), null, id("cooked_tusklin_meat_piece"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("cooked_devils_hole_pupfish_slice"), id("cooked_devils_hole_pupfish"), null, id("cooked_devils_hole_pupfish_slice"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("dried_shredded_squid"), id("cooked_lost_tentacle"), null, id("dried_shredded_squid"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("slice_of_moose_pie"), id("moose_pie"), null, id("slice_of_moose_pie"), 4, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(
            id("banana_slice"),
            new String[] { "alexsmobs:banana" },
            null,
            new String[] { id("banana_slice"), "alexsmobs:banana_peel" },
            new int[] { 2, 1 },
            new float[] { 1.0F, 1.0F }
        );
        CuttingBoardRecipeApi.registerRecipe(id("raw_catfish_slice"), "alexsmobs:raw_catfish", null, id("raw_catfish_slice"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_kangaroo_meat_slice"), "alexsmobs:kangaroo_meat", null, id("raw_kangaroo_meat_slice"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("raw_moose_rib_piece"), "alexsmobs:moose_ribs", null, id("raw_moose_rib_piece"), 2, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("banana_roll_slice"), id("banana_roll"), null, id("banana_roll_slice"), 3, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("slice_of_smoked_tusklin_sausage"), id("smoked_tusklin_sausage"), null, id("slice_of_smoked_tusklin_sausage"), 3, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(id("burger_from_big_mac"), id("big_mac"), null, "farmersdelight:hamburger", 4, 1.0F);
        CuttingBoardRecipeApi.registerRecipe(
            id("raw_crocodile_meat"),
            new String[] { id("raw_crocodile_claw") },
            null,
            new String[] { id("raw_crocodile_meat"), "alexsmobs:crocodile_scute" },
            new int[] { 2, 1 },
            new float[] { 1.0F, 0.5F }
        );
        CuttingBoardRecipeApi.registerRecipe(
            id("raw_crocodile_meat_tail"),
            new String[] { id("raw_crocodile_tail") },
            null,
            new String[] { id("raw_crocodile_meat"), "alexsmobs:crocodile_scute" },
            new int[] { 3, 2 },
            new float[] { 1.0F, 1.0F }
        );
    }

    private static void registerCampfireRecipes() {
        registerCampfire(id("cooked_bear_meat"), id("raw_bear_meat"), AMDItems.COOKED_BEAR_MEAT);
        registerCampfire(id("cooked_bear_meat_slice"), id("raw_bear_meat_slice"), AMDItems.COOKED_BEAR_MEAT_SLICE);
        registerCampfire(id("cooked_bison_meat"), id("raw_bison_meat"), AMDItems.COOKED_BISON_MEAT);
        registerCampfire(id("cooked_bison_meat_cubes"), id("raw_bison_meat_cubes"), AMDItems.COOKED_BISON_MEAT_CUBES);
        registerCampfire(id("cooked_catfish_slice"), id("raw_catfish_slice"), AMDItems.COOKED_CATFISH_SLICE);
        registerCampfire(id("cooked_crocodile_claw"), id("raw_crocodile_claw"), AMDItems.COOKED_CROCODILE_CLAW);
        registerCampfire(id("cooked_crocodile_meat"), id("raw_crocodile_meat"), AMDItems.COOKED_CROCODILE_MEAT);
        registerCampfire(id("cooked_crocodile_tail"), id("raw_crocodile_tail"), AMDItems.COOKED_CROCODILE_TAIL);
        registerCampfire(id("cooked_devils_hole_pupfish"), id("raw_devils_hole_pupfish"), AMDItems.COOKED_DEVILS_HOLE_PUPFISH);
        registerCampfire(id("cooked_devils_hole_pupfish_slice"), id("raw_devils_hole_pupfish_slice"), AMDItems.COOKED_DEVILS_HOLE_PUPFISH_SLICE);
        registerCampfire(id("cooked_kangaroo_meat_slice"), id("raw_kangaroo_meat_slice"), AMDItems.COOKED_KANGAROO_MEAT_SLICE);
        registerCampfire(id("cooked_moose_rib_piece"), id("raw_moose_rib_piece"), AMDItems.COOKED_MOOSE_RIB_PIECE);
        registerCampfire(id("cooked_octopus_tentacle"), id("mimic_octopus_tentacle"), AMDItems.COOKED_OCTOPUS_TENTACLE);
        registerCampfire(id("cooked_seagull"), id("raw_seagull"), AMDItems.COOKED_SEAGULL);
        registerCampfire(id("cooked_seal_meat"), id("seal_meat"), AMDItems.COOKED_SEAL_MEAT);
        registerCampfire(id("cooked_tusklin_meat"), id("raw_tusklin_meat"), AMDItems.COOKED_TUSKLIN_MEAT);
        registerCampfire(id("cooked_tusklin_meat_piece"), id("raw_tusklin_meat_piece"), AMDItems.COOKED_TUSKLIN_MEAT_PIECE);
        registerCampfire(id("cooked_whale_meat"), id("whale_meat"), AMDItems.COOKED_WHALE_MEAT);
        registerCampfire(id("cooked_lost_tentacle"), "alexsmobs:lost_tentacle", AMDItems.COOKED_LOST_TENTACLE);
        registerCampfire(id("cooked_mantis_shrimp_tail_red"), id("mantis_shrimp_tail_red"), AMDItems.COOKED_MANTIS_SHRIMP_TAIL);
        registerCampfire(id("cooked_mantis_shrimp_tail_green"), id("mantis_shrimp_tail_green"), AMDItems.COOKED_MANTIS_SHRIMP_TAIL);
        registerCampfire(id("cooked_mantis_shrimp_tail_lime"), id("mantis_shrimp_tail_lime"), AMDItems.COOKED_MANTIS_SHRIMP_TAIL);
        registerCampfire(id("cooked_mantis_shrimp_tail_white"), id("mantis_shrimp_tail_white"), AMDItems.COOKED_MANTIS_SHRIMP_TAIL);
        registerCampfire(id("smoked_tusklin_sausage"), id("raw_tusklin_sausage"), AMDItems.SMOKED_TUSKLIN_SAUSAGE);
    }

    private static void registerCookingPotRecipes() {
        registerCookingPot(
            id("catfish_stew"),
            new String[] { "ore:amdRawCatfishForStew", "ore:amdSeagrass", "ore:cropOnion" },
            new ItemStack(AMDItems.CATFISH_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("devils_hole_pupfish_stew"),
            new String[] { id("raw_devils_hole_pupfish"), "minecraft:mossy_cobblestone", "ore:cropOnion" },
            new ItemStack(AMDItems.DEVILS_HOLE_PUPFISH_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("crocodile_stewed_with_catfish"),
            new String[] { "ore:amdRawCatfishForStew", id("raw_crocodile_meat"), "ore:cropOnion" },
            new ItemStack(AMDItems.CROCODILE_STEWED_WITH_CATFISH),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("seagull_soup"),
            new String[] { id("raw_seagull"), "ore:listAllmushroom", "ore:listAllmushroom" },
            new ItemStack(AMDItems.SEAGULL_SOUP),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("sea_bear_stew"),
            new String[] { id("raw_bear_meat"), "minecraft:brown_mushroom", "minecraft:brown_mushroom", "minecraft:waterlily" },
            new ItemStack(AMDItems.SEA_BEAR_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("seal_stew"),
            new String[] { id("seal_meat"), "ore:amdFern", "minecraft:brown_mushroom" },
            new ItemStack(AMDItems.SEAL_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("braised_kangaroo_meatballs"),
            new String[] { "alexsmobs:kangaroo_meat", "alexsmobs:kangaroo_meat", "minecraft:wheat", "ore:listAllEgg" },
            new ItemStack(AMDItems.BRAISED_KANGAROO_MEATBALLS),
            new ItemStack(Items.BOWL),
            400,
            1.0F
        );
        registerCookingPot(
            id("fried_tusklin_meat"),
            new String[] { id("raw_tusklin_meat"), "ore:foodDough", "alexsmobs:fish_oil", "alexsmobs:fish_oil" },
            new ItemStack(AMDItems.FRIED_TUSKLIN_MEAT),
            400,
            1.0F
        );
        registerCookingPot(
            id("takoyaki"),
            new String[] { id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), "ore:foodDough", "ore:cropOnion" },
            new ItemStack(AMDItems.TAKOYAKI),
            new ItemStack(Items.PAPER),
            400,
            1.0F
        );
        registerAdditionalCookingPotRecipes();
    }

    private static void registerAdditionalCookingPotRecipes() {
        registerCookingPot(
            "alexsmobs:fish_oil",
            new String[] { "alexsmobs:blobfish", "alexsmobs:blobfish", "alexsmobs:blobfish" },
            stackWithCount("alexsmobs:fish_oil", 3),
            new ItemStack(Items.GLASS_BOTTLE),
            100,
            1.0F
        );
        registerCookingPot(
            id("kangaroo_meat_stew"),
            new String[] { "alexsmobs:kangaroo_meat", "farmersdelight:tomato_sauce", "alexsmobs:acacia_blossom" },
            new ItemStack(AMDItems.KANGAROO_MEAT_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("moose_stew"),
            new String[] { id("raw_moose_rib_piece"), "ore:cropOnion", "ore:cropOnion" },
            new ItemStack(AMDItems.MOOSE_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("gravy_kangaroo_meat"),
            new String[] { "alexsmobs:kangaroo_meat", "alexsmobs:acacia_blossom", "minecraft:baked_potato", "farmersdelight:cooked_bacon", "ore:cropOnion", "ore:listAllmilk" },
            new ItemStack(AMDItems.GRAVY_KANGAROO_MEAT),
            new ItemStack(Items.BOWL),
            400,
            1.0F
        );
        registerCookingPot(
            id("mantis_shrimp_tempura"),
            new String[] { "ore:amdMantisShrimpTail", "ore:amdMantisShrimpTail", "ore:amdMantisShrimpTail", "ore:foodDough", "alexsmobs:fish_oil", "alexsmobs:fish_oil" },
            new ItemStack(AMDItems.MANTIS_SHRIMP_TEMPURA, 3),
            400,
            1.0F
        );
        registerCookingPot(
            id("fried_seagull_with_fries"),
            new String[] { id("raw_seagull"), id("raw_seagull"), "minecraft:baked_potato", "minecraft:baked_potato", "alexsmobs:fish_oil", "alexsmobs:fish_oil" },
            new ItemStack(AMDItems.FRIED_SEAGULL_WITH_FRIES),
            new ItemStack(Items.BUCKET),
            400,
            1.0F
        );
        registerCookingPot(
            id("lobster_pasta"),
            new String[] { "alexsmobs:lobster_tail", "farmersdelight:raw_pasta", "farmersdelight:tomato_sauce", "ore:cropOnion", "ore:listAllmilk", "ore:amdKelp" },
            new ItemStack(AMDItems.LOBSTER_PASTA),
            new ItemStack(Items.BOWL),
            400,
            1.0F
        );
        registerCookingPot(
            id("whale_skin_stew"),
            new String[] { id("whale_meat"), "ore:listAllmilk", "minecraft:fish", "ore:cropOnion" },
            new ItemStack(AMDItems.WHALE_SKIN_STEW),
            new ItemStack(Items.BOWL),
            400,
            3.0F
        );
        registerCookingPot(
            id("whale_meat_stewed_with_pork"),
            new String[] { id("whale_meat"), "minecraft:porkchop", "minecraft:fish@3", "ore:cropOnion", "ore:listAllmilk", driedKelpToken() },
            new ItemStack(AMDBlocks.WHALE_MEAT_STEWED_WITH_PORK_ITEM),
            whaleMeatStewedWithPorkContainer(),
            400,
            3.0F
        );
        registerCookingPot(
            id("canned_bear_meat"),
            new String[] { id("raw_bear_meat"), id("raw_bear_meat"), sweetBerriesToken(), "ore:cropOnion", "alexsmobs:fish_oil", honeyBottleToken() },
            new ItemStack(AMDItems.CANNED_BEAR_MEAT),
            new ItemStack(Items.BUCKET),
            800,
            3.0F
        );
        registerCookingPot(
            id("lobster_head_stew"),
            new String[] { id("lobster_head"), "farmersdelight:tomato_sauce", "ore:listAllmilk" },
            new ItemStack(AMDItems.LOBSTER_HEAD_STEW),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("mosquito_repellent_stew_cup"),
            new String[] { triopsEggToken(), "alexsmobs:stink_bottle", triopsEggToken() },
            new ItemStack(AMDItems.MOSQUITO_REPELLENT_STEW_CUP),
            new ItemStack(Items.BOWL),
            200,
            1.0F
        );
        registerCookingPot(
            id("rainbow_custard"),
            new String[] { "alexsmobs:rainbow_jelly", "alexsmobs:rainbow_jelly", "ore:listAllmilk", "ore:listAllEgg", "minecraft:sugar" },
            new ItemStack(AMDItems.RAINBOW_CUSTARD),
            200,
            1.0F
        );
        registerCookingPot(
            id("banana_slug_slime_custard"),
            new String[] { "alexsmobs:banana_slug_slime", "alexsmobs:banana_slug_slime", "ore:listAllmilk", "ore:listAllEgg", "minecraft:sugar", "alexsmobs:banana" },
            new ItemStack(AMDItems.BANANA_SLUG_SLIME_CUSTARD),
            200,
            1.0F
        );
        registerCookingPot(
            id("whale_meat_with_tentacles"),
            new String[] { id("whale_meat"), "alexsmobs:lost_tentacle", "alexsmobs:lost_tentacle", "ore:cropOnion", kelpToken(), kelpToken() },
            new ItemStack(AMDItems.WHALE_MEAT_WITH_TENTACLES),
            new ItemStack(Items.BOWL),
            400,
            3.0F
        );
        registerCookingPot(
            id("cthulhus_breakfast"),
            new String[] { id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), "minecraft:spider_eye", "minecraft:ender_eye", "minecraft:spider_eye" },
            new ItemStack(AMDItems.CTHULHUS_BREAKFAST),
            new ItemStack(Items.BOWL),
            400,
            1.0F
        );
        registerCookingPot(
            "alexsmobs:warped_mixture",
            new String[] { "ore:amdMushroomColony", warpedWartBlockToken(), warpedWartBlockToken(), twistingVinesToken(), warpedRootsToken(), "farmersdelight:nether_salad" },
            stack("alexsmobs:warped_mixture"),
            new ItemStack(Items.GLASS_BOTTLE),
            200,
            1.0F
        );
        registerCookingPot(
            id("wild_stew"),
            new String[] { id("raw_bison_meat"), "ore:amdWildStewMeat", "ore:amdWildStewMeat", "ore:cropOnion", "minecraft:baked_potato", "minecraft:brown_mushroom" },
            new ItemStack(AMDBlocks.WILD_STEW_ITEM),
            new ItemStack(Items.BUCKET),
            400,
            3.0F
        );
        registerFrontierSoupRecipes();
        registerCookingPot(
            id("steamed_stuffed_crocodile"),
            new String[] { id("raw_whole_crocodile"), "farmersdelight:rice_bag", "farmersdelight:carrot_crate", "farmersdelight:tomato_crate", "ore:amdSeagrass", "minecraft:fish@1" },
            new ItemStack(AMDBlocks.STEAMED_STUFFED_CROCODILE_ITEM),
            new ItemStack(Items.BOAT),
            1200,
            3.0F
        );
    }

    private static void registerCampfire(String id, String input, net.minecraft.item.Item output) {
        if (output != null) {
            CampfireCookingRecipeManager.registerScriptRecipe(id, new String[] { input }, new ItemStack(output), 600);
        }
    }

    private static void registerCookingPot(String recipeId, String[] inputs, ItemStack result, ItemStack container, int cookingTime, float experience) {
        if (!CookingPotRecipeApi.registerRecipe(recipeId, inputs, result, container, cookingTime, experience)) {
            AlexsMobsDelightLegacy.getLogger().warn("Failed to register cooking pot recipe {}.", recipeId);
        }
    }

    private static void registerCookingPot(String recipeId, String[] inputs, ItemStack result, int cookingTime, float experience) {
        if (!CookingPotRecipeApi.registerRecipe(recipeId, inputs, result, cookingTime, experience)) {
            AlexsMobsDelightLegacy.getLogger().warn("Failed to register cooking pot recipe {}.", recipeId);
        }
    }

    private static String id(String path) {
        return "alexsmobsdelightlegacy:" + path;
    }

    private static String kelpToken() {
        return "ore:amdKelp";
    }

    private static String driedKelpToken() {
        return registeredItemToken("oe", "dried_kelp", registeredItemToken("oe", "kelp", "minecraft:tallgrass@1"));
    }

    private static String sweetBerriesToken() {
        return registeredItemToken("futuremc", "sweet_berries", "minecraft:apple");
    }

    private static String honeyBottleToken() {
        return registeredItemToken("futuremc", "honey_bottle", "minecraft:sugar");
    }

    private static String seaPickleOrBeetrootToken() {
        return registeredItemToken("oe", "sea_pickle", "ore:cropBeetroot");
    }

    private static String frontierSoupBaseToken() {
        return registeredItemToken("futuremc", "suspicious_stew", "farmersdelight:bone_broth");
    }

    private static String triopsEggToken() {
        return registeredItemToken("alexsmobs", "triops_eggs", "alexsmobs:triops_bucket");
    }

    private static String warpedWartBlockToken() {
        return registeredItemToken("netherized", "warped_wart_block", registeredItemToken("nb", "warped_wart", "minecraft:nether_wart_block"));
    }

    private static String twistingVinesToken() {
        return registeredItemToken("netherized", "twisting_vines", registeredItemToken("nb", "warped_vine", "minecraft:vine"));
    }

    private static String warpedRootsToken() {
        return registeredItemToken("netherized", "warped_roots", registeredItemToken("nb", "warped_roots", "minecraft:red_mushroom"));
    }

    private static String saladToken() {
        return "ore:cropCabbage";
    }

    private static ItemStack whaleMeatStewedWithPorkContainer() {
        ItemStack decoratedPot = stack("suikecherry:decorated_pot");
        return decoratedPot.isEmpty() ? new ItemStack(Items.FLOWER_POT) : decoratedPot;
    }

    private static String registeredItemToken(String modid, String path, String fallback) {
        ResourceLocation location = new ResourceLocation(modid, path);
        if (ForgeRegistries.ITEMS.containsKey(location)) {
            return location.toString();
        }
        return fallback;
    }

    private static void registerFoodCrafting(IForgeRegistry<IRecipe> registry) {
        registerOreShapeless(registry, "catfish_roll", new ItemStack(AMDItems.CATFISH_ROLL, 2),
            id("raw_catfish_slice"), id("raw_catfish_slice"), "farmersdelight:cooked_rice");
        registerOreShapeless(registry, "devils_hole_pupfish_roll", new ItemStack(AMDItems.DEVILS_HOLE_PUPFISH_ROLL, 2),
            id("raw_devils_hole_pupfish_slice"), id("raw_devils_hole_pupfish_slice"), "farmersdelight:cooked_rice");
        registerOreShapeless(registry, "lobster_roll", new ItemStack(AMDItems.LOBSTER_ROLL, 2),
            "alexsmobs:cooked_lobster_tail", "alexsmobs:cooked_lobster_tail", driedKelpToken(), "farmersdelight:cooked_rice");
        registerOreShaped(registry, "banana_roll", new ItemStack(AMDItems.BANANA_ROLL),
            "rcr",
            "ppp",
            'r', "farmersdelight:cooked_rice",
            'c', "minecraft:dye@3",
            'p', "alexsmobs:banana_peel");
        registerOreShapeless(registry, "moose_pie", new ItemStack(AMDBlocks.MOOSE_PIE_ITEM),
            id("cooked_moose_rib_piece"), id("cooked_moose_rib_piece"), "ore:cropOnion", "farmersdelight:pie_crust");
        registerOreShaped(registry, "moose_pie_from_slice", new ItemStack(AMDBlocks.MOOSE_PIE_ITEM),
            "ss",
            "ss",
            's', id("slice_of_moose_pie"));
        registerOreShaped(registry, "lobster_roll_medley", new ItemStack(AMDBlocks.LOBSTER_ROLL_MEDLEY_ITEM),
            "h t",
            "rrr",
            "kbk",
            'h', id("lobster_head"),
            't', "alexsmobs:cooked_lobster_tail",
            'r', id("lobster_roll"),
            'k', kelpToken(),
            'b', "minecraft:bowl");
        registerOreShapeless(registry, "alexs_rice_roll_medley", new ItemStack(AMDBlocks.ALEXS_RICE_ROLL_MEDLEY_ITEM),
            id("catfish_roll"), id("catfish_roll"), id("catfish_roll"),
            id("devils_hole_pupfish_roll"), id("devils_hole_pupfish_roll"), id("devils_hole_pupfish_roll"),
            "alexsmobs:acacia_blossom", "minecraft:waterlily");
        registerOreShapeless(registry, "honey_glazed_moose_ribs", new ItemStack(AMDItems.HONEY_GLAZED_MOOSE_RIBS),
            "ore:cropOnion", honeyBottleToken(), sweetBerriesToken(), id("cooked_moose_rib_piece"), saladToken(), "minecraft:bowl");
        registerOreShapeless(registry, "honey_glazed_bear_meat_with_salmon", new ItemStack(AMDBlocks.HONEY_GLAZED_BEAR_MEAT_WITH_SALMON_ITEM),
            id("cooked_bear_meat"), "minecraft:cooked_fish@1", honeyBottleToken(), sweetBerriesToken(), sweetBerriesToken());
        registerOreShapeless(registry, "acacia_blossom_tentacle_salad", new ItemStack(AMDItems.ACACIA_BLOSSOM_TENTACLE_SALAD),
            "alexsmobs:acacia_blossom", "alexsmobs:acacia_blossom", "alexsmobs:lost_tentacle", "minecraft:bowl");
        registerAdditionalCrafting(registry);
    }

    private static void registerAdditionalCrafting(IForgeRegistry<IRecipe> registry) {
        registerOreShapeless(registry, "big_mac", new ItemStack(AMDItems.BIG_MAC),
            "minecraft:bread", "ore:amdLargeCookedMeat", saladToken(), seaPickleOrBeetrootToken(), "farmersdelight:tomato", "ore:cropOnion");
        registerOreShapeless(registry, "crocodile_barbecue_stick", new ItemStack(AMDItems.CROCODILE_BARBECUE_STICK),
            "minecraft:carrot", "minecraft:baked_potato", id("cooked_crocodile_meat"), "minecraft:stick");
        registerOreShapeless(registry, "cheese_seal_stick", new ItemStack(AMDItems.CHEESE_SEAL_STICK),
            id("cheese"), id("cheese"), id("cooked_seal_meat"), "minecraft:stick");
        registerOreShapeless(registry, "fried_tentacles_stick", new ItemStack(AMDItems.FRIED_TENTACLES_STICK),
            id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), "alexsmobs:lost_tentacle", "minecraft:stick");
        registerOreShaped(registry, "rainbow_popsicle", new ItemStack(AMDItems.RAINBOW_POPSICLE),
            " sr",
            "irs",
            "-i ",
            's', "minecraft:snowball",
            'r', "alexsmobs:rainbow_jelly",
            'i', "minecraft:ice",
            '-', "minecraft:stick");
        registerOreShaped(registry, "banana_slug_slime_popsicle", new ItemStack(AMDItems.BANANA_SLUG_SLIME_POPSICLE),
            " sr",
            "prs",
            "-p ",
            's', "minecraft:snowball",
            'r', "alexsmobs:banana_slug_slime",
            'p', "alexsmobs:banana_peel",
            '-', "minecraft:stick");
        registerOreShapeless(registry, "tentacle_medley", new ItemStack(AMDItems.TENTACLE_MEDLEY),
            id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"), "minecraft:bowl");
        registerOreShapeless(registry, "bison_tartare", new ItemStack(AMDItems.BISON_TARTARE),
            id("raw_bison_meat"), id("raw_bison_meat"), saladToken(), "ore:listAllEgg", "ore:cropOnion", "minecraft:bowl");
        registerOreShaped(registry, "whale_burger", new ItemStack(AMDItems.WHALE_BURGER),
            "b",
            "w",
            "b",
            'b', "minecraft:bread",
            'w', id("cooked_whale_meat"));
        registerOreShapeless(registry, "cheese_seal_burger", new ItemStack(AMDItems.CHEESE_SEAL_BURGER),
            "minecraft:bread", id("cooked_seal_meat"), id("cheese"), "farmersdelight:tomato", driedKelpToken());
        registerOreShapeless(registry, "smoked_tusklin_sandwich", new ItemStack(AMDItems.SMOKED_TUSKLIN_SANDWICH),
            "minecraft:bread", saladToken(), id("slice_of_smoked_tusklin_sausage"), "farmersdelight:tomato");
        registerOreShapeless(registry, "tusklin_hot_dog", new ItemStack(AMDItems.TUSKLIN_HOT_DOG),
            "minecraft:bread", "minecraft:bread", saladToken(), saladToken(), id("smoked_tusklin_sausage"), "farmersdelight:tomato_sauce");
        registerOreShapeless(registry, "tentacle_sandwich", new ItemStack(AMDItems.TENTACLE_SANDWICH),
            "minecraft:bread", saladToken(), id("cooked_octopus_tentacle"), id("cooked_octopus_tentacle"));
        registerOreShapeless(registry, "dried_kelp_tentacles_sandwich", new ItemStack(AMDItems.DRIED_KELP_TENTACLES_SANDWICH),
            "minecraft:bread", id("cooked_lost_tentacle"), id("cooked_lost_tentacle"), driedKelpToken());
        registerOreShapeless(registry, "seal_sandwich", new ItemStack(AMDItems.SEAL_SANDWICH),
            "minecraft:bread", id("cooked_seal_meat"), "minecraft:tallgrass@2", "minecraft:carrot");
        registerOreShapeless(registry, "roast_seagull", new ItemStack(AMDItems.ROAST_SEAGULL),
            "minecraft:carrot", "ore:cropOnion", id("cooked_seagull"), "minecraft:beetroot", "farmersdelight:sandy_shrub", "minecraft:bowl");
        registerOreShapeless(registry, "shrimp_poke_bowl", new ItemStack(AMDItems.SHRIMP_POKE_BOWL),
            "ore:cropOnion", id("mantis_shrimp_tempura"), id("shrimp_fried_egg"), saladToken(), "alexsmobs:shrimp_fried_rice", saladToken());
        registerOreShapeless(registry, "raw_tusklin_sausage", new ItemStack(AMDItems.RAW_TUSKLIN_SAUSAGE),
            id("raw_tusklin_meat"), id("raw_tusklin_meat"), "alexsmobs:shed_snake_skin");
        registerOreShapeless(registry, "katsudon", new ItemStack(AMDItems.KATSUDON),
            id("fried_tusklin_meat"), "farmersdelight:cooked_rice", driedKelpToken(), driedKelpToken());
        registerOreShapeless(registry, "moose_sausage_with_salmon", new ItemStack(AMDBlocks.MOOSE_SAUSAGE_WITH_SALMON_ITEM),
            id("cooked_moose_rib_piece"), id("cooked_moose_rib_piece"), id("cooked_moose_rib_piece"),
            "minecraft:cooked_fish@1", saladToken(), "alexsmobs:moose_antler");
        registerOreShaped(registry, "crocodile_knife", new ItemStack(AMDItems.CROCODILE_KNIFE),
            " t",
            "tc",
            "c ",
            't', id("crocodile_tooth"),
            'c', "alexsmobs:crocodile_scute");
        registerOreShaped(registry, "lobster_knife", new ItemStack(AMDItems.LOBSTER_KNIFE),
            " hh",
            "hh ",
            "s  ",
            'h', id("lobster_head"),
            's', "minecraft:stick");
        registerOreShaped(registry, "crocodile_scute_sword", new ItemStack(AMDItems.CROCODILE_SCUTE_SWORD),
            "c",
            "c",
            "s",
            'c', "alexsmobs:crocodile_scute",
            's', "minecraft:stick");
        registerOreShaped(registry, "whale_tooth_pickaxe", new ItemStack(AMDItems.WHALE_TOOTH_PICKAXE),
            "tpt",
            " s ",
            " s ",
            't', "alexsmobs:cachalot_whale_tooth",
            'p', "minecraft:string",
            's', "minecraft:stick");
        registerOreShaped(registry, "banana_bow", new ItemStack(AMDItems.BANANA_BOW),
            " bv",
            "b v",
            " bv",
            'b', "alexsmobs:banana",
            'v', "minecraft:vine");
        registerOreShaped(registry, "lobster_dart", new ItemStack(AMDItems.LOBSTER_DART),
            "  h",
            "hh ",
            "sh ",
            'h', id("lobster_head"),
            's', kelpToken());
        registerOreShaped(registry, "seal_fur_carpet_brown", new ItemStack(AMDBlocks.SEAL_FUR_CARPET_BROWN_ITEM, 3),
            "ll",
            'l', id("seal_leather_brown"));
        registerOreShaped(registry, "seal_fur_carpet_gray", new ItemStack(AMDBlocks.SEAL_FUR_CARPET_GRAY_ITEM, 3),
            "ll",
            'l', id("seal_leather_gray"));
    }

    private static void registerFrontierSoupRecipes() {
        String base = frontierSoupBaseToken();
        registerCookingPot(
            id("frontier_soup"),
            new String[] { "alexsmobs:raccoon_tail", "minecraft:dye@7" },
            new ItemStack(AMDItems.FRONTIER_SOUP),
            stack(base),
            200,
            1.0F
        );
    }

    private static void registerOreShapeless(IForgeRegistry<IRecipe> registry, String name, ItemStack output, String... inputs) {
        ResourceLocation recipeId = new ResourceLocation(AlexsMobsDelightLegacy.MODID, name);
        if (registry.containsKey(recipeId) || output.isEmpty()) {
            return;
        }
        Object[] ingredients = new Object[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            ingredients[i] = recipeIngredient(inputs[i]);
            if (ingredients[i] == null) {
                AlexsMobsDelightLegacy.getLogger().warn("Skipped shapeless recipe {} because ingredient {} is missing.", recipeId, inputs[i]);
                return;
            }
        }
        ShapelessOreRecipe recipe = new ShapelessOreRecipe(new ResourceLocation(AlexsMobsDelightLegacy.MODID, "crafting"), output, ingredients);
        recipe.setRegistryName(recipeId);
        registry.register(recipe);
    }

    private static void registerOreShaped(IForgeRegistry<IRecipe> registry, String name, ItemStack output, Object... recipeParts) {
        ResourceLocation recipeId = new ResourceLocation(AlexsMobsDelightLegacy.MODID, name);
        if (registry.containsKey(recipeId) || output.isEmpty()) {
            return;
        }
        Object[] normalized = new Object[recipeParts.length];
        for (int i = 0; i < recipeParts.length; i++) {
            Object part = recipeParts[i];
            if (part instanceof String && i > 0 && recipeParts[i - 1] instanceof Character) {
                normalized[i] = recipeIngredient((String) part);
                if (normalized[i] == null) {
                    AlexsMobsDelightLegacy.getLogger().warn("Skipped shaped recipe {} because ingredient {} is missing.", recipeId, part);
                    return;
                }
            } else {
                normalized[i] = part;
            }
        }
        ShapedOreRecipe recipe = new ShapedOreRecipe(new ResourceLocation(AlexsMobsDelightLegacy.MODID, "crafting"), output, normalized);
        recipe.setRegistryName(recipeId);
        registry.register(recipe);
    }

    private static Object recipeIngredient(String token) {
        if (token.startsWith("ore:")) {
            return token.substring("ore:".length());
        }
        ItemStack stack = stack(token);
        return stack.isEmpty() ? null : stack;
    }

    private static ItemStack stack(String token) {
        int meta = 0;
        String id = token;
        int metaIndex = token.indexOf('@');
        if (metaIndex >= 0) {
            id = token.substring(0, metaIndex);
            try {
                meta = Integer.parseInt(token.substring(metaIndex + 1));
            } catch (NumberFormatException ex) {
                AlexsMobsDelightLegacy.getLogger().warn("Invalid item metadata token {}.", token);
                return ItemStack.EMPTY;
            }
        }
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item, 1, meta);
    }

    private static ItemStack stackWithCount(String token, int count) {
        ItemStack result = stack(token);
        if (!result.isEmpty()) {
            result.setCount(count);
        }
        return result;
    }

    private static void registerKiviakCrafting(IForgeRegistry<IRecipe> registry) {
        registerSimpleShapeless(registry, "coastal_kiviak", new ItemStack(AMDBlocks.COASTAL_KIVIAK_ITEM),
            "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull",
            "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull",
            "minecraft:string", "alexsmobsdelightlegacy:seal_leather_brown", "minecraft:string");
        registerSimpleShapeless(registry, "polar_kiviak", new ItemStack(AMDBlocks.POLAR_KIVIAK_ITEM),
            "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull",
            "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull", "alexsmobsdelightlegacy:raw_seagull",
            "minecraft:string", "alexsmobsdelightlegacy:seal_leather_gray", "minecraft:string");
    }

    private static void registerSimpleShapeless(IForgeRegistry<IRecipe> registry, String name, ItemStack output, String... inputs) {
        ResourceLocation recipeId = new ResourceLocation("alexsmobsdelightlegacy", name);
        if (registry.containsKey(recipeId)) {
            return;
        }
        NonNullList<Ingredient> ingredients = NonNullList.create();
        for (String input : inputs) {
            ingredients.add(Ingredient.fromStacks(new ItemStack(net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS.getValue(new ResourceLocation(input)))));
        }
        ShapelessRecipes recipe = new ShapelessRecipes("alexsmobsdelightlegacy", output, ingredients);
        recipe.setRegistryName(recipeId);
        registry.register(recipe);
    }

    private static void registerRawWholeCrocodileCrafting(IForgeRegistry<IRecipe> registry) {
        ResourceLocation id = new ResourceLocation("alexsmobsdelightlegacy", "raw_whole_crocodile");
        if (registry.containsKey(id)) {
            return;
        }
        NonNullList<Ingredient> ingredients = NonNullList.withSize(9, Ingredient.EMPTY);
        ingredients.set(0, Ingredient.fromItem(AMDItems.RAW_CROCODILE_CLAW));
        ingredients.set(1, Ingredient.fromItem(AMDItems.RAW_CROCODILE_MEAT));
        ingredients.set(2, Ingredient.fromItem(AMDItems.RAW_CROCODILE_CLAW));
        ingredients.set(3, Ingredient.fromItem(AMDItems.RAW_CROCODILE_MEAT));
        ingredients.set(4, Ingredient.fromItem(net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS.getValue(new ResourceLocation("alexsmobs", "crocodile_chestplate"))));
        ingredients.set(5, Ingredient.fromItem(AMDItems.RAW_CROCODILE_MEAT));
        ingredients.set(6, Ingredient.fromItem(AMDItems.RAW_CROCODILE_CLAW));
        ingredients.set(7, Ingredient.fromItem(AMDItems.RAW_CROCODILE_TAIL));
        ingredients.set(8, Ingredient.fromItem(AMDItems.RAW_CROCODILE_CLAW));
        ShapedRecipes recipe = new ShapedRecipes("alexsmobsdelightlegacy", 3, 3, ingredients, new ItemStack(AMDItems.RAW_WHOLE_CROCODILE));
        recipe.setRegistryName(id);
        registry.register(recipe);
    }
}

package xy177.alexsmobsdelightlegacy.common.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.client.ClientProxy;
import xy177.alexsmobsdelightlegacy.common.item.AMDFoodItem;
import xy177.alexsmobsdelightlegacy.common.item.ItemEnchantedSeagullFood;
import xy177.alexsmobsdelightlegacy.common.item.ItemCrocodileKnife;
import xy177.alexsmobsdelightlegacy.common.item.ItemCrocodileScuteSword;
import xy177.alexsmobsdelightlegacy.common.item.ItemBananaBow;
import xy177.alexsmobsdelightlegacy.common.item.ItemKiviakFood;
import xy177.alexsmobsdelightlegacy.common.item.ItemLobsterDart;
import xy177.alexsmobsdelightlegacy.common.item.ItemLobsterKnife;
import xy177.alexsmobsdelightlegacy.common.item.ItemMantisShrimpScythe;
import xy177.alexsmobsdelightlegacy.common.item.ItemMantisShrimpAxe;
import xy177.alexsmobsdelightlegacy.common.item.ItemMantisShrimpShovel;
import xy177.alexsmobsdelightlegacy.common.item.ItemMantisShrimpHammer;
import xy177.alexsmobsdelightlegacy.common.item.ItemSeagullWand;
import xy177.alexsmobsdelightlegacy.common.item.ItemWhaleToothPickaxe;

public final class AMDItems {
    private static final List<Item> ITEMS = new ArrayList<>();

    public static Item RAW_BEAR_MEAT;
    public static Item RAW_BEAR_MEAT_SLICE;
    public static Item COOKED_BEAR_MEAT;
    public static Item COOKED_BEAR_MEAT_SLICE;
    public static Item RAW_BISON_MEAT;
    public static Item RAW_BISON_MEAT_CUBES;
    public static Item COOKED_BISON_MEAT;
    public static Item COOKED_BISON_MEAT_CUBES;
    public static Item RAW_KANGAROO_MEAT_SLICE;
    public static Item COOKED_KANGAROO_MEAT_SLICE;
    public static Item RAW_MOOSE_RIB_PIECE;
    public static Item COOKED_MOOSE_RIB_PIECE;
    public static Item RAW_SEAGULL;
    public static Item COOKED_SEAGULL;
    public static Item ENCHANTED_COOKED_SEAGULL;
    public static Item ETERNAL_COOKED_SEAGULL;
    public static Item ENCHANTED_ETERNAL_COOKED_SEAGULL;
    public static Item MANTIS_SHRIMP_TAIL_RED;
    public static Item MANTIS_SHRIMP_TAIL_GREEN;
    public static Item MANTIS_SHRIMP_TAIL_LIME;
    public static Item MANTIS_SHRIMP_TAIL_WHITE;
    public static Item COOKED_MANTIS_SHRIMP_TAIL;
    public static Item RAW_TUSKLIN_MEAT;
    public static Item RAW_TUSKLIN_MEAT_PIECE;
    public static Item COOKED_TUSKLIN_MEAT;
    public static Item COOKED_TUSKLIN_MEAT_PIECE;
    public static Item RAW_DEVILS_HOLE_PUPFISH;
    public static Item RAW_DEVILS_HOLE_PUPFISH_SLICE;
    public static Item COOKED_DEVILS_HOLE_PUPFISH;
    public static Item COOKED_DEVILS_HOLE_PUPFISH_SLICE;
    public static Item RAW_CATFISH_SLICE;
    public static Item COOKED_CATFISH_SLICE;
    public static Item RAW_FLYING_FISH_SLICE;
    public static Item COOKED_FLYING_FISH;
    public static Item COOKED_FLYING_FISH_SLICE;
    public static Item RAW_MUDSKIPPER;
    public static Item RAW_MUDSKIPPER_SLICE;
    public static Item COOKED_MUDSKIPPER;
    public static Item COOKED_MUDSKIPPER_SLICE;
    public static Item BANANA_SLICE;
    public static Item RAW_CROCODILE_CLAW;
    public static Item RAW_CROCODILE_TAIL;
    public static Item RAW_CROCODILE_MEAT;
    public static Item COOKED_CROCODILE_CLAW;
    public static Item COOKED_CROCODILE_TAIL;
    public static Item COOKED_CROCODILE_MEAT;
    public static Item RAW_WHOLE_CROCODILE;
    public static Item MIMIC_OCTOPUS_TENTACLE;
    public static Item COOKED_OCTOPUS_TENTACLE;
    public static Item WHALE_MEAT;
    public static Item COOKED_WHALE_MEAT;
    public static Item COOKED_LOST_TENTACLE;
    public static Item DRIED_SHREDDED_SQUID;
    public static Item SEAL_MEAT;
    public static Item COOKED_SEAL_MEAT;
    public static Item CHEESE;
    public static Item CROCODILE_TOOTH;
    public static Item LOBSTER_HEAD;
    public static Item SEAL_LEATHER_BROWN;
    public static Item SEAL_LEATHER_GRAY;
    public static Item CANNED_BEAR_MEAT;
    public static Item SLICE_OF_MOOSE_PIE;
    public static Item RAW_TUSKLIN_SAUSAGE;
    public static Item SMOKED_TUSKLIN_SAUSAGE;
    public static Item SLICE_OF_SMOKED_TUSKLIN_SAUSAGE;
    public static Item FRIED_TUSKLIN_MEAT;
    public static Item CROCODILE_RICE;
    public static Item TAKOYAKI;
    public static Item CATFISH_ROLL;
    public static Item DEVILS_HOLE_PUPFISH_ROLL;
    public static Item FLYING_FISH_ROLL;
    public static Item MUDSKIPPER_ROLL;
    public static Item BANANA_ROLL;
    public static Item BANANA_ROLL_SLICE;
    public static Item LOBSTER_ROLL;
    public static Item CROCODILE_BARBECUE_STICK;
    public static Item CHEESE_SEAL_STICK;
    public static Item FRIED_TENTACLES_STICK;
    public static Item BIG_MAC;
    public static Item TUSKLIN_HOT_DOG;
    public static Item WHALE_BURGER;
    public static Item CHEESE_SEAL_BURGER;
    public static Item SMOKED_TUSKLIN_SANDWICH;
    public static Item TENTACLE_SANDWICH;
    public static Item DRIED_KELP_TENTACLES_SANDWICH;
    public static Item SEAL_SANDWICH;
    public static Item MANTIS_SHRIMP_TEMPURA;
    public static Item SHRIMP_FRIED_EGG;
    public static Item RAINBOW_CUSTARD;
    public static Item RAINBOW_POPSICLE;
    public static Item BANANA_SLUG_SLIME_CUSTARD;
    public static Item BANANA_SLUG_SLIME_POPSICLE;
    public static Item BOWL_OF_WILD_STEW;
    public static Item FRONTIER_SOUP;
    public static Item KANGAROO_MEAT_STEW;
    public static Item MOOSE_STEW;
    public static Item SEA_BEAR_STEW;
    public static Item SEAGULL_SOUP;
    public static Item CATFISH_STEW;
    public static Item DEVILS_HOLE_PUPFISH_STEW;
    public static Item FLYING_FISH_STEW;
    public static Item MUDSKIPPER_STEW;
    public static Item SEAL_STEW;
    public static Item CROCODILE_STEWED_WITH_CATFISH;
    public static Item BISON_TARTARE;
    public static Item BRAISED_KANGAROO_MEATBALLS;
    public static Item GRAVY_KANGAROO_MEAT;
    public static Item KATSUDON;
    public static Item HONEY_GLAZED_MOOSE_RIBS;
    public static Item ROAST_SEAGULL;
    public static Item FRIED_SEAGULL_WITH_FRIES;
    public static Item SHRIMP_POKE_BOWL;
    public static Item LOBSTER_HEAD_STEW;
    public static Item MOSQUITO_REPELLENT_STEW_CUP;
    public static Item ACACIA_BLOSSOM_TENTACLE_SALAD;
    public static Item WHALE_MEAT_WITH_TENTACLES;
    public static Item TENTACLE_MEDLEY;
    public static Item CTHULHUS_BREAKFAST;
    public static Item ORCAS_LEAP_SOUP;
    public static Item BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON;
    public static Item LOBSTER_PASTA;
    public static Item BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON;
    public static Item POT_OF_WHALE_MEAT_STEWED_WITH_PORK;
    public static Item WHALE_SKIN_STEW;
    public static Item KIVIAK;
    public static Item BOWL_OF_STUFFED_CROCODILE_HEAD;
    public static Item BOWL_OF_STUFFED_CROCODILE_TAIL;
    public static Item BOWL_OF_STUFFED_CROCODILE_LEG;
    public static Item BOWL_OF_STUFFED_CROCODILE;
    public static Item CROCODILE_KNIFE;
    public static Item LOBSTER_KNIFE;
    public static Item BANANA_BOW;
    public static Item WHALE_TOOTH_PICKAXE;
    public static Item SEAGULL_WAND;
    public static Item CROCODILE_SCUTE_SWORD;
    public static Item MANTIS_SHRIMP_SCYTHE;
    public static Item MANTIS_SHRIMP_AXE;
    public static Item MANTIS_SHRIMP_SHOVEL;
    public static Item MANTIS_SHRIMP_HAMMER;
    public static Item LOBSTER_DART;

    private AMDItems() {
    }

    public static void register(IForgeRegistry<Item> registry) {
        ITEMS.clear();
        AMDToolMaterials.initRepairItems();

        RAW_BEAR_MEAT = register("raw_bear_meat", food(2, 0.3F));
        RAW_BEAR_MEAT_SLICE = register("raw_bear_meat_slice", food(1, 0.2F));
        COOKED_BEAR_MEAT = register("cooked_bear_meat", food(6, 0.6F));
        COOKED_BEAR_MEAT_SLICE = register("cooked_bear_meat_slice", food(3, 0.6F));
        RAW_BISON_MEAT = register("raw_bison_meat", food(3, 0.3F));
        RAW_BISON_MEAT_CUBES = register("raw_bison_meat_cubes", food(2, 0.3F));
        COOKED_BISON_MEAT = register("cooked_bison_meat", food(8, 0.6F));
        COOKED_BISON_MEAT_CUBES = register("cooked_bison_meat_cubes", food(4, 0.6F));
        RAW_KANGAROO_MEAT_SLICE = register("raw_kangaroo_meat_slice", food(2, 0.3F));
        COOKED_KANGAROO_MEAT_SLICE = register("cooked_kangaroo_meat_slice", food(5, 0.6F));
        RAW_MOOSE_RIB_PIECE = register("raw_moose_rib_piece", food(3, 0.3F));
        COOKED_MOOSE_RIB_PIECE = register("cooked_moose_rib_piece", food(7, 0.6F));
        RAW_SEAGULL = register("raw_seagull", food(2, 0.3F));
        COOKED_SEAGULL = register("cooked_seagull", food(6, 0.6F));
        ENCHANTED_COOKED_SEAGULL = register("enchanted_cooked_seagull", new ItemEnchantedSeagullFood(false, true));
        ETERNAL_COOKED_SEAGULL = register("eternal_cooked_seagull", new ItemEnchantedSeagullFood(true, false));
        ENCHANTED_ETERNAL_COOKED_SEAGULL = register("enchanted_eternal_cooked_seagull", new ItemEnchantedSeagullFood(true, true));
        MANTIS_SHRIMP_TAIL_RED = register("mantis_shrimp_tail_red", food(2, 0.3F));
        MANTIS_SHRIMP_TAIL_GREEN = register("mantis_shrimp_tail_green", food(2, 0.3F));
        MANTIS_SHRIMP_TAIL_LIME = register("mantis_shrimp_tail_lime", food(2, 0.3F));
        MANTIS_SHRIMP_TAIL_WHITE = register("mantis_shrimp_tail_white", food(2, 0.3F));
        COOKED_MANTIS_SHRIMP_TAIL = register("cooked_mantis_shrimp_tail", food(5, 0.6F));
        RAW_TUSKLIN_MEAT = register("raw_tusklin_meat", food(3, 0.3F));
        RAW_TUSKLIN_MEAT_PIECE = register("raw_tusklin_meat_piece", food(2, 0.3F));
        COOKED_TUSKLIN_MEAT = register("cooked_tusklin_meat", food(8, 0.6F));
        COOKED_TUSKLIN_MEAT_PIECE = register("cooked_tusklin_meat_piece", food(4, 0.6F));
        RAW_DEVILS_HOLE_PUPFISH = register("raw_devils_hole_pupfish", food(2, 0.3F));
        RAW_DEVILS_HOLE_PUPFISH_SLICE = register("raw_devils_hole_pupfish_slice", food(1, 0.2F));
        COOKED_DEVILS_HOLE_PUPFISH = register("cooked_devils_hole_pupfish", food(5, 0.6F));
        COOKED_DEVILS_HOLE_PUPFISH_SLICE = register("cooked_devils_hole_pupfish_slice", food(3, 0.6F));
        RAW_CATFISH_SLICE = register("raw_catfish_slice", food(1, 0.2F));
        COOKED_CATFISH_SLICE = register("cooked_catfish_slice", food(3, 0.6F));
        BANANA_SLICE = register("banana_slice", food(2, 0.2F));
        RAW_CROCODILE_CLAW = register("raw_crocodile_claw", food(2, 0.3F));
        RAW_CROCODILE_TAIL = register("raw_crocodile_tail", food(4, 0.3F));
        RAW_CROCODILE_MEAT = register("raw_crocodile_meat", food(2, 0.3F));
        COOKED_CROCODILE_CLAW = register("cooked_crocodile_claw", food(5, 0.6F));
        COOKED_CROCODILE_TAIL = register("cooked_crocodile_tail", food(12, 0.6F));
        COOKED_CROCODILE_MEAT = register("cooked_crocodile_meat", food(6, 0.6F));
        RAW_WHOLE_CROCODILE = register("raw_whole_crocodile", plain());
        MIMIC_OCTOPUS_TENTACLE = register("mimic_octopus_tentacle", food(2, 0.3F));
        COOKED_OCTOPUS_TENTACLE = register("cooked_octopus_tentacle", food(4, 0.6F));
        WHALE_MEAT = register("whale_meat", food(10, 0.3F));
        COOKED_WHALE_MEAT = register("cooked_whale_meat", food(16, 0.6F));
        COOKED_LOST_TENTACLE = register("cooked_lost_tentacle", food(8, 0.6F));
        DRIED_SHREDDED_SQUID = register("dried_shredded_squid", food(4, 0.6F));
        SEAL_MEAT = register("seal_meat", food(4, 0.3F).addTooltip("tooltip.alexsmobsdelightlegacy.seal_meat"));
        COOKED_SEAL_MEAT = register("cooked_seal_meat", food(8, 0.6F));
        CHEESE = register("cheese", food(4, 0.6F));
        CROCODILE_TOOTH = register("crocodile_tooth", plain());
        LOBSTER_HEAD = register("lobster_head", plain());
        SEAL_LEATHER_BROWN = register("seal_leather_brown", plain());
        SEAL_LEATHER_GRAY = register("seal_leather_gray", plain());
        CANNED_BEAR_MEAT = register("canned_bear_meat", bucketFood(20, 0.6F)
            .addEffect(effect("minecraft", "strength"), 600, 1, 1.0F)
            .addEffect(effect("alexsmobs", "knockback_resistance"), 1800, 0, 1.0F));
        SLICE_OF_MOOSE_PIE = register("slice_of_moose_pie", food(6, 0.3F));
        RAW_TUSKLIN_SAUSAGE = register("raw_tusklin_sausage", food(6, 0.4F));
        SMOKED_TUSKLIN_SAUSAGE = register("smoked_tusklin_sausage", food(12, 0.85F));
        SLICE_OF_SMOKED_TUSKLIN_SAUSAGE = register("slice_of_smoked_tusklin_sausage", food(6, 0.85F));
        FRIED_TUSKLIN_MEAT = register("fried_tusklin_meat", food(12, 0.85F));
        CROCODILE_RICE = register("crocodile_rice", bowlFood(8, 0.6F));
        TAKOYAKI = register("takoyaki", bowlFood(10, 0.85F).addEffect(effect("farmersdelight", "nourishment"), 3000, 0, 1.0F));
        CATFISH_ROLL = register("catfish_roll", food(3, 0.6F));
        DEVILS_HOLE_PUPFISH_ROLL = register("devils_hole_pupfish_roll", food(3, 0.6F));
        BANANA_ROLL = register("banana_roll", food(12, 0.6F));
        BANANA_ROLL_SLICE = register("banana_roll_slice", food(6, 0.5F));
        LOBSTER_ROLL = register("lobster_roll", food(8, 0.6F));
        CROCODILE_BARBECUE_STICK = register("crocodile_barbecue_stick", food(12, 0.9F));
        CHEESE_SEAL_STICK = register("cheese_seal_stick", food(10, 0.6F).addEffect(effect("minecraft", "luck"), 200, 4, 1.0F));
        FRIED_TENTACLES_STICK = register("fried_tentacles_stick", food(8, 0.6F).addEffect(effect("alexsmobsdelightlegacy", "extended_touch"), 1800, 1, 1.0F));
        BIG_MAC = register("big_mac", food(16, 0.85F)
            .addEffect(effect("minecraft", "strength"), 600, 1, 1.0F)
            .addEffect(effect("minecraft", "absorption"), 1800, 0, 1.0F));
        TUSKLIN_HOT_DOG = register("tusklin_hot_dog", food(20, 0.85F)
            .addEffect(effect("minecraft", "resistance"), 600, 1, 1.0F)
            .addEffect(effect("minecraft", "absorption"), 1800, 0, 1.0F));
        WHALE_BURGER = register("whale_burger", food(24, 0.85F).addEffect(effect("minecraft", "strength"), 600, 1, 1.0F));
        CHEESE_SEAL_BURGER = register("cheese_seal_burger", food(12, 0.85F)
            .addEffect(effect("minecraft", "strength"), 600, 0, 1.0F)
            .addEffect(effect("minecraft", "luck"), 1800, 2, 1.0F));
        SMOKED_TUSKLIN_SANDWICH = register("smoked_tusklin_sandwich", food(12, 0.85F));
        TENTACLE_SANDWICH = register("tentacle_sandwich", food(10, 0.6F));
        DRIED_KELP_TENTACLES_SANDWICH = register("dried_kelp_tentacles_sandwich", food(12, 0.7F));
        SEAL_SANDWICH = register("seal_sandwich", food(12, 0.6F).addEffect(effect("minecraft", "luck"), 3000, 0, 1.0F));
        MANTIS_SHRIMP_TEMPURA = register("mantis_shrimp_tempura", food(8, 0.6F).addEffect(effect("minecraft", "strength"), 600, 0, 1.0F));
        SHRIMP_FRIED_EGG = register("shrimp_fried_egg", food(6, 0.3F));
        RAINBOW_CUSTARD = register("rainbow_custard", containerFood(7, 0.6F, Items.GLASS_BOTTLE));
        RAINBOW_POPSICLE = register("rainbow_popsicle", food(3, 0.3F));
        BANANA_SLUG_SLIME_CUSTARD = register("banana_slug_slime_custard", containerFood(7, 0.6F, Items.GLASS_BOTTLE)
            .addEffect(effect("alexsmobsdelightlegacy", "crystallize_walker"), 3600, 0, 1.0F));
        BANANA_SLUG_SLIME_POPSICLE = register("banana_slug_slime_popsicle", food(3, 0.3F));
        BOWL_OF_WILD_STEW = register("bowl_of_wild_stew", bowlFood(12, 0.8F).addEffect(effect("farmersdelight", "comfort"), 6000, 0, 1.0F));
        FRONTIER_SOUP = register("frontier_soup", bowlFood(10, 0.6F)
            .addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F)
            .addEffect(effect("minecraft", "speed"), 3000, 0, 1.0F));
        KANGAROO_MEAT_STEW = register("kangaroo_meat_stew", bowlFood(8, 0.8F).addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F));
        MOOSE_STEW = register("moose_stew", bowlFood(8, 0.8F).addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F));
        SEA_BEAR_STEW = register("sea_bear_stew", bowlFood(9, 0.8F).addEffect(effect("farmersdelight", "comfort"), 6000, 0, 1.0F));
        SEAGULL_SOUP = register("seagull_soup", bowlFood(7, 0.6F).addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F));
        CATFISH_STEW = register("catfish_stew", bowlFood(8, 0.8F));
        DEVILS_HOLE_PUPFISH_STEW = register("devils_hole_pupfish_stew", bowlFood(8, 0.8F));
        CROCODILE_STEWED_WITH_CATFISH = register("crocodile_stewed_with_catfish", bowlFood(8, 0.8F));
        SEAL_STEW = register("seal_stew", bowlFood(8, 0.8F)
            .addEffect(effect("farmersdelight", "comfort"), 1800, 0, 1.0F)
            .addEffect(effect("minecraft", "luck"), 3000, 0, 1.0F));
        BISON_TARTARE = register("bison_tartare", bowlFood(7, 0.5F)
            .addEffect(effect("minecraft", "nausea"), 100, 0, 0.2F)
            .addEffect(effect("farmersdelight", "nourishment"), 3000, 0, 1.0F));
        BRAISED_KANGAROO_MEATBALLS = register("braised_kangaroo_meatballs", bowlFood(10, 0.6F).addEffect(effect("farmersdelight", "nourishment"), 3000, 0, 1.0F));
        GRAVY_KANGAROO_MEAT = register("gravy_kangaroo_meat", bowlFood(12, 0.7F).addEffect(effect("farmersdelight", "nourishment"), 3000, 0, 1.0F));
        KATSUDON = register("katsudon", bowlFood(18, 0.85F)
            .addEffect(effect("minecraft", "resistance"), 600, 1, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        HONEY_GLAZED_MOOSE_RIBS = register("honey_glazed_moose_ribs", bowlFood(14, 0.85F).addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        ROAST_SEAGULL = register("roast_seagull", bowlFood(14, 0.85F).addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        FRIED_SEAGULL_WITH_FRIES = register("fried_seagull_with_fries", bucketFood(14, 0.85F).addEffect(effect("minecraft", "saturation"), 200, 0, 1.0F));
        SHRIMP_POKE_BOWL = register("shrimp_poke_bowl", bowlFood(20, 0.85F)
            .addEffect(effect("minecraft", "strength"), 600, 1, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        LOBSTER_HEAD_STEW = register("lobster_head_stew", bowlFood(8, 0.8F).addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F));
        MOSQUITO_REPELLENT_STEW_CUP = register("mosquito_repellent_stew_cup", bowlFood(20, 0.6F)
            .addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F)
            .addEffect(effect("minecraft", "resistance"), 900, 0, 1.0F));
        ACACIA_BLOSSOM_TENTACLE_SALAD = register("acacia_blossom_tentacle_salad", bowlFood(8, 0.6F).addEffect(effect("alexsmobsdelightlegacy", "extended_touch"), 3600, 0, 1.0F));
        WHALE_MEAT_WITH_TENTACLES = register("whale_meat_with_tentacles", bowlFood(24, 0.85F)
            .addEffect(effect("alexsmobsdelightlegacy", "extended_touch"), 6000, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        TENTACLE_MEDLEY = register("tentacle_medley", bowlFood(10, 0.6F));
        CTHULHUS_BREAKFAST = register("cthulhus_breakfast", bowlFood(13, 0.85F)
            .addEffect(effect("minecraft", "blindness"), 1200, 0, 1.0F)
            .addEffect(effect("alexsmobs", "fear"), 100, 0, 1.0F)
            .addEffect(effect("minecraft", "haste"), 1200, 4, 1.0F));
        ORCAS_LEAP_SOUP = register("orcas_leap_soup", bowlFood(16, 0.6F)
            .addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F)
            .addEffect(effect("alexsmobs", "orcas_might"), 900, 0, 1.0F)
            .addTooltip("tooltip.alexsmobsdelightlegacy.orcas_leap_soup"));
        BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON = register("bowl_of_moose_sausage_with_salmon", bowlFood(14, 0.85F).addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        LOBSTER_PASTA = register("lobster_pasta", bowlFood(14, 0.85F).addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON = register("bowl_of_honey_glazed_bear_meat_with_salmon", bowlFood(16, 0.85F)
            .addEffect(effect("farmersdelight", "nourishment"), 3000, 0, 1.0F)
            .addEffect(effect("alexsmobs", "knockback_resistance"), 1800, 0, 1.0F));
        POT_OF_WHALE_MEAT_STEWED_WITH_PORK = register("pot_of_whale_meat_stewed_with_pork", containerFood(16, 0.85F, Items.FLOWER_POT)
            .addEffect(effect("farmersdelight", "comfort"), 6000, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        WHALE_SKIN_STEW = register("whale_skin_stew", bowlFood(20, 0.6F)
            .addEffect(effect("farmersdelight", "comfort"), 3000, 0, 1.0F)
            .addEffect(effect("minecraft", "resistance"), 900, 0, 1.0F));
        KIVIAK = register("kiviak", new ItemKiviakFood(3, 0.6F, true).addEffect(effect("alexsmobsdelightlegacy", "seagull_anorexia"), 24000, 0, 1.0F));
        BOWL_OF_STUFFED_CROCODILE_HEAD = register("bowl_of_stuffed_crocodile_head", bowlFood(20, 0.85F)
            .addEffect(effect("alexsmobsdelightlegacy", "crocodile_sharpness"), 1800, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        BOWL_OF_STUFFED_CROCODILE_TAIL = register("bowl_of_stuffed_crocodile_tail", bowlFood(18, 0.85F)
            .addEffect(effect("alexsmobsdelightlegacy", "crocodile_hacksaw"), 1800, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        BOWL_OF_STUFFED_CROCODILE_LEG = register("bowl_of_stuffed_crocodile_leg", bowlFood(16, 0.85F)
            .addEffect(effect("alexsmobsdelightlegacy", "crocodile_crush"), 1800, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        BOWL_OF_STUFFED_CROCODILE = register("bowl_of_stuffed_crocodile", bowlFood(12, 0.85F)
            .addEffect(effect("alexsmobsdelightlegacy", "crocodile_toughness"), 1800, 0, 1.0F)
            .addEffect(effect("farmersdelight", "nourishment"), 6000, 0, 1.0F));
        CROCODILE_KNIFE = register("crocodile_knife", new ItemCrocodileKnife(AMDToolMaterials.CROCODILE, 0.0D));
        LOBSTER_KNIFE = register("lobster_knife", new ItemLobsterKnife(AMDToolMaterials.SHRIMP, 0.0D));
        BANANA_BOW = register("banana_bow", new ItemBananaBow().setMaxDamage(64));
        WHALE_TOOTH_PICKAXE = register("whale_tooth_pickaxe", new ItemWhaleToothPickaxe(AMDToolMaterials.WHALE_TOOTH));
        SEAGULL_WAND = register("seagull_wand", new ItemSeagullWand(Item.ToolMaterial.WOOD));
        CROCODILE_SCUTE_SWORD = register("crocodile_scute_sword", new ItemCrocodileScuteSword(AMDToolMaterials.CROCODILE_SCUTE));
        MANTIS_SHRIMP_SCYTHE = register("mantis_shrimp_scythe", new ItemMantisShrimpScythe(AMDToolMaterials.SHRIMP, 3.0D));
        MANTIS_SHRIMP_AXE = register("mantis_shrimp_axe", new ItemMantisShrimpAxe(AMDToolMaterials.SHRIMP, 6.0F, -3.1F));
        MANTIS_SHRIMP_SHOVEL = register("mantis_shrimp_shovel", new ItemMantisShrimpShovel(AMDToolMaterials.SHRIMP, 1.5F, -3.0F));
        MANTIS_SHRIMP_HAMMER = register("mantis_shrimp_hammer", new ItemMantisShrimpHammer(AMDToolMaterials.SHRIMP));
        LOBSTER_DART = register("lobster_dart", new ItemLobsterDart());

        registry.registerAll(ITEMS.toArray(new Item[0]));
        registerOreDictionary();
    }

    public static void registerModels() {
        for (Item item : ITEMS) {
            ClientProxy.registerItemModel(item);
        }
    }

    private static Item register(String name, Item item) {
        item.setRegistryName(AlexsMobsDelightLegacy.MODID, name);
        item.setUnlocalizedName(AlexsMobsDelightLegacy.MODID + "." + name);
        item.setCreativeTab(AlexsMobsDelightLegacy.CREATIVE_TAB);
        ITEMS.add(item);
        return item;
    }

    private static AMDFoodItem food(int amount, float saturation) {
        return new AMDFoodItem(amount, saturation, true);
    }

    private static AMDFoodItem bowlFood(int amount, float saturation) {
        AMDFoodItem item = new AMDFoodItem(amount, saturation, false, Items.BOWL, net.minecraft.item.EnumAction.EAT);
        item.setMaxStackSize(16);
        return item;
    }

    private static AMDFoodItem bucketFood(int amount, float saturation) {
        AMDFoodItem item = new AMDFoodItem(amount, saturation, false, Items.BUCKET, net.minecraft.item.EnumAction.EAT);
        item.setMaxStackSize(1);
        return item;
    }

    private static AMDFoodItem containerFood(int amount, float saturation, Item container) {
        AMDFoodItem item = new AMDFoodItem(amount, saturation, false, container, net.minecraft.item.EnumAction.EAT);
        item.setMaxStackSize(16);
        return item;
    }

    private static Item plain() {
        return new Item();
    }

    private static ResourceLocation effect(String modid, String path) {
        return new ResourceLocation(modid, path);
    }

    private static void registerOreDictionary() {
        OreDictionary.registerOre("listAllmeatraw", RAW_BEAR_MEAT);
        OreDictionary.registerOre("listAllmeatraw", RAW_BISON_MEAT);
        OreDictionary.registerOre("listAllmeatraw", RAW_TUSKLIN_MEAT);
        OreDictionary.registerOre("listAllmeatraw", RAW_CROCODILE_MEAT);
        OreDictionary.registerOre("listAllfishraw", RAW_DEVILS_HOLE_PUPFISH);
        OreDictionary.registerOre("amdMantisShrimpTail", MANTIS_SHRIMP_TAIL_RED);
        OreDictionary.registerOre("amdMantisShrimpTail", MANTIS_SHRIMP_TAIL_GREEN);
        OreDictionary.registerOre("amdMantisShrimpTail", MANTIS_SHRIMP_TAIL_LIME);
        OreDictionary.registerOre("amdMantisShrimpTail", MANTIS_SHRIMP_TAIL_WHITE);
        OreDictionary.registerOre("foodDough", new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("farmersdelight", "wheat_dough"))));
        OreDictionary.registerOre("listAllmilk", Items.MILK_BUCKET);
        registerExternalOre("cropOnion", "farmersdelight:onion");
        registerExternalOre("listAllEgg", "minecraft:egg");
        registerExternalOre("cropCabbage", "farmersdelight:cabbage_leaf");
        registerExternalOre("amdMushroomColony", "farmersdelight:brown_mushroom_colony");
        registerExternalOre("amdMushroomColony", "farmersdelight:red_mushroom_colony");
        registerOptionalOre("amdSeagrass", "oe:seagrass", new ItemStack(net.minecraft.init.Blocks.TALLGRASS, 1, 1));
        registerOptionalOre("amdKelp", "oe:kelp", new ItemStack(net.minecraft.init.Blocks.TALLGRASS, 1, 1));
        registerOptionalOre("amdDriedKelp", "oe:dried_kelp", OreDictionary.getOres("amdKelp").isEmpty() ? ItemStack.EMPTY : OreDictionary.getOres("amdKelp").get(0).copy());
        OreDictionary.registerOre("amdFern", new ItemStack(net.minecraft.init.Blocks.TALLGRASS, 1, 2));
        registerExternalOre("amdRawCatfishForStew", "alexsmobs:raw_catfish");
        OreDictionary.registerOre("amdRawCatfishForStew", RAW_CATFISH_SLICE);
        OreDictionary.registerOre("amdWildStewMeat", RAW_BEAR_MEAT);
        OreDictionary.registerOre("amdWildStewMeat", RAW_BISON_MEAT);
        OreDictionary.registerOre("amdWildStewMeat", RAW_TUSKLIN_MEAT);
        registerExternalOre("amdWildStewMeat", "alexsmobs:kangaroo_meat");
        registerExternalOre("amdWildStewMeat", "alexsmobs:moose_ribs");
        OreDictionary.registerOre("amdLargeCookedMeat", COOKED_BEAR_MEAT);
        OreDictionary.registerOre("amdLargeCookedMeat", COOKED_BISON_MEAT);
        OreDictionary.registerOre("cropBeetroot", Items.BEETROOT);
        if (RAW_MUDSKIPPER != null) {
            OreDictionary.registerOre("listAllfishraw", RAW_MUDSKIPPER);
        }
    }

    private static void registerOptionalOre(String oreName, String preferredId, ItemStack fallback) {
        ItemStack preferred = externalStack(preferredId);
        if (!preferred.isEmpty()) {
            OreDictionary.registerOre(oreName, preferred);
        } else if (!fallback.isEmpty()) {
            OreDictionary.registerOre(oreName, fallback);
        }
    }

    private static void registerExternalOre(String oreName, String id) {
        ItemStack stack = externalStack(id);
        if (!stack.isEmpty()) {
            OreDictionary.registerOre(oreName, stack);
        }
    }

    private static ItemStack externalStack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }
}

package xy177.alexsmobsdelightlegacy.common.registry;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class AMDCreativeTab extends CreativeTabs {
    public static final AMDCreativeTab INSTANCE = new AMDCreativeTab();

    private AMDCreativeTab() {
        super("alexsmobsdelightlegacy");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(AMDItems.COOKED_BEAR_MEAT);
    }

    @Override
    public void displayAllRelevantItems(NonNullList<ItemStack> items) {
        add(items, AMDItems.RAW_BEAR_MEAT);
        add(items, AMDItems.RAW_BEAR_MEAT_SLICE);
        add(items, AMDItems.COOKED_BEAR_MEAT);
        add(items, AMDItems.COOKED_BEAR_MEAT_SLICE);
        add(items, AMDItems.RAW_BISON_MEAT);
        add(items, AMDItems.RAW_BISON_MEAT_CUBES);
        add(items, AMDItems.COOKED_BISON_MEAT);
        add(items, AMDItems.COOKED_BISON_MEAT_CUBES);
        add(items, AMDItems.RAW_KANGAROO_MEAT_SLICE);
        add(items, AMDItems.COOKED_KANGAROO_MEAT_SLICE);
        add(items, AMDItems.RAW_MOOSE_RIB_PIECE);
        add(items, AMDItems.COOKED_MOOSE_RIB_PIECE);
        add(items, AMDItems.RAW_SEAGULL);
        add(items, AMDItems.COOKED_SEAGULL);
        add(items, AMDItems.ENCHANTED_COOKED_SEAGULL);
        add(items, AMDItems.ETERNAL_COOKED_SEAGULL);
        add(items, AMDItems.ENCHANTED_ETERNAL_COOKED_SEAGULL);
        add(items, AMDItems.MANTIS_SHRIMP_TAIL_RED);
        add(items, AMDItems.MANTIS_SHRIMP_TAIL_GREEN);
        add(items, AMDItems.MANTIS_SHRIMP_TAIL_LIME);
        add(items, AMDItems.MANTIS_SHRIMP_TAIL_WHITE);
        add(items, AMDItems.COOKED_MANTIS_SHRIMP_TAIL);
        add(items, AMDItems.RAW_TUSKLIN_MEAT);
        add(items, AMDItems.RAW_TUSKLIN_MEAT_PIECE);
        add(items, AMDItems.COOKED_TUSKLIN_MEAT);
        add(items, AMDItems.COOKED_TUSKLIN_MEAT_PIECE);
        add(items, AMDItems.RAW_DEVILS_HOLE_PUPFISH);
        add(items, AMDItems.RAW_DEVILS_HOLE_PUPFISH_SLICE);
        add(items, AMDItems.COOKED_DEVILS_HOLE_PUPFISH);
        add(items, AMDItems.COOKED_DEVILS_HOLE_PUPFISH_SLICE);
        add(items, AMDItems.RAW_CATFISH_SLICE);
        add(items, AMDItems.COOKED_CATFISH_SLICE);
        add(items, AMDItems.BANANA_SLICE);
        add(items, AMDItems.RAW_CROCODILE_CLAW);
        add(items, AMDItems.RAW_CROCODILE_TAIL);
        add(items, AMDItems.RAW_CROCODILE_MEAT);
        add(items, AMDItems.COOKED_CROCODILE_CLAW);
        add(items, AMDItems.COOKED_CROCODILE_TAIL);
        add(items, AMDItems.COOKED_CROCODILE_MEAT);
        add(items, AMDItems.RAW_WHOLE_CROCODILE);
        add(items, AMDItems.MIMIC_OCTOPUS_TENTACLE);
        add(items, AMDItems.COOKED_OCTOPUS_TENTACLE);
        add(items, AMDItems.WHALE_MEAT);
        add(items, AMDItems.COOKED_WHALE_MEAT);
        add(items, AMDItems.COOKED_LOST_TENTACLE);
        add(items, AMDItems.DRIED_SHREDDED_SQUID);
        add(items, AMDItems.SEAL_MEAT);
        add(items, AMDItems.COOKED_SEAL_MEAT);
        add(items, AMDItems.CHEESE);

        add(items, AMDItems.CROCODILE_TOOTH);
        add(items, AMDItems.LOBSTER_HEAD);
        add(items, AMDItems.SEAL_LEATHER_BROWN);
        add(items, AMDItems.SEAL_LEATHER_GRAY);
        add(items, AMDItems.CANNED_BEAR_MEAT);

        add(items, AMDItems.MANTIS_SHRIMP_SCYTHE);
        add(items, AMDItems.MANTIS_SHRIMP_SHOVEL);
        add(items, AMDItems.MANTIS_SHRIMP_HAMMER);
        add(items, AMDItems.MANTIS_SHRIMP_AXE);
        add(items, AMDItems.LOBSTER_KNIFE);
        add(items, AMDItems.LOBSTER_DART);
        add(items, AMDItems.CROCODILE_KNIFE);
        add(items, AMDItems.CROCODILE_SCUTE_SWORD);
        add(items, AMDItems.BANANA_BOW);
        add(items, AMDItems.WHALE_TOOTH_PICKAXE);
        add(items, AMDItems.SEAGULL_WAND);

        add(items, AMDItems.RAW_TUSKLIN_SAUSAGE);
        add(items, AMDItems.SMOKED_TUSKLIN_SAUSAGE);
        add(items, AMDItems.SLICE_OF_SMOKED_TUSKLIN_SAUSAGE);
        add(items, AMDItems.MANTIS_SHRIMP_TEMPURA);
        add(items, AMDItems.SHRIMP_FRIED_EGG);
        add(items, AMDItems.RAINBOW_CUSTARD);
        add(items, AMDItems.RAINBOW_POPSICLE);
        add(items, AMDItems.BANANA_SLUG_SLIME_CUSTARD);
        add(items, AMDItems.BANANA_SLUG_SLIME_POPSICLE);
        add(items, AMDItems.SHRIMP_POKE_BOWL);
        add(items, AMDItems.FRIED_TUSKLIN_MEAT);
        add(items, AMDItems.CROCODILE_RICE);
        add(items, AMDItems.TAKOYAKI);

        add(items, AMDItems.CATFISH_ROLL);
        add(items, AMDItems.DEVILS_HOLE_PUPFISH_ROLL);
        add(items, AMDItems.BANANA_ROLL);
        add(items, AMDItems.BANANA_ROLL_SLICE);
        add(items, AMDItems.LOBSTER_ROLL);

        add(items, AMDItems.CROCODILE_BARBECUE_STICK);
        add(items, AMDItems.CHEESE_SEAL_STICK);
        add(items, AMDItems.FRIED_TENTACLES_STICK);

        add(items, AMDItems.BIG_MAC);
        add(items, AMDItems.TUSKLIN_HOT_DOG);
        add(items, AMDItems.WHALE_BURGER);
        add(items, AMDItems.CHEESE_SEAL_BURGER);
        add(items, AMDItems.SMOKED_TUSKLIN_SANDWICH);
        add(items, AMDItems.TENTACLE_SANDWICH);
        add(items, AMDItems.DRIED_KELP_TENTACLES_SANDWICH);
        add(items, AMDItems.SEAL_SANDWICH);

        add(items, AMDBlocks.MOOSE_PIE_ITEM);
        add(items, AMDItems.SLICE_OF_MOOSE_PIE);

        add(items, AMDItems.KIVIAK);

        add(items, AMDItems.BOWL_OF_WILD_STEW);
        add(items, AMDItems.FRONTIER_SOUP);
        add(items, AMDItems.KANGAROO_MEAT_STEW);
        add(items, AMDItems.MOOSE_STEW);
        add(items, AMDItems.SEA_BEAR_STEW);
        add(items, AMDItems.SEAGULL_SOUP);
        add(items, AMDItems.CATFISH_STEW);
        add(items, AMDItems.DEVILS_HOLE_PUPFISH_STEW);
        add(items, AMDItems.CROCODILE_STEWED_WITH_CATFISH);
        add(items, AMDItems.SEAL_STEW);

        add(items, AMDItems.BISON_TARTARE);
        add(items, AMDItems.BRAISED_KANGAROO_MEATBALLS);
        add(items, AMDItems.GRAVY_KANGAROO_MEAT);
        add(items, AMDItems.KATSUDON);
        add(items, AMDItems.HONEY_GLAZED_MOOSE_RIBS);
        add(items, AMDItems.ROAST_SEAGULL);
        add(items, AMDItems.FRIED_SEAGULL_WITH_FRIES);
        add(items, AMDItems.BOWL_OF_MOOSE_SAUSAGE_WITH_SALMON);
        add(items, AMDItems.LOBSTER_HEAD_STEW);
        add(items, AMDItems.MOSQUITO_REPELLENT_STEW_CUP);
        add(items, AMDItems.ACACIA_BLOSSOM_TENTACLE_SALAD);
        add(items, AMDItems.WHALE_MEAT_WITH_TENTACLES);
        add(items, AMDItems.TENTACLE_MEDLEY);
        add(items, AMDItems.CTHULHUS_BREAKFAST);
        add(items, AMDItems.ORCAS_LEAP_SOUP);
        add(items, AMDItems.BOWL_OF_HONEY_GLAZED_BEAR_MEAT_WITH_SALMON);
        add(items, AMDItems.POT_OF_WHALE_MEAT_STEWED_WITH_PORK);
        add(items, AMDItems.WHALE_SKIN_STEW);
        add(items, AMDItems.BOWL_OF_STUFFED_CROCODILE_HEAD);
        add(items, AMDItems.BOWL_OF_STUFFED_CROCODILE_TAIL);
        add(items, AMDItems.BOWL_OF_STUFFED_CROCODILE_LEG);
        add(items, AMDItems.BOWL_OF_STUFFED_CROCODILE);
        add(items, AMDItems.LOBSTER_PASTA);

        add(items, AMDBlocks.MOOSE_SAUSAGE_WITH_SALMON_ITEM);
        add(items, AMDBlocks.HONEY_GLAZED_BEAR_MEAT_WITH_SALMON_ITEM);
        add(items, AMDBlocks.WILD_STEW_ITEM);
        add(items, AMDBlocks.ALEXS_RICE_ROLL_MEDLEY_ITEM);
        add(items, AMDBlocks.STEAMED_STUFFED_CROCODILE_ITEM);
        add(items, AMDBlocks.LOBSTER_ROLL_MEDLEY_ITEM);
        add(items, AMDBlocks.WHALE_MEAT_STEWED_WITH_PORK_ITEM);

        add(items, AMDBlocks.COASTAL_KIVIAK_ITEM);
        add(items, AMDBlocks.POLAR_KIVIAK_ITEM);
        add(items, AMDBlocks.SEAL_FUR_CARPET_BROWN_ITEM);
        add(items, AMDBlocks.SEAL_FUR_CARPET_GRAY_ITEM);
        add(items, AMDBlocks.BANANA_BLOCK_ITEM);
        add(items, AMDBlocks.ACACIA_BLOSSOM_BLOCK_ITEM);
    }

    private static void add(NonNullList<ItemStack> items, Item item) {
        if (item != null) {
            item.getSubItems(INSTANCE, items);
        }
    }
}

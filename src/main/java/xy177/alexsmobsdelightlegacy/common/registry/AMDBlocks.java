package xy177.alexsmobsdelightlegacy.common.registry;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.registries.IForgeRegistry;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.block.BlockAcaciaBlossom;
import xy177.alexsmobsdelightlegacy.common.block.BlockAlexsRiceRollMedley;
import xy177.alexsmobsdelightlegacy.common.block.BlockBanana;
import xy177.alexsmobsdelightlegacy.common.block.BlockHoneyGlazedBearMeatWithSalmon;
import xy177.alexsmobsdelightlegacy.common.block.BlockKiviak;
import xy177.alexsmobsdelightlegacy.common.block.BlockLobsterRollMedley;
import xy177.alexsmobsdelightlegacy.common.block.BlockMooseSausageWithSalmon;
import xy177.alexsmobsdelightlegacy.common.block.BlockWildStew;
import xy177.alexsmobsdelightlegacy.common.block.BlockMoosePie;
import xy177.alexsmobsdelightlegacy.common.block.BlockSealCarpet;
import xy177.alexsmobsdelightlegacy.common.block.BlockSteamedStuffedCrocodile;
import xy177.alexsmobsdelightlegacy.common.block.BlockWhaleMeatStewedWithPork;

public final class AMDBlocks {
    public static Block WILD_STEW;
    public static Item WILD_STEW_ITEM;
    public static Block MOOSE_PIE;
    public static Item MOOSE_PIE_ITEM;
    public static Block SEAL_FUR_CARPET_BROWN;
    public static Item SEAL_FUR_CARPET_BROWN_ITEM;
    public static Block SEAL_FUR_CARPET_GRAY;
    public static Item SEAL_FUR_CARPET_GRAY_ITEM;
    public static Block BANANA_BLOCK;
    public static Item BANANA_BLOCK_ITEM;
    public static Block ACACIA_BLOSSOM_BLOCK;
    public static Item ACACIA_BLOSSOM_BLOCK_ITEM;
    public static Block COASTAL_KIVIAK;
    public static Item COASTAL_KIVIAK_ITEM;
    public static Block POLAR_KIVIAK;
    public static Item POLAR_KIVIAK_ITEM;
    public static Block MOOSE_SAUSAGE_WITH_SALMON;
    public static Item MOOSE_SAUSAGE_WITH_SALMON_ITEM;
    public static Block WHALE_MEAT_STEWED_WITH_PORK;
    public static Item WHALE_MEAT_STEWED_WITH_PORK_ITEM;
    public static Block HONEY_GLAZED_BEAR_MEAT_WITH_SALMON;
    public static Item HONEY_GLAZED_BEAR_MEAT_WITH_SALMON_ITEM;
    public static Block LOBSTER_ROLL_MEDLEY;
    public static Item LOBSTER_ROLL_MEDLEY_ITEM;
    public static Block ALEXS_RICE_ROLL_MEDLEY;
    public static Item ALEXS_RICE_ROLL_MEDLEY_ITEM;
    public static Block STEAMED_STUFFED_CROCODILE;
    public static Item STEAMED_STUFFED_CROCODILE_ITEM;

    private AMDBlocks() {
    }

    public static void register(IForgeRegistry<Block> registry) {
        WILD_STEW = register(registry, "wild_stew", new BlockWildStew());
        MOOSE_PIE = register(registry, "moose_pie", new BlockMoosePie());
        SEAL_FUR_CARPET_BROWN = register(registry, "seal_fur_carpet_brown", new BlockSealCarpet(SoundType.CLOTH));
        SEAL_FUR_CARPET_GRAY = register(registry, "seal_fur_carpet_gray", new BlockSealCarpet(SoundType.CLOTH));
        BANANA_BLOCK = register(registry, "banana_block", new BlockBanana());
        ACACIA_BLOSSOM_BLOCK = register(registry, "acacia_blossom_block", new BlockAcaciaBlossom());
        COASTAL_KIVIAK = register(registry, "coastal_kiviak", new BlockKiviak());
        POLAR_KIVIAK = register(registry, "polar_kiviak", new BlockKiviak());
        MOOSE_SAUSAGE_WITH_SALMON = register(registry, "moose_sausage_with_salmon", new BlockMooseSausageWithSalmon());
        WHALE_MEAT_STEWED_WITH_PORK = register(registry, "whale_meat_stewed_with_pork", new BlockWhaleMeatStewedWithPork());
        HONEY_GLAZED_BEAR_MEAT_WITH_SALMON = register(registry, "honey_glazed_bear_meat_with_salmon", new BlockHoneyGlazedBearMeatWithSalmon());
        LOBSTER_ROLL_MEDLEY = register(registry, "lobster_roll_medley", new BlockLobsterRollMedley());
        ALEXS_RICE_ROLL_MEDLEY = register(registry, "alexs_rice_roll_medley", new BlockAlexsRiceRollMedley());
        STEAMED_STUFFED_CROCODILE = register(registry, "steamed_stuffed_crocodile", new BlockSteamedStuffedCrocodile());
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        WILD_STEW_ITEM = registerItemBlock(registry, WILD_STEW, true);
        MOOSE_PIE_ITEM = registerItemBlock(registry, MOOSE_PIE, true);
        SEAL_FUR_CARPET_BROWN_ITEM = registerItemBlock(registry, SEAL_FUR_CARPET_BROWN, false);
        SEAL_FUR_CARPET_GRAY_ITEM = registerItemBlock(registry, SEAL_FUR_CARPET_GRAY, false);
        BANANA_BLOCK_ITEM = registerItemBlock(registry, BANANA_BLOCK, false);
        ACACIA_BLOSSOM_BLOCK_ITEM = registerItemBlock(registry, ACACIA_BLOSSOM_BLOCK, false);
        COASTAL_KIVIAK_ITEM = registerItemBlock(registry, COASTAL_KIVIAK, true);
        POLAR_KIVIAK_ITEM = registerItemBlock(registry, POLAR_KIVIAK, true);
        MOOSE_SAUSAGE_WITH_SALMON_ITEM = registerItemBlock(registry, MOOSE_SAUSAGE_WITH_SALMON, true);
        WHALE_MEAT_STEWED_WITH_PORK_ITEM = registerItemBlock(registry, WHALE_MEAT_STEWED_WITH_PORK, true);
        HONEY_GLAZED_BEAR_MEAT_WITH_SALMON_ITEM = registerItemBlock(registry, HONEY_GLAZED_BEAR_MEAT_WITH_SALMON, true);
        LOBSTER_ROLL_MEDLEY_ITEM = registerItemBlock(registry, LOBSTER_ROLL_MEDLEY, true);
        ALEXS_RICE_ROLL_MEDLEY_ITEM = registerItemBlock(registry, ALEXS_RICE_ROLL_MEDLEY, true);
        STEAMED_STUFFED_CROCODILE_ITEM = registerItemBlock(registry, STEAMED_STUFFED_CROCODILE, true);
    }

    public static void registerModels() {
        registerModel(WILD_STEW_ITEM);
        registerModel(MOOSE_PIE_ITEM);
        registerModel(SEAL_FUR_CARPET_BROWN_ITEM);
        registerModel(SEAL_FUR_CARPET_GRAY_ITEM);
        registerModel(BANANA_BLOCK_ITEM);
        registerModel(ACACIA_BLOSSOM_BLOCK_ITEM);
        registerModel(COASTAL_KIVIAK_ITEM);
        registerModel(POLAR_KIVIAK_ITEM);
        registerModel(MOOSE_SAUSAGE_WITH_SALMON_ITEM);
        registerModel(WHALE_MEAT_STEWED_WITH_PORK_ITEM);
        registerModel(HONEY_GLAZED_BEAR_MEAT_WITH_SALMON_ITEM);
        registerModel(LOBSTER_ROLL_MEDLEY_ITEM);
        registerModel(ALEXS_RICE_ROLL_MEDLEY_ITEM);
        registerModel(STEAMED_STUFFED_CROCODILE_ITEM);
    }

    private static Block register(IForgeRegistry<Block> registry, String name, Block block) {
        block.setRegistryName(AlexsMobsDelightLegacy.MODID, name);
        block.setUnlocalizedName(AlexsMobsDelightLegacy.MODID + "." + name);
        block.setCreativeTab(AlexsMobsDelightLegacy.CREATIVE_TAB);
        registry.register(block);
        return block;
    }

    private static Item registerItemBlock(IForgeRegistry<Item> registry, Block block, boolean stackOne) {
        ItemBlock item = new ItemBlock(block);
        item.setRegistryName(block.getRegistryName());
        item.setUnlocalizedName(block.getUnlocalizedName());
        item.setCreativeTab(AlexsMobsDelightLegacy.CREATIVE_TAB);
        if (stackOne) {
            item.setMaxStackSize(1);
        }
        registry.register(item);
        return item;
    }

    private static void registerModel(Item item) {
        ModelLoader.setCustomModelResourceLocation(
            item,
            0,
            new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }
}

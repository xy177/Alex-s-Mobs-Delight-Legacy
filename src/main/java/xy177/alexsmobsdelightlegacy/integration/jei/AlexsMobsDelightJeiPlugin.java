package xy177.alexsmobsdelightlegacy.integration.jei;

import com.google.common.collect.ImmutableList;
import java.util.List;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.common.registry.AMDBlocks;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@JEIPlugin
public class AlexsMobsDelightJeiPlugin implements IModPlugin {
    @Override
    public void register(IModRegistry registry) {
        registry.addDescription(new ItemStack(AMDItems.ORCAS_LEAP_SOUP), "alexsmobsdelightlegacy.jei.info.orcas_leap_soup");
        registry.addDescription(kiviakStacks(), "alexsmobsdelightlegacy.jei.info.kiviak");
        registry.addDescription(new ItemStack(AMDBlocks.BANANA_BLOCK_ITEM), "alexsmobsdelightlegacy.jei.info.banana_block");
        registry.addDescription(new ItemStack(AMDBlocks.ACACIA_BLOSSOM_BLOCK_ITEM), "alexsmobsdelightlegacy.jei.info.acacia_blossom_block");
        registry.addDescription(new ItemStack(AMDItems.SHRIMP_FRIED_EGG), "alexsmobsdelightlegacy.jei.info.shrimp_fried_egg");
        addIfPresent(registry, stack("alexsmobs:shrimp_fried_rice"), "alexsmobsdelightlegacy.jei.info.shrimp_fried_rice");
        registry.addDescription(new ItemStack(AMDItems.ENCHANTED_COOKED_SEAGULL), "alexsmobsdelightlegacy.jei.info.enchanted_seagull");
        registry.addIngredientInfo(new ItemStack(AMDItems.SEAL_MEAT), ItemStack.class, "alexsmobsdelightlegacy.jei.info.seal_meat");
        registry.addIngredientInfo(new ItemStack(Items.EGG), ItemStack.class, "alexsmobsdelightlegacy.jei.info.mantis_shrimp_egg_input");
    }

    private static List<ItemStack> kiviakStacks() {
        return ImmutableList.of(
            new ItemStack(AMDItems.KIVIAK),
            new ItemStack(AMDBlocks.COASTAL_KIVIAK_ITEM),
            new ItemStack(AMDBlocks.POLAR_KIVIAK_ITEM)
        );
    }

    private static void addIfPresent(IModRegistry registry, ItemStack stack, String key) {
        if (!stack.isEmpty()) {
            registry.addDescription(stack, key);
        }
    }

    private static ItemStack stack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }
}

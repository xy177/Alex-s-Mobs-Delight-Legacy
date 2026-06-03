package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

public class BlockLobsterRollMedley extends BlockAMDLargeFeast {
    private static final AxisAlignedBB PLATE = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 2.0D / 16.0D, 15.0D / 16.0D);
    private static final AxisAlignedBB FOOD = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 4.0D / 16.0D, 15.0D / 16.0D);

    public BlockLobsterRollMedley() {
        super(5, "lobster_roll", ItemStack.EMPTY, new ItemStack(Items.BOWL), FOOD, PLATE);
        setHardness(0.5F);
    }

    @Override
    protected ItemStack getServingStack(int servings) {
        switch (servings) {
            case 5:
                return new ItemStack(AMDItems.LOBSTER_HEAD);
            case 4:
                return stack("alexsmobs:cooked_lobster_tail");
            case 3:
            case 2:
            case 1:
                return new ItemStack(AMDItems.LOBSTER_ROLL);
            default:
                return ItemStack.EMPTY;
        }
    }

    private ItemStack stack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }
}

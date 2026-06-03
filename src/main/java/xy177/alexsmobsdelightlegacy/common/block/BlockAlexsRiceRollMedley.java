package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockIce;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

public class BlockAlexsRiceRollMedley extends BlockAMDLargeFeast {
    private static final AxisAlignedBB PLATE = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 1.0D / 16.0D, 15.0D / 16.0D);
    private static final AxisAlignedBB FOOD = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 3.0D / 16.0D, 15.0D / 16.0D);

    public BlockAlexsRiceRollMedley() {
        super(7, "catfish_roll", ItemStack.EMPTY, new ItemStack(Items.BOWL), FOOD, PLATE);
        setHardness(0.5F);
    }

    @Override
    protected ItemStack getServingStack(int servings) {
        switch (servings) {
            case 7:
                return stack("alexsmobs:acacia_blossom");
            case 6:
                return new ItemStack(AMDItems.DEVILS_HOLE_PUPFISH_ROLL);
            case 5:
                return new ItemStack(AMDItems.CATFISH_ROLL);
            case 4:
                return new ItemStack(AMDItems.DEVILS_HOLE_PUPFISH_ROLL);
            case 3:
                return new ItemStack(AMDItems.CATFISH_ROLL);
            case 2:
                return new ItemStack(AMDItems.DEVILS_HOLE_PUPFISH_ROLL);
            case 1:
                return new ItemStack(AMDItems.CATFISH_ROLL);
            default:
                return ItemStack.EMPTY;
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        BlockPos below = pos.down();
        IBlockState belowState = worldIn.getBlockState(below);
        Block belowBlock = belowState.getBlock();
        return belowState.isFullCube() || belowBlock instanceof BlockIce || worldIn.getBlockState(below).getMaterial().isLiquid();
    }

    private ItemStack stack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }
}

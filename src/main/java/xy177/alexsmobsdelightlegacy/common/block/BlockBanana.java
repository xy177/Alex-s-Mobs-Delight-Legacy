package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.block.BlockCocoa;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class BlockBanana extends BlockCocoa {
    @Override
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        BlockPos attachPos = pos.offset(state.getValue(FACING));
        IBlockState attachState = worldIn.getBlockState(attachPos);
        return attachState.getBlock().isWood(worldIn, attachPos);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        Item banana = ForgeRegistries.ITEMS.getValue(new net.minecraft.util.ResourceLocation("alexsmobs", "banana"));
        if (banana != null) {
            drops.add(new ItemStack(banana, state.getValue(AGE) >= 2 ? 3 : 1));
        }
    }
}

package xy177.alexsmobsdelightlegacy.common.block;

import com.wdcftgg.farmersdelightlegacy.common.block.BlockPie;
import com.wdcftgg.farmersdelightlegacy.common.registry.ModSounds;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;

public class BlockMoosePie extends BlockPie {
    public BlockMoosePie() {
        super("slice_of_moose_pie");
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (hand != EnumHand.MAIN_HAND) {
            return true;
        }
        if (!worldIn.isRemote) {
            Item slice = ForgeRegistries.ITEMS.getValue(new net.minecraft.util.ResourceLocation(AlexsMobsDelightLegacy.MODID, "slice_of_moose_pie"));
            if (slice == null) {
                return false;
            }
            ItemStack serving = new ItemStack(slice);
            if (!player.inventory.addItemStackToInventory(serving.copy())) {
                worldIn.spawnEntity(new EntityItem(worldIn, player.posX, player.posY + 0.5D, player.posZ, serving.copy()));
            }
            int bites = state.getValue(BITES);
            if (bites >= 3) {
                worldIn.setBlockToAir(pos);
            } else {
                worldIn.setBlockState(pos, state.withProperty(BITES, bites + 1), 3);
            }
            worldIn.playSound(null, pos, ModSounds.foodTakePortion, SoundCategory.BLOCKS, 0.8F, 0.8F);
        }
        return true;
    }
}

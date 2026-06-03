package xy177.alexsmobsdelightlegacy.common.event;

import net.minecraft.block.BlockCocoa;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDBlocks;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDPlantingEvents {
    private AMDPlantingEvents() {
    }

    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty() || stack.getItem().getRegistryName() == null) {
            return;
        }
        String id = stack.getItem().getRegistryName().toString();
        if ("alexsmobs:banana".equals(id)) {
            tryPlant(event, (BlockCocoa) AMDBlocks.BANANA_BLOCK);
        } else if ("alexsmobs:acacia_blossom".equals(id)) {
            tryPlant(event, (BlockCocoa) AMDBlocks.ACACIA_BLOSSOM_BLOCK);
        }
    }

    private static void tryPlant(PlayerInteractEvent.RightClickBlock event, BlockCocoa cropBlock) {
        EnumFacing facing = event.getFace();
        if (facing == EnumFacing.UP || facing == EnumFacing.DOWN) {
            return;
        }
        World world = event.getWorld();
        BlockPos placePos = event.getPos().offset(facing);
        EntityPlayer player = event.getEntityPlayer();
        EnumHand hand = event.getHand();
        ItemStack stack = event.getItemStack();
        if (!world.isAirBlock(placePos) || !player.canPlayerEdit(placePos, facing, stack)) {
            return;
        }

        IBlockState state = cropBlock.getDefaultState()
            .withProperty(BlockCocoa.FACING, facing.getOpposite())
            .withProperty(BlockCocoa.AGE, 0);
        if (!cropBlock.canBlockStay(world, placePos, state)) {
            return;
        }
        if (!world.isRemote) {
            world.setBlockState(placePos, state, 3);
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
        }
        event.setCanceled(true);
        event.setCancellationResult(EnumActionResult.SUCCESS);
    }
}

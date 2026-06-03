package xy177.alexsmobsdelightlegacy.common.effect;

import com.github.alexthe666.alexsmobs.block.AMBlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PotionCrystallizeWalker extends AMDPotion {
    public PotionCrystallizeWalker() {
        super("crystallize_walker", 0xFFEFA8);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }

    @Override
    public void performEffect(EntityLivingBase entity, int amplifier) {
        World world = entity.world;
        if (world.isRemote || !entity.onGround) {
            return;
        }
        int radius = Math.min(2 + amplifier, 5);
        BlockPos center = new BlockPos(entity);
        IBlockState crystal = AMBlockRegistry.CRYSTALIZED_BANANA_SLUG_MUCUS.getDefaultState();
        for (BlockPos pos : BlockPos.getAllInBoxMutable(center.add(-radius, -1, -radius), center.add(radius, -1, radius))) {
            if (pos.distanceSqToCenter(entity.posX, entity.posY, entity.posZ) > radius * radius) {
                continue;
            }
            BlockPos above = pos.up();
            if ((world.getBlockState(pos).getBlock() == Blocks.LAVA || world.getBlockState(pos).getBlock() == Blocks.FLOWING_LAVA)
                && world.getBlockState(above).getBlock().isReplaceable(world, above)) {
                world.setBlockState(pos, crystal, 3);
            }
        }
    }
}

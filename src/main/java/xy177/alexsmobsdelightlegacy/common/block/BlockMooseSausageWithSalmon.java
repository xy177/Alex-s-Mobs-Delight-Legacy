package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockMooseSausageWithSalmon extends BlockAMDFeast {
    private static final AxisAlignedBB SHAPE = new AxisAlignedBB(2.0D / 16.0D, 0.0D, 0.0D, 14.0D / 16.0D, 8.0D / 16.0D, 1.0D);

    public BlockMooseSausageWithSalmon() {
        super(3, "bowl_of_moose_sausage_with_salmon", new ItemStack(Items.BOWL), true, new ItemStack(Items.BOWL), SHAPE, SHAPE);
        setHardness(0.5F);
    }
}

package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockHoneyGlazedBearMeatWithSalmon extends BlockAMDFeast {
    private static final AxisAlignedBB SHAPE = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 6.0D / 16.0D, 15.0D / 16.0D);

    public BlockHoneyGlazedBearMeatWithSalmon() {
        super(4, "bowl_of_honey_glazed_bear_meat_with_salmon", new ItemStack(Items.BOWL), true, new ItemStack(Items.BOWL), SHAPE, SHAPE);
        setHardness(0.5F);
    }
}

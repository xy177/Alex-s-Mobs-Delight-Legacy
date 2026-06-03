package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockWildStew extends BlockAMDFeast {
    private static final AxisAlignedBB SHAPE = new AxisAlignedBB(3.0D / 16.0D, 0.0D, 3.0D / 16.0D, 13.0D / 16.0D, 12.0D / 16.0D, 13.0D / 16.0D);

    public BlockWildStew() {
        super(4, "bowl_of_wild_stew", new ItemStack(Items.BUCKET), true, new ItemStack(Items.BUCKET), SHAPE, SHAPE);
        setHardness(0.5F);
    }
}

package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockWhaleMeatStewedWithPork extends BlockAMDFeast {
    private static final AxisAlignedBB SHAPE = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 1.0D / 16.0D, 15.0D / 16.0D, 6.0D / 16.0D, 15.0D / 16.0D);

    public BlockWhaleMeatStewedWithPork() {
        super(4, "pot_of_whale_meat_stewed_with_pork", new ItemStack(Items.FLOWER_POT), true, new ItemStack(Items.FLOWER_POT), SHAPE, SHAPE);
        setHardness(0.5F);
    }
}

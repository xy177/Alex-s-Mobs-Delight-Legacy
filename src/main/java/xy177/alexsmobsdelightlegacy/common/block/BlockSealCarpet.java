package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.block.BlockCarpet;
import net.minecraft.block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class BlockSealCarpet extends BlockCarpet {
    public BlockSealCarpet(SoundType soundType) {
        super();
        setHardness(0.1F);
        setSoundType(soundType);
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(Item.getItemFromBlock(this)));
    }
}

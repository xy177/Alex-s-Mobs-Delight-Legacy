package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMantisShrimpAxe extends ItemAxe {
    public ItemMantisShrimpAxe(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.mantis_shrimp_tools");
        line.getStyle().setColor(TextFormatting.GOLD);
        tooltip.add(line.getFormattedText());
    }
}

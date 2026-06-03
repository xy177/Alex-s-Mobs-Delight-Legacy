package xy177.alexsmobsdelightlegacy.common.item;

import com.wdcftgg.farmersdelightlegacy.api.knife.ItemKnifeBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemCrocodileKnife extends ItemKnifeBase {
    public ItemCrocodileKnife(net.minecraft.item.Item.ToolMaterial material, double attackDamage) {
        super(material, attackDamage);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.crocodile_knife");
        line.getStyle().setColor(TextFormatting.GREEN);
        tooltip.add(line.getFormattedText());
    }
}

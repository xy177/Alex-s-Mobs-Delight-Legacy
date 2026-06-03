package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemWhaleToothPickaxe extends ItemPickaxe {
    public ItemWhaleToothPickaxe(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving.isInWater()) {
            entityLiving.addPotionEffect(new PotionEffect(MobEffects.HASTE, 40, 0, false, false));
        }
        return super.onEntitySwing(entityLiving, stack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.whale_tools");
        line.getStyle().setColor(TextFormatting.GOLD);
        tooltip.add(line.getFormattedText());
    }
}

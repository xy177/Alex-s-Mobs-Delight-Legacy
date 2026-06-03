package xy177.alexsmobsdelightlegacy.common.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemEnchantedSeagullFood extends AMDFoodItem {
    public static final String EFFECTS_TAG = "AmdConsumedFoodEffects";
    private final boolean eternal;
    private final boolean enchanted;

    public ItemEnchantedSeagullFood(boolean eternal, boolean enchanted) {
        super(3, 0.6F, true);
        this.eternal = eternal;
        this.enchanted = enchanted;
        if (eternal) {
            setMaxStackSize(1);
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return enchanted;
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        applyStoredEffects(stack, entityLiving);
        ItemStack copy = stack.copy();
        ItemStack result = super.onItemUseFinish(stack, worldIn, entityLiving);
        if (eternal) {
            if (entityLiving instanceof EntityPlayer) {
                ((EntityPlayer) entityLiving).getCooldownTracker().setCooldown(this, 1200);
            }
            copy.setCount(1);
            return copy;
        }
        return result;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        NBTTagList effects = getStoredEffects(stack);
        for (int i = 0; i < effects.tagCount(); i++) {
            PotionEffect effect = PotionEffect.readCustomPotionEffectFromNBT(effects.getCompoundTagAt(i));
            if (effect == null) {
                continue;
            }
            String durationText = Potion.getPotionDurationString(effect, 1.0F);
            String effectName = new TextComponentTranslation(effect.getEffectName()).getFormattedText();
            TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.effect_desc", effectName, durationText);
            line.getStyle().setColor(effect.getPotion().isBadEffect() ? TextFormatting.RED : TextFormatting.BLUE);
            tooltip.add(line.getFormattedText());
        }
    }

    public static NBTTagList getStoredEffects(ItemStack stack) {
        if (stack.hasTagCompound() && stack.getTagCompound().hasKey(EFFECTS_TAG, 9)) {
            return stack.getTagCompound().getTagList(EFFECTS_TAG, 10);
        }
        return new NBTTagList();
    }

    public static void writeStoredEffects(ItemStack stack, List<PotionEffect> effects) {
        if (effects == null || effects.isEmpty()) {
            return;
        }
        NBTTagList list = new NBTTagList();
        for (PotionEffect effect : effects) {
            list.appendTag(effect.writeCustomPotionEffectToNBT(new NBTTagCompound()));
        }
        stack.setTagInfo(EFFECTS_TAG, list);
    }

    private static void applyStoredEffects(ItemStack stack, EntityLivingBase entityLiving) {
        NBTTagList effects = getStoredEffects(stack);
        for (int i = 0; i < effects.tagCount(); i++) {
            PotionEffect effect = PotionEffect.readCustomPotionEffectFromNBT(effects.getCompoundTagAt(i));
            if (effect != null) {
                entityLiving.addPotionEffect(new PotionEffect(effect));
            }
        }
    }
}

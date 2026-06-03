package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;

public class ItemCrocodileScuteSword extends ItemSword {
    public ItemCrocodileScuteSword(ToolMaterial material) {
        super(material);
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        if (attacker.isInWater()) {
            attacker.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 100, 0, false, false));
        }
        return super.hitEntity(stack, target, attacker);
    }
}

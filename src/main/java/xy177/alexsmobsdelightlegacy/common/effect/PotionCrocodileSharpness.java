package xy177.alexsmobsdelightlegacy.common.effect;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEffects;

public class PotionCrocodileSharpness extends AMDPotion {
    public PotionCrocodileSharpness() {
        super("crocodile_sharpness", 0x676D4C);
    }

    @Override
    public void performEffect(EntityLivingBase entity, int amplifier) {
        if (entity.isPotionActive(AMDEffects.CROCODILE_CRUSH)
            && entity.isPotionActive(AMDEffects.CROCODILE_TOUGHNESS)
            && entity.isPotionActive(AMDEffects.CROCODILE_HACKSAW)) {
            entity.addPotionEffect(new PotionEffect(AMDEffects.CROCODILE_DEATH_ROLL, 1800, amplifier));
            entity.removePotionEffect(this);
        }
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return duration > 0;
    }
}

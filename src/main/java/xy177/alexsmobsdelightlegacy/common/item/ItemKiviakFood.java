package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class ItemKiviakFood extends AMDFoodItem {
    public ItemKiviakFood(int amount, float saturation, boolean wolfFood) {
        super(amount, saturation, wolfFood);
        setAlwaysEdible();
    }

    public SoundEvent getEatSound() {
        return SoundEvents.ENTITY_GENERIC_DRINK;
    }
}

package xy177.alexsmobsdelightlegacy.common.registry;

import net.minecraft.potion.Potion;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.registries.IForgeRegistry;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.effect.AMDPotion;
import xy177.alexsmobsdelightlegacy.common.effect.PotionCrystallizeWalker;
import xy177.alexsmobsdelightlegacy.common.effect.PotionCrocodileSharpness;
import xy177.alexsmobsdelightlegacy.common.effect.PotionSeagullAnorexia;

public final class AMDEffects {
    public static Potion SEAGULL_ANOREXIA;
    public static Potion CROCODILE_CRUSH;
    public static Potion CROCODILE_TOUGHNESS;
    public static Potion CROCODILE_SHARPNESS;
    public static Potion CROCODILE_HACKSAW;
    public static Potion CROCODILE_DEATH_ROLL;
    public static Potion CRYSTALLIZE_WALKER;
    public static Potion EXTENDED_TOUCH;

    private AMDEffects() {
    }

    public static void register(IForgeRegistry<Potion> registry) {
        SEAGULL_ANOREXIA = new PotionSeagullAnorexia();
        CROCODILE_CRUSH = new AMDPotion("crocodile_crush", 0x676D4C)
            .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_DAMAGE, "90185901-376B-4498-935B-2F7F79060635", 0.1D, 2);
        CROCODILE_TOUGHNESS = new AMDPotion("crocodile_toughness", 0x676D4C)
            .registerPotionAttributeModifier(SharedMonsterAttributes.ARMOR_TOUGHNESS, "90185901-1310-4498-935B-2F7F79060635", 0.2D, 2);
        CROCODILE_SHARPNESS = new PotionCrocodileSharpness();
        CROCODILE_HACKSAW = new AMDPotion("crocodile_hacksaw", 0x676D4C)
            .registerPotionAttributeModifier(SharedMonsterAttributes.ATTACK_SPEED, "90185901-3461-4498-935B-2F7F79060635", 0.15D, 2);
        CROCODILE_DEATH_ROLL = new AMDPotion("crocodile_death_roll", 0x676D4C);
        CRYSTALLIZE_WALKER = new PotionCrystallizeWalker();
        EXTENDED_TOUCH = new AMDPotion("extended_touch", 0xFFEF98)
            .registerPotionAttributeModifier(EntityPlayer.REACH_DISTANCE, "93018673-1364-4498-6341-634563113235", 1.0D, 0);

        register(registry, SEAGULL_ANOREXIA, "seagull_anorexia");
        register(registry, CROCODILE_CRUSH, "crocodile_crush");
        register(registry, CROCODILE_TOUGHNESS, "crocodile_toughness");
        register(registry, CROCODILE_SHARPNESS, "crocodile_sharpness");
        register(registry, CROCODILE_HACKSAW, "crocodile_hacksaw");
        register(registry, CROCODILE_DEATH_ROLL, "crocodile_death_roll");
        register(registry, CRYSTALLIZE_WALKER, "crystallize_walker");
        register(registry, EXTENDED_TOUCH, "extended_touch");
    }

    private static void register(IForgeRegistry<Potion> registry, Potion potion, String name) {
        potion.setRegistryName(AlexsMobsDelightLegacy.MODID, name);
        registry.register(potion);
    }
}

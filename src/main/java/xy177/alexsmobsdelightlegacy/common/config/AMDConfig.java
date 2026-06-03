package xy177.alexsmobsdelightlegacy.common.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public final class AMDConfig {
    public static int orcaGiftChance = 30;

    private AMDConfig() {
    }

    public static void load(File configDir) {
        Configuration config = new Configuration(new File(configDir, "alexsmobsdelightlegacy.cfg"));
        boolean changed = false;
        try {
            config.load();
            if (config.hasKey("test", "kiviakCompostingStagesPerRandomTick")) {
                config.getCategory("test").remove("kiviakCompostingStagesPerRandomTick");
                changed = true;
            }
            if (config.hasKey("test", "kiviakAlwaysCompostsOnRandomTick")) {
                config.getCategory("test").remove("kiviakAlwaysCompostsOnRandomTick");
                changed = true;
            }
            orcaGiftChance = config.getInt(
                "orcaGiftChance",
                "orcas_leap_soup",
                30,
                0,
                100,
                "Chance, in percent, to obtain Orca's Leap Soup after feeding an orca with seal meat."
            );
        } finally {
            if (changed || config.hasChanged()) {
                config.save();
            }
        }
    }
}

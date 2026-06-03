package xy177.alexsmobsdelightlegacy.common.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.ResourceLocation;
import com.github.alexthe666.alexsmobs.entity.EntityMantisShrimp;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

public final class AMDLootEvents {
    private AMDLootEvents() {
    }

    @Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
    public static class Handler {
        @SubscribeEvent
        public static void onLivingDrops(LivingDropsEvent event) {
            EntityLivingBase entity = event.getEntityLiving();
            if (entity.world.isRemote) {
                return;
            }
            ResourceLocation id = EntityList.getKey(entity);
            if (id == null) {
                return;
            }
            String key = id.toString();
            boolean burning = entity.isBurning();
            switch (key) {
                case "alexsmobs:grizzly_bear":
                    drop(event, burning ? AMDItems.COOKED_BEAR_MEAT : AMDItems.RAW_BEAR_MEAT, 1 + entity.getRNG().nextInt(3) + event.getLootingLevel());
                    break;
                case "minecraft:polar_bear":
                    drop(event, burning ? AMDItems.COOKED_BEAR_MEAT : AMDItems.RAW_BEAR_MEAT, 1 + entity.getRNG().nextInt(2) + event.getLootingLevel());
                    break;
                case "alexsmobs:bison":
                    drop(event, burning ? AMDItems.COOKED_BISON_MEAT : AMDItems.RAW_BISON_MEAT, 1 + entity.getRNG().nextInt(2));
                    break;
                case "alexsmobs:devils_hole_pupfish":
                    drop(event, burning ? AMDItems.COOKED_DEVILS_HOLE_PUPFISH : AMDItems.RAW_DEVILS_HOLE_PUPFISH, 1);
                    break;
                case "alexsmobs:seal":
                    drop(event, burning ? AMDItems.COOKED_SEAL_MEAT : AMDItems.SEAL_MEAT, 1 + entity.getRNG().nextInt(2));
                    drop(event, entity.getRNG().nextBoolean() ? AMDItems.SEAL_LEATHER_BROWN : AMDItems.SEAL_LEATHER_GRAY, 1);
                    break;
                case "alexsmobs:cachalot_whale":
                    drop(event, burning ? AMDItems.COOKED_WHALE_MEAT : AMDItems.WHALE_MEAT, 2 + entity.getRNG().nextInt(3));
                    break;
                case "alexsmobs:giant_squid":
                    break;
                case "alexsmobs:moose":
                    break;
                case "alexsmobs:mantis_shrimp":
                    int variant = entity instanceof EntityMantisShrimp ? ((EntityMantisShrimp) entity).getVariant() : entity.getRNG().nextInt(4);
                    drop(event, burning ? AMDItems.COOKED_MANTIS_SHRIMP_TAIL : pickShrimpTail(variant), 1 + randomLootBonus(entity, event.getLootingLevel()));
                    break;
                case "alexsmobs:lobster":
                    drop(event, AMDItems.LOBSTER_HEAD, 1);
                    break;
                case "alexsmobs:seagull":
                    drop(event, burning ? AMDItems.COOKED_SEAGULL : AMDItems.RAW_SEAGULL, 1 + event.getLootingLevel());
                    break;
                case "alexsmobs:tusklin":
                    drop(event, burning ? AMDItems.COOKED_TUSKLIN_MEAT : AMDItems.RAW_TUSKLIN_MEAT, 2 + entity.getRNG().nextInt(3) + event.getLootingLevel());
                    break;
                case "alexsmobs:mimic_octopus":
                    drop(event, burning ? AMDItems.COOKED_OCTOPUS_TENTACLE : AMDItems.MIMIC_OCTOPUS_TENTACLE, 1 + entity.getRNG().nextInt(3) + event.getLootingLevel());
                    break;
                case "alexsmobs:crocodile":
                    drop(event, burning ? AMDItems.COOKED_CROCODILE_MEAT : AMDItems.RAW_CROCODILE_MEAT, 1 + entity.getRNG().nextInt(4) + event.getLootingLevel());
                    break;
                default:
                    break;
            }
        }

        private static void drop(LivingDropsEvent event, net.minecraft.item.Item item, int count) {
            if (item == null || count <= 0) {
                return;
            }
            EntityItem entityItem = new EntityItem(event.getEntityLiving().world, event.getEntityLiving().posX, event.getEntityLiving().posY, event.getEntityLiving().posZ, new net.minecraft.item.ItemStack(item, count));
            event.getDrops().add(entityItem);
        }

        private static net.minecraft.item.Item pickShrimpTail(int idx) {
            switch (idx) {
                case 0:
                    return AMDItems.MANTIS_SHRIMP_TAIL_GREEN;
                case 1:
                    return AMDItems.MANTIS_SHRIMP_TAIL_RED;
                case 2:
                    return AMDItems.MANTIS_SHRIMP_TAIL_LIME;
                default:
                    return AMDItems.MANTIS_SHRIMP_TAIL_WHITE;
            }
        }

        private static int randomLootBonus(EntityLivingBase entity, int lootingLevel) {
            return lootingLevel <= 0 ? 0 : entity.getRNG().nextInt(lootingLevel + 1);
        }

    }
}

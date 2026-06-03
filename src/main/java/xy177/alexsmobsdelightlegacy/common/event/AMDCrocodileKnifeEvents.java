package xy177.alexsmobsdelightlegacy.common.event;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDCrocodileKnifeEvents {
    private AMDCrocodileKnifeEvents() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getSource().getTrueSource() instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) event.getSource().getTrueSource();
        ItemStack held = player.getHeldItemMainhand();
        if (held.isEmpty() || held.getItem() != AMDItems.CROCODILE_KNIFE) {
            return;
        }
        if (!(event.getEntityLiving() instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase target = event.getEntityLiving();
        float targetHealth = target.getMaxHealth();
        float playerHealth = player.getMaxHealth();
        float healthFactor = 2.0F;
        float chancePercent = 20.0F;
        if (healthFactor * 2.0F * playerHealth <= targetHealth) {
            player.sendStatusMessage(new TextComponentTranslation("message.alexsmobsdelightlegacy.crocodile_knife"), true);
            return;
        }
        float strength = Math.max(0.0F, Math.min(1.0F, ((healthFactor * 2.0F * playerHealth) - targetHealth) / (healthFactor * playerHealth)));
        if (strength < 1.0F) {
            player.sendStatusMessage(new TextComponentTranslation("message.alexsmobsdelightlegacy.crocodile_knife_1"), true);
        }

        if (!player.world.isRemote && player.getRNG().nextFloat() * 100.0F <= chancePercent * strength) {
            ItemStack drop = pickTargetDrop(target, player);
            if (!drop.isEmpty()) {
                EntityItem item = new EntityItem(player.world, target.posX, target.posY + 0.5D, target.posZ, drop);
                player.world.spawnEntity(item);
            }
        }
    }

    private static ItemStack pickTargetDrop(EntityLivingBase target, EntityPlayer player) {
        ResourceLocation id = net.minecraft.entity.EntityList.getKey(target);
        if (id != null) {
            String key = id.toString();
            switch (key) {
                case "alexsmobs:bison":
                    return new ItemStack(AMDItems.RAW_BISON_MEAT);
                case "alexsmobs:devils_hole_pupfish":
                    return new ItemStack(AMDItems.RAW_DEVILS_HOLE_PUPFISH);
                case "alexsmobs:seal":
                    return player.getRNG().nextBoolean() ? new ItemStack(AMDItems.SEAL_MEAT) : new ItemStack(player.getRNG().nextBoolean() ? AMDItems.SEAL_LEATHER_BROWN : AMDItems.SEAL_LEATHER_GRAY);
                case "alexsmobs:cachalot_whale":
                    return new ItemStack(AMDItems.WHALE_MEAT);
                case "alexsmobs:mantis_shrimp":
                    return new ItemStack(pickShrimpTail(player.getRNG().nextInt(4)));
                case "alexsmobs:lobster":
                    return new ItemStack(AMDItems.LOBSTER_HEAD);
                case "alexsmobs:crocodile":
                    return externalStack("alexsmobs:crocodile_scute");
                default:
                    break;
            }
        }
        return ItemStack.EMPTY;
    }

    private static ItemStack externalStack(String id) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(id));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    private static Item pickShrimpTail(int idx) {
        switch (idx) {
            case 0:
                return AMDItems.MANTIS_SHRIMP_TAIL_RED;
            case 1:
                return AMDItems.MANTIS_SHRIMP_TAIL_GREEN;
            case 2:
                return AMDItems.MANTIS_SHRIMP_TAIL_LIME;
            default:
                return AMDItems.MANTIS_SHRIMP_TAIL_WHITE;
        }
    }
}

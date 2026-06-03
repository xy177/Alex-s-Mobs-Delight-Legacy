package xy177.alexsmobsdelightlegacy.common.event;

import com.github.alexthe666.alexsmobs.entity.EntityOrca;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.config.AMDConfig;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDOrcaEvents {
    private AMDOrcaEvents() {
    }

    @SubscribeEvent
    public static void onEntityInteract(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getTarget() instanceof EntityOrca)) {
            return;
        }
        ItemStack stack = event.getItemStack();
        if (stack.isEmpty() || stack.getItem() != AMDItems.SEAL_MEAT) {
            return;
        }

        EntityOrca orca = (EntityOrca) event.getTarget();
        if (!orca.world.isRemote) {
            for (int i = 0; i < 30; i++) {
                double x = orca.posX + (orca.getRNG().nextDouble() - 0.5D) * orca.width;
                double y = orca.posY + orca.getRNG().nextDouble() * orca.height;
                double z = orca.posZ + (orca.getRNG().nextDouble() - 0.5D) * orca.width;
                orca.world.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, x, y, z, 0.0D, 0.0D, 0.0D);
            }
            orca.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 0.5F);
            if (orca.getRNG().nextInt(100) < AMDConfig.orcaGiftChance) {
                EntityItem gift = new EntityItem(orca.world, orca.posX, orca.posY + 0.5D, orca.posZ, new ItemStack(AMDItems.ORCAS_LEAP_SOUP));
                orca.world.spawnEntity(gift);
            }
            if (!event.getEntityPlayer().capabilities.isCreativeMode) {
                stack.shrink(1);
            }
        }
        event.setCanceled(true);
        event.setCancellationResult(EnumActionResult.SUCCESS);
    }
}

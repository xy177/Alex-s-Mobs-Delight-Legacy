package xy177.alexsmobsdelightlegacy.common.event;

import com.github.alexthe666.alexsmobs.misc.AMSoundRegistry;
import java.util.ListIterator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDMantisShrimpToolEvents {
    private AMDMantisShrimpToolEvents() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (!(event.getSource().getTrueSource() instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase attacker = (EntityLivingBase) event.getSource().getTrueSource();
        if (!isMantisShrimpTool(attacker.getHeldItemMainhand())) {
            return;
        }

        EntityLivingBase target = event.getEntityLiving();
        target.setFire(20);
        if (!target.world.isRemote) {
            target.world.playSound(null, target.posX, target.posY, target.posZ, AMSoundRegistry.MANTIS_SHRIMP_SNAP, SoundCategory.PLAYERS, 1.0F, 1.0F);
        }
    }

    @SubscribeEvent
    public static void onHarvestDrops(BlockEvent.HarvestDropsEvent event) {
        EntityPlayer player = event.getHarvester();
        if (player == null || player.world.isRemote || event.isSilkTouching() || !isMantisShrimpTool(player.getHeldItemMainhand())) {
            return;
        }

        ListIterator<ItemStack> iterator = event.getDrops().listIterator();
        while (iterator.hasNext()) {
            ItemStack drop = iterator.next();
            ItemStack smelted = FurnaceRecipes.instance().getSmeltingResult(drop);
            if (smelted.isEmpty()) {
                continue;
            }

            ItemStack replacement = smelted.copy();
            replacement.setCount(smelted.getCount() * drop.getCount());
            iterator.set(replacement);
        }
    }

    private static boolean isMantisShrimpTool(ItemStack stack) {
        if (stack.isEmpty()) {
            return false;
        }
        Item item = stack.getItem();
        return item == AMDItems.MANTIS_SHRIMP_SCYTHE
            || item == AMDItems.MANTIS_SHRIMP_HAMMER
            || item == AMDItems.MANTIS_SHRIMP_SHOVEL
            || item == AMDItems.MANTIS_SHRIMP_AXE;
    }
}

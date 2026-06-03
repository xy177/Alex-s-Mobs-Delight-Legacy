package xy177.alexsmobsdelightlegacy.common.event;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.alexthe666.alexsmobs.effect.AMEffectRegistry;
import com.github.alexthe666.alexsmobs.misc.AMSoundRegistry;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.network.AMDNetwork;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEffects;

@Mod.EventBusSubscriber(modid = AlexsMobsDelightLegacy.MODID)
public final class AMDCrocodileEffectEvents {
    private static final String DEATH_ROLL_TICKS = "AMDDeathRollTicks";
    private static final Set<Integer> INTERNAL_DEATH_ROLL_ATTACKS = new HashSet<>();

    private AMDCrocodileEffectEvents() {
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        Entity source = event.getSource().getTrueSource();
        if (!(source instanceof EntityLivingBase) || !(event.getEntityLiving() instanceof EntityLivingBase)) {
            return;
        }

        EntityLivingBase attacker = (EntityLivingBase) source;
        EntityLivingBase target = event.getEntityLiving();

        if (attacker.isPotionActive(AMDEffects.CROCODILE_SHARPNESS)) {
            int amplifier = attacker.getActivePotionEffect(AMDEffects.CROCODILE_SHARPNESS).getAmplifier();
            target.addPotionEffect(new PotionEffect(AMEffectRegistry.EXSANGUINATION, 100, amplifier));
        }

        if (attacker instanceof EntityPlayer
            && attacker.isPotionActive(AMDEffects.CROCODILE_DEATH_ROLL)
            && !INTERNAL_DEATH_ROLL_ATTACKS.contains(attacker.getEntityId())) {
            EntityPlayer player = (EntityPlayer) attacker;
            if (player.getFoodStats().getFoodLevel() > 0) {
                startDeathRoll(player);
            }
        }
    }

    @SubscribeEvent
    public static void onLivingUpdate(LivingUpdateEvent event) {
        if (!(event.getEntityLiving() instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
        NBTTagCompound data = player.getEntityData();
        int ticks = data.getInteger(DEATH_ROLL_TICKS);
        if (ticks <= 0) {
            return;
        }

        data.setInteger(DEATH_ROLL_TICKS, ticks - 1);
        player.hurtResistantTime = Math.max(player.hurtResistantTime, 20);

        if (player.world.isRemote) {
            return;
        }

        AxisAlignedBB box = player.getEntityBoundingBox().grow(0.75D);
        List<EntityLivingBase> targets = player.world.getEntitiesWithinAABB(EntityLivingBase.class, box, entity -> entity != player && entity.isEntityAlive());
        if (targets.isEmpty()) {
            return;
        }

        EntityLivingBase target = targets.get(0);
        target.motionX = 0.0D;
        target.motionY = Math.min(0.0D, target.motionY);
        target.motionZ = 0.0D;
        target.velocityChanged = true;

        if (ticks % 5 == 0 && player.getFoodStats().getFoodLevel() > 6) {
            int id = player.getEntityId();
            INTERNAL_DEATH_ROLL_ATTACKS.add(id);
            try {
                player.attackTargetEntityWithCurrentItem(target);
                player.getFoodStats().addExhaustion(0.1F);
            } finally {
                INTERNAL_DEATH_ROLL_ATTACKS.remove(id);
            }
        }
    }

    private static void startDeathRoll(EntityPlayer player) {
        player.getEntityData().setInteger(DEATH_ROLL_TICKS, 20);
        player.getFoodStats().setFoodLevel(Math.max(0, player.getFoodStats().getFoodLevel() - 1));
        player.getFoodStats().addExhaustion(0.1F);
        if (!player.world.isRemote) {
            player.world.playSound(null, player.posX, player.posY, player.posZ, AMSoundRegistry.CROCODILE_BITE, SoundCategory.PLAYERS, 1.0F, 1.0F);
            if (player instanceof EntityPlayerMP) {
                AMDNetwork.sendDeathRollAnimation((EntityPlayerMP) player);
            }
        }
    }
}

package xy177.alexsmobsdelightlegacy.common.item;

import java.util.List;
import javax.annotation.Nullable;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownBanana;

public class ItemBananaBow extends ItemBow {
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (!(entityLiving instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        ItemStack ammo = findAmmo(player);
        boolean infinite = player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
        if (ammo.isEmpty() && !infinite) {
            return;
        }
        int used = getMaxItemUseDuration(stack) - timeLeft;
        used = ForgeEventFactory.onArrowLoose(stack, worldIn, player, used, !ammo.isEmpty() || infinite);
        if (used < 0) {
            return;
        }
        float velocity = ItemBow.getArrowVelocity(used);
        if (velocity < 0.1F) {
            return;
        }
        if (!worldIn.isRemote) {
            EntityThrownBanana banana = new EntityThrownBanana(worldIn, player);
            banana.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, velocity * 1.5F, 1.0F);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                banana.setFire(100);
            }
            worldIn.spawnEntity(banana);
        }
        worldIn.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, player.getSoundCategory(), 1.0F, 1.0F / (worldIn.rand.nextFloat() * 0.4F + 1.2F) + velocity * 0.5F);
        if (!infinite && !ammo.isEmpty()) {
            ammo.shrink(1);
        }
        stack.damageItem(1, player);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        boolean hasAmmo = !findAmmo(playerIn).isEmpty();
        boolean infinite = playerIn.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, itemstack) > 0;
        ActionResult<ItemStack> ret = ForgeEventFactory.onArrowNock(itemstack, worldIn, playerIn, handIn, hasAmmo || infinite);
        if (ret != null) {
            return ret;
        }
        if (!infinite && !hasAmmo) {
            return new ActionResult<>(EnumActionResult.FAIL, itemstack);
        }
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, itemstack);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.BOW;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.banana_bow");
        line.getStyle().setColor(TextFormatting.GOLD);
        tooltip.add(line.getFormattedText());
    }

    protected ItemStack findAmmo(EntityPlayer player) {
        for (ItemStack stack : player.inventory.mainInventory) {
            if (!stack.isEmpty() && stack.getItem() == AMItemRegistry.BANANA) {
                return stack;
            }
        }
        ItemStack offhand = player.getHeldItemOffhand();
        if (!offhand.isEmpty() && offhand.getItem() == AMItemRegistry.BANANA) {
            return offhand;
        }
        return ItemStack.EMPTY;
    }
}

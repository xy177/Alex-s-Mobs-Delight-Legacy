package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import xy177.alexsmobsdelightlegacy.common.entity.EntityThrownLobsterDart;

public class ItemLobsterDart extends Item {
    public ItemLobsterDart() {
        setMaxStackSize(1);
        setMaxDamage(64);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (!(entityLiving instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        int used = getMaxItemUseDuration(stack) - timeLeft;
        if (used < 5 || stack.getItemDamage() >= stack.getMaxDamage() - 1) {
            return;
        }
        if (!worldIn.isRemote) {
            ItemStack thrownStack = stack.copy();
            thrownStack.setCount(1);
            thrownStack.damageItem(1, player);
            EntityThrownLobsterDart dart = new EntityThrownLobsterDart(worldIn, player, thrownStack).setCreative(player.capabilities.isCreativeMode);
            dart.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.5F, 1.2F);
            worldIn.spawnEntity(dart);
            if (!player.capabilities.isCreativeMode) {
                stack.shrink(1);
            }
        }
        worldIn.playSound(null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_ARROW_SHOOT, player.getSoundCategory(), 1.0F, 1.0F);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        ItemStack stack = playerIn.getHeldItem(handIn);
        if (stack.getItemDamage() >= stack.getMaxDamage() - 1) {
            return new ActionResult<>(EnumActionResult.FAIL, stack);
        }
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, stack);
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
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
        stack.damageItem(1, attacker);
        return true;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, net.minecraft.block.state.IBlockState state, net.minecraft.util.math.BlockPos pos, EntityLivingBase entityLiving) {
        if (state.getBlockHardness(worldIn, pos) != 0.0F) {
            stack.damageItem(2, entityLiving);
        }
        return true;
    }

    @Override
    public com.google.common.collect.Multimap<String, net.minecraft.entity.ai.attributes.AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {
        com.google.common.collect.Multimap<String, net.minecraft.entity.ai.attributes.AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);
        if (slot == EntityEquipmentSlot.MAINHAND) {
            com.google.common.collect.HashMultimap<String, net.minecraft.entity.ai.attributes.AttributeModifier> copy = com.google.common.collect.HashMultimap.create(modifiers);
            copy.put(net.minecraft.entity.SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new net.minecraft.entity.ai.attributes.AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Tool modifier", 5.0D, 0));
            copy.put(net.minecraft.entity.SharedMonsterAttributes.ATTACK_SPEED.getName(), new net.minecraft.entity.ai.attributes.AttributeModifier(ATTACK_SPEED_MODIFIER, "Tool modifier", -3.0D, 0));
            return copy;
        }
        return modifiers;
    }
}

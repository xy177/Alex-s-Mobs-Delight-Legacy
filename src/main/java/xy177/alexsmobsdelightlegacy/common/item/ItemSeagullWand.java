package xy177.alexsmobsdelightlegacy.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSeagullWand extends ItemHoe {
    public ItemSeagullWand(ToolMaterial material) {
        super(material);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
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
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
        if (!(entityLiving instanceof EntityPlayer) || worldIn.isRemote) {
            return;
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        int used = getMaxItemUseDuration(stack) - timeLeft;
        if (used <= 20) {
            return;
        }

        AxisAlignedBB box = player.getEntityBoundingBox().offset(player.getLookVec()).grow(1.0D);
        List<Entity> hits = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
        for (Entity hit : hits) {
            if (hit instanceof EntityPlayer) {
                EntityPlayer target = (EntityPlayer) hit;
                for (ItemStack inv : target.inventory.mainInventory) {
                    if (!inv.isEmpty() && inv.getItem() instanceof net.minecraft.item.ItemFood) {
                        ItemStack copy = inv.copy();
                        copy.setCount(1);
                        inv.shrink(1);
                        if (!player.inventory.addItemStackToInventory(copy)) {
                            player.dropItem(copy, false);
                        }
                        return;
                    }
                }
            } else if (hit instanceof EntityLivingBase) {
                EntityLivingBase living = (EntityLivingBase) hit;
                ItemStack main = living.getHeldItemMainhand();
                if (!main.isEmpty() && main.getItem() instanceof net.minecraft.item.ItemFood) {
                    ItemStack copy = main.copy();
                    copy.setCount(1);
                    main.shrink(1);
                    if (!player.inventory.addItemStackToInventory(copy)) {
                        player.dropItem(copy, false);
                    }
                    return;
                }
            }
        }
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.seagull_wand");
        line.getStyle().setColor(TextFormatting.GOLD);
        tooltip.add(line.getFormattedText());
    }
}

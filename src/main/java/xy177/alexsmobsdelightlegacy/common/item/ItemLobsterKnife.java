package xy177.alexsmobsdelightlegacy.common.item;

import com.wdcftgg.farmersdelightlegacy.api.knife.ItemKnifeBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemLobsterKnife extends ItemKnifeBase {
    public ItemLobsterKnife(net.minecraft.item.Item.ToolMaterial material, double attackDamage) {
        super(material, attackDamage);
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
        if (!(entityLiving instanceof EntityPlayer)) {
            return;
        }
        EntityPlayer player = (EntityPlayer) entityLiving;
        int used = getMaxItemUseDuration(stack) - timeLeft;
        if (used <= 20) {
            return;
        }
        if (!worldIn.isRemote) {
            player.addVelocity(player.getLookVec().x * 1.2D, player.getLookVec().y * 0.2D, player.getLookVec().z * 1.2D);
            player.velocityChanged = true;
            AxisAlignedBB box = player.getEntityBoundingBox().expand(player.getLookVec().x, player.getLookVec().y, player.getLookVec().z).grow(0.5D);
            List<Entity> hits = worldIn.getEntitiesWithinAABBExcludingEntity(player, box);
            for (Entity hit : hits) {
                if (hit instanceof EntityLivingBase) {
                    hit.attackEntityFrom(net.minecraft.util.DamageSource.causePlayerDamage(player), 4.0F);
                    player.motionY = 1.0D;
                    player.velocityChanged = true;
                    break;
                }
            }
        }
        player.getCooldownTracker().setCooldown(this, 10);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        TextComponentTranslation line = new TextComponentTranslation("tooltip.alexsmobsdelightlegacy.lobster_knife");
        line.getStyle().setColor(TextFormatting.GREEN);
        tooltip.add(line.getFormattedText());
    }
}

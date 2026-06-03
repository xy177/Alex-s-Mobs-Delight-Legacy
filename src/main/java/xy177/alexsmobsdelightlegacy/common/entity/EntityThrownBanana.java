package xy177.alexsmobsdelightlegacy.common.entity;

import com.github.alexthe666.alexsmobs.block.AMBlockRegistry;
import com.github.alexthe666.alexsmobs.item.AMItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownBanana extends EntityThrowable {
    public EntityThrownBanana(World world) {
        super(world);
    }

    public EntityThrownBanana(World world, EntityLivingBase thrower) {
        super(world, thrower);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            if (result.entityHit instanceof EntityLivingBase) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 2.0F);
                ((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(MobEffects.SPEED, 20, 60));
                maybePlaceBananaPeel(result.entityHit.getPosition());
            } else if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
                maybePlaceBananaPeel(result.getBlockPos().offset(result.sideHit));
            }
            world.setEntityState(this, (byte) 3);
            setDead();
        }
    }

    private void maybePlaceBananaPeel(BlockPos pos) {
        if (rand.nextInt(8) != 0) {
            return;
        }
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock().isReplaceable(world, pos)) {
            world.setBlockState(pos, AMBlockRegistry.BANANA_PEEL.getDefaultState(), 3);
        }
    }

    @Override
    public void handleStatusUpdate(byte id) {
        if (id != 3) {
            super.handleStatusUpdate(id);
            return;
        }
        Item item = AMItemRegistry.BANANA;
        for (int i = 0; i < 8; ++i) {
            world.spawnParticle(
                EnumParticleTypes.ITEM_CRACK,
                posX,
                posY,
                posZ,
                (rand.nextFloat() - 0.5D) * 0.08D,
                (rand.nextFloat() - 0.5D) * 0.08D,
                (rand.nextFloat() - 0.5D) * 0.08D,
                Item.getIdFromItem(item),
                0
            );
        }
    }

    @Override
    protected float getGravityVelocity() {
        return 0.03F;
    }

    public ItemStack getRenderStack() {
        return new ItemStack(AMItemRegistry.BANANA);
    }
}

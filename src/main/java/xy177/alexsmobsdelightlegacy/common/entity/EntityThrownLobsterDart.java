package xy177.alexsmobsdelightlegacy.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;

public class EntityThrownLobsterDart extends EntityThrowable {
    private ItemStack dartStack = ItemStack.EMPTY;
    private boolean creative;

    public EntityThrownLobsterDart(World world) {
        super(world);
    }

    public EntityThrownLobsterDart(World world, EntityLivingBase thrower, ItemStack stack) {
        super(world, thrower);
        dartStack = stack.copy();
        dartStack.setCount(1);
    }

    public EntityThrownLobsterDart setCreative(boolean creative) {
        this.creative = creative;
        return this;
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            if (result.entityHit instanceof EntityLivingBase) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, getThrower()), 6.0F);
                motionX *= -0.01D;
                motionY *= -0.1D;
                motionZ *= -0.01D;
            }
            dropDart();
            setDead();
        }
    }

    private void dropDart() {
        if (creative) {
            return;
        }
        ItemStack stack = dartStack.isEmpty() ? new ItemStack(AMDItems.LOBSTER_DART) : dartStack.copy();
        EntityItem item = new EntityItem(world, posX, posY, posZ, stack);
        item.setDefaultPickupDelay();
        world.spawnEntity(item);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        if (!dartStack.isEmpty()) {
            compound.setTag("Dart", dartStack.writeToNBT(new NBTTagCompound()));
        }
        compound.setBoolean("Creative", creative);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        if (compound.hasKey("Dart", 10)) {
            dartStack = new ItemStack(compound.getCompoundTag("Dart"));
        }
        creative = compound.getBoolean("Creative");
    }

    @Override
    protected float getGravityVelocity() {
        return 0.05F;
    }

    public ItemStack getRenderStack() {
        return dartStack.isEmpty() ? new ItemStack(AMDItems.LOBSTER_DART) : dartStack.copy();
    }
}

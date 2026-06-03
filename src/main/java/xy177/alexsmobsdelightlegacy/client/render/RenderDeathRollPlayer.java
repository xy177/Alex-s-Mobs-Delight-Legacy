package xy177.alexsmobsdelightlegacy.client.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;

public class RenderDeathRollPlayer extends RenderPlayer {
    private static final float SPIN_SPEED = 50.0F;
    private static final double DEATH_ROLL_Y_OFFSET = 1.0D;

    public RenderDeathRollPlayer(RenderManager renderManager, boolean useSmallArms) {
        super(renderManager, useSmallArms);
        addLayer(new LayerDeathRollAnim(this));
    }

    @Override
    protected void renderLivingAt(AbstractClientPlayer player, double x, double y, double z) {
        if (DeathRollAnimationTracker.isActive(player.getEntityId())) {
            y += DEATH_ROLL_Y_OFFSET;
        }
        super.renderLivingAt(player, x, y, z);
    }

    @Override
    protected void applyRotations(AbstractClientPlayer player, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(player, ageInTicks, rotationYaw, partialTicks);
        if (!DeathRollAnimationTracker.isActive(player.getEntityId())) {
            return;
        }

        GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate((player.ticksExisted + partialTicks) * -SPIN_SPEED, 0.0F, 1.0F, 0.0F);
    }
}

package xy177.alexsmobsdelightlegacy.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.client.model.ModelDeathRollAnim;
import xy177.alexsmobsdelightlegacy.common.registry.AMDEffects;

public class LayerDeathRollAnim implements LayerRenderer<EntityLivingBase> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(AlexsMobsDelightLegacy.MODID, "textures/entities/riptide_anim.png");

    private final RenderLivingBase<?> renderer;
    private final ModelDeathRollAnim model = new ModelDeathRollAnim();

    public LayerDeathRollAnim(RenderLivingBase<?> renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!entity.isPotionActive(AMDEffects.CROCODILE_DEATH_ROLL) || !DeathRollAnimationTracker.isActive(entity.getEntityId())) {
            return;
        }
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
        renderer.bindTexture(TEXTURE);
        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, 0.0F, 0.125F);
        model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        model.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}

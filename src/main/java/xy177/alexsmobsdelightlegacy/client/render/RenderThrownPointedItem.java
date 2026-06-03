package xy177.alexsmobsdelightlegacy.client.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import java.util.function.Function;

public class RenderThrownPointedItem<T extends Entity> extends Render<T> {
    private final RenderItem itemRenderer;
    private final Function<T, ItemStack> stackGetter;
    private final float zRotation;

    public RenderThrownPointedItem(RenderManager renderManager, Function<T, ItemStack> stackGetter, float zRotation) {
        super(renderManager);
        this.itemRenderer = net.minecraft.client.Minecraft.getMinecraft().getRenderItem();
        this.stackGetter = stackGetter;
        this.zRotation = zRotation;
    }

    @Override
    public void doRender(T entity, double x, double y, double z, float entityYaw, float partialTicks) {
        if (entity.ticksExisted < 2 && renderManager.renderViewEntity.getDistanceSq(entity) < 12.25D) {
            return;
        }

        GlStateManager.pushMatrix();
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.rotate(lerp(partialTicks, entity.prevRotationYaw, entity.rotationYaw) - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(lerp(partialTicks, entity.prevRotationPitch, entity.rotationPitch) + zRotation, 0.0F, 0.0F, 1.0F);
        GlStateManager.translate(0.0F, -0.2F, 0.0F);

        GlStateManager.enableRescaleNormal();
        bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
        itemRenderer.renderItem(stackGetter.apply(entity), ItemCameraTransforms.TransformType.GROUND);
        GlStateManager.disableRescaleNormal();

        GlStateManager.popMatrix();

        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }

    private static float lerp(float partialTicks, float start, float end) {
        return start + partialTicks * (end - start);
    }
}

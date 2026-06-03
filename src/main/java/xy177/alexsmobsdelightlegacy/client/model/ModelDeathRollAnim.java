package xy177.alexsmobsdelightlegacy.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelDeathRollAnim extends ModelBase {
    private final ModelRenderer spin;
    private final ModelRenderer spin1;
    private final ModelRenderer spin2;

    public ModelDeathRollAnim() {
        textureWidth = 128;
        textureHeight = 128;

        spin = new ModelRenderer(this);
        spin.setRotationPoint(0.0F, 24.0F, -3.0F);

        spin1 = new ModelRenderer(this);
        spin1.setRotationPoint(0.0F, 0.0F, 0.0F);
        spin.addChild(spin1);
        spin1.cubeList.add(new ModelBox(spin1, 0, 0, -9.0F, -33.0F, -9.0F, 18, 50, 18, 0.0F, false));

        spin2 = new ModelRenderer(this);
        spin2.setRotationPoint(0.0F, -5.0F, 0.0F);
        spin.addChild(spin2);
        setRotationAngle(spin2, 0.0F, 1.5708F, 0.0F);
        spin2.cubeList.add(new ModelBox(spin2, 0, 0, -9.0F, -34.25F, -9.0F, 18, 50, 18, -2.0F, false));
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.disableLighting();
        GlStateManager.disableCull();
        if (entity instanceof EntityLivingBase && ((EntityLivingBase) entity).isChild()) {
            GlStateManager.pushMatrix();
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
            GlStateManager.translate(0.0F, 1.2F, -0.1F);
            spin.render(scale);
            GlStateManager.popMatrix();
        } else {
            spin.render(scale);
        }
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float rotation = ageInTicks * (float) Math.PI;
        spin1.rotateAngleY = rotation * 0.1F;
        spin2.rotateAngleY = rotation * 0.05F;
    }

    private void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

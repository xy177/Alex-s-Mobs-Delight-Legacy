package xy177.alexsmobsdelightlegacy.common.effect;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;

public class AMDIconPotion extends Potion {
    private final String iconName;

    public AMDIconPotion(String name, int color) {
        super(false, color);
        this.iconName = name;
        setPotionName("effect.alexsmobsdelightlegacy." + name);
    }

    @Override
    public boolean hasStatusIcon() {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderInventoryEffect(PotionEffect effect, Gui gui, int x, int y, float z) {
        drawIcon(gui, x + 6, y + 7, 1.0F);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void renderHUDEffect(PotionEffect effect, Gui gui, int x, int y, float z, float alpha) {
        drawIcon(gui, x + 3, y + 3, alpha);
    }

    @SideOnly(Side.CLIENT)
    private void drawIcon(Gui gui, int x, int y, float alpha) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(
            new ResourceLocation(AlexsMobsDelightLegacy.MODID, "textures/mob_effect/" + iconName + ".png")
        );
        GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
        Gui.drawModalRectWithCustomSizedTexture(x, y, 0.0F, 0.0F, 18, 18, 18.0F, 18.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }
}

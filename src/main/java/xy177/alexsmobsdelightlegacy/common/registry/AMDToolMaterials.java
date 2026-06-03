package xy177.alexsmobsdelightlegacy.common.registry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.common.util.EnumHelper;

public final class AMDToolMaterials {
    public static final ItemTool.ToolMaterial CROCODILE = EnumHelper.addToolMaterial("AMD_CROCODILE", 2, 250, 8.0F, 3.0F, 10);
    public static final ItemTool.ToolMaterial CROCODILE_SCUTE = EnumHelper.addToolMaterial("AMD_CROCODILE_SCUTE", 2, 250, 8.0F, 3.0F, 10);
    public static final ItemTool.ToolMaterial SHRIMP = EnumHelper.addToolMaterial("AMD_SHRIMP", 3, 300, 12.0F, 3.0F, 5);
    public static final ItemTool.ToolMaterial WHALE_TOOTH = EnumHelper.addToolMaterial("AMD_WHALE_TOOTH", 2, 400, 7.5F, 2.0F, 5);

    private AMDToolMaterials() {
    }

    public static void initRepairItems() {
        CROCODILE.setRepairItem(new ItemStack(AMDItems.CROCODILE_TOOTH));
        CROCODILE_SCUTE.setRepairItem(new ItemStack(net.minecraftforge.fml.common.registry.ForgeRegistries.ITEMS.getValue(new net.minecraft.util.ResourceLocation("alexsmobs", "crocodile_scute"))));
        SHRIMP.setRepairItem(new ItemStack(AMDItems.LOBSTER_HEAD));
    }
}

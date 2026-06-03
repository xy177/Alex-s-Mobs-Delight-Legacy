package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import com.wdcftgg.farmersdelightlegacy.common.registry.ModSounds;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import xy177.alexsmobsdelightlegacy.AlexsMobsDelightLegacy;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntityAMDLargeFeast;

public class BlockAMDLargeFeast extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyInteger SERVINGS = PropertyInteger.create("servings", 0, 7);

    private final int maxServings;
    private final String servingItemPath;
    private final ItemStack requiredContainer;
    private final ItemStack partialDrop;
    private final AxisAlignedBB fullShape;
    private final AxisAlignedBB leftoverShape;

    public BlockAMDLargeFeast(int maxServings, String servingItemPath, ItemStack requiredContainer,
                              ItemStack partialDrop, AxisAlignedBB fullShape, AxisAlignedBB leftoverShape) {
        super(Material.CAKE);
        this.maxServings = maxServings;
        this.servingItemPath = servingItemPath;
        this.requiredContainer = requiredContainer.copy();
        this.partialDrop = partialDrop == null ? ItemStack.EMPTY : partialDrop.copy();
        this.fullShape = fullShape;
        this.leftoverShape = leftoverShape == null ? fullShape : leftoverShape;
        setHardness(0.5F);
        setSoundType(SoundType.WOOD);
        setDefaultState(blockState.getBaseState()
            .withProperty(FACING, EnumFacing.NORTH)
            .withProperty(SERVINGS, maxServings));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityAMDLargeFeast();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY,
                                            float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        setServings(worldIn, pos, maxServings);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (hand != EnumHand.MAIN_HAND) {
            return true;
        }

        int servings = getServings(worldIn, pos);
        if (servings <= 0) {
            if (!worldIn.isRemote) {
                worldIn.setBlockToAir(pos);
                spawnPartialDrop(worldIn, pos);
            }
            return true;
        }

        ItemStack held = player.getHeldItem(hand);
        if (!isRequiredContainer(held)) {
            if (!worldIn.isRemote) {
                player.sendStatusMessage(new TextComponentTranslation(
                    "farmersdelight.block.feast.use_container",
                    requiredContainer.getDisplayName()), true);
            }
            return true;
        }

        if (!worldIn.isRemote) {
            if (shouldConsumeHeldContainer(held) && !player.capabilities.isCreativeMode) {
                held.shrink(1);
            }
            ItemStack serving = getServingStack(servings);
            if (!serving.isEmpty() && !player.inventory.addItemStackToInventory(serving.copy())) {
                player.dropItem(serving.copy(), false);
            }
            setServings(worldIn, pos, servings - 1);
            worldIn.playSound(null, pos, ModSounds.foodTakePortion, SoundCategory.BLOCKS, 0.8F, 0.8F);
        }
        return true;
    }

    private boolean isRequiredContainer(ItemStack held) {
        if (requiredContainer.isEmpty()) {
            return true;
        }
        return !held.isEmpty() && ItemStack.areItemsEqual(held, requiredContainer)
            && (!requiredContainer.getItem().getHasSubtypes() || held.getMetadata() == requiredContainer.getMetadata());
    }

    private boolean shouldConsumeHeldContainer(ItemStack held) {
        return !requiredContainer.isEmpty() && !held.isEmpty();
    }

    protected ItemStack getServingStack(int servings) {
        Item item = ForgeRegistries.ITEMS.getValue(new net.minecraft.util.ResourceLocation(
            AlexsMobsDelightLegacy.MODID, servingItemPath));
        return item == null ? ItemStack.EMPTY : new ItemStack(item);
    }

    private int getServings(IBlockAccess worldIn, BlockPos pos) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof TileEntityAMDLargeFeast) {
            return clampServings(((TileEntityAMDLargeFeast) tile).getServings());
        }
        IBlockState state = worldIn.getBlockState(pos);
        return state.getBlock() == this ? clampServings(state.getValue(SERVINGS)) : maxServings;
    }

    private void setServings(World worldIn, BlockPos pos, int servings) {
        int clamped = clampServings(servings);
        IBlockState state = worldIn.getBlockState(pos);
        if (state.getBlock() == this) {
            worldIn.setBlockState(pos, state.withProperty(SERVINGS, clamped), 3);
        }
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof TileEntityAMDLargeFeast) {
            ((TileEntityAMDLargeFeast) tile).setServings(clamped);
        }
    }

    private int clampServings(int servings) {
        return Math.max(0, Math.min(maxServings, servings));
    }

    private void spawnPartialDrop(World worldIn, BlockPos pos) {
        if (!partialDrop.isEmpty()) {
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D, partialDrop.copy()));
        }
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(SERVINGS, getServings(worldIn, pos));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState()
            .withProperty(FACING, EnumFacing.getHorizontal(meta & 3))
            .withProperty(SERVINGS, maxServings);
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
        int servings = getServings(worldIn, pos);
        if (servings == maxServings) {
            Item item = Item.getItemFromBlock(this);
            if (item != Items.AIR) {
                drops.add(new ItemStack(item));
            }
        } else if (!partialDrop.isEmpty()) {
            drops.add(partialDrop.copy());
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return state.getValue(SERVINGS) == 0 ? leftoverShape : fullShape;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
        return getServings(worldIn, pos);
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, SERVINGS);
    }
}

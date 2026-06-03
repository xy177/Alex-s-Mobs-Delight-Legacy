package xy177.alexsmobsdelightlegacy.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.util.SoundCategory;
import net.minecraft.init.SoundEvents;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntitySteamedStuffedCrocodile;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockSteamedStuffedCrocodile extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyEnum<Part> PART = PropertyEnum.create("part", Part.class);
    public static final PropertyInteger SERVINGS = PropertyInteger.create("servings", 0, 17);

    private static final AxisAlignedBB SHAPE_FRONT = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.375D, 1.0D);
    private static final AxisAlignedBB SHAPE_MIDDLE = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D);
    private static final AxisAlignedBB SHAPE_BACK = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5625D, 1.0D);

    public BlockSteamedStuffedCrocodile() {
        super(Material.CAKE);
        setHardness(0.8F);
        setResistance(1.0F);
        setDefaultState(blockState.getBaseState()
            .withProperty(FACING, EnumFacing.NORTH)
            .withProperty(PART, Part.FRONT)
            .withProperty(SERVINGS, 17));
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntitySteamedStuffedCrocodile();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (worldIn.isRemote) {
            return true;
        }
        BlockPos front = getFrontPos(pos, state);
        IBlockState frontState = worldIn.getBlockState(front);
        if (frontState.getBlock() != this) {
            return true;
        }

        int servings = getServings(worldIn, front);
        ItemStack held = player.getHeldItem(hand);

        if (servings > 0) {
            ItemStack serving = getServingStack(servings);
            ItemStack container = getContainerStack(serving);
            boolean needsContainer = !container.isEmpty();
            if (needsContainer && (held.isEmpty() || held.getItem() != container.getItem())) {
                player.sendStatusMessage(new TextComponentTranslation("farmersdelight.block.feast.use_container", container.getDisplayName()), true);
                return true;
            }
            if (needsContainer && !player.capabilities.isCreativeMode) {
                held.shrink(1);
            }
            if (!player.inventory.addItemStackToInventory(serving.copy())) {
                player.dropItem(serving.copy(), false);
            }
            setServings(worldIn, front, servings - 1);
            worldIn.playSound(null, front, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.BLOCKS, 1.0F, 1.0F);
            return true;
        }

        if (servings == 0) {
            dropLeftovers(worldIn, front);
            clearStructure(worldIn, front, frontState);
            worldIn.playSound(null, front, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.PLAYERS, 0.8F, 0.8F);
            return true;
        }

        return true;
    }

    private ItemStack getServingStack(int servings) {
        if (servings == 17) return new ItemStack(AMDItems.CROCODILE_TOOTH, 4);
        if (servings == 16) return new ItemStack(AMDItems.BOWL_OF_STUFFED_CROCODILE_HEAD);
        if (servings >= 14) return new ItemStack(AMDItems.BOWL_OF_STUFFED_CROCODILE_TAIL);
        if (servings >= 10) return new ItemStack(AMDItems.BOWL_OF_STUFFED_CROCODILE_LEG);
        return new ItemStack(AMDItems.BOWL_OF_STUFFED_CROCODILE);
    }

    private ItemStack getContainerStack(ItemStack serving) {
        Item item = serving.getItem();
        if (item == AMDItems.BOWL_OF_STUFFED_CROCODILE_HEAD || item == AMDItems.BOWL_OF_STUFFED_CROCODILE_TAIL || item == AMDItems.BOWL_OF_STUFFED_CROCODILE_LEG || item == AMDItems.BOWL_OF_STUFFED_CROCODILE) {
            return new ItemStack(Items.BOWL);
        }
        return ItemStack.EMPTY;
    }

    private void dropLeftovers(World worldIn, BlockPos front) {
        spawnItem(worldIn, front, new ItemStack(AMDItems.CROCODILE_RICE, 1 + worldIn.rand.nextInt(3)));
        spawnItem(worldIn, front, new ItemStack(Items.BOAT));
    }

    private void spawnItem(World worldIn, BlockPos pos, ItemStack stack) {
        if (!stack.isEmpty()) {
            worldIn.spawnEntity(new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.2D, pos.getZ() + 0.5D, stack));
        }
    }

    private void clearStructure(World worldIn, BlockPos front, IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        for (int i = 0; i < 3; i++) {
            BlockPos partPos = front.offset(facing, i);
            if (worldIn.getBlockState(partPos).getBlock() == this) {
                worldIn.setBlockToAir(partPos);
            }
        }
    }

    private int getServings(IBlockAccess worldIn, BlockPos pos) {
        TileEntity tile = worldIn.getTileEntity(pos);
        return tile instanceof TileEntitySteamedStuffedCrocodile ? ((TileEntitySteamedStuffedCrocodile) tile).getServings() : 17;
    }

    private void setServings(World worldIn, BlockPos front, int servings) {
        IBlockState frontState = worldIn.getBlockState(front);
        EnumFacing facing = frontState.getValue(FACING);
        int clamped = Math.max(0, Math.min(17, servings));
        for (int i = 0; i < 3; i++) {
            BlockPos partPos = front.offset(facing, i);
            if (worldIn.getBlockState(partPos).getBlock() == this) {
                TileEntity tile = worldIn.getTileEntity(partPos);
                if (tile instanceof TileEntitySteamedStuffedCrocodile) {
                    ((TileEntitySteamedStuffedCrocodile) tile).setServings(clamped);
                }
                IBlockState state = worldIn.getBlockState(partPos);
                IBlockState updated = state.withProperty(SERVINGS, clamped);
                worldIn.setBlockState(partPos, updated, 3);
                TileEntity updatedTile = worldIn.getTileEntity(partPos);
                if (updatedTile instanceof TileEntitySteamedStuffedCrocodile) {
                    ((TileEntitySteamedStuffedCrocodile) updatedTile).setServings(clamped);
                }
                worldIn.notifyBlockUpdate(partPos, state, updated, 3);
            }
        }
    }

    private BlockPos getFrontPos(BlockPos pos, IBlockState state) {
        EnumFacing facing = state.getValue(FACING);
        switch (state.getValue(PART)) {
            case FRONT: return pos;
            case MIDDLE: return pos.offset(facing.getOpposite());
            case BACK: return pos.offset(facing.getOpposite(), 2);
            default: return pos;
        }
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing()).withProperty(PART, Part.FRONT);
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        EnumFacing facing = state.getValue(FACING);
        for (int i = 1; i < 3; i++) {
            BlockPos partPos = pos.offset(facing, i);
            IBlockState partState = worldIn.getBlockState(partPos);
            if (!partState.getBlock().isReplaceable(worldIn, partPos)) {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState(), 3);
                if (placer instanceof EntityPlayer && !worldIn.isRemote) {
                    ((EntityPlayer) placer).sendStatusMessage(new TextComponentTranslation("alexsmobsdelightlegacy.message.need_more_space"), true);
                }
                return;
            }
        }
        worldIn.setBlockState(pos, state.withProperty(PART, Part.FRONT), 3);
        worldIn.setBlockState(pos.offset(facing), state.withProperty(PART, Part.MIDDLE), 3);
        worldIn.setBlockState(pos.offset(facing, 2), state.withProperty(PART, Part.BACK), 3);
        setServings(worldIn, pos, 17);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        BlockPos front = getFrontPos(pos, state);
        EnumFacing facing = state.getValue(FACING);
        for (int i = 0; i < 3; i++) {
            if (worldIn.getBlockState(front.offset(facing, i)).getBlock() != this) {
                worldIn.setBlockToAir(pos);
                return;
            }
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (state.getValue(PART)) {
            case FRONT: return SHAPE_FRONT;
            case MIDDLE: return SHAPE_MIDDLE;
            case BACK: return SHAPE_BACK;
            default: return FULL_BLOCK_AABB;
        }
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(SERVINGS, getServings(worldIn, pos));
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
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Items.AIR;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
        if (state.getValue(PART) != Part.FRONT) {
            return;
        }
        int servings = getServings(worldIn, pos);
        if (servings == 17) {
            drops.add(new ItemStack(Item.getItemFromBlock(this)));
        } else {
            drops.add(new ItemStack(Items.BOAT));
            drops.add(new ItemStack(AMDItems.CROCODILE_RICE, 1 + RANDOM.nextInt(3)));
        }
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, SERVINGS, PART);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing = EnumFacing.getHorizontal(meta & 3);
        int partIndex = (meta >> 2) & 3;
        Part part = partIndex >= 0 && partIndex < 3 ? Part.values()[partIndex] : Part.FRONT;
        return getDefaultState().withProperty(FACING, facing).withProperty(PART, part);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getHorizontalIndex() | (state.getValue(PART).ordinal() << 2);
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    public enum Part implements net.minecraft.util.IStringSerializable {
        FRONT, MIDDLE, BACK;
        @Override
        public String getName() {
            return name().toLowerCase();
        }
    }
}

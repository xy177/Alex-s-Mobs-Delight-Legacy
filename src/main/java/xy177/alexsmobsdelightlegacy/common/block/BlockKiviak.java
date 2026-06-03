package xy177.alexsmobsdelightlegacy.common.block;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xy177.alexsmobsdelightlegacy.common.registry.AMDItems;
import xy177.alexsmobsdelightlegacy.common.tile.TileEntityKiviak;

public class BlockKiviak extends Block implements ITileEntityProvider {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    public static final PropertyBool OPENED = PropertyBool.create("opened");
    public static final PropertyInteger COMPOSTING = PropertyInteger.create("composting", 0, 7);
    private static final AxisAlignedBB SHAPE_N = new AxisAlignedBB(0.0D, 0.0D, 3.0D / 16.0D, 15.0D / 16.0D, 13.0D / 16.0D, 12.0D / 16.0D);
    private static final AxisAlignedBB SHAPE_W = new AxisAlignedBB(3.0D / 16.0D, 0.0D, 1.0D / 16.0D, 12.0D / 16.0D, 13.0D / 16.0D, 1.0D);
    private static final AxisAlignedBB SHAPE_S = new AxisAlignedBB(1.0D / 16.0D, 0.0D, 4.0D / 16.0D, 1.0D, 13.0D / 16.0D, 13.0D / 16.0D);
    private static final AxisAlignedBB SHAPE_E = new AxisAlignedBB(4.0D / 16.0D, 0.0D, 0.0D, 13.0D / 16.0D, 13.0D / 16.0D, 15.0D / 16.0D);

    public BlockKiviak() {
        super(Material.CLOTH);
        setHardness(0.5F);
        setSoundType(SoundType.CLOTH);
        setTickRandomly(true);
        setDefaultState(blockState.getBaseState()
            .withProperty(FACING, EnumFacing.NORTH)
            .withProperty(OPENED, Boolean.FALSE)
            .withProperty(COMPOSTING, 0));
    }

    public boolean tickRandomly(IBlockState state) {
        return !state.getValue(OPENED);
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, java.util.Random rand) {
        if (worldIn.isRemote || state.getValue(OPENED)) {
            return;
        }

        float chance = 0.0F;
        boolean coldBiome = worldIn.getBiome(pos).getTemperature(pos) < 0.15F;
        int maxLight = 0;
        for (BlockPos checkPos : BlockPos.getAllInBoxMutable(pos.add(-1, -1, -1), pos.add(1, 1, 1))) {
            IBlockState checkState = worldIn.getBlockState(checkPos);
            if (checkState.getMaterial() == Material.ICE || checkState.getBlock() == Blocks.PACKED_ICE || checkState.getBlock() == Blocks.FROSTED_ICE) {
                chance += 0.02F;
            }
            int light = worldIn.getLightFor(EnumSkyBlock.SKY, checkPos.up());
            if (light > maxLight) {
                maxLight = light;
            }
        }
        chance += maxLight < 5 ? 0.1F : 0.05F;
        chance += coldBiome ? 0.1F : 0.0F;
        if (rand.nextFloat() <= chance) {
            int stage = getComposting(state);
            if (stage < 7) {
                setComposting(worldIn, pos, state, stage + 1);
            }
        }
    }

    @Override
    public boolean hasComparatorInputOverride(IBlockState state) {
        return true;
    }

    @Override
    public int getComparatorInputOverride(IBlockState blockState, World worldIn, BlockPos pos) {
        return 8 - getComposting(blockState);
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
                                    EnumFacing facing, float hitX, float hitY, float hitZ) {
        return takeServing(worldIn, pos, state, player, hand) != EnumActionResult.PASS;
    }

    protected EnumActionResult takeServing(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand) {
        int stage = getComposting(state);
        boolean opened = state.getValue(OPENED);
        ItemStack held = player.getHeldItem(hand);
        boolean knife = held != null && !held.isEmpty() && isKnife(held);

        if (stage == 7 && knife && !opened) {
            if (!worldIn.isRemote) {
                setComposting(worldIn, pos, state.withProperty(OPENED, Boolean.TRUE), stage);
                spawnOpenedDrops(worldIn, pos, getFacing(state, worldIn, pos).getOpposite());
                worldIn.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.8F, 1.3F);
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 300, 0));
                annoyNearbyMobs(worldIn, player);
                for (int i = 0; i < 24; i++) {
                    worldIn.spawnParticle(EnumParticleTypes.CLOUD, pos.getX() + 0.5D, pos.getY() + 0.3D, pos.getZ() + 0.5D, 0.0D, 0.02D, 0.0D);
                }
            }
            return EnumActionResult.SUCCESS;
        }

        if (stage < 7 && !opened && !worldIn.isRemote) {
            player.sendStatusMessage(new TextComponentTranslation("alexsmobsdelightlegacy.message.kiviak_wait"), true);
        }
        return opened ? EnumActionResult.SUCCESS : EnumActionResult.PASS;
    }

    private void spawnOpenedDrops(World worldIn, BlockPos pos, EnumFacing direction) {
        EntityItem item = new EntityItem(worldIn, pos.getX() + 0.5D, pos.getY() + 0.3D, pos.getZ() + 0.5D, new ItemStack(AMDItems.KIVIAK, 3));
        item.setDefaultPickupDelay();
        item.motionX = direction.getFrontOffsetX() * worldIn.rand.nextDouble() + (0.6D * worldIn.rand.nextDouble() - 0.3D);
        item.motionY = 0.4D * worldIn.rand.nextDouble() - 0.1D;
        item.motionZ = direction.getFrontOffsetZ() * worldIn.rand.nextDouble() + (0.6D * worldIn.rand.nextDouble() - 0.3D);
        worldIn.spawnEntity(item);
    }

    private void annoyNearbyMobs(World worldIn, EntityPlayer player) {
        List<EntityCreature> mobs = worldIn.getEntitiesWithinAABB(EntityCreature.class, player.getEntityBoundingBox().grow(15.0D));
        for (EntityCreature mob : mobs) {
            if (!mob.isOnSameTeam(player)) {
                mob.setAttackTarget(player);
            }
        }
    }

    private boolean isKnife(ItemStack stack) {
        return com.wdcftgg.farmersdelightlegacy.common.item.ItemKnife.isKnife(stack);
    }

    private int getComposting(IBlockState state) {
        return state.getValue(OPENED) ? 7 : state.getValue(COMPOSTING);
    }

    private void setComposting(World worldIn, BlockPos pos, IBlockState baseState, int stage) {
        int clamped = Math.max(0, Math.min(7, stage));
        IBlockState currentState = worldIn.getBlockState(pos);
        IBlockState updatedState = baseState
            .withProperty(COMPOSTING, clamped);
        worldIn.setBlockState(pos, updatedState, 3);
        worldIn.notifyBlockUpdate(pos, currentState, updatedState, 3);
        worldIn.markBlockRangeForRenderUpdate(pos, pos);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityKiviak();
    }

    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, net.minecraft.entity.EntityLivingBase placer, EnumHand hand) {
        return getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof TileEntityKiviak) {
            ((TileEntityKiviak) tile).setFacing(placer.getHorizontalFacing());
        }
        if (!worldIn.isRemote) {
            worldIn.notifyBlockUpdate(pos, state, state, 3);
            worldIn.markBlockRangeForRenderUpdate(pos, pos);
        }
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
        if (state.getValue(OPENED)) {
            drops.add(new ItemStack(AMDItems.KIVIAK, 3));
            return;
        }

        Item item = Item.getItemFromBlock(this);
        if (item != null) {
            drops.add(new ItemStack(item));
        }
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        switch (getFacing(state, source, pos)) {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
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
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(100) == getComposting(state) * 10) {
            worldIn.spawnParticle(
                EnumParticleTypes.TOWN_AURA,
                pos.getX() + rand.nextFloat(),
                pos.getY() + 1.1D,
                pos.getZ() + rand.nextFloat(),
                0.0D,
                0.0D,
                0.0D
            );
        }
    }

    private EnumFacing getFacing(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (tile instanceof TileEntityKiviak) {
            return ((TileEntityKiviak) tile).getFacing();
        }
        return state.getValue(FACING);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, OPENED, COMPOSTING);
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(FACING, getFacing(state, worldIn, pos));
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        boolean opened = (meta & 8) != 0;
        int composting = opened ? 7 : meta & 7;
        return getDefaultState()
            .withProperty(FACING, EnumFacing.NORTH)
            .withProperty(OPENED, opened)
            .withProperty(COMPOSTING, composting);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        if (state.getValue(OPENED)) {
            return 15;
        }
        return state.getValue(COMPOSTING) & 7;
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }
}

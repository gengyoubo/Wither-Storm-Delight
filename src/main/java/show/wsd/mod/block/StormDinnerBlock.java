package show.wsd.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import nonamecrackers2.witherstormmod.common.init.WitherStormModSoundEvents;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class StormDinnerBlock extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 2.0D, 15.0D);
    protected static final VoxelShape ROAST_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(4.0D, 2.0D, 4.0D, 12.0D, 10.0D, 12.0D), BooleanOp.OR);

    public StormDinnerBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }
    protected InteractionResult takeServing(LevelAccessor levelacc, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        if (!(levelacc instanceof Level level)) {
            return InteractionResult.PASS;
        }
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            level.playSound(null, pos, WitherStormModSoundEvents.WITHER_STORM_ROAR.get(), SoundSource.PLAYERS, 0.5F, 0.5F);
            level.destroyBlock(pos, false);
            ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, Items.BOWL.getDefaultInstance());
            itemEntity.setPickUpDelay(10);
            level.addFreshEntity(itemEntity);

            return InteractionResult.SUCCESS;
        }
        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getItemInHand(hand);

        if (servings > 0) {
            if (!serving.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, serving.getCraftingRemainingItem())) {
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                    heldStack.shrink(1);
                }
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (level.getBlockState(pos).getValue(getServingsProperty()) == 0 && !this.hasLeftovers) {
                    level.removeBlock(pos, false);
                }
                level.playSound(null, pos, WitherStormModSoundEvents.WITHER_STORM_HURT.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", serving.getCraftingRemainingItem().getHoverName()), true);
                levelacc.playSound(null, pos, WitherStormModSoundEvents.WITHER_STORM_SHOOT.get(), SoundSource.BLOCKS, 1.0F, 1.0F);

            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : ROAST_SHAPE;
    }
}

package show.wsd.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import nonamecrackers2.witherstormmod.common.init.WitherStormModItems;
import nonamecrackers2.witherstormmod.common.init.WitherStormModSoundEvents;
import vectorwing.farmersdelight.common.block.FeastBlock;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModParticleTypes;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.function.Supplier;

public class GoldenAppleStewBlock extends FeastBlock {

    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 10.0D, 14.0D);

    public GoldenAppleStewBlock(Properties properties, Supplier<Item> servingItem, boolean hasLeftovers) {
        super(properties, servingItem, hasLeftovers);
    }
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState stateIn, Level level, BlockPos pos, RandomSource rand) {
        int servings = stateIn.getValue(getServingsProperty());

        if (servings > 0) {
            RandomSource random = level.random;
            if (random.nextFloat() < 0.2F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.6D - 0.3D);
                double y = (double) pos.getY() + 0.8D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.6D - 0.3D);
                level.addParticle(ParticleTypes.ENTITY_EFFECT, x, y, z, 0.0D, 0.0D, 0.0D);
            }
            if (random.nextFloat() < 0.05F) {
                double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.6D - 0.3D);
                double y = (double) pos.getY() + 0.8D;
                double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.6D - 0.3D);
                level.addParticle(ParticleTypes.ENTITY_EFFECT, x, y, z, 0.0D, 0.0D, 0.0D);
            }

        }
    }

    protected InteractionResult takeServing(LevelAccessor levelacc, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            levelacc.playSound(null, pos, SoundEvents.LANTERN_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);

            // The feast is already empty at this point.  Remove only the block
            // and restore its cooking pot on the server; dropping the block
            // itself here duplicates the feast item and doing this on the
            // client creates a ghost pot.
            if (levelacc instanceof Level level && !level.isClientSide) {
                level.destroyBlock(pos, false);
                ItemEntity itemEntity = new ItemEntity(level,
                        pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D,
                        ModItems.COOKING_POT.get().getDefaultInstance());
                itemEntity.setPickUpDelay(10);
                level.addFreshEntity(itemEntity);
            }

            return levelacc instanceof Level level
                    ? InteractionResult.sidedSuccess(level.isClientSide)
                    : InteractionResult.SUCCESS;
        }

        ItemStack serving = this.getServingItem(state);
        ItemStack heldStack = player.getItemInHand(hand);

        if (servings > 0) {
            if (!serving.hasCraftingRemainingItem() || ItemStack.isSameItem(heldStack, serving.getCraftingRemainingItem())) {
                levelacc.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                if (!player.getAbilities().instabuild && serving.hasCraftingRemainingItem()) {
                    heldStack.shrink(1);
                }
                if (!player.getInventory().add(serving)) {
                    player.drop(serving, false);
                }
                if (levelacc.getBlockState(pos).getValue(getServingsProperty()) == 0 && !this.hasLeftovers) {
                    levelacc.removeBlock(pos, false);
                }
                levelacc.playSound(null, pos, SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(TextUtils.getTranslation("block.feast.use_container", serving.getCraftingRemainingItem().getHoverName()), true);
            }
        }
        return InteractionResult.PASS;
    }


}

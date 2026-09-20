package show.wsd.mod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import show.wsd.mod.block.entity.CommandCookingPotBlockEntity;
import show.wsd.mod.init.ModOther;
import vectorwing.farmersdelight.common.block.CookingPotBlock;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

public class CommandCookingPot extends CookingPotBlock {
    public CommandCookingPot(Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CommandCookingPotBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return createTickerHelper(type, ModOther.COMMAND_COOKING_POT_BE.get(), CookingPotBlockEntity::animationTick);
        }
        return createTickerHelper(type, ModOther.COMMAND_COOKING_POT_BE.get(), CookingPotBlockEntity::cookingTick);
    }
}

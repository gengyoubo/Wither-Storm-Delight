package show.wsd.mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import show.wsd.mod.init.ModOther;
import vectorwing.farmersdelight.common.block.entity.StoveBlockEntity;

public class WitherStoveBlockEntity extends StoveBlockEntity {
    public WitherStoveBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModOther.WITHER_STOVE_BE.get();
    }
}

package show.wsd.mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraftforge.items.ItemStackHandler;
import show.wsd.mod.init.ModOther;
import vectorwing.farmersdelight.common.block.AbstractStoveBlock;
import vectorwing.farmersdelight.common.block.entity.AbstractStoveBlockEntity;

public class WitherStoveBlockEntity extends AbstractStoveBlockEntity {
    public WitherStoveBlockEntity(BlockPos pos, BlockState state) {
        super(ModOther.WITHER_STOVE_BE.get(), pos, state, RecipeType.CAMPFIRE_COOKING);
    }

    public static void particleTick(Level level, BlockPos pos, BlockState state, WitherStoveBlockEntity blockEntity) {
        if (!blockEntity.isEmpty()) {
            blockEntity.addSmokeParticles();
        }
    }

    public void addSmokeParticles() {
        if (this.level == null) {
            return;
        }
        ItemStackHandler items = this.getItems();
        for (int i = 0; i < items.getSlots(); i++) {
            if (items.getStackInSlot(i).isEmpty()) {
                continue;
            }
            if (this.level.random.nextFloat() >= 0.2F) {
                continue;
            }
            Vec2 offset = this.getStoveItemOffset(i);
            Direction direction = this.getBlockState().getValue(AbstractStoveBlock.FACING);
            if (direction.get2DDataValue() % 2 != 0) {
                offset = new Vec2(offset.y, offset.x);
            }
            double x = this.worldPosition.getX() + 0.5D
                    - direction.getStepX() * offset.x
                    + direction.getClockWise().getStepX() * offset.x;
            double y = this.worldPosition.getY() + 1.0D;
            double z = this.worldPosition.getZ() + 0.5D
                    - direction.getStepZ() * offset.y
                    + direction.getClockWise().getStepZ() * offset.y;
            for (int k = 0; k < 3; k++) {
                this.level.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0D, 5.0E-4D, 0.0D);
            }
        }
    }

    @Override
    protected int getInventorySlotCount() {
        return 6;
    }

    @Override
    public Vec2 getStoveItemOffset(int index) {
        Vec2[] offsets = {
                new Vec2(0.3F, 0.2F), new Vec2(0.0F, 0.2F), new Vec2(-0.3F, 0.2F),
                new Vec2(0.3F, -0.2F), new Vec2(0.0F, -0.2F), new Vec2(-0.3F, -0.2F)
        };
        return offsets[index];
    }
}

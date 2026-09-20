package show.wsd.mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import show.wsd.mod.block.entity.container.CommandCookingPotMenu;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;

public class CommandCookingPotBlockEntity extends CookingPotBlockEntity {
    public CommandCookingPotBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new CommandCookingPotMenu(id, inv, this, this.cookingPotData);
    }
}

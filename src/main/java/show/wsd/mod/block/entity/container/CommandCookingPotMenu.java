package show.wsd.mod.block.entity.container;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.ContainerLevelAccess;
import show.wsd.mod.block.entity.CommandCookingPotBlockEntity;
import show.wsd.mod.init.ModBlock;
import vectorwing.farmersdelight.common.block.entity.container.CookingPotMenu;

public class CommandCookingPotMenu extends CookingPotMenu {
    public CommandCookingPotMenu(int id, Inventory inv, CommandCookingPotBlockEntity blockEntity, ContainerData data) {
        super(id, inv, blockEntity, data);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(this.level, this.blockEntity.getBlockPos()), player, ModBlock.COMMAND_COOKING_POT.get())
                || super.stillValid(player);
    }
}

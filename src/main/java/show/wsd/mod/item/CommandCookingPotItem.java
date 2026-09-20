package show.wsd.mod.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.items.ItemStackHandler;
import show.wsd.mod.init.ModItem;
import vectorwing.farmersdelight.client.gui.CookingPotTooltip;
import vectorwing.farmersdelight.common.block.entity.CookingPotBlockEntity;
import vectorwing.farmersdelight.common.item.CookingPotItem;

import java.util.Optional;

public class CommandCookingPotItem extends CookingPotItem {
    public CommandCookingPotItem(Block block, Properties properties) {
        super(block, properties);
    }

    public static ItemStack getMealFromItem(ItemStack stack) {
        if (!stack.is(ModItem.COMMAND_COOKING_POT.get())) {
            return CookingPotBlockEntity.getMealFromItem(stack);
        }
        CompoundTag tag = stack.getTagElement(BlockItem.BLOCK_ENTITY_TAG);
        if (tag != null) {
            CompoundTag inventory = tag.getCompound("Inventory");
            if (inventory.contains("Items", 9)) {
                ItemStackHandler handler = new ItemStackHandler();
                handler.deserializeNBT(inventory);
                return handler.getStackInSlot(CookingPotBlockEntity.MEAL_DISPLAY_SLOT);
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        return Optional.of(new CookingPotTooltip.CookingPotTooltipComponent(getMealFromItem(stack)));
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return getServingCount(stack) > 0;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.min(1 + 12 * getServingCount(stack) / 64, 13);
    }

    private static int getServingCount(ItemStack stack) {
        CompoundTag tag = stack.getTagElement(BlockItem.BLOCK_ENTITY_TAG);
        if (tag == null) {
            return 0;
        }
        return getMealFromItem(stack).getCount();
    }
}

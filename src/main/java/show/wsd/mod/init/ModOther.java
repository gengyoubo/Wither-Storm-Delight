package show.wsd.mod.init;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.wsd.mod.WitherStormDelightMod;
import show.wsd.mod.block.entity.CommandCookingPotBlockEntity;

public class ModOther {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WitherStormDelightMod.MOD_ID);

    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WitherStormDelightMod.MOD_ID);

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, WitherStormDelightMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CommandCookingPotBlockEntity>> COMMAND_COOKING_POT_BE = BLOCK_ENTITY_TYPES.register("command_cooking_pot",
            () -> BlockEntityType.Builder.of(CommandCookingPotBlockEntity::new, ModBlock.COMMAND_COOKING_POT.get()).build(null));

    public static final RegistryObject<CreativeModeTab> MOD_TAB = TABS.register("item",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("ItemGroup.witherstorm_delight.item"))
                    .icon(() -> new ItemStack(ModItem.WITHER_STOVE.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItem.WITHER_STOVE.get());
                        output.accept(ModItem.COMMAND_COOKING_POT.get());
                        output.accept(ModItem.WITHERED_CABBAGE_CRATE.get());
                        output.accept(ModItem.WITHERED_TOMATO_CRATE.get());
                        output.accept(ModItem.WITHERED_ONION_CRATE.get());
                        output.accept(ModItem.WITHERED_RICE_BALE.get());
                        output.accept(ModItem.WITHERED_RICE_BAG.get());
                        output.accept(ModItem.TAINTED_CABINET.get());
                        output.accept(ModItem.FLINT_COMMAND_BLOCK_KNIFE.get());
                        output.accept(ModItem.IRON_COMMAND_BLOCK_KNIFE.get());
                        output.accept(ModItem.COMMAND_BLOCK_KNIFE.get());
                        output.accept(ModItem.NETHERITE_COMMAND_BLOCK_KNIFE.get());
                        output.accept(ModItem.GOLD_COMMAND_BLOCK_KNIFE.get());
                        output.accept(ModItem.TAINTED_MUSHROOM_COLONY.get());
                        output.accept(ModItem.SYMBIONT_EYE.get());
                        output.accept(ModItem.TAINTED_EYE.get());
                        output.accept(ModItem.WITHERED_CABBAGE.get());
                        output.accept(ModItem.WITHERED_TOMATO.get());
                        output.accept(ModItem.WITHERED_ONION.get());
                        output.accept(ModItem.WITHERED_RICE_PANICLE.get());
                        output.accept(ModItem.WITHERED_RICE.get());
                        output.accept(ModItem.WITHERED_CABBAGE_SEEDS.get());
                        output.accept(ModItem.WITHERED_TOMATO_SEEDS.get());
                        output.accept(ModItem.SUPER_FRIED_EGG.get());
                        output.accept(ModItem.FORMIDIFRIED_EGG.get());
                        output.accept(ModItem.SUPER_EGG.get());
                        output.accept(ModItem.FORMIDIEGG.get());
                        output.accept(ModItem.TAINTED_ESSENCE.get());
                        output.accept(ModItem.WITHER_ROSE_PETAL_TEA.get());
                        output.accept(ModItem.WITHERED_TOMATO_SAUCE.get());
                        output.accept(ModItem.TAINTED_PUMPKIN_SLICE.get());
                        output.accept(ModItem.WITHERED_CABBAGE_LEAF.get());
                        output.accept(ModItem.MINCED_WITHERED_FLESH.get());
                        output.accept(ModItem.WITHERED_FLESH_PATTY.get());
                        output.accept(ModItem.COOKED_WITHERED_FLESH.get());
                        output.accept(ModItem.WITHER_STORM_TENTACLE.get());
                        output.accept(ModItem.STORM_PIE.get());
                        output.accept(ModItem.STORM_PIE_SLICE.get());
                        output.accept(ModItem.STORM_POPSICLE.get());
                        output.accept(ModItem.SALAD.get());
                        output.accept(ModItem.WITHER_BARBECUE.get());
                        output.accept(ModItem.STORM_SANDWICH.get());
                        output.accept(ModItem.WITHERED_CABBAGE_ROLLS.get());
                        output.accept(ModItem.WITHERED_BONE_BROTH.get());
                        output.accept(ModItem.COOKED_RICE.get());
                        output.accept(ModItem.FRIED_RICE.get());
                        output.accept(ModItem.EYES_PORRIDGE.get());
                        output.accept(ModItem.BIG_MAC_BURGER_BLOCK.get());
                        output.accept(ModItem.BIG_MAC_BURGER.get());
                        output.accept(ModItem.STUFFED_TAINTED_PUMPKIN_BLOCK.get());
                        output.accept(ModItem.STUFFED_TAINTED_PUMPKIN.get());
                        output.accept(ModItem.STORM_DINNER_BLOCK.get());
                        output.accept(ModItem.STORM_DINNER.get());
                        output.accept(ModItem.STUFFED_COMMAND_BLOCK_BLOCK.get());
                        output.accept(ModItem.STUFFED_COMMAND_BLOCK.get());
                        output.accept(ModItem.GOLDEN_APPLE_STEW_BLOCK.get());
                        output.accept(ModItem.GOLDEN_APPLE_STEW_LARGE_BOWL.get());
                        output.accept(ModItem.COOKED_ZOMBIE_BLOCK.get());
                        output.accept(ModItem.COOKED_ZOMBIE.get());
                    }).build());

    public static final RegistryObject<SimpleParticleType> WIRHER_FLAME = PARTICLE_TYPES.register("wither_flame",
            () -> new SimpleParticleType(false));
}

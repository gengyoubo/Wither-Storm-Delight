package show.wsd.mod.init;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import nonamecrackers2.witherstormmod.common.init.WitherStormModBlocks;
import nonamecrackers2.witherstormmod.common.init.WitherStormModItems;
import show.wsd.mod.WitherStormDelightMod;
import show.wsd.mod.block.*;
import vectorwing.farmersdelight.common.block.*;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WitherStormDelightMod.MOD_ID);

    public static final RegistryObject<Block> TAINTED_CABINET = BLOCKS.register("tainted_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(2f, 2f)));

    public static final RegistryObject<Block> WITHER_STOVE = BLOCKS.register("wither_stove", WitherStoveBlock::new);

    public static final RegistryObject<Block> COMMAND_COOKING_POT = BLOCKS.register("command_cooking_pot",
            () -> new CommandCookingPot(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.METAL)
                    .strength(0.7F, 6.0F)
                    .sound(SoundType.NETHERITE_BLOCK)));

    public static final RegistryObject<Block> STORM_DINNER_BLOCK = BLOCKS.register("storm_dinner_block",
            () -> new StormDinnerBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
                    ModItem.STORM_DINNER,
                    true));

    public static final RegistryObject<Block> GOLDEN_APPLE_STEW_BLOCK = BLOCKS.register("cooking_pot_of_golden_apple_stew",
            () -> new GoldenAppleStewBlock(BlockBehaviour.Properties.copy(Blocks.LANTERN).sound(SoundType.LANTERN).lightLevel(s -> 0).mapColor(MapColor.METAL).strength(0.5F, 6.0F),
                    ModItem.GOLDEN_APPLE_STEW_LARGE_BOWL,
                    true));

    public static final RegistryObject<Block> STUFFED_TAINTED_PUMPKIN_BLOCK = BLOCKS.register("stuffed_tainted_pumpkin_block",
            () -> new FeastBlock(BlockBehaviour.Properties.copy(Blocks.PUMPKIN),
                    ModItem.STUFFED_TAINTED_PUMPKIN,
                    false));

    public static final RegistryObject<Block> BIG_MAC_BURGER_BLOCK = BLOCKS.register("big_mac_burger_block",
            () -> new BigMacBurgerBlock(BlockBehaviour.Properties.copy(Blocks.CAKE),
                    ModItem.BIG_MAC_BURGER));

    public static final RegistryObject<Block> STORM_PIE = BLOCKS.register("storm_pie",
            () -> new PieBlock(BlockBehaviour.Properties.copy(Blocks.CAKE),
                    ModItem.STORM_PIE_SLICE));


    public static final RegistryObject<Block> STUFFED_COMMAND_BLOCK_BLOCK = BLOCKS.register("stuffed_command_block_block",
            () -> new StuffedCommandBlockBlock(BlockBehaviour.Properties.copy(Blocks.COMMAND_BLOCK),
                    ModItem.STUFFED_COMMAND_BLOCK,
                    false));

    public static final RegistryObject<Block> TAINTED_MUSHROOM_COLONY = BLOCKS.register("tainted_mushroom_colony",
            () -> new MushroomColonyBlock(Block.Properties.copy(Blocks.BROWN_MUSHROOM)
                    .hasPostProcess((bs, br, bp) -> true)
                    .emissiveRendering((bs, br, bp) -> true),
                    WitherStormModItems.TAINTED_MUSHROOM));

    public static final RegistryObject<Block> COOKED_ZOMBIE_BLOCK = BLOCKS.register("cooked_tainted_zombie_block",
            () -> new CookedZombieBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD),
                    ModItem.COOKED_ZOMBIE,
                    true));

    //Crops
    public static final RegistryObject<Block> WITHERED_CABBAGE_CROP = BLOCKS.register("withered_cabbages",
            () -> new WitheredCabbageBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> WITHERED_ONION_CROP = BLOCKS.register("withered_onions",
            () -> new WitheredOnionBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> BUDDING_WITHERED_TOMATO_CROP = BLOCKS.register("budding_withered_tomatoes",
            () -> new BuddingWitheredTomatoBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> WITHERED_TOMATO_CROP = BLOCKS.register("withered_tomatoes",
            () -> new WitheredTomatoVineBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> WITHERED_RICE_CROP = BLOCKS.register("withered_rice",
            () -> new WitheredRiceBlock(Block.Properties.copy(Blocks.WHEAT).strength(0.2F)));

    public static final RegistryObject<Block> WITHERED_RICE_CROP_PANICLES = BLOCKS.register("withered_rice_panicles",
            () -> new WitheredRicePaniclesBlock(Block.Properties.copy(Blocks.WHEAT)));

    //Crate
    public static final RegistryObject<Block> WITHERED_CABBAGE_CRATE = BLOCKS.register("withered_cabbage_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WITHERED_TOMATO_CRATE = BLOCKS.register("withered_tomato_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WITHERED_ONION_CRATE = BLOCKS.register("withered_onion_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0F, 3.0F)
                    .sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WITHERED_RICE_BALE = BLOCKS.register("withered_rice_bale",
            () -> new RiceBaleBlock(Block.Properties.copy(Blocks.HAY_BLOCK)));

    public static final RegistryObject<Block> WITHERED_RICE_BAG = BLOCKS.register("withered_rice_bag",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL)));
}

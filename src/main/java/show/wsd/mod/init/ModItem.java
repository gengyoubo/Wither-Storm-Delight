package show.wsd.mod.init;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import show.wsd.mod.WitherStormDelightMod;
import show.wsd.mod.item.*;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.MushroomColonyItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;

public class ModItem {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WitherStormDelightMod.MOD_ID);

    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes
    public static final int SUPER_LONG_DURATION = 24000;    // 20 minutes

    // Feast Portions
    public static final FoodProperties FOOD_STUFFED_TAINTED_PUMPKIN = new FoodProperties.Builder()
            .nutrition(16).saturationMod(1.4f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties FOOD_STUFFED_COMMAND_BLOCK = new FoodProperties.Builder()
            .nutrition(22).saturationMod(1.4f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties FOOD_STORM_DINNER = new FoodProperties.Builder()
            .nutrition(24).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties FOOD_COOKED_ZOMBIE = new FoodProperties.Builder()
            .nutrition(13).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties FOOD_WITHER_BARBECUE = new FoodProperties.Builder()
            .nutrition(9).saturationMod(1.1f)
            .build();

    public static final FoodProperties FOOD_STORM_POPSICLE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.2f)
            .build();

    public static final FoodProperties FOOD_STORM_SANDWICH = new FoodProperties.Builder()
            .nutrition(12).saturationMod(1f)
            .build();

    public static final FoodProperties FOOD_EYES_PORRIDGE = new FoodProperties.Builder()
            .nutrition(10).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 1), 1.0F)
            .build();

    public static final FoodProperties FOOD_FRIED_RICE = new FoodProperties.Builder()
            .nutrition(16).saturationMod(1f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 2.0F)
            .build();

    public static final FoodProperties FOOD_COOKED_RICE = new FoodProperties.Builder()
            .nutrition(7).saturationMod(1f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 2.0F)
            .build();

    public static final FoodProperties FOOD_SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 2.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 1), 1.0F)
            .build();

    public static final FoodProperties FOOD_PIE_SLICE = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.5f)
            .build();

    public static final FoodProperties FOOD_BIG_MAC_BURGER = new FoodProperties.Builder()
            .nutrition(10).saturationMod(1.2f)
            .build();
    public static final FoodProperties FOOD_WITHERED_CABBAGE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.5f)
            .build();

    public static final FoodProperties FOOD_WITHERED_TOMATO = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.4f)
            .build();

    public static final FoodProperties FOOD_WITHERED_ONION = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.6f)
            .build();

    public static final FoodProperties FOOD_WITHERED_BONE_BROTH = new FoodProperties.Builder()
            .nutrition(9).saturationMod(1f).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F)
            .meat()
            .build();

    public static final FoodProperties FOOD_WITHERED_TOMATO_SAUCE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.7f)
            .meat()
            .build();

    public static final FoodProperties FOOD_GOLDEN_APPLE_STEW_LARGE_BOWL = new FoodProperties.Builder()
            .nutrition(10).saturationMod(1.3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, LONG_DURATION, 1), 1.0F)
            .alwaysEat()
            .build();

    public static final FoodProperties FOOD_WITHER_ROSE_PETAL_TEA = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 1), 1.0F)
            .alwaysEat()
            .build();

    public static final RegistryObject<Item> COOKED_WITHERED_FLESH = ITEMS.register("cooked_withered_flesh",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder()
                            .nutrition(6)
                            .saturationMod(0.4f)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> WITHERED_FLESH_PATTY = ITEMS.register("withered_flesh_patty",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder()
                            .nutrition(3)
                            .saturationMod(0.6f)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> MINCED_WITHERED_FLESH = ITEMS.register("minced_withered_flesh",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationMod(0.5f)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> WITHERED_CABBAGE_ROLLS = ITEMS.register("withered_cabbage_rolls",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(0.6f)
                            .build())));

    public static final RegistryObject<Item> TAINTED_ESSENCE = ITEMS.register("tainted_essence",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> WITHERED_TOMATO_SAUCE = ITEMS.register("withered_tomato_sauce",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_WITHERED_TOMATO_SAUCE),
                    false));

    public static final RegistryObject<Item> GOLDEN_APPLE_STEW_LARGE_BOWL = ITEMS.register("large_bowl_of_golden_apple_stew",
            () -> new GoldenAppleConsumableItem(bowlFoodItem(FOOD_GOLDEN_APPLE_STEW_LARGE_BOWL).rarity(Rarity.RARE),
                    true));


    public static final RegistryObject<Item> WITHERED_BONE_BROTH = ITEMS.register("withered_bone_broth",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_WITHERED_BONE_BROTH),
                    true));

    public static final RegistryObject<Item> TAINTED_PUMPKIN_SLICE = ITEMS.register("tainted_pumpkin_slice",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(4)
                            .saturationMod(0.2f)
                            .build())));

    public static final RegistryObject<Item> WITHER_STORM_TENTACLE = ITEMS.register("wither_storm_tentacle",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<BlockItem> WITHER_STOVE = ITEMS.register("wither_stove",
            () -> new BlockItem(ModBlock.WITHER_STOVE.get(), new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<BlockItem> TAINTED_CABINET = ITEMS.register("tainted_cabinet",
            () -> new BlockItem(ModBlock.TAINTED_CABINET.get(), new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> COMMAND_BLOCK_FRAGMENT = ITEMS.register("command_block_fragment",
            () -> new Item(new Item.Properties()
                    .rarity(WitherStormDelightMod.COMMAND)));

    public static final RegistryObject<Item> FORMIDIEGG = ITEMS.register("formidiegg", Formidiegg::new);

    public static final RegistryObject<Item> SUPER_EGG = ITEMS.register("super_egg", SuperEgg::new);

    public static final RegistryObject<Item> SUPER_FRIED_EGG = ITEMS.register("super_fried_egg",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .food(new FoodProperties.Builder()
                            .nutrition(5)
                            .saturationMod(2.5f)
                            .meat()
                            .build())));

    public static final RegistryObject<Item> FORMIDIFRIED_EGG = ITEMS.register("formidifried_egg", FormidifriedEgg::new);

    public static final RegistryObject<Item> TAINTED_EYE = ITEMS.register("tainted_eye",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> SYMBIONT_EYE = ITEMS.register("the_eye_of_symbiont",
            () -> new Item(new Item.Properties()
                    .stacksTo(1)
                    .rarity(WitherStormDelightMod.SYMBIONT)));

    public static final RegistryObject<Item> COMMAND_COOKING_POT = ITEMS.register("command_cooking_pot",
            () -> new CommandCookingPotItem(ModBlock.COMMAND_COOKING_POT.get(), basicItem()
                    .stacksTo(1)
                    .rarity(WitherStormDelightMod.COMMAND)));

    public static final RegistryObject<BlockItem> STORM_DINNER_BLOCK = ITEMS.register("storm_dinner_block",
            () -> new BlockItem(ModBlock.STORM_DINNER_BLOCK.get(), basicItem()
                    .rarity(Rarity.EPIC)));

    public static final RegistryObject<BlockItem> GOLDEN_APPLE_STEW_BLOCK = ITEMS.register("cooking_pot_of_golden_apple_stew",
            () -> new BlockItem(ModBlock.GOLDEN_APPLE_STEW_BLOCK.get(), basicItem()
                    .rarity(Rarity.RARE)));

    public static final RegistryObject<Item> STORM_DINNER = ITEMS.register("storm_dinner",
            () -> new GoldenAppleConsumableItem(bowlFoodItem(FOOD_STORM_DINNER).rarity(Rarity.EPIC),
                    true));

    public static final RegistryObject<BlockItem> STUFFED_TAINTED_PUMPKIN_BLOCK = ITEMS.register("stuffed_tainted_pumpkin_block",
            () -> new BlockItem(ModBlock.STUFFED_TAINTED_PUMPKIN_BLOCK.get(), basicItem()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> STUFFED_TAINTED_PUMPKIN = ITEMS.register("stuffed_tainted_pumpkin",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_STUFFED_TAINTED_PUMPKIN).rarity(Rarity.UNCOMMON),
                    true));

    public static final RegistryObject<Item> BIG_MAC_BURGER_BLOCK = ITEMS.register("big_mac_burger_block",
            () -> new BlockItem(ModBlock.BIG_MAC_BURGER_BLOCK.get(), basicItem()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> BIG_MAC_BURGER = ITEMS.register("big_mac_burger",
            () -> new WSDConsumableItem(foodItem(FOOD_BIG_MAC_BURGER).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<BlockItem> STUFFED_COMMAND_BLOCK_BLOCK = ITEMS.register("stuffed_command_block_block",
            () -> new BlockItem(ModBlock.STUFFED_COMMAND_BLOCK_BLOCK.get(), basicItem()
                    .rarity(WitherStormDelightMod.COMMAND)));

    public static final RegistryObject<Item> STUFFED_COMMAND_BLOCK = ITEMS.register("stuffed_command_block",
            () -> new GoldenAppleConsumableItem(bowlFoodItem(FOOD_STUFFED_COMMAND_BLOCK).rarity(WitherStormDelightMod.COMMAND),
                    true));

    public static final RegistryObject<BlockItem> COOKED_ZOMBIE_BLOCK = ITEMS.register("cooked_tainted_zombie_block",
            () -> new BlockItem(ModBlock.COOKED_ZOMBIE_BLOCK.get(), basicItem()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> COOKED_ZOMBIE = ITEMS.register("cooked_tainted_zombie",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_COOKED_ZOMBIE).rarity(Rarity.UNCOMMON),
                    true));

    public static final RegistryObject<Item> WITHER_BARBECUE = ITEMS.register("wither_barbecue_stick",
            () -> new WSDConsumableItem(stickFoodItem(FOOD_WITHER_BARBECUE).rarity(Rarity.UNCOMMON),
                    false));

    public static final RegistryObject<Item> STORM_SANDWICH = ITEMS.register("storm_sandwich",
            () -> new WSDConsumableItem(foodItem(FOOD_STORM_SANDWICH).rarity(Rarity.UNCOMMON),
                    false));

    public static final RegistryObject<Item> EYES_PORRIDGE = ITEMS.register("eyes_porridge",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_EYES_PORRIDGE).rarity(Rarity.UNCOMMON),
                    true));

    public static final RegistryObject<Item> FRIED_RICE = ITEMS.register("fried_withered_rice",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_FRIED_RICE).rarity(Rarity.UNCOMMON),
                    true));

    public static final RegistryObject<Item> SALAD = ITEMS.register("withered_salad",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_SALAD).rarity(Rarity.UNCOMMON),
                    true));

    public static final RegistryObject<Item> COOKED_RICE = ITEMS.register("cooked_withered_rice",
            () -> new WSDConsumableItem(bowlFoodItem(FOOD_COOKED_RICE),
                    true));

    public static final RegistryObject<Item> STORM_PIE_SLICE = ITEMS.register("storm_pie_slice",
            () -> new WSDConsumableItem(foodItem(FOOD_PIE_SLICE).rarity(Rarity.UNCOMMON),
                    false));

    public static final RegistryObject<Item> STORM_PIE = ITEMS.register("storm_pie",
            () -> new BlockItem(ModBlock.STORM_PIE.get(), basicItem()
                    .rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> STORM_POPSICLE = ITEMS.register("storm_popsicle",
            () -> new WSDConsumableItem(stickFoodItem(FOOD_STORM_POPSICLE).rarity(Rarity.UNCOMMON),
                    false));


    public static final RegistryObject<Item> TAINTED_MUSHROOM_COLONY = ITEMS.register("tainted_mushroom_colony",
            () -> new MushroomColonyItem(ModBlock.TAINTED_MUSHROOM_COLONY.get(), basicItem()
                    .rarity(Rarity.UNCOMMON)));

    //Crops
    public static final RegistryObject<Item> WITHERED_CABBAGE = ITEMS.register("withered_cabbage",
            () -> new Item(foodItem(FOOD_WITHERED_CABBAGE)));

    public static final RegistryObject<Item> WITHERED_TOMATO = ITEMS.register("withered_tomato",
            () -> new Item(foodItem(FOOD_WITHERED_TOMATO)));

    public static final RegistryObject<Item> WITHERED_CABBAGE_LEAF = ITEMS.register("withered_cabbage_leaf",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(1)
                            .saturationMod(0.2f)
                            .build())));

    public static final RegistryObject<Item> WITHERED_RICE_PANICLE = ITEMS.register("withered_rice_panicle",
            () -> new Item(basicItem()));

    public static final RegistryObject<Item> WITHERED_RICE = ITEMS.register("withered_rice",
            () -> new WitheredRiceItem(ModBlock.WITHERED_RICE_CROP.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_CABBAGE_SEEDS = ITEMS.register("withered_cabbage_seeds",
            () -> new ItemNameBlockItem(ModBlock.WITHERED_CABBAGE_CROP.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_TOMATO_SEEDS = ITEMS.register("withered_tomato_seeds",
            () -> new ItemNameBlockItem(ModBlock.BUDDING_WITHERED_TOMATO_CROP.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_ONION = ITEMS.register("withered_onion",
            () -> new ItemNameBlockItem(ModBlock.WITHERED_ONION_CROP.get(), foodItem(FOOD_WITHERED_ONION)));

    //Crate
    public static final RegistryObject<Item> WITHERED_CABBAGE_CRATE = ITEMS.register("withered_cabbage_crate",
            () -> new BlockItem(ModBlock.WITHERED_CABBAGE_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_TOMATO_CRATE = ITEMS.register("withered_tomato_crate",
            () -> new BlockItem(ModBlock.WITHERED_TOMATO_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_ONION_CRATE = ITEMS.register("withered_onion_crate",
            () -> new BlockItem(ModBlock.WITHERED_ONION_CRATE.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_RICE_BALE = ITEMS.register("withered_rice_bale",
            () -> new BlockItem(ModBlock.WITHERED_RICE_BALE.get(), basicItem()));

    public static final RegistryObject<Item> WITHERED_RICE_BAG = ITEMS.register("withered_rice_bag",
            () -> new BlockItem(ModBlock.WITHERED_RICE_BAG.get(), basicItem()));

    //Knifes
    public static final RegistryObject<Item> COMMAND_BLOCK_KNIFE = ITEMS.register("command_block_knife", CommandBlockKnife::new);

    public static final RegistryObject<Item> IRON_COMMAND_BLOCK_KNIFE = ITEMS.register("iron_command_block_knife", IronCommandBlockKnife::new);

    public static final RegistryObject<Item> GOLD_COMMAND_BLOCK_KNIFE = ITEMS.register("gold_command_block_knife", GoldCommandBlockKnife::new);

    public static final RegistryObject<Item> FLINT_COMMAND_BLOCK_KNIFE = ITEMS.register("flint_command_block_knife", FlintCommandBlockKnife::new);

    public static final RegistryObject<Item> NETHERITE_COMMAND_BLOCK_KNIFE = ITEMS.register("netherite_command_block_knife", NetheriteCommandBlockKnife::new);

    //Drinks
    public static final RegistryObject<Item> WITHER_ROSE_PETAL_TEA = ITEMS.register("wither_rose_petal_tea",
            () -> new DrinkableItem(drinkItem(FOOD_WITHER_ROSE_PETAL_TEA).rarity(Rarity.UNCOMMON),
                    true, false));
    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.BOWL)
                .stacksTo(16);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.GLASS_BOTTLE)
                .stacksTo(16);
    }
    public static Item.Properties stickFoodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food)
                .craftRemainder(Items.STICK)
                .stacksTo(16);
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties()
                .food(food);
    }
}

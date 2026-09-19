package show.wsd.mod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class WSDFoodValues {
    public static final int BRIEF_DURATION = 600;    // 30 seconds
    public static final int SHORT_DURATION = 1200;    // 1 minute
    public static final int MEDIUM_DURATION = 3600;    // 3 minutes
    public static final int LONG_DURATION = 6000;    // 5 minutes
    public static final int SUPER_LONG_DURATION = 24000;    // 20 minutes

    // Feast Portions
    public static final FoodProperties STUFFED_TAINTED_PUMPKIN = new FoodProperties.Builder()
            .nutrition(16).saturationMod(1.4f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties STUFFED_COMMAND_BLOCK = new FoodProperties.Builder()
            .nutrition(22).saturationMod(1.4f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties STORM_DINNER = new FoodProperties.Builder()
            .nutrition(24).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties COOKED_ZOMBIE = new FoodProperties.Builder()
            .nutrition(13).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();

    public static final FoodProperties WITHER_BARBECUE = new FoodProperties.Builder()
            .nutrition(9).saturationMod(1.1f)
            .build();

    public static final FoodProperties STORM_POPSICLE = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.2f)
            .build();

    public static final FoodProperties STORM_SANDWICH = new FoodProperties.Builder()
            .nutrition(12).saturationMod(1f)
            .build();

    public static final FoodProperties EYES_PORRIDGE = new FoodProperties.Builder()
            .nutrition(10).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 1), 1.0F)
            .build();

    public static final FoodProperties FRIED_RICE = new FoodProperties.Builder()
            .nutrition(16).saturationMod(1f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 2.0F)
            .build();

    public static final FoodProperties COOKED_RICE = new FoodProperties.Builder()
            .nutrition(7).saturationMod(1f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 2.0F)
            .build();

    public static final FoodProperties SALAD = new FoodProperties.Builder()
            .nutrition(6).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), BRIEF_DURATION, 0), 2.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, MEDIUM_DURATION, 1), 1.0F)
            .build();

    public static final FoodProperties PIE_SLICE = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.5f)
            .build();

    public static final FoodProperties BIG_MAC_BURGER = new FoodProperties.Builder()
            .nutrition(10).saturationMod(1.2f)
            .build();
    public static final FoodProperties WITHERED_CABBAGE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.5f)
            .build();

    public static final FoodProperties WITHERED_TOMATO = new FoodProperties.Builder()
            .nutrition(2).saturationMod(0.4f)
            .build();

    public static final FoodProperties WITHERED_ONION = new FoodProperties.Builder()
            .nutrition(4).saturationMod(0.6f)
            .build();

    public static final FoodProperties WITHERED_BONE_BROTH = new FoodProperties.Builder()
            .nutrition(9).saturationMod(1f).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F)
            .meat()
            .build();

    public static final FoodProperties WITHERED_TOMATO_SAUCE = new FoodProperties.Builder()
            .nutrition(3).saturationMod(0.7f)
            .meat()
            .build();

    public static final FoodProperties GOLDEN_APPLE_STEW_LARGE_BOWL = new FoodProperties.Builder()
            .nutrition(10).saturationMod(1.3f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, LONG_DURATION, 1), 1.0F)
            .alwaysEat()
            .build();

    public static final FoodProperties WITHER_ROSE_PETAL_TEA = new FoodProperties.Builder()
            .effect(() -> new MobEffectInstance(MobEffects.WITHER, BRIEF_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, MEDIUM_DURATION, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 1), 1.0F)
            .alwaysEat()
            .build();
}

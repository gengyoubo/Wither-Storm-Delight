package show.wsd.mod.item;

import com.google.common.collect.Lists;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import vectorwing.farmersdelight.common.Configuration;
import vectorwing.farmersdelight.common.registry.ModEffects;

import javax.annotation.Nullable;
import java.util.List;

public class FormidifriedEgg extends Item {
    public static final List<MobEffectInstance> EFFECTS = Lists.newArrayList(
            new MobEffectInstance(ModEffects.NOURISHMENT.get(), 288000, 1));

    public FormidifriedEgg() {
        super(new Properties().stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(20).saturationMod(10f).alwaysEat().meat().build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        entity.addEffect(new MobEffectInstance(ModEffects.NOURISHMENT.get(), 288000, 1, false, true));
        return retval;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag isAdvanced) {
        if (!Configuration.ENABLE_FOOD_EFFECT_TOOLTIP.get()) {
            return;
        }

        for (MobEffectInstance effectInstance : EFFECTS) {
            MutableComponent effectDescription = Component.literal("");
            MutableComponent effectName = Component.translatable(effectInstance.getDescriptionId());
            effectDescription.append(effectName);
            MobEffect effect = effectInstance.getEffect();

            if (effectInstance.getAmplifier() > 0) {
                effectDescription.append(" ").append(Component.translatable("potion.potency." + effectInstance.getAmplifier()));
            }

            if (effectInstance.getDuration() > 20) {
                effectDescription.append(" (").append(MobEffectUtil.formatDuration(effectInstance, 1.0F)).append(")");
            }

            tooltip.add(effectDescription.withStyle(effect.getCategory().getTooltipFormatting()));
        }
    }
}

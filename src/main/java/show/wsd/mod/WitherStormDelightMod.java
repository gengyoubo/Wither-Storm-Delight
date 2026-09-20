package show.wsd.mod;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import show.wsd.mod.init.ModBlock;
import show.wsd.mod.init.ModItem;
import show.wsd.mod.init.ModParticleType;
import show.wsd.mod.init.ModTab;
import show.wsd.mod.util.AddValidBlockUtil;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;


@Mod(WitherStormDelightMod.MOD_ID)
@Mod.EventBusSubscriber(modid = WitherStormDelightMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WitherStormDelightMod {
    public static final String MOD_ID = "witherstorm_delight";
    public static final Rarity COMMAND = Rarity.create("COMMAND", ChatFormatting.RED);
    public static final Rarity SYMBIONT = Rarity.create("SYMBIONT", ChatFormatting.DARK_PURPLE);
    @SuppressWarnings("removal")
    public WitherStormDelightMod() {
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItem.ITEMS.register(modbus);
        ModTab.TABS.register(modbus);
        ModBlock.BLOCKS.register(modbus);
        ModParticleType.PARTICLE_TYPES.register(modbus);
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.STOVE.get(), ModBlock.WITHER_STOVE.get());
            AddValidBlockUtil.addBlock(ModBlockEntityTypes.COOKING_POT.get(), ModBlock.COMMAND_COOKING_POT.get());
        });
    }
}

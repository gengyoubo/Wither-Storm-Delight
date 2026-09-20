package show.wsd.mod;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import show.wsd.mod.client.WitherFlameParticle;
import show.wsd.mod.init.ModBlock;
import show.wsd.mod.init.ModItem;
import show.wsd.mod.init.ModOther;
import vectorwing.farmersdelight.common.registry.ModBlockEntityTypes;

import java.util.HashSet;
import java.util.Set;


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
        ModOther.TABS.register(modbus);
        ModBlock.BLOCKS.register(modbus);
        ModOther.PARTICLE_TYPES.register(modbus);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modbus.addListener(WitherStormDelightMod::registerParticles);
        }
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            addBlock(ModBlockEntityTypes.STOVE.get(), ModBlock.WITHER_STOVE.get());
            addBlock(ModBlockEntityTypes.COOKING_POT.get(), ModBlock.COMMAND_COOKING_POT.get());
        });
    }
    private static void addBlock(BlockEntityType<?> type, Block block) {
        Set<Block> set = new HashSet<>(type.validBlocks);
        set.add(block);
        type.validBlocks = set;
    }

    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModOther.WIRHER_FLAME.get(), WitherFlameParticle::provider);
    }
}

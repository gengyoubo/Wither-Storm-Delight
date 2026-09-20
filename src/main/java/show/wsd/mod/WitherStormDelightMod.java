package show.wsd.mod;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import show.wsd.mod.client.WitherFlameParticle;
import show.wsd.mod.init.ModBlock;
import show.wsd.mod.init.ModItem;
import show.wsd.mod.init.ModOther;
import vectorwing.farmersdelight.client.renderer.DefaultStoveRenderer;


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
        ModOther.BLOCK_ENTITY_TYPES.register(modbus);
        if (FMLEnvironment.dist == Dist.CLIENT) {
            modbus.addListener(WitherStormDelightMod::registerParticles);
            modbus.addListener(WitherStormDelightMod::registerRenderers);
        }
    }

    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModOther.WIRHER_FLAME.get(), WitherFlameParticle::provider);
    }

    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModOther.WITHER_STOVE_BE.get(), DefaultStoveRenderer::new);
    }
}

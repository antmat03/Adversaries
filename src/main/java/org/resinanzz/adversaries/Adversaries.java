package org.resinanzz.adversaries;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.util.Tuple;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.resinanzz.adversaries.client.PunchProjectileRenderer;
import org.resinanzz.adversaries.component.AdversariesModAttachments;
import org.resinanzz.adversaries.init.*;
import org.resinanzz.adversaries.particle.AdversariesModParticles;
import org.resinanzz.adversaries.particle.PunchParticle;
import org.slf4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

//import static com.example.aahjhff.init.ExampleModBlocks.POTION_BLOCK;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Adversaries.MOD_ID)
public class Adversaries
{
    public static Adversaries instance;
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "adversaries";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public Adversaries(IEventBus modEventBus, ModContainer modContainer)
    {
        instance = this;
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::registerNetworking);
        NeoForge.EVENT_BUS.register(this);
        // Register the Deferred Register to the mod event bus so blocks get registered
        AdversariesModBlocks.REGISTRY.register(modEventBus);
        AdversariesModItems.REGISTRY.register(modEventBus);
        AdversariesModTabs.REGISTRY.register(modEventBus);
        AdversariesModEntities.REGISTRY.register(modEventBus);
        AdversariesModSounds.REGISTRY.register(modEventBus);
        AdversariesModParticles.REGISTRY.register(modEventBus);
        AdversariesModAttachments.REGISTRY.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

    }

    private static boolean networkingRegistered = false;
    private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

    private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
    }
    public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
        if (networkingRegistered)
            throw new IllegalStateException("Cannot register new network messages after networking has been registered");
        MESSAGES.put(id, new NetworkMessage<>(reader, handler));
    }


    @SuppressWarnings({"rawtypes", "unchecked", "rawtypes", "unchecked"})
    private void registerNetworking(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(MOD_ID);
        MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
        networkingRegistered = true;
    }

    private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new Tuple<>(action, tick));
    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            EntityRenderers.register(AdversariesModEntities.PUNCH_PROJECTILE.get(), PunchProjectileRenderer::new);
        }
        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event){
            event.registerSpriteSet(AdversariesModParticles.PUNCH_PARTICLE.get(), PunchParticle.Provider::new);

        }
    }
    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setB(work.getB() - 1);
            if (work.getB() == 0)
                actions.add(work);
        });
        actions.forEach(e -> e.getA().run());
        workQueue.removeAll(actions);


    }




}

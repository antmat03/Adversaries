package org.resinanzz.adversaries.event;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.client.magicRenderers.PunchProjectileRenderer;
import org.resinanzz.adversaries.init.AdversariesModEntities;
import org.resinanzz.adversaries.particle.AdversariesModParticles;
import org.resinanzz.adversaries.particle.PunchParticle;
import org.slf4j.Logger;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModClientEvent {
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event)
    {
        LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());


        EntityRenderers.register(AdversariesModEntities.PUNCH_PROJECTILE.get(), PunchProjectileRenderer::new);
    }
    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event){
        event.registerSpriteSet(AdversariesModParticles.PUNCH_PARTICLE.get(), PunchParticle.Provider::new);

    }
}

package org.resinanzz.adversaries.init;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.resinanzz.adversaries.client.AngelEntityRenderer;
import org.resinanzz.adversaries.client.OverworldChampionRenderer;
import org.resinanzz.adversaries.client.PunchProjectileRenderer;
import org.resinanzz.adversaries.client.ElfEntityRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class AdversariesModRenderers {


    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AdversariesModEntities.OVERWORLD_CHAMPION.get(), OverworldChampionRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.ANGEL.get(), AngelEntityRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.WIZARD_ELF.get(), ElfEntityRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.PUNCH_PROJECTILE.get(), PunchProjectileRenderer::new);
    }

}

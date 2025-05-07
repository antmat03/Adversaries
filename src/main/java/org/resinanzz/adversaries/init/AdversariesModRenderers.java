package org.resinanzz.adversaries.init;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import org.resinanzz.adversaries.client.AngelEntityRenderer;
import org.resinanzz.adversaries.client.OverworldChampionRenderer;
import org.resinanzz.adversaries.client.PunchProjectileRenderer;
import org.resinanzz.adversaries.client.WizardEntityRenderer;

import java.awt.*;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class AdversariesModRenderers {


    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AdversariesModEntities.OVERWORLD_CHAMPION.get(), OverworldChampionRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.ANGEL.get(), AngelEntityRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.WIZARD.get(), WizardEntityRenderer::new);
        event.registerEntityRenderer(AdversariesModEntities.PUNCH_PROJECTILE.get(), PunchProjectileRenderer::new);
    }

}

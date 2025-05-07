package org.resinanzz.adversaries.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.client.models.PunchProjectileModel;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(PunchProjectileModel.LAYER_LOCATION, PunchProjectileModel::createBodyLayer);


    }
}

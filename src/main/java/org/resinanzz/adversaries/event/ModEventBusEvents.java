package org.resinanzz.adversaries.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.client.models.PunchProjectileModel;
import org.resinanzz.adversaries.entity.*;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(PunchProjectileModel.LAYER_LOCATION, PunchProjectileModel::createBodyLayer);
    }
    @SubscribeEvent
    public static void init(RegisterSpawnPlacementsEvent event) {
        OverworldChampionEntity.init(event);
        AngelEntity.init(event);
        PunchProjectileEntity.init(event);
        WizardElfEntity.init(event);
        PrisonerEntity.init(event);
    }
}

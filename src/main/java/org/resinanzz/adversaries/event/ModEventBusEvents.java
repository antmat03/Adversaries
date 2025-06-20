package org.resinanzz.adversaries.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.client.models.PunchProjectileModel;
import org.resinanzz.adversaries.entity.*;
import org.resinanzz.adversaries.entity.projectileEntity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModEntities;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(PunchProjectileModel.LAYER_LOCATION, PunchProjectileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(AdversariesModEntities.OVERWORLD_CHAMPION.get(), OverworldChampionEntity.createAttributes().build());
        event.put(AdversariesModEntities.ANGEL.get(), AngelEntity.createAttributes().build());
        event.put(AdversariesModEntities.WIZARD_ELF.get(), WizardElfEntity.createAttributes().build());
        event.put(AdversariesModEntities.PRISONER.get(), PrisonerEntity.createAttributes().build());
        event.put(AdversariesModEntities.DEER.get(), DeerEntity.createAttributes().build());
    }
    @SubscribeEvent
    public static void init(RegisterSpawnPlacementsEvent event) {
        OverworldChampionEntity.init(event);
        PunchProjectileEntity.init(event);
        WizardElfEntity.init(event);
        event.register(AdversariesModEntities.DEER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        event.register(AdversariesModEntities.PRISONER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Monster::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }
}
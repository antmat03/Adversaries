package org.resinanzz.adversaries.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.entity.*;
import oshi.jna.platform.mac.SystemB;

public class AdversariesModEntities {
    public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, Adversaries.MOD_ID);
    public static final DeferredHolder<EntityType<?>, EntityType<OverworldChampionEntity>> OVERWORLD_CHAMPION = register("overworld_champion",
            EntityType.Builder.<OverworldChampionEntity>of(OverworldChampionEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

                    .sized(0.8f, 2.3f));
    public static final DeferredHolder<EntityType<?>, EntityType<AngelEntity>> ANGEL = register("angel_adv", EntityType.Builder.<AngelEntity>of(AngelEntity::new, MobCategory.CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(15)
            .setUpdateInterval(3)
            .sized(0.8f, 2f));

    public static final DeferredHolder<EntityType<?>, EntityType<WizardElfEntity>> WIZARD_ELF = register("wizard_elf_adv", EntityType.Builder.<WizardElfEntity>of(WizardElfEntity::new, MobCategory.CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(15)
            .setUpdateInterval(3)
            .sized(0.7f, 1.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<PrisonerEntity>> PRISONER = register("prisoner", EntityType.Builder.<PrisonerEntity>of(PrisonerEntity::new, MobCategory.CREATURE)
            .setShouldReceiveVelocityUpdates(true)
            .setTrackingRange(15)
            .setUpdateInterval(3)
            .sized(0.7f, 1.4f));
    public static final DeferredHolder<EntityType<?>, EntityType<PunchProjectileEntity>> PUNCH_PROJECTILE = register("punch_projectile", EntityType.Builder.<PunchProjectileEntity>of(PunchProjectileEntity::new, MobCategory.MISC)
            .sized(1.2f, 1.2f));


    // Start of user code block custom entity
    // End of user code block custom entity
    private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
        return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
    }

}


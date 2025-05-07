package org.resinanzz.adversaries.procedures;

import net.minecraft.world.entity.Entity;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import org.resinanzz.adversaries.entity.OverworldChampionEntity;

import javax.annotation.Nullable;

@EventBusSubscriber
public class InitialEntSpawnProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof OverworldChampionEntity) {
			entity.getPersistentData().putBoolean("aggro", false);
		}
	}
}

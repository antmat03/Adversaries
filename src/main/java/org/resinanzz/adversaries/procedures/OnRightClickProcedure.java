package org.resinanzz.adversaries.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.Event;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import org.resinanzz.adversaries.init.AdversariesModItems;

import javax.annotation.Nullable;

@EventBusSubscriber
public class OnRightClickProcedure {
	@SubscribeEvent
	public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getTarget(), event.getEntity());
	}

	public static void execute(Level world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Level world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		//dialogue only works when aggro is false
		double rand = 0;
		boolean isAggro = entity.getPersistentData().getBoolean("aggro");

		//check if source entity has a soul stone, then set aggro to true if it does. and disables dialogue when true
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == AdversariesModItems.WRITTEN_CONTRACT.get()) {
			entity.getPersistentData().putBoolean("aggro", true);

			if (sourceentity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Champion: This may be your last battle."), false);
			PunchVolley.doVolley(world, (LivingEntity) entity, world.getRandom(), 1, 2, 0d, 1f, 1.3f, 50);

			if (sourceentity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);

		}
	}
}

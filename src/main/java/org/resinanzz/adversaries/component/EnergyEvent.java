package org.resinanzz.adversaries.component;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;

import org.resinanzz.adversaries.init.AdversariesModItems;


@EventBusSubscriber
public class EnergyEvent {

    @SubscribeEvent
    static void gamemodeEvent(PlayerEvent.PlayerChangeGameModeEvent event){
        if(event.getEntity().level().isClientSide){return;}
        Player player = event.getEntity();
        player.getPersistentData().putBoolean("isPlayerCreative", player.isCreative());
    }


}

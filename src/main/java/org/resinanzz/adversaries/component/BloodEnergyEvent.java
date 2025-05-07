package org.resinanzz.adversaries.component;

import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.resinanzz.adversaries.init.AdversariesModItems;

@EventBusSubscriber
public class BloodEnergyEvent {
    @SubscribeEvent
    public static void onEntityEat(LivingEntityUseItemEvent.Finish event){
        if(event.getEntity().level().isClientSide) return;
        Player player = (Player)event.getEntity();

        if(event.getItem().is(AdversariesModItems.PURIFIED_FLESH.get())){
            EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
        }
    }
}

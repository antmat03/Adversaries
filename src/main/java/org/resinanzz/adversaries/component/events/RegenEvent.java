package org.resinanzz.adversaries.component.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.init.AdversariesModAttachments;
import org.resinanzz.adversaries.init.AdversariesModItems;

public class RegenEvent {
   public static void Food(LivingEntityUseItemEvent.Finish event){
       Player player = (Player)event.getEntity();
       ItemStack item = event.getItem();

       if(item.is(AdversariesModItems.PURIFIED_FLESH.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
       }
       else if(item.is(AdversariesModItems.GLOWSTONE_CORE.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.PHOSPHENE_ENERGY, AdversariesModAttachments.PHOSPHENE_ENERGY_LIMIT);

       }else if(item.is(AdversariesModItems.DWELLER_HEART.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.NEBULOUS_ENERGY, AdversariesModAttachments.NEBULOUS_ENERGY_LIMIT);

       }else if(item.is(AdversariesModItems.EIK_FAT.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.FAYE_ENERGY, AdversariesModAttachments.FAYE_ENERGY_LIMIT);

       }
   }
}

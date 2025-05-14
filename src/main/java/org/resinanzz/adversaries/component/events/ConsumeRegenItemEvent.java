package org.resinanzz.adversaries.component.events;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.resinanzz.adversaries.component.AdversariesModAttachments;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.init.AdversariesModItems;

public class ConsumeRegenItemEvent {
   public static void Food(LivingEntityUseItemEvent.Finish event){
       Player player = (Player)event.getEntity();
       ItemStack item = event.getItem();

       if(item.is(AdversariesModItems.PURIFIED_FLESH.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
       }
       if(item.is(AdversariesModItems.GLOWSTONE_CORE.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.PHOSPHENE_ENERGY, AdversariesModAttachments.PHOSPHENE_ENERGY_LIMIT);

       }
   }
}

package org.resinanzz.adversaries.event;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.init.AdversariesModAttachments;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.init.AdversariesModItems;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.GAME)

public class EntityEvent {
    @SubscribeEvent
    public static void entityDeathEvent(LivingDeathEvent event){
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();
        Player player = (Player) source.getEntity();
        if(entity.level().isClientSide)return;
        assert player != null;
        if(player.getInventory().contains(AdversariesModItems.TOTEM_OF_FLESH.toStack())){
            if(entity instanceof LivingEntity){
                EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
            } else if (entity instanceof Monster) {
                EnergyHandler.addEnergy(player, 2, AdversariesModAttachments.NEBULOUS_ENERGY, AdversariesModAttachments.NEBULOUS_ENERGY_LIMIT);
            }
        }else if (player.getInventory().contains(AdversariesModItems.GAUNTLET_OF_RAGE.toStack())){

        }
    }
}

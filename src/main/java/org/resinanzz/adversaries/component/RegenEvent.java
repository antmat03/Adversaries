package org.resinanzz.adversaries.component;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import org.resinanzz.adversaries.init.AdversariesModAttachments;
import org.resinanzz.adversaries.init.AdversariesModItems;

public class RegenEvent {


   public static void Food(LivingEntityUseItemEvent.Finish event){
       Player player = (Player)event.getEntity();
       ItemStack item = event.getItem();

       if(item.is(AdversariesModItems.PURIFIED_FLESH.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.BLOOD_ENERGY);
           doRedeemEnergyParticles(event);
       }
       else if(item.is(AdversariesModItems.GLOWSTONE_CORE.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.PHOSPHENE_ENERGY);
           doRedeemEnergyParticles(event);
       }else if(item.is(AdversariesModItems.DWELLER_HEART.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.NEBULOUS_ENERGY);
           doRedeemEnergyParticles(event);
       }else if(item.is(AdversariesModItems.EIK_FAT.get()) || item.is(AdversariesModItems.ENCHANTED_TALLOW.get())){
           EnergyHandler.addEnergy(player, 5, AdversariesModAttachments.FAYE_ENERGY);
           doRedeemEnergyParticles(event);
       }
   }
   public static void doRedeemEnergyParticles(LivingEntityUseItemEvent.Finish event){
       Player player = (Player)event.getEntity();
       player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
               BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:magic_start")),
               SoundSource.PLAYERS, 0.3f , 1);
       ((ServerLevel)player.level()).sendParticles(ParticleTypes.END_ROD,player.getX()  ,player.getY() ,player.getZ() , 20, 0.5,0.6,0.5, 0);
   }
}

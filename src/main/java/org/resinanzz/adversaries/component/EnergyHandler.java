package org.resinanzz.adversaries.component;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.attachment.AttachmentType;
import org.resinanzz.adversaries.init.AdversariesModAttachments;
import org.resinanzz.adversaries.init.AdversariesModItems;

import java.util.function.Supplier;

public class EnergyHandler {
    public static Supplier<AttachmentType<Integer>> getLimitType(Supplier<AttachmentType<Integer>> type) {
        if (type == AdversariesModAttachments.FAYE_ENERGY) {
            return AdversariesModAttachments.FAYE_ENERGY_LIMIT;
        } else if (type == AdversariesModAttachments.BLOOD_ENERGY) {
            return AdversariesModAttachments.BLOOD_ENERGY_LIMIT;
        } else if (type == AdversariesModAttachments.PHOSPHENE_ENERGY) {
            return AdversariesModAttachments.PHOSPHENE_ENERGY_LIMIT;
        } else if (type == AdversariesModAttachments.NEBULOUS_ENERGY) {
            return AdversariesModAttachments.NEBULOUS_ENERGY_LIMIT;
        }
        return null;
    }
    public static Supplier<AttachmentType<Integer>> getEnergyType(ItemStack item){
        if(item.is(AdversariesModItems.REACTIVE_STRIP)){
            return AdversariesModAttachments.BLOOD_ENERGY;
        }else if(item.is(AdversariesModItems.ELECTROCHROMALOG)){
            return AdversariesModAttachments.PHOSPHENE_ENERGY;
        }else if(item.is(AdversariesModItems.GRADUATED_DREAM_CATCHER)){
            return AdversariesModAttachments.FAYE_ENERGY;
        }else if(item.is(AdversariesModItems.BRAIN_SCANNER)){
            return AdversariesModAttachments.NEBULOUS_ENERGY;
        }
        return null;
    }
    public static int getCurrentEnergy(LivingEntity entity, Supplier<AttachmentType<Integer>> type){
        if(entity.level().isClientSide || !(entity instanceof Player))return entity.getData(type);
        return 0;
    }

    public static void setEnergy(LivingEntity entity, int newEnergy, Supplier<AttachmentType<Integer>> type) {
        if(entity.level().isClientSide || !(entity instanceof Player))return;
        int limit = entity.getData(getLimitType(type));
        newEnergy = Mth.clamp(newEnergy, 0, limit);
        entity.setData(type, newEnergy);
    }

    public static void addEnergy(LivingEntity entity, int amount, Supplier<AttachmentType<Integer>> type){
        if(!(entity instanceof Player))return;
        int energy = entity.getData(type);
        setEnergy(entity, energy + amount, type);
    }
    public static void setEnergyLimit(LivingEntity entity, int newLimit, Supplier<AttachmentType<Integer>> typeLimit){
        if(entity.level().isClientSide || !(entity instanceof Player))return;
        newLimit = Mth.clamp(newLimit, 0, newLimit);
        entity.setData(typeLimit, newLimit);
    }
    public static void addEnergyLimit(Player player, int amount, Supplier<AttachmentType<Integer>> typeLimit){
        int limit = player.getData(typeLimit);
        setEnergyLimit(player, limit + amount, typeLimit);
    }
    public static void resetAllEnergy(Player player){
        player.setData(AdversariesModAttachments.BLOOD_ENERGY, 0);
        player.setData(AdversariesModAttachments.NEBULOUS_ENERGY, 0);
        player.setData(AdversariesModAttachments.PHOSPHENE_ENERGY, 0);
        player.setData(AdversariesModAttachments.FAYE_ENERGY, 0);
    }
    public static void addLevel(Player player,Supplier<AttachmentType<Integer>> type){
        player.setData(type, player.getData(type) + 1);
    }
}

package org.resinanzz.adversaries.component;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.AttachmentType;

import java.util.function.Supplier;

public abstract class EnergyHandler {
    public final Player player;
    public EnergyHandler(Player player){
        this.player = player;
    }

    public static void setEnergy(Player player, int newEnergy, Supplier<AttachmentType<Integer>> type, Supplier<AttachmentType<Integer>> typeLimit) {
        if(player.level().isClientSide){return;}
        int energy = player.getData(type);
        int limit = player.getData(typeLimit);
        newEnergy = Mth.clamp(newEnergy, 0, limit);
        player.setData(type, newEnergy);
    }

    public static void addEnergy(Player player, int amount, Supplier<AttachmentType<Integer>> type, Supplier<AttachmentType<Integer>> typeLimit){
        int energy = player.getData(type);
        setEnergy(player, energy + amount, type, typeLimit);
    }
    public static void setEnergyLimit(Player player, int newLimit, Supplier<AttachmentType<Integer>> typeLimit){
        if(player.level().isClientSide){return;}
        newLimit = Mth.clamp(newLimit, 0, newLimit);
        player.setData(typeLimit, newLimit);
    }
}

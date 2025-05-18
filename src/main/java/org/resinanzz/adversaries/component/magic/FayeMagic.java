package org.resinanzz.adversaries.component.magic;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

public class FayeMagic {
    private int energy;
    private int limit;

    public FayeMagic(Player player){
        this.energy = player.getData(AdversariesModAttachments.FAYE_ENERGY);
        this.limit = player.getData(AdversariesModAttachments.FAYE_ENERGY_LIMIT);
    }
    public static void fayeHeal(Player player, int modifier){
        player.addEffect(new MobEffectInstance(MobEffects.HEAL, 1, 2));
    }
}

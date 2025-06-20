package org.resinanzz.adversaries.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

public class WoodWandItem extends Item {
    public WoodWandItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        int energy = player.getData(AdversariesModAttachments.FAYE_ENERGY);
        if(energy >= 2){
            // ((ServerLevel)player.level()).sendParticles(ParticleTypes.EXPLOSION,player.getX(),player.getY() ,player.getZ() , 1, 0.4,0.4,0.4, 0);
            EnergyHandler.addEnergy(player, -2, AdversariesModAttachments.FAYE_ENERGY);
            player.getCooldowns().addCooldown(this, 10);
            player.swing(hand);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}

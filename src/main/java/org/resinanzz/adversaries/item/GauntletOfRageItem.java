package org.resinanzz.adversaries.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.EnergyHandler;

import org.resinanzz.adversaries.entity.projectileEntity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

public class GauntletOfRageItem extends SwordItem {
    public GauntletOfRageItem() {
        super(Tiers.NETHERITE,new Item.Properties().rarity(Rarity.RARE).fireResistant().durability(2000).attributes(SwordItem.createAttributes(Tiers.NETHERITE, 3, -2.8f)));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        int energy = EnergyHandler.getCurrentEnergy(player, AdversariesModAttachments.BLOOD_ENERGY);
            if(energy >= 5 && !player.isCrouching()){
                // ((ServerLevel)player.level()).sendParticles(ParticleTypes.EXPLOSION,player.getX(),player.getY() ,player.getZ() , 1, 0.4,0.4,0.4, 0);
                PunchProjectileEntity.shoot(player, 1, 4, 1d, 1f, 1,0);
                //EnergyHandler.addEnergy(player,-5, AdversariesModAttachments.BLOOD_ENERGY);
                player.getCooldowns().addCooldown(this, 7);
                player.swing(hand);
            }
            if(energy >= 0 && player.isCrouching()){
                //EnergyHandler.addEnergy(player, -50, AdversariesModAttachments.BLOOD_ENERGY);
                //level.playSound(player, player.getX(), player.getY(), player.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:monster_growl")), SoundSource.PLAYERS, (float) (1.3-0.9f), 1f);
                PunchProjectileEntity.chainVolley(player, 1, 2, 0d, 1f, 1.3f, 10, 2,0);
                player.swing(hand);
            }
        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}

package org.resinanzz.adversaries.item;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.component.magic.BloodMagic;
import org.resinanzz.adversaries.entity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

public class GauntletOfRageItem extends Item {
    public GauntletOfRageItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.RARE));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        int energy = player.getData(AdversariesModAttachments.BLOOD_ENERGY);
            if(energy >= 5){
                if (!player.isCrouching()) {
                   // ((ServerLevel)player.level()).sendParticles(ParticleTypes.EXPLOSION,player.getX(),player.getY() ,player.getZ() , 1, 0.4,0.4,0.4, 0);
                    PunchProjectileEntity.shoot(level, player, level.getRandom(), 1, 2, 0d, 1f, 1);
                    EnergyHandler.addEnergy(player, -5, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
                    player.getCooldowns().addCooldown(this, 7);
                    player.swing(hand);
                }
            }
            if(energy >= 50 && player.isCrouching()){
                EnergyHandler.addEnergy(player, -50, AdversariesModAttachments.BLOOD_ENERGY, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
                BloodMagic.doVolley(level, player, level.getRandom(), 1, 2, 0d, 1f, 1.3f, 50);
                level.playSound(player, player.getX(), player.getY(), player.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:monster_growl")), SoundSource.PLAYERS, (float) (1.3-0.9f), 1f);
                player.swing(hand);
            }

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
}

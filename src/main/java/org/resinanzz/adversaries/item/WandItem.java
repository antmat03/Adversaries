package org.resinanzz.adversaries.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.entity.projectileEntity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

import java.sql.SQLOutput;

public class WandItem extends Item {
    public WandItem() {super(new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(SwordItem.createAttributes(Tiers.DIAMOND, 100, -2.8F)));}
    CompoundTag mode = new CompoundTag();
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(player.level().isClientSide){
            if(player.isCrouching()){
                switchMode(mode);
                switch (mode.getInt("mode")){
                    case 0:
                        player.displayClientMessage(Component.literal("mode: none"), true);
                        break;
                    case 1:
                        player.displayClientMessage(Component.literal("mode: upgrade blood"), true);
                        break;
                    case 2:
                        player.displayClientMessage(Component.literal("mode: upgrade faye"), true);
                        break;
                    case 3:
                        player.displayClientMessage(Component.literal("mode: upgrade phosphene"), true);
                        break;
                    case 4:
                        player.displayClientMessage(Component.literal("mode: upgrade nebula"), true);
                        break;
                }
                //System.out.println(mode.getInt("mode"));
            }else{
                switch (mode.getInt("mode")){
                    default:
                        break;
                    case 1:
                        EnergyHandler.addLevel(player, AdversariesModAttachments.BLOOD_ENERGY_UPGRADE);
                        System.out.println(player.getData(AdversariesModAttachments.BLOOD_ENERGY_UPGRADE));
                        break;
                    case 2:
                        EnergyHandler.addLevel(player, AdversariesModAttachments.FAYE_ENERGY_UPGRADE);
                        break;
                    case 3:
                        EnergyHandler.addLevel(player, AdversariesModAttachments.PHOSPHENE_ENERGY_UPGRADE);
                        break;
                    case 4:
                        EnergyHandler.addLevel(player, AdversariesModAttachments.NEBULOUS_ENERGY_UPGRADE);
                        break;
                }

            }
            player.swing(hand);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }
    public void switchMode(CompoundTag prevMode){
        mode.putInt("mode", prevMode.getInt("mode") + 1);
        if(mode.getInt("mode") == 5){
            mode.putInt("mode", 0);
        }
    }
}

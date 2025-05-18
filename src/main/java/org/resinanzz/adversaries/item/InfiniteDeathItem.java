package org.resinanzz.adversaries.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.init.AdversariesModAttachments;

public class InfiniteDeathItem extends AbstractTalismanItem{
    public InfiniteDeathItem() {
        super(new Properties().rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        super.use(level, player, hand);
        ItemStack itemstack = player.getItemInHand(hand);

        EnergyHandler.setEnergyLimit(player, 10000, AdversariesModAttachments.BLOOD_ENERGY_LIMIT);
        return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
    }


}

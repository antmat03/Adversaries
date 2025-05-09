package org.resinanzz.adversaries.item;

import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.component.AdversariesModAttachments;
import org.resinanzz.adversaries.component.EnergyHandler;
import org.resinanzz.adversaries.entity.PunchProjectileEntity;
import org.resinanzz.adversaries.procedures.PunchVolley;

public class WandItem extends Item {
    public WandItem() {super(new Properties().stacksTo(1).rarity(Rarity.COMMON));}

}

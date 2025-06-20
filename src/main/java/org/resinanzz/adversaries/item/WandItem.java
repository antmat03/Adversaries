package org.resinanzz.adversaries.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;

public class WandItem extends Item {
    public WandItem() {super(new Properties().stacksTo(1).rarity(Rarity.COMMON).attributes(SwordItem.createAttributes(Tiers.DIAMOND, 100, -2.8F)));}

}

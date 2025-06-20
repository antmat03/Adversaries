package org.resinanzz.adversaries.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class DaggerItem extends Item {
    public DaggerItem() {
        super(new Properties().stacksTo(1).rarity(Rarity.COMMON));
    }
}

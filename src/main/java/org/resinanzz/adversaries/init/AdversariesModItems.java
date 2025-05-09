package org.resinanzz.adversaries.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.item.*;



public class AdversariesModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(Adversaries.MOD_ID);
    public static final DeferredItem<Item> OVERWORLD_CHAMPION_SPAWN_EGG = REGISTRY.register("overworld_champion_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.OVERWORLD_CHAMPION, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> ANGEL_SPAWN_EGG = REGISTRY.register("angel_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.ANGEL, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> WIZARD_SPAWN_EGG = REGISTRY.register("wizard_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.WIZARD, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> SOUL_STONE = REGISTRY.register("soul_stone", SoulStoneItem::new);
    public static final DeferredItem<Item> WRITTEN_CONTRACT = REGISTRY.register("written_contract", WrittenContractItem::new);
    public static final DeferredItem<Item> SCROLL = REGISTRY.register("scroll", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> ADVERSARIES_WAND = REGISTRY.register("adversaries_wand", WandItem::new);
    public static final DeferredItem<Item> WARBRAND = REGISTRY.register("warbrand", () -> new SwordItem(Tiers.IRON,new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 3, -1.4F))));
    public static final DeferredItem<Item> REACTIVE_STRIP = REGISTRY.register("reactive_strip", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> LAMBDAMETER = REGISTRY.register("lambdameter", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GAUNTLET_OF_RAGE = REGISTRY.register("gauntlet", GauntletOfRageItem::new);
    public static final DeferredItem<Item> SKULL = REGISTRY.register("skull", SkullItem::new);
    public static final DeferredItem<Item> RAW_DEMON_BLOOD = REGISTRY.register("raw_demon_blood", DemonBloodOreItem::new);
    public static final DeferredItem<Item> CELESTRIUM_INGOT = REGISTRY.register("celestrium_ingot", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> CRUCIBLE_STEEL_INGOT = REGISTRY.register("crucible_steel_ingot", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> FIRE_SIGIL = REGISTRY.register("fire_sigil", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> INFINITE_DEATH = REGISTRY.register("infinite_death", InfiniteDeathItem::new);
    public static final DeferredItem<Item> PURIFIED_FLESH = REGISTRY.register("purified_flesh", ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).alwaysEdible().saturationModifier(0).fast().build()).stacksTo(64)));
    public static final DeferredItem<Item> POTION_BLOCK = block(AdversariesModBlocks.POTION_BLOCK);
    public static final DeferredItem<Item> DEMON_BLOOD_ORE = block(AdversariesModBlocks.DEMON_BLOOD_ORE);
    private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}

package org.resinanzz.adversaries.init;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.item.*;



public class AdversariesModItems {
    public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(Adversaries.MOD_ID);
    //materials
    public static final DeferredItem<Item> SCROLL = REGISTRY.register("scroll", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> CELESTRIUM_INGOT = REGISTRY.register("celestrium_ingot", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> CRUCIBLE_STEEL_INGOT = REGISTRY.register("crucible_steel_ingot", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> RAW_DEMON_BLOOD = REGISTRY.register("raw_demon_blood", DemonBloodOreItem::new);
    public static final DeferredItem<Item> SKULL = REGISTRY.register("ancient_skull", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> ANCIENT_ASH = REGISTRY.register("ancient_ash", ()-> new Item(new Item.Properties().stacksTo(64)));

    //tools
    public static final DeferredItem<Item> SOUL_STONE = REGISTRY.register("soul_stone", SoulStoneItem::new);
    public static final DeferredItem<Item> WRITTEN_CONTRACT = REGISTRY.register("written_contract", WrittenContractItem::new);
    public static final DeferredItem<Item> DEBUG_WAND = REGISTRY.register("debug_wand", WandItem::new);
    public static final DeferredItem<Item> LAMBDAMETER = REGISTRY.register("lambdameter", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> REACTIVE_STRIP = REGISTRY.register("reactive_strip", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> GRADUATED_DREAM_CATCHER = REGISTRY.register("graduated_dream_catcher", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> ELECTROCHROMALOG = REGISTRY.register("electrochromalog", ()-> new Item(new Item.Properties().stacksTo(1)));
    public static final DeferredItem<Item> BRAIN_SCANNER = REGISTRY.register("brain_scanner", ()-> new Item(new Item.Properties().stacksTo(1)));
        //TODO make SHACKLES do more knockback but mid damage
    public static final DeferredItem<Item> SHACKLES = REGISTRY.register("shackles", () -> new SwordItem(Tiers.IRON,new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 2, -1.5F))));
    public static final DeferredItem<Item> GAUNTLET_OF_RAGE = REGISTRY.register("gauntlet", GauntletOfRageItem::new);
    public static final DeferredItem<Item> WARBRAND = REGISTRY.register("warbrand", () -> new SwordItem(Tiers.IRON,new Item.Properties().attributes(SwordItem.createAttributes(Tiers.IRON, 3, -1.8F))));
    public static final DeferredItem<Item> TOTEM_OF_FLESH = REGISTRY.register("totem_of_flesh", SoulStoneItem::new);
    public static final DeferredItem<Item> WOOD_WAND = REGISTRY.register("wood_wand", SoulStoneItem::new);
    public static final DeferredItem<Item> RUNE_SLATE = REGISTRY.register("rune_slate", SoulStoneItem::new);
    public static final DeferredItem<Item> COPPER_WAND = REGISTRY.register("copper_tipped_wand", SoulStoneItem::new);
    //armor
    //blockitems
    public static final DeferredItem<Item> POTION_BLOCK = block(AdversariesModBlocks.POTION_BLOCK);
    public static final DeferredItem<Item> DEMON_BLOOD_ORE = block(AdversariesModBlocks.DEMON_BLOOD_ORE);

    //spawneggs
    public static final DeferredItem<Item> OVERWORLD_CHAMPION_SPAWN_EGG = REGISTRY.register("overworld_champion_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.OVERWORLD_CHAMPION, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> ANGEL_SPAWN_EGG = REGISTRY.register("angel_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.ANGEL, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> WIZARD_ELF_SPAWN_EGG = REGISTRY.register("wizard_elf_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.WIZARD_ELF, -16777216, -10092544, new Item.Properties()));
    public static final DeferredItem<Item> PRISONER_SPAWN_EGG = REGISTRY.register("prisoner_spawn_egg", () -> new DeferredSpawnEggItem(AdversariesModEntities.PRISONER, -16777216, -10092544, new Item.Properties()));
    //runes
    public static final DeferredItem<Item> FIRE_SIGIL = REGISTRY.register("fire_sigil", ()-> new Item(new Item.Properties().stacksTo(64)));
    public static final DeferredItem<Item> INFINITE_DEATH = REGISTRY.register("infinite_death", InfiniteDeathItem::new);

    //food
    public static final DeferredItem<Item> PURIFIED_FLESH = REGISTRY.register("purified_flesh", ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).alwaysEdible().saturationModifier(0).fast().build()).stacksTo(64)));
    public static final DeferredItem<Item> EIK_FAT = REGISTRY.register("eik_fat", ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).alwaysEdible().saturationModifier(0).fast().build()).stacksTo(64)));
    public static final DeferredItem<Item> DWELLER_HEART = REGISTRY.register("dweller_heart", ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).alwaysEdible().saturationModifier(0).fast().build()).stacksTo(64)));
    public static final DeferredItem<Item> GLOWSTONE_CORE = REGISTRY.register("glowstone_core", ()-> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(0).alwaysEdible().saturationModifier(0).fast().build()).stacksTo(64)));
    private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
    }
}

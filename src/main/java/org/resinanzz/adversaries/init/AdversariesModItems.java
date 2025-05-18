package org.resinanzz.adversaries.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.item.*;
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)



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
    public static final DeferredItem<Item> DEMONBLOOD_CHEST = REGISTRY.register("demonblood_plate", () -> new ArmorItem(ArmorMaterials.IRON, ArmorItem.Type.CHESTPLATE,  new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(23))));
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

    public static final DeferredRegister<CreativeModeTab> TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Adversaries.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVERSARIES = TAB_REGISTRY.register("adversaries",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.adversaries.adversaries")).icon(() -> new ItemStack(AdversariesModItems.SOUL_STONE.get())).displayItems((parameters, tabData) -> {
                //debug
                tabData.accept(AdversariesModItems.DEBUG_WAND.get());
                //materials
                tabData.accept(AdversariesModItems.RAW_DEMON_BLOOD.get());
                tabData.accept(AdversariesModItems.ANCIENT_ASH.get());
                tabData.accept(AdversariesModItems.SOUL_STONE.get());
                tabData.accept(AdversariesModItems.SKULL.get());
                tabData.accept(AdversariesModItems.SCROLL.get());
                tabData.accept(AdversariesModItems.WRITTEN_CONTRACT.get());
                //foods
                tabData.accept(AdversariesModItems.PURIFIED_FLESH.get());
                tabData.accept(AdversariesModItems.DWELLER_HEART.get());
                tabData.accept(AdversariesModItems.EIK_FAT.get());
                tabData.accept(AdversariesModItems.GLOWSTONE_CORE.get());
                //ingots
                tabData.accept(AdversariesModBlocks.POTION_BLOCK.get().asItem());
                tabData.accept(AdversariesModBlocks.DEMON_BLOOD_ORE.get().asItem());
                tabData.accept(AdversariesModItems.CRUCIBLE_STEEL_INGOT.get());
                tabData.accept(AdversariesModItems.CELESTRIUM_INGOT.get());
                //spawn eggs
                tabData.accept(AdversariesModItems.OVERWORLD_CHAMPION_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.ANGEL_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.WIZARD_ELF_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.PRISONER_SPAWN_EGG.get());
                //scanners
                tabData.accept(AdversariesModItems.REACTIVE_STRIP.get());
                tabData.accept(AdversariesModItems.GRADUATED_DREAM_CATCHER.get());
                tabData.accept(AdversariesModItems.ELECTROCHROMALOG.get());
                tabData.accept(AdversariesModItems.BRAIN_SCANNER.get());
                tabData.accept(AdversariesModItems.LAMBDAMETER.get());
                //talismans
                tabData.accept(AdversariesModItems.FIRE_SIGIL.get());
                tabData.accept(AdversariesModItems.TOTEM_OF_FLESH.get());
                tabData.accept(AdversariesModItems.INFINITE_DEATH.get());
                //weapons
                tabData.accept(AdversariesModItems.WARBRAND.get());
                tabData.accept(AdversariesModItems.RUNE_SLATE.get());
                tabData.accept(AdversariesModItems.WOOD_WAND.get());
                tabData.accept(AdversariesModItems.COPPER_WAND.get());
                tabData.accept(AdversariesModItems.SHACKLES.get());
                tabData.accept(AdversariesModItems.GAUNTLET_OF_RAGE.get());

            }).withSearchBar().build());

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            tabData.accept(AdversariesModItems.DEBUG_WAND.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(AdversariesModItems.OVERWORLD_CHAMPION_SPAWN_EGG.get());
            tabData.accept(AdversariesModItems.ANGEL_SPAWN_EGG.get());
            tabData.accept(AdversariesModItems.WIZARD_ELF_SPAWN_EGG.get());
            tabData.accept(AdversariesModItems.PRISONER_SPAWN_EGG.get());
        }else if (tabData.getTabKey() == CreativeModeTabs.COMBAT){
            tabData.accept(AdversariesModItems.WARBRAND.get());
            tabData.accept(AdversariesModItems.RUNE_SLATE.get());
            tabData.accept(AdversariesModItems.WOOD_WAND.get());
            tabData.accept(AdversariesModItems.COPPER_WAND.get());
            tabData.accept(AdversariesModItems.GAUNTLET_OF_RAGE.get());
        }else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            tabData.accept(AdversariesModItems.PURIFIED_FLESH.get());
            tabData.accept(AdversariesModItems.DWELLER_HEART.get());
            tabData.accept(AdversariesModItems.EIK_FAT.get());
            tabData.accept(AdversariesModItems.GLOWSTONE_CORE.get());
        }else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS){
            tabData.accept(AdversariesModItems.RAW_DEMON_BLOOD.get());
            tabData.accept(AdversariesModItems.ANCIENT_ASH.get());
            tabData.accept(AdversariesModItems.SOUL_STONE.get());
            tabData.accept(AdversariesModItems.SKULL.get());
            tabData.accept(AdversariesModItems.SCROLL.get());
            tabData.accept(AdversariesModItems.WRITTEN_CONTRACT.get());
        }
    }
}

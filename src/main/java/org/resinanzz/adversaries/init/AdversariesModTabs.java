package org.resinanzz.adversaries.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;



@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class AdversariesModTabs {
    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Adversaries.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ADVERSARIES = REGISTRY.register("adversaries",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.adversaries.adversaries")).icon(() -> new ItemStack(AdversariesModItems.SOUL_STONE.get())).displayItems((parameters, tabData) -> {
                tabData.accept(AdversariesModItems.SOUL_STONE.get());
                tabData.accept(AdversariesModItems.SKULL.get());
                tabData.accept(AdversariesModBlocks.POTION_BLOCK.get().asItem());
                tabData.accept(AdversariesModBlocks.DEMON_BLOOD_ORE.get().asItem());
                tabData.accept(AdversariesModItems.RAW_DEMON_BLOOD.get());
                tabData.accept(AdversariesModItems.CELESTRIUM_INGOT.get());
                tabData.accept(AdversariesModItems.CRUCIBLE_STEEL_INGOT.get());
                tabData.accept(AdversariesModItems.ADVERSARIES_WAND.get());
                tabData.accept(AdversariesModItems.WARBRAND.get());
                tabData.accept(AdversariesModItems.SCROLL.get());
                tabData.accept(AdversariesModItems.WRITTEN_CONTRACT.get());
                tabData.accept(AdversariesModItems.OVERWORLD_CHAMPION_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.ANGEL_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.WIZARD_ELF_SPAWN_EGG.get());
                tabData.accept(AdversariesModItems.GAUNTLET_OF_RAGE.get());
                tabData.accept(AdversariesModItems.FIRE_SIGIL.get());
                tabData.accept(AdversariesModItems.INFINITE_DEATH.get());
                tabData.accept(AdversariesModItems.PURIFIED_FLESH.get());
                tabData.accept(AdversariesModItems.DWELLER_HEART.get());
                tabData.accept(AdversariesModItems.FREYAN_DUST.get());
                tabData.accept(AdversariesModItems.GLOWSTONE_CORE.get());
                tabData.accept(AdversariesModItems.REACTIVE_STRIP.get());
                tabData.accept(AdversariesModItems.LAMBDAMETER.get());
            }).withSearchBar().build());

    @SubscribeEvent
    public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
        if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            tabData.accept(AdversariesModItems.ADVERSARIES_WAND.get());
        } else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            tabData.accept(AdversariesModItems.OVERWORLD_CHAMPION_SPAWN_EGG.get());
            tabData.accept(AdversariesModItems.ANGEL_SPAWN_EGG.get());
        }
    }
}



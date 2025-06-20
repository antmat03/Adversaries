package org.resinanzz.adversaries.datagen;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.resinanzz.adversaries.Adversaries;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Adversaries.MOD_ID, bus = EventBusSubscriber.Bus.MOD)

public class AdversariesDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new AdversariesDatapackProvider(packOutput, lookupProvider));
    }
}

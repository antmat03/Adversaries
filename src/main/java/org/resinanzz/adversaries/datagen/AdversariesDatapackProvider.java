package org.resinanzz.adversaries.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.worldgen.AdversariesBiomeModifiers;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class AdversariesDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, AdversariesBiomeModifiers::bootstrap);

    public AdversariesDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(Adversaries.MOD_ID));
    }
}

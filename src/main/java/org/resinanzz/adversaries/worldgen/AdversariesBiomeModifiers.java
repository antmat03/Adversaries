package org.resinanzz.adversaries.worldgen;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.init.AdversariesModEntities;

import java.util.List;

public class AdversariesBiomeModifiers {

    public static final ResourceKey<BiomeModifier> SPAWN_PRISONER = registerKey("spawn_prisoner");
    public static final ResourceKey<BiomeModifier> SPAWN_DEER = registerKey("spawn_deer");
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(SPAWN_PRISONER, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.NETHER_WASTES)),
                List.of(new MobSpawnSettings.SpawnerData(AdversariesModEntities.PRISONER.get(), 30, 1, 3))));

        context.register(SPAWN_DEER, new BiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                List.of(new MobSpawnSettings.SpawnerData(AdversariesModEntities.DEER.get(), 20, 1, 5))));
    }
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(Adversaries.MOD_ID, name));
    }
}

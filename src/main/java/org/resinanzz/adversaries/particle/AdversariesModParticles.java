package org.resinanzz.adversaries.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;

import java.util.function.Supplier;

public class AdversariesModParticles {
    public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, Adversaries.MOD_ID);


    // The easiest way to add new particle types is reusing vanilla's SimpleParticleType.
    // Implementing a custom ParticleType is also possible, see below.
    public static final Supplier<SimpleParticleType> PUNCH_PARTICLE = REGISTRY.register(
            // The name of the particle type.
            "punch_particle",
            // The supplier. The boolean parameter denotes whether setting the Particles option in the
            // video settings to Minimal will affect this particle type or not; this is false for
            // most vanilla particles, but true for e.g. explosions, campfire smoke, or squid ink.
            () -> new SimpleParticleType(true)
    );

}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package org.resinanzz.adversaries.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;

public class AdversariesModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(Registries.SOUND_EVENT, Adversaries.MOD_ID);
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGIC_SHOOT = REGISTRY.register("magic_shoot", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("adversaries", "magic_shoot")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MONSTER_GROWL = REGISTRY.register("monster_growl", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("adversaries", "monster_growl")));
	public static final DeferredHolder<SoundEvent, SoundEvent> MAGIC_START = REGISTRY.register("magic_start", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath("adversaries", "magic_start")));
}

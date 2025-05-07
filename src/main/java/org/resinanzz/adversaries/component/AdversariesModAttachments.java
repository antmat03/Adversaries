package org.resinanzz.adversaries.component;

import com.mojang.serialization.Codec;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.resinanzz.adversaries.Adversaries;

import java.util.function.Supplier;

public class AdversariesModAttachments {
    public static final DeferredRegister<AttachmentType<?>> REGISTRY = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, Adversaries.MOD_ID);

    public static final Supplier<AttachmentType<Integer>> BLOOD_ENERGY = REGISTRY.register("blood_energy", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> PHOSPHENE_ENERGY = REGISTRY.register("phosphene_energy", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> SULPHERE_ENERGY = REGISTRY.register("sulphere_energy", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> FAYE_ENERGY = REGISTRY.register("faye_energy", () -> AttachmentType.builder(() -> 0).serialize(Codec.INT).build());


    public static final Supplier<AttachmentType<Integer>> BLOOD_ENERGY_LIMIT = REGISTRY.register("blood_energy_limit", () -> AttachmentType.builder(() -> 20).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> PHOSPHENE_ENERGY_LIMIT = REGISTRY.register("phosphene_energy_limit", () -> AttachmentType.builder(() -> 20).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> SULPHERE_ENERGY_LIMIT = REGISTRY.register("sulphere_energy_limit", () -> AttachmentType.builder(() -> 20).serialize(Codec.INT).build());
    public static final Supplier<AttachmentType<Integer>> FAYE_ENERGY_LIMIT = REGISTRY.register("faye_energy_limit", () -> AttachmentType.builder(() -> 20).serialize(Codec.INT).build());


}

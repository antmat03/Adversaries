package org.resinanzz.adversaries.init;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;

import java.util.function.UnaryOperator;

public class AdversariesDataComponents {
    public static final DeferredRegister<DataComponentType<?>> REGISTRY =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, Adversaries.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<BlockPos>> COORDINATES = register("coordinates",
            builder -> builder.persistent(BlockPos.CODEC));


    private static <T>DeferredHolder<DataComponentType<?>, DataComponentType<T>> register(String name,
                                                                                          UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return REGISTRY.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

}

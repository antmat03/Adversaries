package org.resinanzz.adversaries.init;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.block.LuckyPotionBlock;


public class AdversariesModBlocks {
    public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(Adversaries.MOD_ID);
    public static final DeferredBlock<Block> POTION_BLOCK = REGISTRY.register("potion_block", LuckyPotionBlock::new);
    public static final DeferredBlock<Block> DEMON_BLOOD_ORE = REGISTRY.register("demon_blood_ore", () -> new DropExperienceBlock(UniformInt.of(3,6),
            BlockBehaviour.Properties.of().strength(3f).sound(SoundType.STONE).destroyTime(0.5f).requiresCorrectToolForDrops()));


}


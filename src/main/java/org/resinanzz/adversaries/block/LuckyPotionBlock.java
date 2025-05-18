package org.resinanzz.adversaries.block;


import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class LuckyPotionBlock extends Block{
    public LuckyPotionBlock() {
        super(Properties.of().sound(SoundType.SAND).destroyTime(0.5f).noLootTable());
    }
    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 15;
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


    @Override
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack) {
        super.playerDestroy(world, player, pos, state, blockEntity, stack);
        if(!world.isClientSide){
            int number = getRandomNumberInRange(1, 6);
            if (number == 1){
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 500, 1 ));
            }
            if(number == 2){
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 1));
            }
            if(number == 3){
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 500, 1));
            }
            if(number == 4){
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 500, 1));
            }
            if(number == 5){
                    player.removeAllEffects();
                    player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 500, 1));
            }
            if(number == 6){
                player.removeAllEffects();
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 500, 1));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 500, 3));
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 500, 10));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 500, 5));
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 500, 1));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 500, 2));
            }

        }


    }


}



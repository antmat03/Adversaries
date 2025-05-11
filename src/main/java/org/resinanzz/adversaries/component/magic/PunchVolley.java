package org.resinanzz.adversaries.component.magic;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.resinanzz.adversaries.Adversaries;
import org.resinanzz.adversaries.entity.PunchProjectileEntity;
import org.resinanzz.adversaries.init.AdversariesModEntities;


public class PunchVolley {
    static int chain = 0;
    static int chainWait = 0;
    public static PunchProjectileEntity doVolley(Level world, LivingEntity entity, RandomSource random, float power, double damage, double knockback, float pitch, float volume, int amount){
        PunchProjectileEntity entityarrow = new PunchProjectileEntity(AdversariesModEntities.PUNCH_PROJECTILE.get(), entity, world, null);
        MobEffectInstance mobeffectinstance = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 260, 0, false, false);

        entity.addEffect(mobeffectinstance, entity);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:monster_growl")), SoundSource.PLAYERS, volume-0.9f, pitch);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:magic_start")), SoundSource.PLAYERS, volume-0.5f, 0);

        chain = amount;
        for (int index0 = 0; index0 < chain; index0++) {

            Adversaries.queueServerWork(chainWait, () -> {
                PunchProjectileEntity.shoot(world, entity, random, power, damage, knockback, pitch, volume);
            });

            chainWait = chainWait +2;

        }
        chainWait = 0;

        return entityarrow;
    }
}

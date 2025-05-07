package org.resinanzz.adversaries.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;


    public class BossStateChangerProcedure {
        public static void execute(Entity entity) {
            if (entity == null)
                return;
            double StateSelector = 0;
            entity.getPersistentData().putString("PrevState", (entity.getPersistentData().getString("State")));
            StateSelector = Mth.nextInt(RandomSource.create(), 0, 2);
            if (StateSelector == 0) {
                entity.getPersistentData().putString("State", "Idle");
            }
            if (StateSelector == 1) {
                entity.getPersistentData().putString("State", "Darkness");
            }
            if (StateSelector == 2) {
                entity.getPersistentData().putString("State", "Darkpunch");
            }
            if((entity.getPersistentData().getString("State").equals(entity.getPersistentData().getString("PrevState")))){
                BossStateChangerProcedure.execute(entity);
            }
        }
    }


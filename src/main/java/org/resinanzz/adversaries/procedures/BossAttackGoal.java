package org.resinanzz.adversaries.procedures;

import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.player.Player;

public class BossAttackGoal extends MeleeAttackGoal {
    private final PathfinderMob boss;
    private Player targetPlayer;
    private final double speed;
    private final double followDistance;



    public BossAttackGoal(PathfinderMob mob, double speed, double followDistance, boolean followingTargetEvenIfNotSeen) {
            super(mob, speed,followingTargetEvenIfNotSeen);
            this.boss = mob;
            this.speed = speed;
            this.followDistance = followDistance;
        }
    
}

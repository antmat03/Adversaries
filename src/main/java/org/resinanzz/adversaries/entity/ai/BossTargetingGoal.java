package org.resinanzz.adversaries.entity.ai;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;

public class BossTargetingGoal<T extends LivingEntity> extends NearestAttackableTargetGoal<T> {
    private final PathfinderMob mob;
    private Player targetPlayer;

    public BossTargetingGoal(PathfinderMob mob, Class<T> targetPlayer, boolean mustSee) {
        super(mob, targetPlayer, false);
        this.mob = mob;

    }

    @Override
    public void start(){
        super.start();

    }
    @Override
    public void stop()
    {
        super.stop();
    }

}

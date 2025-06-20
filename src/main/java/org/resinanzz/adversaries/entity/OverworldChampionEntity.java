package org.resinanzz.adversaries.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.BossEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.resinanzz.adversaries.entity.ai.BossAttackGoal;
import org.resinanzz.adversaries.entity.ai.BossTargetingGoal;
import org.resinanzz.adversaries.init.AdversariesModEntities;

public class OverworldChampionEntity extends Monster {
    public static final EntityDataAccessor<Integer> DATA_phase = SynchedEntityData.defineId(OverworldChampionEntity.class, EntityDataSerializers.INT);
    private boolean isAggro;
    private int count;

    public OverworldChampionEntity(EntityType<OverworldChampionEntity> type, Level world) {
        super(type, world);
        xpReward = 0;
        setNoAi(false);
        setPersistenceRequired();
        //this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(AdversariesModItems.GAUNTLET_OF_RAGE.get()));
    }

   private final ServerBossEvent bossEvent = new ServerBossEvent(
           Component.literal("Champion of the Overworld: Asmund"),
           BossEvent.BossBarColor.GREEN,
           BossEvent.BossBarOverlay.PROGRESS
   );

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_phase, 0);
    }

    @Override
    protected void registerGoals(){
        this.goalSelector.addGoal(1, new BossAttackGoal(this, 1.0,  true));
        this.goalSelector.addGoal(3, new RandomStrollGoal(this, 0.3));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new BossTargetingGoal<>(this, Player.class, false));
    }


    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public Vec3 getPassengerRidingPosition(Entity entity) {
        return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.ambient"));
    }

    @Override
    public void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.step")), 0.15f, 1);
    }

    @Override
    public SoundEvent getHurtSound(DamageSource ds) {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.husk.hurt"));
    }

    @Override
    public SoundEvent getDeathSound() {
        return BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("entity.wither.death"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Dataphase", this.entityData.get(DATA_phase));
        compound.putBoolean("isSlow", false);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Dataphase"))
            this.entityData.set(DATA_phase, compound.getInt("Dataphase"));
    }
    @Override
    public void aiStep() {
        super.aiStep();
    }
    @Override
    public void startSeenByPlayer(ServerPlayer player) {
        super.startSeenByPlayer(player);
        bossEvent.addPlayer(player);
    }
    @Override
    public void stopSeenByPlayer(ServerPlayer player) {
        super.stopSeenByPlayer(player);
        bossEvent.removePlayer(player);
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
        event.register(AdversariesModEntities.PRISONER.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.WORLD_SURFACE_WG, Animal::checkMobSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.6);
        builder = builder.add(Attributes.MAX_HEALTH, 300);
        builder = builder.add(Attributes.ARMOR, 0);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
        builder = builder.add(Attributes.FOLLOW_RANGE, 40);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 3);
        return builder;
    }
}


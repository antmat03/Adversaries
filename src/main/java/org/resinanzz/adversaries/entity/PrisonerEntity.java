
package org.resinanzz.adversaries.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.resinanzz.adversaries.init.AdversariesModItems;

public class PrisonerEntity<T extends LivingEntity> extends PathfinderMob {
    public static final EntityDataAccessor<Integer> DATA_phase = SynchedEntityData.defineId(PrisonerEntity.class, EntityDataSerializers.INT);

    public PrisonerEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        setPersistenceRequired();
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(AdversariesModItems.WARBRAND.get()));
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_phase, 0);

    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Dataphase"))
            this.entityData.set(DATA_phase, compound.getInt("Dataphase"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Dataphase", this.entityData.get(DATA_phase));
    }

    public static void init(RegisterSpawnPlacementsEvent event) {
    }
    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Mob.createMobAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.25);
        builder = builder.add(Attributes.MAX_HEALTH, 50);
        builder = builder.add(Attributes.ARMOR, 2);
        builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
        builder = builder.add(Attributes.FOLLOW_RANGE, 40);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.5);
        return builder;
    }
}

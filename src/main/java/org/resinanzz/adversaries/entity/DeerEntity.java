package org.resinanzz.adversaries.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.resinanzz.adversaries.init.AdversariesModEntities;

public class DeerEntity extends Animal {
    private static final EntityDimensions BABY_DIMENSIONS = EntityType.COW.getDimensions().scale(0.5F).withEyeHeight(0.665F);
    public DeerEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.25, p_335386_ -> p_335386_.is(ItemTags.COW_FOOD), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 2.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }
    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.WHEAT.asItem());
    }

    public static AttributeSupplier.Builder createAttributes() {
        AttributeSupplier.Builder builder = Animal.createLivingAttributes();
        builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
        builder = builder.add(Attributes.MAX_HEALTH, 10);
        builder = builder.add(Attributes.ARMOR, 2);
        builder = builder.add(Attributes.FOLLOW_RANGE, 24D);
        builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
        return builder;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return AdversariesModEntities.DEER.get().create(level);
    }
    @Override
    public EntityDimensions getDefaultDimensions(Pose pose) {
        return this.isBaby() ? BABY_DIMENSIONS : super.getDefaultDimensions(pose);
    }
}

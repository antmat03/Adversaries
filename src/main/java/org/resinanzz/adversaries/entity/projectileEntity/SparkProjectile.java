package org.resinanzz.adversaries.entity.projectileEntity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.jetbrains.annotations.NotNull;
import org.resinanzz.adversaries.init.AdversariesModEntities;

import javax.annotation.Nullable;

public class SparkProjectile extends AbstractArrow {
    private double knockback = 0;
    public SparkProjectile(EntityType<? extends AbstractArrow> entityType, Level level) {
        super(entityType, level);
    }
    public SparkProjectile(EntityType<? extends SparkProjectile> type, LivingEntity entity, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, entity, world, ItemStack.EMPTY, null);

    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return ItemStack.EMPTY;
    }
    public boolean isGrounded(){
        return inGround;
    }
    @Override
    public void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        Entity entity1 = this.getOwner();
        DamageSource damagesource = this.damageSources().arrow(this, (Entity)(entity1 != null ? entity1 : this));
        if(!this.level().isClientSide && entity instanceof LivingEntity livingentity){
            this.doKnockback(livingentity, damagesource);

            entity.invulnerableTime = 0;
            ((LivingEntity) entity).hurtTime = 5;
            entity.hurtMarked = true;
        }
    }
    @Override
    public void onHitBlock(@NotNull BlockHitResult result){
        this.kill();
    }
    @Override
    public void tick(){
        super.tick();

        if(this.tickCount == 4){
            this.discard();
        }

    }
    public static void init(RegisterSpawnPlacementsEvent event) {
    }
    public void setKnockback(double knockback) {
        this.knockback = knockback;
    }
    @Override
    protected void doKnockback(LivingEntity livingEntity, DamageSource damageSource) {
        if (knockback > 0.0) {
            double d1 = Math.max(0.0, 1.0 - livingEntity.getAttributeValue(Attributes.KNOCKBACK_RESISTANCE));
            Vec3 vec3 = this.getDeltaMovement().multiply(1.0, 0.0, 1.0).normalize().scale(knockback * 0.6 * d1);
            if (vec3.lengthSqr() > 0.0) {
                livingEntity.push(vec3.x, 0.1, vec3.z);
            }
        }
    }
    public static void shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, double knockback) {
        SparkProjectile entityarrow = new SparkProjectile(AdversariesModEntities.SPARK_PROJECTILE.get(), entity, world, null);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setNoGravity(true);
        entityarrow.setNoGravity(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:magic_shoot")), SoundSource.PLAYERS);
    }
}

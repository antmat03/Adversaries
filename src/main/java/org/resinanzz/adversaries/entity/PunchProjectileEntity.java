package org.resinanzz.adversaries.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.jetbrains.annotations.NotNull;
import org.resinanzz.adversaries.init.AdversariesModEntities;
import org.resinanzz.adversaries.particle.AdversariesModParticles;

import javax.annotation.Nullable;
@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)

public class PunchProjectileEntity extends AbstractArrow {
    private double knockback = 0;
    public PunchProjectileEntity(EntityType<? extends PunchProjectileEntity> entityType, Level world) {
        super(entityType, world);


    }
    public PunchProjectileEntity(LivingEntity shooter, Level world) {
        super(AdversariesModEntities.PUNCH_PROJECTILE.get(), shooter, world, ItemStack.EMPTY, null);
    }

    public PunchProjectileEntity(EntityType<? extends PunchProjectileEntity> type, double x, double y, double z, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, x, y, z, world, ItemStack.EMPTY, null);
    }

    public PunchProjectileEntity(EntityType<? extends PunchProjectileEntity> type, LivingEntity entity, Level world, @Nullable ItemStack firedFromWeapon) {
        super(type, entity, world, ItemStack.EMPTY, null);

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

            ((ServerLevel)result.getEntity().level()).sendParticles(AdversariesModParticles.PUNCH_PARTICLE.get(),this.getX()  ,this.getY() ,this.getZ() , 1, 0.4,0.4,0.4, 0);
            result.getEntity().playSound(SoundEvents.PLAYER_ATTACK_CRIT);
        }
    }

    @Override
    public void onHitBlock(@NotNull BlockHitResult result){
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

    public static void shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, double knockback, float pitch, float volume) {
        PunchProjectileEntity entityarrow = new PunchProjectileEntity(AdversariesModEntities.PUNCH_PROJECTILE.get(), entity, world, null);
        entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
        entityarrow.setSilent(true);
        entityarrow.setNoGravity(true);
        entityarrow.setNoGravity(true);
        entityarrow.setCritArrow(false);
        entityarrow.setBaseDamage(damage);
        entityarrow.setKnockback(knockback);
        world.addFreshEntity(entityarrow);
        world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("adversaries:magic_shoot")), SoundSource.PLAYERS, volume, pitch / (random.nextFloat() * 0.5f + 1) + 0.5f);
    }

}

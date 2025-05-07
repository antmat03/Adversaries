package org.resinanzz.adversaries.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;

import javax.annotation.Nullable;

public class PunchParticle extends TextureSheetParticle {
    private final SpriteSet spriteSet;
    protected boolean isGlowing;

    public PunchParticle(ClientLevel level, double x, double y, double z, SpriteSet spriteSet) {
        super(level, x, y, z);
        this.gravity = 0;
        this.lifetime = 15;
        this.scale(4);
        this.setSize(4,4);
        this.spriteSet = spriteSet;
        this.setSpriteFromAge(spriteSet);
        this.bbWidth = 4;
        this.bbHeight = 4;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_LIT;
    }
    @Override
    public int getLightColor(float partialTick) {
        return 240;
    }
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;
        public Provider(SpriteSet spriteSet) {
            this.spriteSet = spriteSet;
        }
        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType type, ClientLevel level,
                                       double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            // We don't use the type and speed, and pass in everything else. You may of course use them if needed.
            return new PunchParticle(level, x, y, z, spriteSet);
        }

    }
    @Override
    public void tick() {
        // Set the sprite for the current particle age, i.e. advance the animation.
        this.setSpriteFromAge(spriteSet);
        // Let super handle further movement. You may replace this with your own movement if needed.
        // You may also override move() if you only want to modify the built-in movement.
        super.tick();
    }
}

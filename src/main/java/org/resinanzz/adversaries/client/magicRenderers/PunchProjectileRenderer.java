package org.resinanzz.adversaries.client.magicRenderers;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import org.resinanzz.adversaries.client.models.PunchProjectileModel;
import org.resinanzz.adversaries.entity.projectileEntity.PunchProjectileEntity;

public class PunchProjectileRenderer extends EntityRenderer<PunchProjectileEntity> {
    private final PunchProjectileModel model;

    public PunchProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new PunchProjectileModel(context.bakeLayer(PunchProjectileModel.LAYER_LOCATION));
    }


    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PunchProjectileEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/punch_projectile.png");
    }

    @Override
    public void render(PunchProjectileEntity entity, float entityYaw,float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight){
        poseStack.pushPose();

        double randomY = entity.getPersistentData().getDouble("randomY");
        double randomX = entity.getPersistentData().getDouble("randomX");

        int fullBright = LightTexture.FULL_BRIGHT;

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));

        float f9 = (float)entity.shakeTime - partialTicks;
        if (f9 > 0.0F) {
            float f10 = -Mth.sin(f9 * 3.0F) * f9;
            poseStack.mulPose(Axis.ZP.rotationDegrees(f10));
        }

        poseStack.mulPose(Axis.YP.rotationDegrees(-90.0f));

        poseStack.translate( randomX ,  randomY , 1F );

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(entity)), false, true);

        this.model.renderToBuffer(poseStack,vertexconsumer, fullBright, OverlayTexture.NO_OVERLAY);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, fullBright);
        poseStack.popPose();

    }


}


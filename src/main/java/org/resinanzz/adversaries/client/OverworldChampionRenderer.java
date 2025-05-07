package org.resinanzz.adversaries.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import org.resinanzz.adversaries.client.models.OverworldChampionModel;
import org.resinanzz.adversaries.entity.OverworldChampionEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import org.resinanzz.adversaries.entity.PunchProjectileEntity;

public class OverworldChampionRenderer extends HumanoidMobRenderer<OverworldChampionEntity, HumanoidModel<OverworldChampionEntity>> {

    public OverworldChampionRenderer(EntityRendererProvider.Context context) {
        super(context, new OverworldChampionModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.6f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }
    @Override
    public void render(OverworldChampionEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight){
        poseStack.pushPose();
        float scale = 1.2F;
        poseStack.scale(scale, scale, scale);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull OverworldChampionEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/undeadchampiontexture.png");
    }


}

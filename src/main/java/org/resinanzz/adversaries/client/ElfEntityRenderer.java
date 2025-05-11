package org.resinanzz.adversaries.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.resinanzz.adversaries.client.models.AngelEntityModel;
import org.resinanzz.adversaries.entity.WizardElfEntity;


public class ElfEntityRenderer extends HumanoidMobRenderer<WizardElfEntity, HumanoidModel<WizardElfEntity>> {

    public ElfEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new AngelEntityModel<>(context.bakeLayer(ModelLayers.PLAYER),false), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }
    @Override
    public void render(WizardElfEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight){
        poseStack.pushPose();
        float scale = 0.7F;
        poseStack.scale(scale, scale, scale);

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        poseStack.popPose();
    }
    @Override
    public ResourceLocation getTextureLocation(WizardElfEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/wizard_elf_green.png");
    }
}

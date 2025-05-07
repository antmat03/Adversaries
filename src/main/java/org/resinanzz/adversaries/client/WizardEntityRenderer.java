package org.resinanzz.adversaries.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.resinanzz.adversaries.client.models.AngelEntityModel;
import org.resinanzz.adversaries.entity.AngelEntity;
import org.resinanzz.adversaries.entity.WizardEntity;


public class WizardEntityRenderer extends HumanoidMobRenderer<WizardEntity, HumanoidModel<WizardEntity>> {

    public WizardEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new AngelEntityModel<>(context.bakeLayer(ModelLayers.PLAYER),false), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(WizardEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/wizard_green.png");
    }
}

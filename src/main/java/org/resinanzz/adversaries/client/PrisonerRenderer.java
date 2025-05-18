package org.resinanzz.adversaries.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.resinanzz.adversaries.client.models.AngelEntityModel;
import org.resinanzz.adversaries.client.models.PrisonerEntityModel;
import org.resinanzz.adversaries.entity.PrisonerEntity;

public class PrisonerRenderer extends HumanoidMobRenderer<PrisonerEntity, HumanoidModel<PrisonerEntity>> {
    public PrisonerRenderer(EntityRendererProvider.Context context) {
        super(context, new PrisonerEntityModel<>(context.bakeLayer(ModelLayers.PLAYER),false), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

    }

    @Override
    public ResourceLocation getTextureLocation(PrisonerEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/prisoner.png");
    }
}

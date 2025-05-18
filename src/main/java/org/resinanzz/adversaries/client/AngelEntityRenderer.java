package org.resinanzz.adversaries.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import org.resinanzz.adversaries.client.models.AngelEntityModel;
import org.resinanzz.adversaries.entity.AngelEntity;



public class AngelEntityRenderer extends HumanoidMobRenderer<AngelEntity, HumanoidModel<AngelEntity>> {

    public AngelEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new AngelEntityModel<>(context.bakeLayer(ModelLayers.PLAYER),false), 0.5f);
        this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
    }

    @Override
    public ResourceLocation getTextureLocation(AngelEntity entity) {
        return ResourceLocation.parse("adversaries:textures/entity/angeltexture.png");
    }
}

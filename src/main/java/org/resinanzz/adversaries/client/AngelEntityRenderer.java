package org.resinanzz.adversaries.client;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.event.level.NoteBlockEvent;
import org.jetbrains.annotations.NotNull;
import org.resinanzz.adversaries.client.models.AngelEntityModel;
import org.resinanzz.adversaries.client.models.OverworldChampionModel;
import org.resinanzz.adversaries.entity.AngelEntity;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;



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

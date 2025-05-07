package org.resinanzz.adversaries.client.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import org.resinanzz.adversaries.entity.AngelEntity;

public class AngelEntityModel<T extends LivingEntity> extends PlayerModel<T> {
    public AngelEntityModel(ModelPart root, boolean slim) {
        super(root, slim);
    }
}

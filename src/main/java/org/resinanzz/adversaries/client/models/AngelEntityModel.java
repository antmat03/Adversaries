package org.resinanzz.adversaries.client.models;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class AngelEntityModel<T extends LivingEntity> extends PlayerModel<T> {
    public AngelEntityModel(ModelPart root, boolean slim) {
        super(root, slim);
    }
}

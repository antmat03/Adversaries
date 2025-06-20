package org.resinanzz.adversaries.client.models;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class DeerEntityModel <T extends LivingEntity> extends PlayerModel<T> {

    public DeerEntityModel(ModelPart root, boolean slim) {
        super(root, slim);
    }
}

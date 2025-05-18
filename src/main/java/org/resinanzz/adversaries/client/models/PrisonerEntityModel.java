package org.resinanzz.adversaries.client.models;

import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;

public class PrisonerEntityModel <T extends LivingEntity> extends PlayerModel<T> {
    public PrisonerEntityModel(ModelPart root, boolean slim) {
        super(root, slim);
    }
}

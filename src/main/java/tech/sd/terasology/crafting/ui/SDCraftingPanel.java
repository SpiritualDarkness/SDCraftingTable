// Copyright 2023 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package tech.sd.terasology.crafting.ui;

import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.rendering.nui.BaseInteractionScreen;
import org.terasology.engine.rendering.nui.CoreScreenLayer;
import org.terasology.module.inventory.ui.InventoryGrid;
import org.terasology.nui.CoreWidget;
import org.terasology.nui.databinding.Binding;
import org.terasology.nui.databinding.DefaultBinding;

public class SDCraftingPanel extends BaseInteractionScreen {

    private InventoryGrid recipe;

    @Override
    protected void initializeWithInteractionTarget(EntityRef interactionTarget) {
        recipe.bindTargetEntity(new DefaultBinding<>(interactionTarget));
    }

    @Override
    public void initialise() {

        recipe = find("recipe",InventoryGrid.class);
    }
}

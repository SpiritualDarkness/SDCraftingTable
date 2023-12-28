// Copyright 2023 The Terasology Foundation
// SPDX-License-Identifier: Apache-2.0

package tech.sd.terasology.crafting.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.terasology.engine.entitySystem.entity.EntityRef;
import org.terasology.engine.entitySystem.systems.BaseComponentSystem;
import org.terasology.engine.entitySystem.systems.RegisterMode;
import org.terasology.engine.entitySystem.systems.RegisterSystem;
import org.terasology.engine.logic.common.ActivateEvent;
import org.terasology.engine.registry.In;
import org.terasology.engine.rendering.nui.NUIManager;
import org.terasology.engine.world.block.BlockComponent;
import org.terasology.gestalt.entitysystem.event.ReceiveEvent;
import tech.sd.terasology.crafting.component.OpenCraftingGuiOnActive;

@RegisterSystem(RegisterMode.CLIENT)
public class OpenCraftingGuiOnActivationSystem extends BaseComponentSystem {
    @In
    private NUIManager nuiManager;
    private static final Logger LOG = LoggerFactory.getLogger(OpenCraftingGuiOnActivationSystem.class);

    @ReceiveEvent(components = {BlockComponent.class, OpenCraftingGuiOnActive.class})
    public void onActivate(ActivateEvent event, EntityRef entityRef){
        nuiManager.pushScreen("SDCraftingTable:SDCraftingPanel");
    }
}

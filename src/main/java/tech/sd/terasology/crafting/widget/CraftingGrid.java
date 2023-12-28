//// Copyright 2023 The Terasology Foundation
//// SPDX-License-Identifier: Apache-2.0
//
//package tech.sd.terasology.crafting.widget;
//
//import com.google.common.collect.Lists;
//import org.joml.Vector2i;
//import org.terasology.engine.entitySystem.entity.EntityRef;
//import org.terasology.input.MouseInput;
//import org.terasology.joml.geom.Rectanglei;
//import org.terasology.module.inventory.ui.InventoryCell;
//import org.terasology.module.inventory.ui.InventoryGrid;
//import org.terasology.nui.BaseInteractionListener;
//import org.terasology.nui.Canvas;
//import org.terasology.nui.CoreWidget;
//import org.terasology.nui.InteractionListener;
//import org.terasology.nui.LayoutConfig;
//import org.terasology.nui.databinding.Binding;
//import org.terasology.nui.databinding.DefaultBinding;
//import org.terasology.nui.databinding.ReadOnlyBinding;
//import org.terasology.nui.events.NUIMouseClickEvent;
//
//import java.util.List;
//
//public class CraftingGrid extends CoreWidget {
//
//    @LayoutConfig
//    private Binding<Integer> gridSize = new DefaultBinding<>(3);
//    private List<InventoryCell> cells = Lists.newArrayList();
//
//    private InteractionListener interactionListener = new BaseInteractionListener() {
//        @Override
//        public boolean onMouseClick(NUIMouseClickEvent event) {
//            MouseInput mouseButton = event.getMouseButton();
//            if (mouseButton == MouseInput.MOUSE_LEFT) {
//                return true;
//            }
//            return false;
//        }
//    };
//
//    /**
//     * EntityRef to an entity whose inventory will be accessed using this InventoryGrid.
//     */
//    private Binding<EntityRef> targetEntity = new DefaultBinding<>(EntityRef.NULL);
//
//
//    @Override
//    public void update(float delta) {
//        super.update(delta);
//
//        int numSlots = getNumSlots();
//
//        // allow the UI to grow or shrink the cell count if the inventory changes size
//        if (numSlots < cells.size()) {
//            for (int i = cells.size(); i > numSlots && i > 0; --i) {
//                cells.remove(i - 1);
//            }
//        } else if (numSlots > cells.size()) {
//            for (int i = cells.size(); i < numSlots && i < getNumSlots(); ++i) {
//                InventoryCell cell = new InventoryCell();
//                cell.bindTargetInventory(this.targetEntity);
//                cell.bindTargetSlot(new DefaultBinding<>(i));
//                cells.add(cell);
//            }
//        }
//    }
//
//    @Override
//    public void onDraw(Canvas canvas) {
//        int numSlots = getNumSlots();
//        if (numSlots == 0 || cells.isEmpty()) {
//            return;
//        }
//        Vector2i cellSize = canvas.calculatePreferredSize(cells.get(0));
//        if (cellSize.x() == 0 || cellSize.y() == 0) {
//            return;
//        }
//        canvas.addInteractionRegion(interactionListener);
//
//        int horizontalCells = Math.max(1, Math.min(gridSize.get(), canvas.size().x() / cellSize.x()));
//        for (int i = 0; i < numSlots && i < cells.size(); ++i) {
//            int horizPos = i % horizontalCells;
//            int vertPos = i / horizontalCells;
//            canvas.drawWidget(cells.get(i), new Rectanglei(
//                    horizPos * cellSize.x, vertPos * cellSize.y).setSize(cellSize.x, cellSize.y)
//            );
//        }
//    }
//
//    @Override
//    public Vector2i getPreferredContentSize(Canvas canvas, Vector2i sizeHint) {
//        int numSlots = getNumSlots();
//        if (numSlots == 0 || cells.isEmpty()) {
//            return new Vector2i();
//        }
//        Vector2i cellSize = canvas.calculatePreferredSize(cells.get(0));
//        if (cellSize.x() == 0 || cellSize.y() == 0) {
//            return new Vector2i();
//        }
//        int horizontalCells = Math.min(numSlots, sizeHint.x() / cellSize.x());
//        int verticalCells = ((numSlots - 1) / horizontalCells) + 1;
//        return new Vector2i(horizontalCells * cellSize.x, verticalCells * cellSize.y);
//    }
//
//    private int getNumSlots() {
//
//        return gridSize.get() * gridSize.get();
//    }
//}

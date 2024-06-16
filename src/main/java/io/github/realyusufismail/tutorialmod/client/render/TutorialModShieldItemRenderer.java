package io.github.realyusufismail.tutorialmod.client.render;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;

public class TutorialModShieldItemRenderer extends ModBlockEntityWithoutLevelRenderer {
    private static Material SHIELD_GRAPHITE = new Material(
            InventoryMenu.BLOCK_ATLAS, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "entity/shield/graphite")
    );

    private ShieldModel model;

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        try {
            //model = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
        } catch (Exception e) {
            TutorialMod.logger.error("Failed to load shield model", e);
        }
    }
}

package io.github.realyusufismail.tutorialmod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.items.ModShieldItem;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import java.util.Locale;
import java.util.function.Function;

public class TutorialModShieldItemRenderer extends ModBlockEntityWithoutLevelRenderer {
    private static final Material SHIELD_GRAPHITE = new Material(
            InventoryMenu.BLOCK_ATLAS, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "entity/shield/graphite")
    );

    private ShieldModel shieldModel;

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        try {
            shieldModel = new ShieldModel(this.entityModelSet.bakeLayer(ModelLayers.SHIELD));
        } catch (Exception e) {
            TutorialMod.logger.error("Failed to load shield model", e);
        }
    }

    @Override
    public void renderByItem(ItemStack stack,
                             ItemDisplayContext type,
                             PoseStack poseStack,
                             MultiBufferSource buffer,
                             int combinedLight,
                             int combinedOverlay) {
        try {
            if (stack.getItem() instanceof ModShieldItem) {
                //boolean isGraphite = stack.is(ItemInit.GRAPHITE_SHIELD.get());

                poseStack.pushPose();
                poseStack.scale(1.0f, -1.0f, -1.0f);
                Material material = SHIELD_GRAPHITE;

                if (this.shieldModel == null) {
                    throw new NullPointerException("Shield model is null");
                }

                TextureAtlasSprite sprite = material.sprite();
                VertexConsumer vertexConsumer =
                        sprite.wrap(ItemRenderer.getFoilBufferDirect(
                                buffer,
                                this.shieldModel.renderType(material.atlasLocation()),
                                true,
                                stack.hasFoil()));

                this.shieldModel.handle().render(
                        poseStack,
                        vertexConsumer,
                        combinedLight,
                        combinedOverlay
                );
                this.shieldModel.plate().render(
                        poseStack,
                        vertexConsumer,
                        combinedLight,
                        combinedOverlay
                );

                poseStack.popPose();
            }
        } catch (Exception e) {
            TutorialMod.logger.error("Failed to render shield", e);
        }
    }
}

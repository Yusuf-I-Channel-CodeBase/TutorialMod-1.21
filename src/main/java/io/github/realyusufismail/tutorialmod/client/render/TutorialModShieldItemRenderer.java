package io.github.realyusufismail.tutorialmod.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.items.ModShieldItem;
import io.github.realyusufismail.tutorialmod.material.ShieldMaterial;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.Material;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TutorialModShieldItemRenderer extends ModBlockEntityWithoutLevelRenderer {

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
                poseStack.pushPose();
                poseStack.scale(1.0F, -1.0F, -1.0F);

                Material material;

                if (stack.is(ItemInit.GRAPHITE_SHIELD.get())) {
                    material = ShieldMaterial.SHIELD_BASE_GRAPHITE;
                } else {
                    material = ModelBakery.SHIELD_BASE;
                }

                TextureAtlasSprite sprite = material.sprite();
                VertexConsumer vertexConsumer =
                        sprite.wrap(ItemRenderer.getFoilBufferDirect(
                                buffer,
                                this.shieldModel.renderType(material.atlasLocation()),
                                true,
                                stack.hasFoil()));

                this.shieldModel.handle().render(poseStack, vertexConsumer, combinedLight, combinedOverlay);

                this.shieldModel.plate().render(poseStack, vertexConsumer, combinedLight, combinedOverlay);

                poseStack.popPose();
            }
        } catch (Exception e) {
            TutorialMod.logger.error("Failed to render shield", e);
        }
    }
}

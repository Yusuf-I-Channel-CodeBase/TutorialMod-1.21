package io.github.realyusufismail.tutorialmod.client.render.trident;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.projectile.ThrownTrident;
import org.jetbrains.annotations.NotNull;

public class TutorialModTridentItemRenderer extends EntityRenderer<ThrownTrident> {

    private final TridentModel tridentModel;

    public TutorialModTridentItemRenderer(EntityRendererProvider.Context context) {
        super(context);
        tridentModel = new TridentModel(context.bakeLayer(ModelLayers.TRIDENT));
    }

    @Override
    public void render(ThrownTrident pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(
                Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot()) - 90.0f));
        pPoseStack.mulPose(
                Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getYRot()) + 90.0f));
        VertexConsumer vertexConsumer =
                ItemRenderer.getFoilBufferDirect(
                        pBuffer,
                        tridentModel.renderType(getTextureLocation(pEntity)),
                false,
                pEntity.isFoil());
        tridentModel.renderToBuffer(pPoseStack, vertexConsumer, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(ThrownTrident pEntity) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "entity/trident/example_trident");
    }
}

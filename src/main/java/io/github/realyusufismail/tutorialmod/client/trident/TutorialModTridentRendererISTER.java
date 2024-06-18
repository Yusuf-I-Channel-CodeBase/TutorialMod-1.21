package io.github.realyusufismail.tutorialmod.client.trident;

import com.mojang.blaze3d.vertex.PoseStack;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.client.render.ModBlockEntityWithoutLevelRenderer;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class TutorialModTridentRendererISTER extends ModBlockEntityWithoutLevelRenderer {

    private TridentModel tridentModel;
    private final ModelResourceLocation modelResourceLocation =
            new ModelResourceLocation(ResourceLocation.fromNamespaceAndPath("tutorialmod", "example_trident"), "example_trident");
    private final ResourceLocation textureLocation =
            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "entity/trident/example_trident");

    @Override
    public void onResourceManagerReload(ResourceManager pResourceManager) {
        tridentModel = new TridentModel(this.entityModelSet.bakeLayer(ModelLayers.TRIDENT));
    }

    @Override
    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {

    }
}

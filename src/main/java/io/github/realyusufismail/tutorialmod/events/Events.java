package io.github.realyusufismail.tutorialmod.events;

import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Objects;

public class Events {

    public static void clientSetup(FMLClientSetupEvent event) {
        // Register client event listeners here
        event.enqueueWork(() -> {
            ItemProperties.register(ItemInit.GRAPHITE_SHIELD.get(), Objects.requireNonNull(ResourceLocation.tryParse("blocking"), "Failed to register blocking property"),
                    (pItemStack, pClientLevel, pLivingEntity, pPartialTicks) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
        });
    }
}

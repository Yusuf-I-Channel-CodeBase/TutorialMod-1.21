package io.github.realyusufismail.tutorialmod.events;

import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class Events {

    public static void clientSetup(FMLClientSetupEvent event) {
        // Register client event listeners here
        event.enqueueWork(() -> {
            ItemProperties.register(ItemInit.GRAPHITE_SHIELD.get(), ResourceLocation.read("blocking").getOrThrow(),
                    (pItemStack, pClientLevel, pLivingEntity, pPartialTicks) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
        });
    }
}

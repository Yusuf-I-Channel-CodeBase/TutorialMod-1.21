package io.github.realyusufismail.tutorialmod.events;

import io.github.realyusufismail.tutorialmod.armour.ExampleArmour;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Objects;

public class Events {

    public static void clientSetup(FMLClientSetupEvent event) {
        // Register client event listeners here
        event.enqueueWork(() -> {
            ItemProperties.register(ItemInit.GRAPHITE_SHIELD.get(), Objects.requireNonNull(ResourceLocation.tryParse("blocking"), "Failed to register blocking property"),
                    (pItemStack, pClientLevel, pLivingEntity, pPartialTicks) -> pLivingEntity != null && pLivingEntity.isUsingItem() && pLivingEntity.getUseItem() == pItemStack ? 1.0F : 0.0F);
        });
    }

    public static void onPlayerTickEventPre(PlayerTickEvent.Pre event) {
        // Handle player tick event here
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide ) {
            return;
        }

        if (Objects.requireNonNull(level.getServer(), "Tick count is null").getTickCount() % 40 == 5) {
            ExampleArmour.handleFlight(player);
        }
    }
}

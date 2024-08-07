package io.github.realyusufismail.tutorialmod.events;

import io.github.realyusufismail.tutorialmod.armour.ExampleArmour;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.items.ModSwordItem;
import io.github.realyusufismail.tutorialmod.util.TutorialModUtils;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.Objects;

import static io.github.realyusufismail.tutorialmod.util.TutorialModUtils.getTimeInTicks;

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

        if (level.isClientSide) {
            return;
        }

        if (Objects.requireNonNull(level.getServer(), "Tick count is null").getTickCount() % 40 == 5) {
            ExampleArmour.handleFlight(player);
        }
    }

    /**
     * This method is called when a player is damaged by an entity.
     *
     * @param event The event that is fired when a player is damaged by an entity.
     * @see DamageContainer
     */
    public static void onEntityDamage(LivingDamageEvent.Post event) {
        ItemStack weapon = event.getSource().getWeaponItem();
        if (weapon != null) {
            if (weapon.getItem() instanceof ModSwordItem) {
                event.getEntity()
                        .igniteForTicks(getTimeInTicks(30, TutorialModUtils.TimeUnit.SECONDS));
            }
        }
    }
}

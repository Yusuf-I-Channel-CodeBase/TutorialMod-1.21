package io.github.realyusufismail.tutorialmod.client.shield;

import io.github.realyusufismail.tutorialmod.client.render.shield.TutorialModShieldItemRenderer;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

public class TutorialModShieldItemRendererProvider {
    private static TutorialModShieldItemRenderer shieldItemRenderer;

    public static void init(final RegisterClientReloadListenersEvent event) {
        shieldItemRenderer = new TutorialModShieldItemRenderer();

        event.registerReloadListener(shieldItemRenderer);
    }

    public static IClientItemExtensions shield() {
        return new IClientItemExtensions() {
            @Override
            public @NotNull TutorialModShieldItemRenderer getCustomRenderer() {
                return shieldItemRenderer;
            }
        };
    }
}

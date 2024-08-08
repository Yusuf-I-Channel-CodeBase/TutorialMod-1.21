package io.github.realyusufismail.events;

import io.github.realyusufismail.armour.ExampleArmour;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.jetbrains.annotations.NotNull;

public class Events {

    public static void onPlayerTickEventsPre(PlayerTickEvent.@NotNull Pre event) {
        Player player = event.getEntity();
        Level level = player.level();

        if (level.isClientSide()) {
            return;
        }

        if (level.getServer() == null) {
            return;
        }

        if (level.getServer().getTickCount() % 40 == 5) {
            ExampleArmour.handleFlightAndEffects(player);
        }
    }
}

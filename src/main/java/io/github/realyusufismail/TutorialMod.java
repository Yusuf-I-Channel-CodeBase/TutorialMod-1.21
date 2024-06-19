package io.github.realyusufismail;

import io.github.realyusufismail.data.DataGenerators;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.CreativeModeTabInit;
import io.github.realyusufismail.init.ItemInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger logger = LoggerFactory.getLogger(TutorialMod.class);

    public TutorialMod(@NotNull IEventBus bus) {
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        bus.addListener(DataGenerators::gatherData);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Hello from TutorialMod!, using version: {}", modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}

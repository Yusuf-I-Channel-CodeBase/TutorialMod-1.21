package io.github.realyusufismail;

import io.github.realyusufismail.data.DataGenerators;
import io.github.realyusufismail.events.Events;
import io.github.realyusufismail.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TutorialMod.MOD_ID)
public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    public static final Logger logger = LoggerFactory.getLogger(TutorialMod.class);

    public TutorialMod(@NotNull IEventBus bus) {
        IEventBus neoForgeBus = NeoForge.EVENT_BUS;

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);
        LootModifierInit.LOOT_MODIFIERS.register(bus);
        ArmorMaterialInit.ARMOR_MATERIALS.register(bus);

        bus.addListener(DataGenerators::gatherData);
        neoForgeBus.addListener(Events::onPlayerTickEventsPre);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Hello from TutorialMod!, using version: {}", modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}

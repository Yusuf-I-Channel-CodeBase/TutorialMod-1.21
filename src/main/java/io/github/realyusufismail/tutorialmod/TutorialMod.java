package io.github.realyusufismail.tutorialmod;

import io.github.realyusufismail.tutorialmod.init.ArmorMaterialInit;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.CreativeModeTabInit;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(TutorialMod.MOD_ID)

public class TutorialMod {
    public static final String MOD_ID = "tutorialmod";
    public static Logger logger = LoggerFactory.getLogger(TutorialMod.class);

    public TutorialMod(IEventBus bus) {
        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        ArmorMaterialInit.ARMOR_MATERIALS.register(bus);
        CreativeModeTabInit.CREATIVE_MODE_TABS.register(bus);

        bus.addListener(FMLClientSetupEvent.class, (fmlClientSetupEvent -> {
            fmlClientSetupEvent.enqueueWork(() -> {
                ModList.get().getModContainerById(MOD_ID).ifPresent(modContainer -> {
                    logger.info("Loaded {}, using version {}", modContainer.getModInfo().getDisplayName(), modContainer.getModInfo().getVersion());
                });
            });
        }));
    }
}

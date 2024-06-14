package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class CreativeModeTabInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static String TUTORIAL_MOD_TAB_ONE_TITLE = "tutorialmod.tab.one";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TUTORIAL_MOD_TAB_ONE = CREATIVE_MODE_TABS.register("tutorial_mod_tab_one", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplayParameters, output) -> {

            ItemInit.ITEMS.getEntries()
                    .stream()
                    .map((item) -> item.get().asItem())
                    .forEach(output::accept);

            var b = BlockInit.BLOCKS.getEntries()
                    .stream()
                    .map((block) -> block.get().asItem())
                    .forEach(output::accept);

            // TODO: find out why there is duplicate entries
            //check for no duplicate entries
        });

        builder.icon(() -> new ItemStack(ItemInit.EXAMPLE_ITEM.get()));
        builder.title(Component.translatable(TUTORIAL_MOD_TAB_ONE_TITLE));

        return builder.build();
    });
}

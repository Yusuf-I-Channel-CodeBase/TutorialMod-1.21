package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashSet;
import java.util.Set;

public class CreativeModeTabInit {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static String TUTORIAL_MOD_TAB_ONE_TITLE = "tutorialmod.tab.one";

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TUTORIAL_MOD_TAB_ONE = CREATIVE_MODE_TABS.register("tutorial_mod_tab_one", () -> {
        CreativeModeTab.Builder builder = CreativeModeTab.builder();

        builder.displayItems((itemDisplayParameters, output) -> {
            // Added to prevent duplicates
            Set<Item> addedItems = new HashSet<>();

            ItemInit.ITEMS.getEntries()
                    .stream()
                    .map((item) -> item.get().asItem())
                    .filter(addedItems::add)  // add to the set and filter out duplicates
                    .forEach(output::accept);

            BlockInit.BLOCKS.getEntries()
                    .stream()
                    .map((block) -> block.get().asItem())
                    .filter(addedItems::add)  // add to the set and filter out duplicates
                    .forEach(output::accept);
        });

        builder.icon(() -> new ItemStack(ItemInit.EXAMPLE_ITEM.get()));
        builder.title(Component.translatable(TUTORIAL_MOD_TAB_ONE_TITLE));

        return builder.build();
    });
}

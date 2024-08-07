package io.github.realyusufismail.tutorialmod.data.lang;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.CreativeModeTabInit;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {
    public ModEnLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        // items
        addItem(ItemInit.EXAMPLE_ITEM, "Example Item");
        addItem(ItemInit.RAW_EXAMPLE, "Raw Example");

        addItem(ItemInit.HELMET, "Helmet");
        addItem(ItemInit.CHESTPLATE, "Chestplate");
        addItem(ItemInit.LEGGINGS, "Leggings");
        addItem(ItemInit.BOOTS, "Boots");

        // blocks
        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");
        addBlock(BlockInit.EXAMPLE_ORE, "Example Ore");
        addBlock(BlockInit.DEEPSLATE_EXAMPLE_ORE, "Deepslate Example Ore");

        // tools
        addItem(ItemInit.SWORD, "Sword");
        addItem(ItemInit.PICKAXE, "Pickaxe");
        addItem(ItemInit.GRAPHITE_SHIELD, "Graphite Shield");

        // others
        add(CreativeModeTabInit.TUTORIAL_MOD_TAB_ONE_TITLE, "Tutorial Mod");

        // advancements
        addAdvancement("root", "Using Tutorial Mod", "Thanks for using the tutorial mod!");
        addAdvancement("raw_example", "Raw Example", "You have mined some raw example!");
        addAdvancement("example", "Example", "You have smelted some example!");
        addAdvancement("example_block", "Example Block", "You have crafted an example block!");
        addAdvancement("sword", "Sword", "You have crafted an example sword!");
        addAdvancement("pickaxe", "Pickaxe", "You have crafted an example pickaxe!");
        addAdvancement("example_armor", "Example Armor", "You have crafted an example armor set!");
    }

    private void addAdvancement(String advancement, String title, String description) {
        add("advancements." + TutorialMod.MOD_ID + "." + advancement + ".title", title);
        add("advancements." + TutorialMod.MOD_ID + "." + advancement + ".description", description);
    }
}
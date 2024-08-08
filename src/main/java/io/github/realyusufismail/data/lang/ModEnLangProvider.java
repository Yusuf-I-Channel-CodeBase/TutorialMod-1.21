package io.github.realyusufismail.data.lang;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.CreativeModeTabInit;
import io.github.realyusufismail.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModEnLangProvider extends LanguageProvider {

    public ModEnLangProvider(PackOutput output) {
        super(output, TutorialMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        addItem(ItemInit.EXAMPLE_ITEM, "Example Item");
        addItem(ItemInit.RAW_EXAMPLE, "Raw Example");

        // Armor
        addItem(ItemInit.HELMET, "Helmet");
        addItem(ItemInit.CHESTPLATE, "Chestplate");
        addItem(ItemInit.LEGGINGS, "Leggings");
        addItem(ItemInit.BOOTS, "Boots");

        //Blocks
        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");

        // Ores
        addBlock(BlockInit.EXAMPLE_ORE, "Example Ore");

        // Deepslate Ores
        addBlock(BlockInit.DEEPSLATE_EXAMPLE_ORE, "Deepslate Example Ore");

        // others
        add(CreativeModeTabInit.TUTORIAL_MOD_TAB_ONE_TITLE, "Tutorial Mod");
    }
}

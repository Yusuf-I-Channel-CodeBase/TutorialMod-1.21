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

        //Blocks
        addBlock(BlockInit.EXAMPLE_BLOCK, "Example Block");

        // others
        add(CreativeModeTabInit.TUTORIAL_MOD_TAB_ONE_TITLE, "Tutorial Mod");
    }
}

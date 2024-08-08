package io.github.realyusufismail.data;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.data.lang.ModEnLangProvider;
import io.github.realyusufismail.data.loot.ModGlobalLootModifiersProvider;
import io.github.realyusufismail.data.loottable.ModLootTables;
import io.github.realyusufismail.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.data.tag.ModBlockTagsProvider;
import io.github.realyusufismail.data.tag.ModItemTagProvider;
import io.github.realyusufismail.data.texture.ModBlockStateProvider;
import io.github.realyusufismail.data.texture.ModItemStateProvider;
import io.github.realyusufismail.data.worldgen.ModWorldGenProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {

    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

            generator.addProvider(true, new ModEnLangProvider(output));
            generator.addProvider(true, new ModItemStateProvider(output, existingFileHelper));
            generator.addProvider(true, new ModBlockStateProvider(output, existingFileHelper));
            ModBlockTagsProvider modBlockTagsProvider = new ModBlockTagsProvider(output, event.getLookupProvider(), existingFileHelper);
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, new ModItemTagProvider(output, event.getLookupProvider(), modBlockTagsProvider, existingFileHelper));
            generator.addProvider(true, new ModLootTables(output, event.getLookupProvider()));
            generator.addProvider(true, new ModWorldGenProvider(output, event.getLookupProvider()));
            generator.addProvider(true, new MainModRecipeProvider(generator, event.getLookupProvider()));
            generator.addProvider(true, new ModGlobalLootModifiersProvider(output, event.getLookupProvider()));
        } catch (RuntimeException e) {
            TutorialMod.logger.error("Failed to gather data", e);
        }
    }
}

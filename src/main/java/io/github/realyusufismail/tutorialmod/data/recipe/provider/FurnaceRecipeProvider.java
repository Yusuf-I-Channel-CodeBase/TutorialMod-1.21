package io.github.realyusufismail.tutorialmod.data.recipe.provider;


import io.github.realyusufismail.tutorialmod.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public FurnaceRecipeProvider(DataGenerator generator, RecipeOutput output, CompletableFuture<HolderLookup. Provider> pRegistries) {
        super(generator, pRegistries);
        this.output = output;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM, 0.6f, 300)
                .unlockedBy("has_item", has(ItemInit.RAW_EXAMPLE.get()))
                .save(output, getModId("raw_example_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.3f, 300)
                .unlockedBy("has_item", has(ItemInit.RAW_EXAMPLE.get()))
                .save(output, getModId("raw_example_blasting"));
    }
}
package io.github.realyusufismail.data.recipe.provider;

import io.github.realyusufismail.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.ItemInit;
import io.github.realyusufismail.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class FurnaceRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput recipeOutput;

    public FurnaceRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> pRegistries, RecipeOutput recipeOutput) {
        super(generator, pRegistries);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM, 0.6f, 300)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG))
                .save(this.recipeOutput, getModId("example_item_smelting"));

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG), RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM, 0.6f, 100)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG))
                .save(this.recipeOutput, getModId("example_item_blasting"));
    }
}

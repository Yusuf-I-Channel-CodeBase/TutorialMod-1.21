package io.github.realyusufismail.data.recipe.provider;

import io.github.realyusufismail.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput recipeOutput;


    public NormalCraftingTableRecipeProvider(DataGenerator generator, CompletableFuture<HolderLookup.Provider> pRegistries, RecipeOutput recipeOutput) {
        super(generator, pRegistries);
        this.recipeOutput = recipeOutput;
    }

    public void build() {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXAMPLE_BLOCK.get(), 1)
                .requires(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG), 9)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(this.recipeOutput, getModId("example_item_block_recipe"));
    }
}

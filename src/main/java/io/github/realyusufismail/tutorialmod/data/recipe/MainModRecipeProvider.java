package io.github.realyusufismail.tutorialmod.data.recipe;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.data.recipe.provider.FurnaceRecipeProvider;
import io.github.realyusufismail.tutorialmod.data.recipe.provider.NormalCraftingTableRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class MainModRecipeProvider extends RecipeProvider {
    protected final DataGenerator generator;
    private final CompletableFuture<HolderLookup.Provider> pRegistries;

    public MainModRecipeProvider(@NotNull DataGenerator generator, CompletableFuture<HolderLookup. Provider> pRegistries) {
        super(generator.getPackOutput(), pRegistries);
        this.generator = generator;
        this.pRegistries = pRegistries;
    }


    @Override
    protected void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        new NormalCraftingTableRecipeProvider(generator, recipeOutput, pRegistries).build();
        new FurnaceRecipeProvider(generator, recipeOutput, pRegistries).build();
    }

    public ResourceLocation getModId(String path) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, path);
    }
}
package io.github.realyusufismail.tutorialmod.data.recipe.provider;

import io.github.realyusufismail.tutorialmod.data.recipe.MainModRecipeProvider;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.concurrent.CompletableFuture;

public class NormalCraftingTableRecipeProvider extends MainModRecipeProvider {
    private final RecipeOutput output;

    public NormalCraftingTableRecipeProvider(DataGenerator generator, RecipeOutput output, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(generator, pRegistries);
        this.output = output;
    }

    public void build() {
        //ShapedRecipeBuilder has to be crafted in a certain order like a sword
        //ShapelessRecipeBuilder like making an iron block. no order

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, BlockInit.EXAMPLE_BLOCK.get(), 1)
                .requires(Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG), 9)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_block_recipe"));


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.SWORD.get(), 1)
                .pattern(" x ")
                .pattern(" x ")
                .pattern(" s ")
                .define('s', Items.STICK)
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_sword_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.PICKAXE.get(), 1)
                .pattern("xxx")
                .pattern(" s ")
                .pattern(" s ")
                .define('s', Items.STICK)
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_pickaxe_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ItemInit.GRAPHITE_SHIELD.get(), 1)
                .pattern(" A ")
                .pattern("SIS")
                .pattern("SSS")
                .define('A', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .define('I', Items.IRON_INGOT)
                .define('S', Items.SHIELD)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_shield_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.HELMET.get(), 1)
                .pattern("xxx")
                .pattern("x x")
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_helmet_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.CHESTPLATE.get(), 1)
                .pattern("x x")
                .pattern("xxx")
                .pattern("xxx")
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_chestplate_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.LEGGINGS.get(), 1)
                .pattern("xxx")
                .pattern("x x")
                .pattern("x x")
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_leggings_recipe"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ItemInit.BOOTS.get(), 1)
                .pattern("x x")
                .pattern("x x")
                .define('x', TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG)
                .unlockedBy("has_item", has(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG))
                .save(output, getModId("example_item_boots_recipe"));
    }
}

package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public class TagsInit {
    @Contract("_ -> new")
    public static @NotNull ResourceLocation createOresLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "ores/" + name);
    }

    @Contract("_ -> new")
    public static @NotNull ResourceLocation createBlocksLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
    }

    @Contract("_ -> new")
    public static @NotNull ResourceLocation createGenericItemsLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
    }

    @Contract("_ -> new")
    public static @NotNull ResourceLocation createRawItemsLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "raw/" + name);
    }

    @Contract("_ -> new")
    public static @NotNull ResourceLocation createArmourLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "armour/" + name);
    }

    public static @NotNull TagKey<Block> createToolTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    private static @NotNull TagKey<Item> createItemToolTag(String name) {
        return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    public static class ItemTagsInit {

        // Item Tags
        public static final TagKey<Item> EXAMPLE_ITEM_TAG =
                ItemTags.create(createGenericItemsLocation("example_item"));

        public static final TagKey<Item> EXAMPLE_RAW_TAG =
                ItemTags.create(createRawItemsLocation("example_raw"));

        // Blocks
        public static final TagKey<Item> EXAMPLE_BLOCK_TAG =
                ItemTags.create(createBlocksLocation("example_block"));

        public static final TagKey<Item> EXAMPLE_ORE_TAG =
                ItemTags.create(createOresLocation("example_ore"));

        public static final TagKey<Item> DEEPSLATE_EXAMPLE_ORE_TAG =
                ItemTags.create(createOresLocation("deepslate_example_ore"));
    }

    public static class BlockTagsInit {
        public static final TagKey<Block> EXAMPLE_BLOCK_TAG =
                BlockTags.create(createBlocksLocation("example_block"));

        public static final TagKey<Block> EXAMPLE_ORE_TAG =
                BlockTags.create(createOresLocation("example_ore"));

        public static final TagKey<Block> DEEPSLATE_EXAMPLE_ORE_TAG =
                BlockTags.create(createOresLocation("deepslate_example_ore"));


        // Tags that determines what blocks this tool cannot break.
        public static final TagKey<Block> INCORRECT_FOR_EXAMPLE_TOOL =
                createToolTag("incorrect_for_example_tool");

        // Tags that determines what blocks this tool can break.
        public static final TagKey<Block> NEEDS_EXAMPLE_TOOL =
                createToolTag("needs_example_tool");
    }
}

package io.github.realyusufismail.init;

import io.github.realyusufismail.TutorialMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsInit {
    public static ResourceLocation createOreLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,  "ores/" + name);
    }

    public static ResourceLocation createBlockLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
    }

    public static ResourceLocation createGenericItemsLocation(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name);
    }

    public static ResourceLocation createRawItemsLocation(String name) {
        return  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "raw/" + name);
    }

    public static TagKey<Block> createToolTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }

    public static class ItemTagsInit {
        // Items
        public static final TagKey<Item> EXAMPLE_ITEM_TAG = ItemTags.create(createGenericItemsLocation("example_item"));

        public static final TagKey<Item> EXAMPLE_RAW_TAG = ItemTags.create(createRawItemsLocation("example_raw"));

        // Blocks
        public static final TagKey<Item> EXAMPLE_BLOCK_TAG = ItemTags.create(createBlockLocation("example_block"));

        public static final TagKey<Item> EXAMPLE_ORE_TAG = ItemTags.create(createOreLocation("example_ore"));

        public static final TagKey<Item> DEEPSLATE_EXAMPLE_ORE_TAG = ItemTags.create(createOreLocation("deepslate_example_ore"));
    }

    public static class BlockTagsInit {
        public static final TagKey<Block> EXAMPLE_BLOCK_TAG =
                BlockTags.create(createBlockLocation("example_block"));

        public static final TagKey<Block> EXAMPLE_ORE_TAG =
                BlockTags.create(createOreLocation("example_ore"));

        public static final TagKey<Block> DEEPSLATE_EXAMPLE_ORE_TAG =
                BlockTags.create(createOreLocation("deepslate_example_ore"));
    }
}

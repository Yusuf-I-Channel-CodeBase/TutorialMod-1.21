package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class TagsInit {
    // ITEMS TAGS
    public static final TagKey<Item> EXAMPLE_ITEM_TAG =
            ItemTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "example_item"));

    // BLOCKS TAGS
    public static final TagKey<Block> EXAMPLE_BLOCK_TAG =
            BlockTags.create(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "example_block"));

    // ARMOUR TAGS
    public static final TagKey<ArmorMaterial> EXAMPLE_ARMOUR_TAG =
            TagKey.create(Registries.ARMOR_MATERIAL, ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "example_armour"));
}

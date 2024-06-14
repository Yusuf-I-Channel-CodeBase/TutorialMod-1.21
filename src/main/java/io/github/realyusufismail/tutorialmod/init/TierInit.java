package io.github.realyusufismail.tutorialmod.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class TierInit {
    public static SimpleTier SWORD = new SimpleTier(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG, 3, 2000, 0f, 10, () ->
            Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG));
}

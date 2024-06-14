package io.github.realyusufismail.tutorialmod.init;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class TierInit {
    public static SimpleTier SWORD = new SimpleTier(TagsInit.EXAMPLE_BLOCK_TAG, 3, 2000, 0f, 10, () ->
            Ingredient.of(TagsInit.EXAMPLE_ITEM_TAG));
}

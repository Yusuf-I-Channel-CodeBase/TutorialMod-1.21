package io.github.realyusufismail.tutorialmod.init;

import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

/**
 * @see Tiers
 */
public class TierInit {
    public static SimpleTier SWORD = new SimpleTier(
            // The tag that determines what blocks this tool cannot break. See below for more information.
            // Iron durability is 250, mining speed is 6f, attack damage bonus is 3f.
            // For attack damage bonus for example, swords do (getAttackDamageBonus() + 4) damage.
            TagsInit.BlockTagsInit.INCORRECT_FOR_EXAMPLE_TOOL, 250, 7f, 1f, 10, () ->
            Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG));

    public static SimpleTier PICKAXE = new SimpleTier(
            TagsInit.BlockTagsInit.INCORRECT_FOR_EXAMPLE_TOOL, 250, 5f, 0f, 10, () ->
            Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG));
}

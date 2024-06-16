package io.github.realyusufismail.tutorialmod.data.loot;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.loot.AddItemModifier;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TutorialMod.MOD_ID);
    }

    @Override
    protected void start() {
        // Add your loot modifiers here
        add("example_item_from_grass", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS_BLOCK).build(),
                // 35% chance
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ItemInit.EXAMPLE_ITEM.get()));

        add("example_item_from_creeper", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS_BLOCK).build(),
                LootTableIdCondition.builder(ResourceLocation.parse("entities/creeper")).build()},
                ItemInit.EXAMPLE_ITEM.get()));
    }
}

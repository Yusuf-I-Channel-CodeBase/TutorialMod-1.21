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

// see https://github.com/Luohuayu/CatServer/blob/1c92118fcca69ffac97a48c8e1f6e1bb861b41d1/src/main/java/org/bukkit/loot/LootTables.java#L71 for some loot tables
public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, TutorialMod.MOD_ID);
    }

    @Override
    protected void start() {
        // Add your loot modifiers here
        add("example_item_from_igloo_chest", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("chests/igloo_chest")).build(),
                // 35% chance to get example item from igloo chest
                LootItemRandomChanceCondition.randomChance(0.35f).build()},
                ItemInit.EXAMPLE_ITEM.get()));

        add("example_item_from_iron_golem", new AddItemModifier(new LootItemCondition[]{
                LootTableIdCondition.builder(ResourceLocation.parse("entities/iron_golem")).build()},
                ItemInit.EXAMPLE_ITEM.get()));
    }
}

package io.github.realyusufismail.data.loottable;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.ItemInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables(HolderLookup.Provider p_344943_) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), p_344943_);
    }

    @Override
    protected void generate() {
        add(BlockInit.EXAMPLE_ORE.get(), createOreDrop(BlockInit.EXAMPLE_ORE.get(), ItemInit.RAW_EXAMPLE.get()));
        add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), createOreDrop(BlockInit.DEEPSLATE_EXAMPLE_ORE.get(), ItemInit.RAW_EXAMPLE.get()));

        dropSelf(BlockInit.EXAMPLE_BLOCK.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
       return BuiltInRegistries.BLOCK.stream()
               .filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block))
                       .filter(key -> key.getNamespace().equals(TutorialMod.MOD_ID))
                       .isPresent())
               .collect(Collectors.toSet());
    }
}

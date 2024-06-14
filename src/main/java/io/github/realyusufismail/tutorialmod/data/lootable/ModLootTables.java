package io.github.realyusufismail.tutorialmod.data.lootable;

import com.google.common.collect.Sets;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.WritableRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class ModLootTables extends LootTableProvider {
    public ModLootTables(PackOutput packOutput, CompletableFuture<HolderLookup. Provider> pRegistries) {
        super(packOutput, Set.of(), List.of(new SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)), pRegistries);
    }

    @Override
    public void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationContext, ProblemReporter.Collector problemreporter$collector) {
        var modLootTablesId = BuiltInLootTables.all()
                .stream()
                .filter((id) -> id.registry().getNamespace().equals(TutorialMod.MOD_ID))
                .collect(Collectors.toSet());

        for (var id : Sets.difference(modLootTablesId, writableregistry.keySet())) {
            validationContext.reportProblem("Missing mod loot table: " + id);
        }

        writableregistry.forEach((lootTable) -> lootTable.validate(validationContext));
    }
}
package io.github.realyusufismail.tutorialmod.loot;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class DungeonLootEnhancerModifier extends LootModifier {
    public static final Supplier<MapCodec<DungeonLootEnhancerModifier>> CODEC_SUPPLIER = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
            .and(ExtraCodecs.POSITIVE_INT.optionalFieldOf("multiplication_factor", 2).forGetter(m -> m.multiplicationFactor))
            .apply(inst, DungeonLootEnhancerModifier::new)));

    private final int multiplicationFactor;

    public DungeonLootEnhancerModifier(LootItemCondition[] conditionsIn, int multiplicationFactor) {
        super(conditionsIn);
        this.multiplicationFactor = multiplicationFactor;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.hasParam(LootContextParams.THIS_ENTITY)) {
            // Only modify if a player attempts to open it
            return generatedLoot.stream()
                    .map(ItemStack::copy)
                    .peek(stack -> stack.setCount(Math.min(stack.getMaxStackSize(), stack.getCount() * this.multiplicationFactor)))
                    .collect(Collectors.toCollection(ObjectArrayList::new));
        }

        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC_SUPPLIER.get();
    }
}

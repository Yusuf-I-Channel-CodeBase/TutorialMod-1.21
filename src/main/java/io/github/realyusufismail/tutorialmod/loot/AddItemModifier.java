package io.github.realyusufismail.tutorialmod.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static io.github.realyusufismail.tutorialmod.init.LootModifierInit.LOOT_MODIFIERS;

// Add one item to a spefic lootable
public class AddItemModifier extends LootModifier {

    public static final Supplier<MapCodec<AddItemModifier>> CODEC_SUPPLIER = LOOT_MODIFIERS.register("add_item", () ->
            RecordCodecBuilder.mapCodec(instance -> codecStart(instance)
                    .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(addItemModifier -> addItemModifier.item))
                    .apply(instance, AddItemModifier::new)));


    private final Item item;

    public AddItemModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        // Allows to add item conditions.
        // Like random chance.
        for (LootItemCondition condition : this.conditions) {
            if (!condition.test(context)) {
                return generatedLoot;
            }
        }

        // Adds the generated loot if not.
        generatedLoot.add(new ItemStack(item));
        return generatedLoot;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC_SUPPLIER.get();
    }
}

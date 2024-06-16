package io.github.realyusufismail.tutorialmod.init;

import com.mojang.serialization.MapCodec;
import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.loot.AddItemModifier;
import io.github.realyusufismail.tutorialmod.loot.DungeonLootEnhancerModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

// Loot Modifers allow you to add items to loot tables based on conditions. For example you can make where is a 35% for a diamond to drop from grass.
public class LootModifierInit {
    public static DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, TutorialMod.MOD_ID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemModifier>> ADD_ITEM_MODIFIER = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC_SUPPLIER);

    private static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<DungeonLootEnhancerModifier>> DUNGEON_LOOT = LOOT_MODIFIERS.register("dungeon_loot", DungeonLootEnhancerModifier.CODEC_SUPPLIER);
}

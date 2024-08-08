package io.github.realyusufismail.init;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.armour.ExampleArmour;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> RAW_EXAMPLE = ITEMS.register("raw_example", () -> new Item(new Item.Properties()));

    public static DeferredItem<Item> HELMET = ITEMS.register("helmet", () -> new ExampleArmour(ArmorItem.Type.HELMET, 15));

    public static DeferredItem<Item> CHESTPLATE = ITEMS.register("chestplate", () -> new ExampleArmour(ArmorItem.Type.CHESTPLATE, 15));

    public static DeferredItem<Item> LEGGINGS = ITEMS.register("leggings", () -> new ExampleArmour(ArmorItem.Type.LEGGINGS, 15));

    public static DeferredItem<Item> BOOTS = ITEMS.register("boots", () -> new ExampleArmour(ArmorItem.Type.BOOTS, 15));
}

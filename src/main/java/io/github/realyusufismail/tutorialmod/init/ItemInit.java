package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.armour.ExampleArmor;
import io.github.realyusufismail.tutorialmod.items.ModShieldItem;
import io.github.realyusufismail.tutorialmod.items.ModSwordItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemInit {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    public static final DeferredItem<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_EXAMPLE = ITEMS.register("raw_example", () -> new Item(new Item.Properties()));

    public static final DeferredItem<ModSwordItem> SWORD = ITEMS.register("sword", () -> new ModSwordItem(TierInit.SWORD,
            new Item.Properties()
                    .attributes(SwordItem.createAttributes(
                            TierInit.SWORD,
                            // The type-specific attack damage. Its calculated by adding this and the attack damage bonus, set in the tier.
                            // We have 5 here and an attack damage bonus of 1, so the sword will do 7 damage, as an extra 1 is added by default.
                            5,
                            // The type-specific attack speed modifier.
                            -2.6f
                    ))
                    .stacksTo(1)));

    public static final DeferredItem<Item> PICKAXE = ITEMS.register("pickaxe", () -> new PickaxeItem(TierInit.PICKAXE,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(
                            TierInit.PICKAXE,
                            5,
                            -2.8f
                    ))
                    .stacksTo(1)));

    public static DeferredItem<Item> HELMET = ITEMS.register("helmet", () -> new ExampleArmor(ArmorItem.Type.HELMET, 15));

    public static DeferredItem<Item> CHESTPLATE = ITEMS.register("chestplate", () -> new ExampleArmor(ArmorItem.Type.CHESTPLATE, 15));

    public static DeferredItem<Item> LEGGINGS = ITEMS.register("leggings", () -> new ExampleArmor(ArmorItem.Type.LEGGINGS, 15));

    public static DeferredItem<Item> BOOTS = ITEMS.register("boots", () -> new ExampleArmor(ArmorItem.Type.BOOTS, 15));

    public static DeferredItem<Item> GRAPHITE_SHIELD = ITEMS.register("graphite_shield", () -> new ModShieldItem(TierInit.SHIELD, 250));
}

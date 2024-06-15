package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.armour.ExampleArmour;
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

    public static final DeferredItem<Item> SWORD = ITEMS.register("sword", () -> new SwordItem(TierInit.SWORD,
            new Item.Properties()
                    .attributes(SwordItem.createAttributes(
                                    TierInit.SWORD,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            8,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.6f
                            ))
                    .stacksTo(1)));

    public static final DeferredItem<Item> PICKAXE = ITEMS.register("pickaxe", () -> new PickaxeItem(TierInit.PICKAXE,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(
                            TierInit.PICKAXE,
                            // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                            5,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                            // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                            -2.8f
                            ))
                    .stacksTo(1)));

    public static DeferredItem<Item> HELMET = ITEMS.register("helmet", () -> new ExampleArmour(ArmorItem.Type.HELMET, 15));

    public static DeferredItem<Item> CHESTPLATE = ITEMS.register("chestplate", () -> new ExampleArmour(ArmorItem.Type.CHESTPLATE, 15));

    public static DeferredItem<Item> LEGGINGS = ITEMS.register("leggings", () -> new ExampleArmour(ArmorItem.Type.LEGGINGS, 15));

    public static DeferredItem<Item> BOOTS = ITEMS.register("boots", () -> new ExampleArmour(ArmorItem.Type.BOOTS, 15));

}

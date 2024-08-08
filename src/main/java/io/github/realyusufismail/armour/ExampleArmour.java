package io.github.realyusufismail.armour;

import io.github.realyusufismail.init.ArmorMaterialInit;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class ExampleArmour extends ArmorItem implements IItemExtension {

    public ExampleArmour(Type type, int durability) {
        super(ArmorMaterialInit.EXAMPLE_ARMOR, type, new Item.Properties().durability(type.getDurability(durability)));
    }
}

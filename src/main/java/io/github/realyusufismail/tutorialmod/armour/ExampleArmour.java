package io.github.realyusufismail.tutorialmod.armour;

import io.github.realyusufismail.tutorialmod.init.ArmorMaterialInit;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class ExampleArmour extends ArmorItem implements IItemExtension {
    public ExampleArmour(Type pType, int durability) {
        super(ArmorMaterialInit.EXAMPLE_ARMOUR, pType, new Item.Properties().durability(pType.getDurability(durability)));
    }

}

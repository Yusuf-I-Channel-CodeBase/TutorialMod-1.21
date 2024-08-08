package io.github.realyusufismail.tutorialmod.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tier;

public class ModShieldItem extends ShieldItem {
    private final Tier tier;

    public ModShieldItem(Tier tier, int durability) {
        super(new Properties().stacksTo(1)
                .durability(durability));
        this.tier = tier;
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return this.tier.getRepairIngredient().test(pRepair);
    }
}

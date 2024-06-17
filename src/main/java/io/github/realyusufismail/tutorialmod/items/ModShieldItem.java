package io.github.realyusufismail.tutorialmod.items;

import io.github.realyusufismail.tutorialmod.client.TutorialModShieldItemRendererProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Tier;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class ModShieldItem extends ShieldItem {
    private final Tier tier;

    public ModShieldItem(Tier tier, int durability) {
        super(new Properties().stacksTo(1)
                .durability(durability));
        this.tier = tier;
    }

    @Override
    public void initializeClient(@NotNull Consumer<IClientItemExtensions> consumer) {
        consumer.accept(TutorialModShieldItemRendererProvider.shield());
    }

    @Override
    public boolean isValidRepairItem(ItemStack pToRepair, ItemStack pRepair) {
        return this.tier.getRepairIngredient().test(pRepair);
    }
}

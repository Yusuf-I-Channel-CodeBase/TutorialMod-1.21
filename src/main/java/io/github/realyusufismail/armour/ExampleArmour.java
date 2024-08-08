package io.github.realyusufismail.armour;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.ArmorMaterialInit;
import io.github.realyusufismail.utils.TutorialModUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class ExampleArmour extends ArmorItem implements IItemExtension {
    public static final ResourceLocation ENABLE_FLIGHT_RL = ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "enable_flight");
    public static final AttributeModifier ENABLE_FLIGHT = new AttributeModifier(ENABLE_FLIGHT_RL, 2.0D, AttributeModifier.Operation.ADD_VALUE);

    public ExampleArmour(Type type, int durability) {
        super(ArmorMaterialInit.EXAMPLE_ARMOR, type, new Item.Properties().durability(type.getDurability(durability)));
    }

    public static void handleFlightAndEffects(Player player) {
        ItemStack boots = player.getItemBySlot(EquipmentSlot.FEET);
        ItemStack leggings = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack chestplate = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);

        if (player.isCreative() || player.isSpectator() || !player.isAlive()) {
            return;
        }

        AttributeInstance attributeInstance = player.getAttribute(NeoForgeMod.CREATIVE_FLIGHT);

        if (attributeInstance == null) {
            TutorialMod.logger.error("Failed to get attribute instance for creative flight");
            return;
        }

        if (attributeInstance.getValue() == 1.0 && !attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
            return; // Creative flight is enabled, from another source
        }

        if (isWearingFullSet(boots, leggings, chestplate, helmet)) {
            if (!attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.addTransientModifier(ENABLE_FLIGHT);
            }

            if (!player.hasEffect(MobEffects.REGENERATION)) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, TutorialModUtils.getTimeInTicks(1, TutorialModUtils.TimeUnit.MINUTES), 1,
                        false, false, false));
            }
        } else {
            if (attributeInstance.hasModifier(ENABLE_FLIGHT_RL)) {
                attributeInstance.removeModifier(ENABLE_FLIGHT_RL);
            }

            if (player.hasEffect(MobEffects.REGENERATION)) {
                player.removeEffect(MobEffects.REGENERATION);
            }
        }
    }

    private static boolean isWearingFullSet(ItemStack boots, ItemStack leggings, ItemStack chestplate, ItemStack helmet) {
        return boots.getItem() instanceof ExampleArmour &&
                leggings.getItem() instanceof ExampleArmour &&
                chestplate.getItem() instanceof ExampleArmour &&
                helmet.getItem() instanceof ExampleArmour;
    }
}

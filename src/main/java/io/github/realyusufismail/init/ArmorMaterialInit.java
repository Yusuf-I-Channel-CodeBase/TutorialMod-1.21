package io.github.realyusufismail.init;

import io.github.realyusufismail.TutorialMod;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ArmorMaterialInit {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS =
            DeferredRegister.create(Registries.ARMOR_MATERIAL, TutorialMod.MOD_ID);

    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> EXAMPLE_ARMOR = ARMOR_MATERIALS.register("example_armor", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), (Map<ArmorItem.Type, Integer> map) -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 4);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            () -> Ingredient.of(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG),
            List.of(
                    new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "example")
                    )

                    // Creates a new armor texture that will be rendered on top of the previous at:
                    // - 'assets/mod_id/textures/models/armor/example_layer_1_overlay.png' for the outer texture
                    // - 'assets/mod_id/textures/models/armor/example_layer_2_overlay.png' for the inner texture (only legs)
                    // 'true' means that the armor material is dyeable; however, the item must also be added to the 'minecraft:dyeable' tag
                    // new ArmorMaterial.Layer(
                    //       ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "example"), "_overlay", true
                    //)
            ),
            // Returns the toughness value of the armor. The toughness value is an additional value included in
            // damage calculation, for more information, refer to the Minecraft Wiki's article on armor mechanics:
            // https://minecraft.wiki/w/Armor#Armor_toughness
            // Only diamond and netherite have values greater than 0 here, so we just return 0.
            0,
            // Returns the knockback resistance value of the armor. While wearing this armor, the player is
            // immune to knockback to some degree. If the player has a total knockback resistance value of 1 or greater
            // from all armor pieces combined, they will not take any knockback at all.
            // Only netherite has values greater than 0 here, so we just return 0.
            0
    ));
}

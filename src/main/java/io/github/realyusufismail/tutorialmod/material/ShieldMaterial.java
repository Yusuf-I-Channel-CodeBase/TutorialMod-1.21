package io.github.realyusufismail.tutorialmod.material;

import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class ShieldMaterial {

    public static final Material SHIELD_BASE_GRAPHITE = new Material(
            net.minecraft.client.renderer.Sheets.SHIELD_SHEET,
            ResourceLocation.fromNamespaceAndPath("tutorialmod", "entity/shield/shield_base_graphite"));

    public static final Material SHIELD_BASE_GRAPHITE_NO_PATTERN = new Material(
            net.minecraft.client.renderer.Sheets.SHIELD_SHEET,
            ResourceLocation.fromNamespaceAndPath("tutorialmod", "entity/shield/shield_base_nopattern"));
}

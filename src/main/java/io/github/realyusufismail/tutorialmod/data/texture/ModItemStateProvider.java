package io.github.realyusufismail.tutorialmod.data.texture;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemStateProvider extends ItemModelProvider {
    public ModItemStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        item(ItemInit.EXAMPLE_ITEM.get());
        item(ItemInit.RAW_EXAMPLE.get());

        // example armour
        item(ItemInit.HELMET.get());
        item(ItemInit.CHESTPLATE.get());
        item(ItemInit.LEGGINGS.get());
        item(ItemInit.BOOTS.get());

        // tools
        tool(ItemInit.SWORD.get());
        tool(ItemInit.PICKAXE.get());
    }


    private void item(Item item) {
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", "item/" + name);
    }

    private void tool(Item item) {
        String name = getItemName(item);
        getBuilder(name)
                .parent(getExistingFile(mcLoc("item/handheld")))
                .texture("layer0", "item/" + name);
    }

    private String getItemName(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString().replace(TutorialMod.MOD_ID + ":", "");
    }
}
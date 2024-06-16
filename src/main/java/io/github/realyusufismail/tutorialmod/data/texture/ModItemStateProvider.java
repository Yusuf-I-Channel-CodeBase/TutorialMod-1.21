package io.github.realyusufismail.tutorialmod.data.texture;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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

        // shield
        ModelFile builtInEntityModel = new ModelFile.UncheckedModelFile("builtin/entity");

        ModelFile graphiteShieldBlocking =
                shieldBlockingModel("graphite_shield_blocking", builtInEntityModel, "example_block");
        shieldModel("graphite_shield", builtInEntityModel, "example_block", graphiteShieldBlocking);
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

    private ModelFile shieldBlockingModel(String path, ModelFile parent, String particleTexture) {
        return getBuilder(path)
                .parent(parent)
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", modLoc(BLOCK_FOLDER + "/" + particleTexture))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(45f, 135f, 0f)
                .translation(3.51f, 11f, -2f)
                .scale(1f, 1f, 1f)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(45f, 135f, 0f)
                .translation(13.51f, 3f, 5f)
                .scale(1f, 1f, 1f)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0f, 180f, -5f)
                .translation(-15f, 5f, -11f)
                .scale(1.25f, 1.25f, 1.25f)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0f, 180f, -5f)
                .translation(5f, 5f, -11f)
                .scale(1.25f, 1.25f, 1.25f)
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(15f, -25f, -5f)
                .translation(2f, 3f, 0f)
                .scale(0.65f, 0.65f, 0.65f)
                .end()
                .end();
    }

    private void shieldModel(String path, ModelFile parent, String particleTexture, ModelFile blockingModel) {
        getBuilder(path)
                .parent(parent)
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", modLoc(BLOCK_FOLDER + "/" + particleTexture))
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(0f, 90f, 0f)
                .translation(10f, 6f, -4f)
                .scale(1f, 1f, 1f)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(0f, 90f, 0f)
                .translation(10f, 6f, 12f)
                .scale(1f, 1f, 1f)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_RIGHT_HAND)
                .rotation(0f, 180f, 5f)
                .translation(-10f, 2f, -10f)
                .scale(1.25f, 1.25f, 1.25f)
                .end()
                .transform(ItemDisplayContext.FIRST_PERSON_LEFT_HAND)
                .rotation(0f, 180f, 5f)
                .translation(10f, 0f, -10f)
                .scale(1.25f, 1.25f, 1.25f)
                .end()
                .transform(ItemDisplayContext.GUI)
                .rotation(15f, -25f, -5f)
                .translation(2f, 3f, 0f)
                .scale(0.65f, 0.65f, 0.65f)
                .end()
                .transform(ItemDisplayContext.FIXED)
                .rotation(0f, 180f, 0f)
                .translation(-2f, 4f, -5f)
                .scale(0.5f, 0.5f, 0.5f)
                .end()
                .transform(ItemDisplayContext.GROUND)
                .rotation(0f, 0f, 0f)
                .translation(4f, 4f, 2f)
                .scale(0.25f, 0.25f, 0.25f)
                .end()
                .end()
                .override()
                .predicate(mcLoc("blocking"), 1f)
                .model(blockingModel)
                .end();
    }
}
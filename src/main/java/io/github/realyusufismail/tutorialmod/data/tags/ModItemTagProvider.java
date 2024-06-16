package io.github.realyusufismail.tutorialmod.data.tags;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, BlockTagsProvider blockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, blockTagsProvider.contentsGetter(), TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // ore tag
        copy(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG, TagsInit.ItemTagsInit.EXAMPLE_ORE_TAG);

        // deepslate ore tag
        copy(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG, TagsInit.ItemTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG);

        // block tag
        copy(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG, TagsInit.ItemTagsInit.EXAMPLE_BLOCK_TAG);

        // ingot tag
        tag(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG).add(ItemInit.EXAMPLE_ITEM.get());

        // raw tag
        tag(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG).add(ItemInit.RAW_EXAMPLE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ItemInit.HELMET.get())
                .add(ItemInit.CHESTPLATE.get())
                .add(ItemInit.LEGGINGS.get())
                .add(ItemInit.BOOTS.get());
    }
}

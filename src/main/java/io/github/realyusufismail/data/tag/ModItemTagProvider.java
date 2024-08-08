package io.github.realyusufismail.data.tag;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.ItemInit;
import io.github.realyusufismail.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider,  BlockTagsProvider provider, ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, provider.contentsGetter(), TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        copy(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG, TagsInit.ItemTagsInit.EXAMPLE_BLOCK_TAG);

        copy(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG, TagsInit.ItemTagsInit.EXAMPLE_ORE_TAG);

        copy(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG, TagsInit.ItemTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG);

        tag(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG).add(ItemInit.EXAMPLE_ITEM.get());

        tag(TagsInit.ItemTagsInit.EXAMPLE_RAW_TAG).add(ItemInit.RAW_EXAMPLE.get());

        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ItemInit.HELMET.get())
                .add(ItemInit.CHESTPLATE.get())
                .add(ItemInit.LEGGINGS.get())
                .add(ItemInit.BOOTS.get());
    }
}

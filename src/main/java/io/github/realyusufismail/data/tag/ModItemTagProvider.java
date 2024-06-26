package io.github.realyusufismail.data.tag;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.ItemInit;
import io.github.realyusufismail.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
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

        tag(TagsInit.ItemTagsInit.EXAMPLE_ITEM_TAG).add(ItemInit.EXAMPLE_ITEM.get());

        // tag(ItemTags.TRIMMABLE_ARMOR)
    }
}

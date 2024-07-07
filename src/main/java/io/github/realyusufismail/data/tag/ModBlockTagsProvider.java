package io.github.realyusufismail.data.tag;

import io.github.realyusufismail.TutorialMod;
import io.github.realyusufismail.init.BlockInit;
import io.github.realyusufismail.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG)
                .add(BlockInit.EXAMPLE_BLOCK.get());

        tag(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG)
                .add(BlockInit.EXAMPLE_ORE.get());

        tag(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG)
                .add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .addTag(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG)
                .addTag(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG)
                .addTag(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG);

       // TagKey<Block> netherite = createNeoForgeTag("needs_netherite_tool")
       tag(BlockTags.NEEDS_IRON_TOOL)
                .addTag(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG)
                .addTag(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG)
                .addTag(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG);
    }
}

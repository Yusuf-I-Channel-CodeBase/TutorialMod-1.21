package io.github.realyusufismail.tutorialmod.data.tags;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.VanillaBlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @see VanillaBlockTagsProvider
 */
public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ore
        tag(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG)
                .add(BlockInit.EXAMPLE_ORE.get());

        // deepslate ore
        tag(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG).add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        // block
        tag(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG).add(BlockInit.EXAMPLE_BLOCK.get());

        // Needed to allow the block to be mined with a pickaxe, only for vanilla tools.
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.EXAMPLE_ORE.get(), BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        tag(TagsInit.BlockTagsInit.INCORRECT_FOR_EXAMPLE_TOOL);

        // determine if the block needs an iron tool to be mined

        //        TagKey<Block> goldTags = createNeoForgeTag("needs_gold_tool");
        //        TagKey<Block> netheriteTags = createNeoForgeTag("needs_netherite_tool");
        //        TagKey<Block> woodTags = createNeoForgeTag("needs_wood_tool");

        // can change the tag to any of the above or diamond or stone

        requiresIronTool(BlockInit.EXAMPLE_ORE.get(), BlockInit.DEEPSLATE_EXAMPLE_ORE.get());
        requiresCustomTool(TagsInit.BlockTagsInit.NEEDS_EXAMPLE_TOOL, BlockInit.EXAMPLE_BLOCK.get());
    }

    private void requiresIronTool(Block... block) {
        tag(BlockTags.NEEDS_IRON_TOOL).add(block);

    }

    private void requiresCustomTool(TagKey<Block> toolNeeded, Block... block) {
        tag(toolNeeded).add(block);
    }
}

package io.github.realyusufismail.tutorialmod.data.tags;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {

    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        // ore
        tag(TagsInit.BlockTagsInit.EXAMPLE_ORE_TAG).add(BlockInit.EXAMPLE_ORE.get());

        // deepslate ore
        tag(TagsInit.BlockTagsInit.DEEPSLATE_EXAMPLE_ORE_TAG).add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        // block
        tag(TagsInit.BlockTagsInit.EXAMPLE_BLOCK_TAG).add(BlockInit.EXAMPLE_BLOCK.get());

        // Needed to allow the block to be mined with a pickaxe
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockInit.EXAMPLE_ORE.get())
                .add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get())
                .add(BlockInit.EXAMPLE_BLOCK.get());

        // determine if the block needs an iron tool to be mined

        //        TagKey<Block> goldTags = createNeoForgeTag("needs_gold_tool");
        //        TagKey<Block> netheriteTags = createNeoForgeTag("needs_netherite_tool");
        //        TagKey<Block> woodTags = createNeoForgeTag("needs_wood_tool");

        // can change the tag to any of the above or diamond or stone

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(BlockInit.EXAMPLE_ORE.get())
                .add(BlockInit.DEEPSLATE_EXAMPLE_ORE.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockInit.EXAMPLE_BLOCK.get());
    }

    private static TagKey<Block> createNeoForgeTag(String name) {
        return TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name));
    }
}

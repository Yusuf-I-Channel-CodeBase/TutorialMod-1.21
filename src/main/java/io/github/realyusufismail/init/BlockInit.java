package io.github.realyusufismail.init;

import io.github.realyusufismail.TutorialMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockInit {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_BLOCK)));

    public static final DeferredBlock<Block> EXAMPLE_ORE = registerBlock("example_ore", () ->
            new Block(BlockBehaviour.Properties.of()
                    .destroyTime(3.0F)
                    .explosionResistance(10.0F)
                    .sound(SoundType.METAL)
                    .lightLevel((state) -> 5)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> DEEPSLATE_EXAMPLE_ORE = registerBlock("deepslate_example_ore", () ->
            new Block(BlockBehaviour.Properties.of()
                    .destroyTime(3.0F)
                    .explosionResistance(10.0F)
                    .sound(SoundType.METAL)
                    .lightLevel((state) -> 5)
                    .requiresCorrectToolForDrops()));


    public static DeferredBlock<Block> registerBlock(String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}

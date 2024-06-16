package io.github.realyusufismail.tutorialmod.init;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BlockInit {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = registerBlock("example_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.METAL)
                    .lightLevel(state -> 7)
                    //.requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> EXAMPLE_ORE = registerBlock("example_ore", () ->
            new Block(Block.Properties.of()
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.METAL)
                    .lightLevel(state -> 7)
                    .requiresCorrectToolForDrops()));

    // Deepslate ores - starts gen at y 0
    public static final DeferredBlock<Block> DEEPSLATE_EXAMPLE_ORE = registerBlock("deepslate_example_ore", () ->
            new Block(Block.Properties.of()
                    .destroyTime(3.0f)
                    .explosionResistance(10.0f)
                    .sound(SoundType.METAL)
                    .lightLevel(state -> 7)
                    .requiresCorrectToolForDrops()));

    public static @NotNull DeferredBlock<Block> registerBlock(
            String name, Supplier<Block> block) {
        DeferredBlock<Block> blockReg = BLOCKS.register(name, block);
        ItemInit.ITEMS.register(name, () -> new BlockItem(blockReg.get(), new Item.Properties()));
        return blockReg;
    }
}

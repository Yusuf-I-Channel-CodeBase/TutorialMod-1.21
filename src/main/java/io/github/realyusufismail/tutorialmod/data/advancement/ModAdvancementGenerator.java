package io.github.realyusufismail.tutorialmod.data.advancement;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import io.github.realyusufismail.tutorialmod.init.BlockInit;
import io.github.realyusufismail.tutorialmod.init.ItemInit;
import io.github.realyusufismail.tutorialmod.init.TagsInit;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
    private static ResourceLocation LIGHT_BLUE_WOOL = ResourceLocation.withDefaultNamespace("block/light_blue_wool.png");

    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
        ItemStack rootIcon = new ItemStack(ItemInit.EXAMPLE_ITEM.get());

        // Create a new advancement
        AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                .display(
                        rootIcon,
                        getTitle("root"),
                        getDescription("root"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        // showToast, announceToChat, hidden
                        true,
                        false,
                        false
                )
                .addCriterion("root", getItem(Items.CRAFTING_TABLE))
                .save(saver, getId("root"));

        // Create a child advancement
        AdvancementHolder rawExample = Advancement.Builder.advancement()
                .display(
                        new ItemStack(ItemInit.RAW_EXAMPLE.get()),
                        getTitle("raw_example"),
                        getDescription("raw_example"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .parent(rootAdvancement)
                .addCriterion("get_ore", getItem(ItemInit.RAW_EXAMPLE.get()))
                .save(saver, getId("raw_example"));

        AdvancementHolder exampleIngot = Advancement.Builder.advancement()
                .display(
                        new ItemStack(ItemInit.EXAMPLE_ITEM.get()),
                        getTitle("example_ingot"),
                        getDescription("example_ingot"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .parent(rawExample)
                .addCriterion("get_ingot", getItem(ItemInit.EXAMPLE_ITEM.get()))
                .save(saver, getId("example_ingot"));

        AdvancementHolder exampleBlock = Advancement.Builder.advancement()
                .display(
                        new ItemStack(BlockInit.EXAMPLE_BLOCK.get()),
                        getTitle("example_block"),
                        getDescription("example_block"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .parent(exampleIngot)
                .addCriterion("get_block", getItem(BlockInit.EXAMPLE_BLOCK.get()))
                .save(saver, getId("example_block"));

        Advancement.Builder.advancement()
                .display(
                        new ItemStack(ItemInit.SWORD.get()),
                        getTitle("sword"),
                        getDescription("sword"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .parent(exampleIngot)
                .addCriterion("get_sword", getItem(ItemInit.SWORD.get()))
                .save(saver, getId("sword"));

        Advancement.Builder.advancement()
                .display(
                        new ItemStack(ItemInit.PICKAXE.get()),
                        getTitle("pickaxe"),
                        getDescription("pickaxe"),
                        LIGHT_BLUE_WOOL,
                        AdvancementType.TASK,
                        true,
                        false,
                        false
                )
                .parent(exampleIngot)
                .addCriterion("get_pickaxe", getItem(ItemInit.PICKAXE.get()))
                .save(saver, getId("pickaxe"));

        Advancement.Builder.advancement()
                .display(
                        new ItemStack(ItemInit.HELMET.get()),
                        getTitle("example_armor"),
                        getDescription("example_armor"),
                        null,
                        AdvancementType.GOAL,
                        true,
                        true,
                        false)
                .addCriterion("example_helmet", getItem(ItemInit.HELMET.get()))
                .addCriterion("example_chestplate", getItem(ItemInit.CHESTPLATE.get()))
                .addCriterion("example_leggings", getItem(ItemInit.LEGGINGS.get()))
                .addCriterion("example_boots", getItem(ItemInit.BOOTS.get()))
                .requirements(AdvancementRequirements.Strategy.OR)
                .save(saver, getId("example_armor"));
    }

    private @NotNull Component getTitle(String name) {
        return Component.translatable("advancements." + TutorialMod.MOD_ID + "." + name + ".title");
    }

    private @NotNull Component getDescription(String name) {
        return Component.translatable("advancements." + TutorialMod.MOD_ID + "." + name + ".description");
    }

    private @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> getItem(ItemLike... items) {
        return InventoryChangeTrigger.TriggerInstance.hasItems(items);
    }

    private @NotNull String getId(String name) {
        return ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, name).toString();
    }
}

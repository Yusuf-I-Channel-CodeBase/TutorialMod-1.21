package io.github.realyusufismail.tutorialmod.data;

import io.github.realyusufismail.tutorialmod.TutorialMod;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

public class DataGenerators {
    public static void gatherData(GatherDataEvent event) {
        try {
            DataGenerator generator = event.getGenerator();
            PackOutput output = event.getGenerator().getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        } catch (Exception e) {
            TutorialMod.logger.error("Failed to gather data", e);
        }
    }
}

package com.sg143.smithing_plus;

import com.sg143.smithing_plus.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class SmithingPlusDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(LanguageEngGenProvider::new);
		pack.addProvider(ModelGenProvider::new);
		pack.addProvider(RecipeOverwriteProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ItemTagProvider::new);
	}
}

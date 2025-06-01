package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.datagen.custom.RefiningRecipeProvider;
import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        RefiningRecipeProvider refiningRecipeProvider = new RefiningRecipeProvider(wrapperLookup, recipeExporter);
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                generateCopyRecipe();
            }
            private void generateCopyRecipe() {
                List<Item> templates = List.of(
                        ModItems.HOE_TEMPLATE,
                        ModItems.SHOVEL_TEMPLATE,
                        ModItems.SWORD_TEMPLATE,
                        ModItems.AXE_TEMPLATE,
                        ModItems.PICKAXE_TEMPLATE
                );
                for (Item template : templates) {
                    refiningRecipeProvider.offerRefiningTemplateCopyingRecipe(template);
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Generated Recipe";
    }
}

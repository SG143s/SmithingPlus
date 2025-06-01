package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.datagen.custom.RefiningRecipeProvider;
import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class RecipeOverwriteProvider extends FabricRecipeProvider {
    public RecipeOverwriteProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier id) {
        // Here, use the id namespace as folder — this controls output path
        return Identifier.of(id.getNamespace(), id.getPath());
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        RefiningRecipeProvider refiningRecipeProvider = new RefiningRecipeProvider(wrapperLookup, recipeExporter);
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                generateRefiningRecipe();
                generateWoodenTools();
            }
            private void generateRefiningRecipe() {
                record RefiningData(Item template, Item input, TagKey<Item> materialTag, RecipeCategory category, Item result) {}
                List<RefiningData> recipes = List.of(
                        new RefiningData(ModItems.PICKAXE_TEMPLATE, ModItems.UNREFINED_DIAMOND_PICKAXE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE),
                        new RefiningData(ModItems.AXE_TEMPLATE, ModItems.UNREFINED_DIAMOND_AXE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_AXE),
                        new RefiningData(ModItems.SWORD_TEMPLATE, ModItems.UNREFINED_DIAMOND_SWORD, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.COMBAT, Items.DIAMOND_SWORD),
                        new RefiningData(ModItems.SHOVEL_TEMPLATE, ModItems.UNREFINED_DIAMOND_SHOVEL, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL),
                        new RefiningData(ModItems.HOE_TEMPLATE, ModItems.UNREFINED_DIAMOND_HOE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_HOE)
                );
                for (RefiningData r : recipes) {
                    refiningRecipeProvider.offerRefiningRecipe(r.template, r.input, r.materialTag, r.category, r.result);
                }
            }
            private void generateWoodenTools() {
                record ToolData(Item result, RecipeCategory category, List<String> pattern) {}
                List<ToolData> tools = List.of(
                        new ToolData(Items.WOODEN_PICKAXE, RecipeCategory.TOOLS, List.of("###", "XC ", " C ")),
                        new ToolData(Items.WOODEN_AXE, RecipeCategory.TOOLS, List.of("##", "#C", "XC")),
                        new ToolData(Items.WOODEN_SHOVEL, RecipeCategory.TOOLS, List.of(" #", "XC", " C")),
                        new ToolData(Items.WOODEN_SWORD, RecipeCategory.TOOLS, List.of(" #", " #", "XC")),
                        new ToolData(Items.WOODEN_HOE, RecipeCategory.TOOLS, List.of("##", "XC", " C"))
                );
                for (ToolData tool : tools) {
                    var builder = this.createShaped(tool.category, tool.result)
                            .input('#', this.ingredientFromTag(ItemTags.PLANKS))
                            .input('C', Items.STICK)
                            .input('X', Items.STRING)
                            .criterion(hasItem(Items.STICK), this.conditionsFromItem(Items.STICK));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.offerTo(this.exporter);
                }
            }
        };
    }



    @Override
    public String getName() {
        return "Overwritten Recipe";
    }
}

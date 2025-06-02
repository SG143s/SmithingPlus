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
                unrefinedIronRecipe();
                unrefinedGoldRecipe();
                unrefinedDiamondRecipe();
                this.createShaped(RecipeCategory.MISC, ModItems.TOOL_HANDLE)
                        .input('#', Items.STICK)
                        .input('C', Items.RESIN_CLUMP)
                        .criterion(hasItem(Items.RESIN_CLUMP), this.conditionsFromItem(Items.RESIN_CLUMP))
                        .pattern("C#C")
                        .pattern("C#C")
                        .offerTo(this.exporter);
                this.createShaped(RecipeCategory.MISC, ModItems.MACE_HANDLE)
                        .input('#', ModItems.TOOL_HANDLE)
                        .input('C', Items.BREEZE_ROD)
                        .criterion(hasItem(Items.BREEZE_ROD), this.conditionsFromItem(Items.BREEZE_ROD))
                        .pattern("C#C")
                        .pattern("C#C")
                        .offerTo(this.exporter);
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
            private void unrefinedIronRecipe() {
                record ToolData(Item result, RecipeCategory category, List<String> pattern) {}
                List<ToolData> tools = List.of(
                        new ToolData(ModItems.UNREFINED_IRON_PICKAXE, RecipeCategory.TOOLS, List.of("###", " C ", " C ")),
                        new ToolData(ModItems.UNREFINED_IRON_AXE, RecipeCategory.TOOLS, List.of("##", "#C", " C")),
                        new ToolData(ModItems.UNREFINED_IRON_SHOVEL, RecipeCategory.TOOLS, List.of("#", "C", "C")),
                        new ToolData(ModItems.UNREFINED_IRON_SWORD, RecipeCategory.TOOLS, List.of("#", "#", "C")),
                        new ToolData(ModItems.UNREFINED_IRON_HOE, RecipeCategory.TOOLS, List.of("##", " C", " C"))
                );
                for (ToolData tool : tools) {
                    var builder = this.createShaped(tool.category, tool.result)
                            .input('#', this.ingredientFromTag(ItemTags.IRON_TOOL_MATERIALS))
                            .input('C', ModItems.TOOL_HANDLE)
                            .criterion(hasItem(Items.IRON_INGOT), this.conditionsFromItem(Items.IRON_INGOT));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.offerTo(this.exporter);
                }
            }
            private void unrefinedDiamondRecipe() {
                record ToolData(Item result, RecipeCategory category, List<String> pattern) {}
                List<ToolData> tools = List.of(
                        new ToolData(ModItems.UNREFINED_DIAMOND_PICKAXE, RecipeCategory.TOOLS, List.of("###", " C ", " C ")),
                        new ToolData(ModItems.UNREFINED_DIAMOND_AXE, RecipeCategory.TOOLS, List.of("##", "#C", " C")),
                        new ToolData(ModItems.UNREFINED_DIAMOND_SHOVEL, RecipeCategory.TOOLS, List.of("#", "C", "C")),
                        new ToolData(ModItems.UNREFINED_DIAMOND_SWORD, RecipeCategory.TOOLS, List.of("#", "#", "C")),
                        new ToolData(ModItems.UNREFINED_DIAMOND_HOE, RecipeCategory.TOOLS, List.of("##", " C", " C"))
                );
                for (ToolData tool : tools) {
                    var builder = this.createShaped(tool.category, tool.result)
                            .input('#', this.ingredientFromTag(ItemTags.DIAMOND_TOOL_MATERIALS))
                            .input('C', ModItems.TOOL_HANDLE)
                            .criterion(hasItem(Items.DIAMOND), this.conditionsFromItem(Items.DIAMOND));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.offerTo(this.exporter);
                }
            }
            private void unrefinedGoldRecipe() {
                record ToolData(Item result, RecipeCategory category, List<String> pattern) {}
                List<ToolData> tools = List.of(
                        new ToolData(ModItems.UNREFINED_GOLDEN_PICKAXE, RecipeCategory.TOOLS, List.of("###", " C ", " C ")),
                        new ToolData(ModItems.UNREFINED_GOLDEN_AXE, RecipeCategory.TOOLS, List.of("##", "#C", " C")),
                        new ToolData(ModItems.UNREFINED_GOLDEN_SHOVEL, RecipeCategory.TOOLS, List.of("#", "C", "C")),
                        new ToolData(ModItems.UNREFINED_GOLDEN_SWORD, RecipeCategory.TOOLS, List.of("#", "#", "C")),
                        new ToolData(ModItems.UNREFINED_GOLDEN_HOE, RecipeCategory.TOOLS, List.of("##", " C", " C"))
                );
                for (ToolData tool : tools) {
                    var builder = this.createShaped(tool.category, tool.result)
                            .input('#', this.ingredientFromTag(ItemTags.GOLD_TOOL_MATERIALS))
                            .input('C', ModItems.TOOL_HANDLE)
                            .criterion(hasItem(Items.GOLD_INGOT), this.conditionsFromItem(Items.GOLD_INGOT));
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
        return "Generated Recipe";
    }
}

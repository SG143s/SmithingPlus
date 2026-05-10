package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.datagen.custom.RefiningRecipeProvider;
import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        RefiningRecipeProvider refiningRecipeProvider = new RefiningRecipeProvider(wrapperLookup, recipeExporter);
        return new RecipeProvider(wrapperLookup, recipeExporter) {
            @Override
            public void buildRecipes() {
                generateCopyRecipe();
                unrefinedIronRecipe();
                unrefinedGoldRecipe();
                unrefinedDiamondRecipe();
                this.shaped(RecipeCategory.MISC, ModItems.TOOL_HANDLE)
                        .define('#', Items.STICK)
                        .define('C', Items.RESIN_CLUMP)
                        .unlockedBy(getHasName(Items.RESIN_CLUMP), this.has(Items.RESIN_CLUMP))
                        .pattern("C#C")
                        .pattern("C#C")
                        .save(this.output);
                this.shaped(RecipeCategory.MISC, ModItems.MACE_HANDLE)
                        .define('#', ModItems.TOOL_HANDLE)
                        .define('C', Items.BREEZE_ROD)
                        .unlockedBy(getHasName(Items.BREEZE_ROD), this.has(Items.BREEZE_ROD))
                        .pattern("C#C")
                        .pattern("C#C")
                        .save(this.output);
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
                    var builder = this.shaped(tool.category, tool.result)
                            .define('#', this.tag(ItemTags.IRON_TOOL_MATERIALS))
                            .define('C', ModItems.TOOL_HANDLE)
                            .unlockedBy(getHasName(Items.IRON_INGOT), this.has(Items.IRON_INGOT));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.save(this.output);
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
                    var builder = this.shaped(tool.category, tool.result)
                            .define('#', this.tag(ItemTags.DIAMOND_TOOL_MATERIALS))
                            .define('C', ModItems.TOOL_HANDLE)
                            .unlockedBy(getHasName(Items.DIAMOND), this.has(Items.DIAMOND));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.save(this.output);
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
                    var builder = this.shaped(tool.category, tool.result)
                            .define('#', this.tag(ItemTags.GOLD_TOOL_MATERIALS))
                            .define('C', ModItems.TOOL_HANDLE)
                            .unlockedBy(getHasName(Items.GOLD_INGOT), this.has(Items.GOLD_INGOT));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.save(this.output);
                }
            }
        };
    }

    @Override
    public String getName() {
        return "Generated Recipe";
    }
}

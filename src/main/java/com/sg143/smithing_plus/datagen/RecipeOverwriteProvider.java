package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.datagen.custom.RefiningRecipeProvider;
import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class RecipeOverwriteProvider extends FabricRecipeProvider {
    public RecipeOverwriteProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected Identifier getRecipeIdentifier(Identifier id) {
        // Here, use the id namespace as folder — this controls output path
        return Identifier.fromNamespaceAndPath(id.getNamespace(), id.getPath());
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        RefiningRecipeProvider refiningRecipeProvider = new RefiningRecipeProvider(wrapperLookup, recipeExporter);
        return new RecipeProvider(wrapperLookup, recipeExporter) {
            @Override
            public void buildRecipes() {
                generateRefiningRecipe();
                generateWoodenTools();
                generateStoneTools();
                this.shaped(RecipeCategory.COMBAT, Items.MACE)
                        .define('X', Items.HEAVY_CORE)
                        .define('#', ModItems.MACE_HANDLE)
                        .pattern("X")
                        .pattern("#")
                        .unlockedBy(getHasName(Items.HEAVY_CORE), this.has(Items.HEAVY_CORE))
                        .save(this.output);
            }
            private void generateRefiningRecipe() {
                record RefiningData(Item template, Item input, TagKey<Item> materialTag, RecipeCategory category, Item result) {}
                List<RefiningData> recipes = List.of(
                        new RefiningData(ModItems.PICKAXE_TEMPLATE, ModItems.UNREFINED_DIAMOND_PICKAXE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_PICKAXE),
                        new RefiningData(ModItems.AXE_TEMPLATE, ModItems.UNREFINED_DIAMOND_AXE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_AXE),
                        new RefiningData(ModItems.SWORD_TEMPLATE, ModItems.UNREFINED_DIAMOND_SWORD, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.COMBAT, Items.DIAMOND_SWORD),
                        new RefiningData(ModItems.SHOVEL_TEMPLATE, ModItems.UNREFINED_DIAMOND_SHOVEL, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_SHOVEL),
                        new RefiningData(ModItems.HOE_TEMPLATE, ModItems.UNREFINED_DIAMOND_HOE, ItemTags.DIAMOND_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.DIAMOND_HOE),

                        new RefiningData(ModItems.PICKAXE_TEMPLATE, ModItems.UNREFINED_IRON_PICKAXE, ItemTags.IRON_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.IRON_PICKAXE),
                        new RefiningData(ModItems.AXE_TEMPLATE, ModItems.UNREFINED_IRON_AXE, ItemTags.IRON_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.IRON_AXE),
                        new RefiningData(ModItems.SWORD_TEMPLATE, ModItems.UNREFINED_IRON_SWORD, ItemTags.IRON_TOOL_MATERIALS, RecipeCategory.COMBAT, Items.IRON_SWORD),
                        new RefiningData(ModItems.SHOVEL_TEMPLATE, ModItems.UNREFINED_IRON_SHOVEL, ItemTags.IRON_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.IRON_SHOVEL),
                        new RefiningData(ModItems.HOE_TEMPLATE, ModItems.UNREFINED_IRON_HOE, ItemTags.IRON_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.IRON_HOE),

                        new RefiningData(ModItems.PICKAXE_TEMPLATE, ModItems.UNREFINED_GOLDEN_PICKAXE, ItemTags.GOLD_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.GOLDEN_PICKAXE),
                        new RefiningData(ModItems.AXE_TEMPLATE, ModItems.UNREFINED_GOLDEN_AXE, ItemTags.GOLD_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.GOLDEN_AXE),
                        new RefiningData(ModItems.SWORD_TEMPLATE, ModItems.UNREFINED_GOLDEN_SWORD, ItemTags.GOLD_TOOL_MATERIALS, RecipeCategory.COMBAT, Items.GOLDEN_SWORD),
                        new RefiningData(ModItems.SHOVEL_TEMPLATE, ModItems.UNREFINED_GOLDEN_SHOVEL, ItemTags.GOLD_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.GOLDEN_SHOVEL),
                        new RefiningData(ModItems.HOE_TEMPLATE, ModItems.UNREFINED_GOLDEN_HOE, ItemTags.GOLD_TOOL_MATERIALS, RecipeCategory.TOOLS, Items.GOLDEN_HOE)
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
                    var builder = this.shaped(tool.category, tool.result)
                            .define('#', this.tag(ItemTags.PLANKS))
                            .define('C', Items.STICK)
                            .define('X', Items.STRING)
                            .unlockedBy(getHasName(Items.STICK), this.has(Items.STICK));
                    for (String line : tool.pattern) {
                        builder.pattern(line);
                    }
                    builder.save(this.output);
                }
            }
            private void generateStoneTools() {
                record ToolData(Item result, RecipeCategory category, List<String> pattern) {}
                List<ToolData> tools = List.of(
                        new ToolData(Items.STONE_PICKAXE, RecipeCategory.TOOLS, List.of("###", "XC ", " C ")),
                        new ToolData(Items.STONE_AXE, RecipeCategory.TOOLS, List.of("##", "#C", "XC")),
                        new ToolData(Items.STONE_SHOVEL, RecipeCategory.TOOLS, List.of(" #", "XC", " C")),
                        new ToolData(Items.STONE_SWORD, RecipeCategory.TOOLS, List.of(" #", " #", "XC")),
                        new ToolData(Items.STONE_HOE, RecipeCategory.TOOLS, List.of("##", "XC", " C"))
                );
                for (ToolData tool : tools) {
                    var builder = this.shaped(tool.category, tool.result)
                            .define('#', this.tag(ItemTags.STONE_TOOL_MATERIALS))
                            .define('C', Items.STICK)
                            .define('X', Items.STRING)
                            .unlockedBy(getHasName(Items.COBBLESTONE), this.has(Items.COBBLESTONE));
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
        return "Overwritten Recipe";
    }
}

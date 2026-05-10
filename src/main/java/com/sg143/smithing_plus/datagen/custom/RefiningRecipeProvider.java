package com.sg143.smithing_plus.datagen.custom;

import com.sg143.smithing_plus.util.ModTags;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.TagKey;

public class RefiningRecipeProvider extends RecipeProvider {

    public RefiningRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
        super(registries, exporter);
    }

    @Override
    public void buildRecipes() {

    }

    public void offerRefiningRecipe(Item template, Item input, TagKey<Item> addition, RecipeCategory category, Item output) {
        Identifier itemId  = BuiltInRegistries.ITEM.getKey(output);
        Identifier recipeId = Identifier.fromNamespaceAndPath(itemId.getNamespace(), itemId.getPath());
        SmithingTransformRecipeBuilder.smithing(
                Ingredient.of(template),
                Ingredient.of(input),
                this.tag(addition),
                category,
                output
        )
                .unlocks("have_refining_template", this.has(ModTags.Items.REFINING_TEMPLATE))
                .save(this.output, recipeId.toString());
    }

    public void offerRefiningTemplateCopyingRecipe(ItemLike template) {
        this.shaped(RecipeCategory.MISC, template, 2)
                .define('#', Items.EMERALD)
                .define('C', template)
                .pattern("#C#")
                .pattern("# #")
                .pattern("###")
                .unlockedBy(getHasName(template), this.has(template))
                .save(this.output);
    }
}

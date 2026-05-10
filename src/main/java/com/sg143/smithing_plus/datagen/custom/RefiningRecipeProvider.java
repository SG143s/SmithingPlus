package com.sg143.smithing_plus.datagen.custom;

import com.sg143.smithing_plus.util.ModTags;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.TagKey;

public class RefiningRecipeProvider extends RecipeGenerator {

    public RefiningRecipeProvider(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    @Override
    public void generate() {

    }

    public void offerRefiningRecipe(Item template, Item input, TagKey<Item> addition, RecipeCategory category, Item output) {
        Identifier itemId  = Registries.ITEM.getId(output);
        Identifier recipeId = Identifier.of(itemId.getNamespace(), itemId.getPath());
        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItem(template),
                Ingredient.ofItem(input),
                this.ingredientFromTag(addition),
                category,
                output
        )
                .criterion("have_refining_template", this.conditionsFromTag(ModTags.Items.REFINING_TEMPLATE))
                .offerTo(this.exporter, recipeId.toString());
    }

    public void offerRefiningTemplateCopyingRecipe(ItemConvertible template) {
        this.createShaped(RecipeCategory.MISC, template, 2)
                .input('#', Items.EMERALD)
                .input('C', template)
                .pattern("#C#")
                .pattern("# #")
                .pattern("###")
                .criterion(hasItem(template), this.conditionsFromItem(template))
                .offerTo(this.exporter);
    }
}

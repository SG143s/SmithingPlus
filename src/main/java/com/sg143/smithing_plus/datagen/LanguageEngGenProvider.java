package com.sg143.smithing_plus.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageEngGenProvider extends FabricLanguageProvider {
    public LanguageEngGenProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, "en_us", registriesFuture);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.smithing-plus.sword_refining_template", "Sword Refining Template");
        translationBuilder.add("item.smithing-plus.shovel_refining_template", "Shovel Refining Template");
        translationBuilder.add("item.smithing-plus.pickaxe_refining_template", "Pickaxe Refining Template");
        translationBuilder.add("item.smithing-plus.axe_refining_template", "Axe Refining Template");
        translationBuilder.add("item.smithing-plus.hoe_refining_template", "Hoe Refining Template");

        translationBuilder.add("item.smithing-plus.unrefined_diamond_pickaxe", "Unrefined Diamond Pickaxe");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_axe", "Unrefined Diamond Axe");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_shovel", "Unrefined Diamond Shovel");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_sword", "Unrefined Diamond Sword");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_hoe", "Unrefined Diamond Hoe");

        translationBuilder.add("tooltip.smithing-plus.pickaxe_refining_template.applyOption","Pickaxe");
        translationBuilder.add("tooltip.smithing-plus.axe_refining_template.applyOption","Axe");
        translationBuilder.add("tooltip.smithing-plus.sword_refining_template.applyOption","Sword");
        translationBuilder.add("tooltip.smithing-plus.shovel_refining_template.applyOption","Shovel");
        translationBuilder.add("tooltip.smithing-plus.hoe_refining_template.applyOption","Hoe");

        translationBuilder.add("tooltip.smithing-plus.refining_template.type", "Refining Template");
        translationBuilder.add("tooltip.smithing-plus.refining_template.applyState","Applies to:");
        translationBuilder.add("tooltip.smithing-plus.refining_template.ingredientState","Ingredients:");
        translationBuilder.add("tooltip.smithing-plus.refining_template.ingredientOption","Ingots & Diamond");
    }
}

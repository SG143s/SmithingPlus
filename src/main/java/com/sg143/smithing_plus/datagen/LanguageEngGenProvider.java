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
        //region == TEMPLATES ==
        translationBuilder.add("item.smithing-plus.sword_refining_template", "Sword Refining Template");
        translationBuilder.add("item.smithing-plus.shovel_refining_template", "Shovel Refining Template");
        translationBuilder.add("item.smithing-plus.pickaxe_refining_template", "Pickaxe Refining Template");
        translationBuilder.add("item.smithing-plus.axe_refining_template", "Axe Refining Template");
        translationBuilder.add("item.smithing-plus.hoe_refining_template", "Hoe Refining Template");
        //endregion

        //region == UNREFINED DIAMONDS ==
        translationBuilder.add("item.smithing-plus.unrefined_diamond_pickaxe", "Unrefined Diamond Pickaxe");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_axe", "Unrefined Diamond Axe");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_shovel", "Unrefined Diamond Shovel");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_sword", "Unrefined Diamond Sword");
        translationBuilder.add("item.smithing-plus.unrefined_diamond_hoe", "Unrefined Diamond Hoe");
        //endregion

        //region == UNREFINED IRONS ==
        translationBuilder.add("item.smithing-plus.unrefined_iron_pickaxe", "Unrefined Iron Pickaxe");
        translationBuilder.add("item.smithing-plus.unrefined_iron_axe", "Unrefined Iron Axe");
        translationBuilder.add("item.smithing-plus.unrefined_iron_shovel", "Unrefined Iron Shovel");
        translationBuilder.add("item.smithing-plus.unrefined_iron_sword", "Unrefined Iron Sword");
        translationBuilder.add("item.smithing-plus.unrefined_iron_hoe", "Unrefined Iron Hoe");
        //endregion

        //region == UNREFINED GOLDS ==
        translationBuilder.add("item.smithing-plus.unrefined_golden_pickaxe", "Unrefined Gold Pickaxe");
        translationBuilder.add("item.smithing-plus.unrefined_golden_axe", "Unrefined Gold Axe");
        translationBuilder.add("item.smithing-plus.unrefined_golden_shovel", "Unrefined Gold Shovel");
        translationBuilder.add("item.smithing-plus.unrefined_golden_sword", "Unrefined Gold Sword");
        translationBuilder.add("item.smithing-plus.unrefined_golden_hoe", "Unrefined Gold Hoe");
        //endregion

        //region == TEMPLATE TOOLTIPS ==
        translationBuilder.add("tooltip.smithing-plus.pickaxe_refining_template.applyOption","Pickaxe");
        translationBuilder.add("tooltip.smithing-plus.axe_refining_template.applyOption","Axe");
        translationBuilder.add("tooltip.smithing-plus.sword_refining_template.applyOption","Sword");
        translationBuilder.add("tooltip.smithing-plus.shovel_refining_template.applyOption","Shovel");
        translationBuilder.add("tooltip.smithing-plus.hoe_refining_template.applyOption","Hoe");

        translationBuilder.add("tooltip.smithing-plus.refining_template.type", "Refining Template");
        translationBuilder.add("tooltip.smithing-plus.refining_template.applyState","Applies to:");
        translationBuilder.add("tooltip.smithing-plus.refining_template.ingredientState","Ingredients:");
        translationBuilder.add("tooltip.smithing-plus.refining_template.ingredientOption","Ingots & Diamond");
        //endregion
    }
}

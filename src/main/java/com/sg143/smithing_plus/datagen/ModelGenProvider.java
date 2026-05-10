package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModelGenProvider extends FabricModelProvider {
    public ModelGenProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        //region == TEMPLATES ==
        itemModelGenerator.generateFlatItem(ModItems.SWORD_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PICKAXE_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.AXE_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SHOVEL_TEMPLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.HOE_TEMPLATE, ModelTemplates.FLAT_ITEM);
        //endregion
        //region == UNREFINED DIAMONDS ==
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_DIAMOND_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_DIAMOND_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_DIAMOND_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_DIAMOND_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_DIAMOND_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        //endregion
        //region == UNREFINED IRONS ==
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_IRON_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_IRON_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_IRON_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_IRON_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_IRON_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);

        //endregion
        //region == UNREFINED GOLDS ==
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_GOLDEN_PICKAXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_GOLDEN_AXE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_GOLDEN_SHOVEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_GOLDEN_SWORD, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.UNREFINED_GOLDEN_HOE, ModelTemplates.FLAT_HANDHELD_ITEM);
        //endregion
        //region == OTHER ==
        itemModelGenerator.generateFlatItem(ModItems.TOOL_HANDLE, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MACE_HANDLE, ModelTemplates.FLAT_HANDHELD_ITEM);
        //endregion
    }
}

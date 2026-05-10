package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;

public class ModelGenProvider extends FabricModelProvider {
    public ModelGenProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //region == TEMPLATES ==
        itemModelGenerator.register(ModItems.SWORD_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PICKAXE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AXE_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHOVEL_TEMPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.HOE_TEMPLATE, Models.GENERATED);
        //endregion
        //region == UNREFINED DIAMONDS ==
        itemModelGenerator.register(ModItems.UNREFINED_DIAMOND_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_DIAMOND_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_DIAMOND_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_DIAMOND_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_DIAMOND_HOE, Models.HANDHELD);
        //endregion
        //region == UNREFINED IRONS ==
        itemModelGenerator.register(ModItems.UNREFINED_IRON_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_IRON_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_IRON_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_IRON_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_IRON_HOE, Models.HANDHELD);

        //endregion
        //region == UNREFINED GOLDS ==
        itemModelGenerator.register(ModItems.UNREFINED_GOLDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_GOLDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_GOLDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_GOLDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.UNREFINED_GOLDEN_HOE, Models.HANDHELD);
        //endregion
        //region == OTHER ==
        itemModelGenerator.register(ModItems.TOOL_HANDLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MACE_HANDLE, Models.HANDHELD);
        //endregion
    }
}

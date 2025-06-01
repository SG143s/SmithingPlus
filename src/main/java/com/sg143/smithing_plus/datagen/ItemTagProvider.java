package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.item.ModItems;
import com.sg143.smithing_plus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.REFINING_TEMPLATE)
                .add(ModItems.AXE_TEMPLATE)
                .add(ModItems.SHOVEL_TEMPLATE)
                .add(ModItems.SWORD_TEMPLATE)
                .add(ModItems.PICKAXE_TEMPLATE)
                .add(ModItems.HOE_TEMPLATE);
        getOrCreateTagBuilder(ModTags.Items.UNREFINED_DIAMOND_ITEM)
                .add(ModItems.UNREFINED_DIAMOND_PICKAXE)
                .add(ModItems.UNREFINED_DIAMOND_AXE)
                .add(ModItems.UNREFINED_DIAMOND_SWORD)
                .add(ModItems.UNREFINED_DIAMOND_SHOVEL)
                .add(ModItems.UNREFINED_DIAMOND_HOE);
        getOrCreateTagBuilder(ModTags.Items.UNREFINED_IRON_ITEM)
                .add(ModItems.UNREFINED_IRON_PICKAXE)
                .add(ModItems.UNREFINED_IRON_AXE)
                .add(ModItems.UNREFINED_IRON_SWORD)
                .add(ModItems.UNREFINED_IRON_SHOVEL)
                .add(ModItems.UNREFINED_IRON_HOE);
        getOrCreateTagBuilder(ModTags.Items.UNREFINED_GOLD_ITEM)
                .add(ModItems.UNREFINED_GOLDEN_PICKAXE)
                .add(ModItems.UNREFINED_GOLDEN_AXE)
                .add(ModItems.UNREFINED_GOLDEN_SWORD)
                .add(ModItems.UNREFINED_GOLDEN_SHOVEL)
                .add(ModItems.UNREFINED_GOLDEN_HOE);
    }
}

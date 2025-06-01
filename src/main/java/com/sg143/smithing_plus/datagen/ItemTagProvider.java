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
        getOrCreateTagBuilder(ModTags.Items.UNREFINED_DIAMOND_ITEM)
                .add(ModItems.UNREFINED_DIAMOND_PICKAXE)
                .add(ModItems.UNREFINED_DIAMOND_AXE)
                .add(ModItems.UNREFINED_DIAMOND_SWORD)
                .add(ModItems.UNREFINED_DIAMOND_SHOVEL)
                .add(ModItems.UNREFINED_DIAMOND_HOE);
    }
}

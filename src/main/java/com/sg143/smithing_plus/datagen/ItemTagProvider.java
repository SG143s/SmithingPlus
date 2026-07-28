package com.sg143.smithing_plus.datagen;

import com.sg143.smithing_plus.item.ModItems;
import com.sg143.smithing_plus.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
    public ItemTagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        valueLookupBuilder(ModTags.Items.REFINING_TEMPLATE)
                .add(ModItems.AXE_TEMPLATE)
                .add(ModItems.SHOVEL_TEMPLATE)
                .add(ModItems.SWORD_TEMPLATE)
                .add(ModItems.PICKAXE_TEMPLATE)
                .add(ModItems.HOE_TEMPLATE);
        valueLookupBuilder(ModTags.Items.UNREFINED_DIAMOND_ITEM)
                .add(ModItems.UNREFINED_DIAMOND_PICKAXE)
                .add(ModItems.UNREFINED_DIAMOND_AXE)
                .add(ModItems.UNREFINED_DIAMOND_SWORD)
                .add(ModItems.UNREFINED_DIAMOND_SHOVEL)
                .add(ModItems.UNREFINED_DIAMOND_HOE);
        valueLookupBuilder(ModTags.Items.UNREFINED_IRON_ITEM)
                .add(ModItems.UNREFINED_IRON_PICKAXE)
                .add(ModItems.UNREFINED_IRON_AXE)
                .add(ModItems.UNREFINED_IRON_SWORD)
                .add(ModItems.UNREFINED_IRON_SHOVEL)
                .add(ModItems.UNREFINED_IRON_HOE);
        valueLookupBuilder(ModTags.Items.UNREFINED_COPPER_ITEM)
                .add(ModItems.UNREFINED_COPPER_PICKAXE)
                .add(ModItems.UNREFINED_COPPER_AXE)
                .add(ModItems.UNREFINED_COPPER_SWORD)
                .add(ModItems.UNREFINED_COPPER_SHOVEL)
                .add(ModItems.UNREFINED_COPPER_HOE);
        valueLookupBuilder(ModTags.Items.UNREFINED_GOLD_ITEM)
                .add(ModItems.UNREFINED_GOLDEN_PICKAXE)
                .add(ModItems.UNREFINED_GOLDEN_AXE)
                .add(ModItems.UNREFINED_GOLDEN_SWORD)
                .add(ModItems.UNREFINED_GOLDEN_SHOVEL)
                .add(ModItems.UNREFINED_GOLDEN_HOE);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModItems.UNREFINED_COPPER_AXE)
                .add(ModItems.UNREFINED_DIAMOND_AXE)
                .add(ModItems.UNREFINED_IRON_AXE)
                .add(ModItems.UNREFINED_GOLDEN_AXE);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModItems.UNREFINED_COPPER_PICKAXE)
                .add(ModItems.UNREFINED_DIAMOND_PICKAXE)
                .add(ModItems.UNREFINED_IRON_PICKAXE)
                .add(ModItems.UNREFINED_GOLDEN_PICKAXE);
        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModItems.UNREFINED_COPPER_SWORD)
                .add(ModItems.UNREFINED_DIAMOND_SWORD)
                .add(ModItems.UNREFINED_IRON_SWORD)
                .add(ModItems.UNREFINED_GOLDEN_SWORD);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModItems.UNREFINED_COPPER_SHOVEL)
                .add(ModItems.UNREFINED_DIAMOND_SHOVEL)
                .add(ModItems.UNREFINED_IRON_SHOVEL)
                .add(ModItems.UNREFINED_GOLDEN_SHOVEL);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModItems.UNREFINED_COPPER_HOE)
                .add(ModItems.UNREFINED_DIAMOND_HOE)
                .add(ModItems.UNREFINED_IRON_HOE)
                .add(ModItems.UNREFINED_GOLDEN_HOE);

    }
}

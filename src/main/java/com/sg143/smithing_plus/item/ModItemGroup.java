package com.sg143.smithing_plus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroup {
    public static void addIngredientMenu (FabricItemGroupEntries entries) {

    }
    public static void registerModItemGroup () {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroup::addIngredientMenu);
    }
}

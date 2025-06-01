package com.sg143.smithing_plus.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class ModItemGroup {
    public static void addIngredientMenu (FabricItemGroupEntries entries) {
        entries.add(ModItems.SWORD_TEMPLATE);
        entries.add(ModItems.PICKAXE_TEMPLATE);
        entries.add(ModItems.AXE_TEMPLATE);
        entries.add(ModItems.SHOVEL_TEMPLATE);
        entries.add(ModItems.HOE_TEMPLATE);

    }

    public static void addToolMenu (FabricItemGroupEntries entries) {
        entries.add(ModItems.UNREFINED_DIAMOND_PICKAXE);
        entries.add(ModItems.UNREFINED_DIAMOND_AXE);
        entries.add(ModItems.UNREFINED_DIAMOND_SHOVEL);
        entries.add(ModItems.UNREFINED_DIAMOND_HOE);
    }

    public static void addWeaponMenu (FabricItemGroupEntries entries) {
        entries.add(ModItems.UNREFINED_DIAMOND_SWORD);
    }
    public static void registerModItemGroup () {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroup::addIngredientMenu);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItemGroup::addToolMenu);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroup::addWeaponMenu);
    }
}

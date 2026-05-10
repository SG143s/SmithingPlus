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

        entries.add(ModItems.TOOL_HANDLE);
        entries.add(ModItems.MACE_HANDLE);

    }

    public static void addToolMenu (FabricItemGroupEntries entries) {
        entries.add(ModItems.UNREFINED_GOLDEN_SHOVEL);
        entries.add(ModItems.UNREFINED_GOLDEN_PICKAXE);
        entries.add(ModItems.UNREFINED_GOLDEN_AXE);
        entries.add(ModItems.UNREFINED_GOLDEN_HOE);

        entries.add(ModItems.UNREFINED_IRON_SHOVEL);
        entries.add(ModItems.UNREFINED_IRON_PICKAXE);
        entries.add(ModItems.UNREFINED_IRON_AXE);
        entries.add(ModItems.UNREFINED_IRON_HOE);

        entries.add(ModItems.UNREFINED_DIAMOND_SHOVEL);
        entries.add(ModItems.UNREFINED_DIAMOND_PICKAXE);
        entries.add(ModItems.UNREFINED_DIAMOND_AXE);
        entries.add(ModItems.UNREFINED_DIAMOND_HOE);
    }

    public static void addWeaponMenu (FabricItemGroupEntries entries) {
        entries.add(ModItems.UNREFINED_GOLDEN_SWORD);
        entries.add(ModItems.UNREFINED_IRON_SWORD);
        entries.add(ModItems.UNREFINED_DIAMOND_SWORD);

        entries.add(ModItems.UNREFINED_GOLDEN_AXE);
        entries.add(ModItems.UNREFINED_IRON_AXE);
        entries.add(ModItems.UNREFINED_DIAMOND_AXE);
    }
    public static void registerModItemGroup () {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroup::addIngredientMenu);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItemGroup::addToolMenu);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroup::addWeaponMenu);
    }
}

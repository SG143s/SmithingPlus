package com.sg143.smithing_plus.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.world.item.CreativeModeTabs;

public class ModItemGroup {
    public static void addIngredientMenu (FabricCreativeModeTabOutput entries) {
        entries.accept(ModItems.SWORD_TEMPLATE);
        entries.accept(ModItems.PICKAXE_TEMPLATE);
        entries.accept(ModItems.AXE_TEMPLATE);
        entries.accept(ModItems.SHOVEL_TEMPLATE);
        entries.accept(ModItems.HOE_TEMPLATE);

        entries.accept(ModItems.TOOL_HANDLE);
        entries.accept(ModItems.MACE_HANDLE);

    }

    public static void addToolMenu (FabricCreativeModeTabOutput entries) {
        entries.accept(ModItems.UNREFINED_GOLDEN_SHOVEL);
        entries.accept(ModItems.UNREFINED_GOLDEN_PICKAXE);
        entries.accept(ModItems.UNREFINED_GOLDEN_AXE);
        entries.accept(ModItems.UNREFINED_GOLDEN_HOE);

        entries.accept(ModItems.UNREFINED_IRON_SHOVEL);
        entries.accept(ModItems.UNREFINED_IRON_PICKAXE);
        entries.accept(ModItems.UNREFINED_IRON_AXE);
        entries.accept(ModItems.UNREFINED_IRON_HOE);

        entries.accept(ModItems.UNREFINED_DIAMOND_SHOVEL);
        entries.accept(ModItems.UNREFINED_DIAMOND_PICKAXE);
        entries.accept(ModItems.UNREFINED_DIAMOND_AXE);
        entries.accept(ModItems.UNREFINED_DIAMOND_HOE);
    }

    public static void addWeaponMenu (FabricCreativeModeTabOutput entries) {
        entries.accept(ModItems.UNREFINED_GOLDEN_SWORD);
        entries.accept(ModItems.UNREFINED_IRON_SWORD);
        entries.accept(ModItems.UNREFINED_DIAMOND_SWORD);

        entries.accept(ModItems.UNREFINED_GOLDEN_AXE);
        entries.accept(ModItems.UNREFINED_IRON_AXE);
        entries.accept(ModItems.UNREFINED_DIAMOND_AXE);
    }
    public static void registerModItemGroup () {

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(ModItemGroup::addIngredientMenu);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(ModItemGroup::addToolMenu);
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(ModItemGroup::addWeaponMenu);
    }
}

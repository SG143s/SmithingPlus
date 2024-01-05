package net.plusplus.smithing.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.plusplus.smithing.SmithingPlus;

public class ModItems {

    public static final Item PICK_TEMPLATE = registerItem("pickaxe_refining_template", new Item(new FabricItemSettings()));

    private static void addIngredientMenu (FabricItemGroupEntries entries) {
        entries.add(PICK_TEMPLATE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SmithingPlus.MODID, name), item);
    }
    public static void registerModItems() {
        SmithingPlus.LOGGER.info("Reg Mod Items " + SmithingPlus.MODID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addIngredientMenu);
    }
}

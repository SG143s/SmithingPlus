package net.plusplus.smithing.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.plusplus.smithing.SmithingPlus;

public class ModItems {

    public static final Item PICK_TEMPLATE = registerItem("pickaxe_refining_template", new Item(new FabricItemSettings()));
    public static final Item AXE_TEMPLATE = registerItem("axe_refining_template", new Item(new FabricItemSettings()));
    public static final Item SWORD_TEMPLATE = registerItem("sword_refining_template", new Item(new FabricItemSettings()));
    public static final Item SHOVEL_TEMPLATE = registerItem("shovel_refining_template", new Item(new FabricItemSettings()));
    public static final Item HOE_TEMPLATE = registerItem("hoe_refining_template", new Item(new FabricItemSettings()));


    public static final Item UNREFINED_DIAMOND_PICKAXE = registerItem("unrefined_diamond_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_DIAMOND, 1, -2.8f, new FabricItemSettings()));

    public static final Item UNREFINED_IRON_PICKAXE = registerItem("unrefined_iron_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_IRON, 1, -2.8f, new FabricItemSettings()));

    public static final Item UNREFINED_GOLDEN_PICKAXE = registerItem("unrefined_golden_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_GOLD, 1, -2.8f, new FabricItemSettings()));

    private static void addIngredientMenu (FabricItemGroupEntries entries) {
        entries.add(PICK_TEMPLATE);
        entries.add(AXE_TEMPLATE);
        entries.add(SWORD_TEMPLATE);
        entries.add(SHOVEL_TEMPLATE);
        entries.add(HOE_TEMPLATE);
    }
    private static void addToolMenu (FabricItemGroupEntries entries) {
        entries.add(UNREFINED_DIAMOND_PICKAXE);

        entries.add(UNREFINED_GOLDEN_PICKAXE);

        entries.add(UNREFINED_IRON_PICKAXE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SmithingPlus.MODID, name), item);
    }
    public static void registerModItems() {
        SmithingPlus.LOGGER.info("Reg Mod Items " + SmithingPlus.MODID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addIngredientMenu);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addToolMenu);
    }
}

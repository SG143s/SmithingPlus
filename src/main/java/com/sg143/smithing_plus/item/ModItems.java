package com.sg143.smithing_plus.item;

import com.sg143.smithing_plus.SmithingPlus;
import com.sg143.smithing_plus.item.customtype.RefiningTemplate;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;

import java.util.function.Function;

public class ModItems {
    //region === TEMPLATES ===
    public static final Item SWORD_TEMPLATE = registerItem("sword_refining_template",
            settings -> new RefiningTemplate("sword", settings));
    public static final Item PICKAXE_TEMPLATE = registerItem("pickaxe_refining_template",
            settings -> new RefiningTemplate("pickaxe", settings));
    public static final Item AXE_TEMPLATE = registerItem("axe_refining_template",
            settings -> new RefiningTemplate("axe", settings));
    public static final Item SHOVEL_TEMPLATE = registerItem("shovel_refining_template",
            settings -> new RefiningTemplate("shovel", settings));
    public static final Item HOE_TEMPLATE = registerItem("hoe_refining_template",
            settings -> new RefiningTemplate("hoe", settings));
    //endregion
    //region === UNREFINED DIAMOND ===
    public static final Item UNREFINED_DIAMOND_PICKAXE =
            registerItem("unrefined_diamond_pickaxe",
                    new Item.Properties().pickaxe(ToolMaterial.WOOD, 1.0F, -2.8F));
    public static final Item UNREFINED_DIAMOND_AXE = registerItem("unrefined_diamond_axe",
            settings -> new AxeItem(ModToolMaterial.UNREFINED_DIAMOND, 4.25f, -3.1f, settings));
    public static final Item UNREFINED_DIAMOND_SWORD = registerItem("unrefined_diamond_sword",
            new Item.Properties().sword(ModToolMaterial.UNREFINED_DIAMOND, 2.0f, -2.4f));
    public static final Item UNREFINED_DIAMOND_SHOVEL = registerItem("unrefined_diamond_shovel",
            settings -> new ShovelItem(ModToolMaterial.UNREFINED_DIAMOND, 0.5f, -3.0f, settings));
    public static final Item UNREFINED_DIAMOND_HOE = registerItem("unrefined_diamond_hoe",
            settings -> new HoeItem(ModToolMaterial.UNREFINED_DIAMOND, -3.0f, -1f, settings));
    //endregion
    //region === UNREFINED IRON ===
    public static final Item UNREFINED_IRON_PICKAXE = registerItem("unrefined_iron_pickaxe",
            new Item.Properties().pickaxe(ModToolMaterial.UNREFINED_IRON, 0.0f, -2.8f));
    public static final Item UNREFINED_IRON_AXE = registerItem("unrefined_iron_axe",
            settings -> new AxeItem(ModToolMaterial.UNREFINED_IRON, 4.25f, -3.1f, settings));
    public static final Item UNREFINED_IRON_SWORD = registerItem("unrefined_iron_sword",
            new Item.Properties().sword(ModToolMaterial.UNREFINED_IRON, 2.0f, -2.4f));
    public static final Item UNREFINED_IRON_SHOVEL = registerItem("unrefined_iron_shovel",
            settings -> new ShovelItem(ModToolMaterial.UNREFINED_IRON, 0.5f, -3.0f, settings));
    public static final Item UNREFINED_IRON_HOE = registerItem("unrefined_iron_hoe",
            settings -> new HoeItem(ModToolMaterial.UNREFINED_IRON, -3.0f, -1f, settings));
    //endregion
    //region === UNREFINED GOLD ===
    public static final Item UNREFINED_GOLDEN_PICKAXE = registerItem("unrefined_golden_pickaxe",
            new Item.Properties().pickaxe(ModToolMaterial.UNREFINED_GOLD, 0.0f, -2.8f));
    public static final Item UNREFINED_GOLDEN_AXE = registerItem("unrefined_golden_axe",
            settings -> new AxeItem(ModToolMaterial.UNREFINED_GOLD, 4.25f, -3.1f, settings));
    public static final Item UNREFINED_GOLDEN_SWORD = registerItem("unrefined_golden_sword",
            new Item.Properties().sword(ModToolMaterial.UNREFINED_GOLD, 2.0f, -2.4f));
    public static final Item UNREFINED_GOLDEN_SHOVEL = registerItem("unrefined_golden_shovel",
            settings -> new ShovelItem(ModToolMaterial.UNREFINED_GOLD, 0.5f, -3.0f, settings));
    public static final Item UNREFINED_GOLDEN_HOE = registerItem("unrefined_golden_hoe",
            settings -> new HoeItem(ModToolMaterial.UNREFINED_GOLD, -1.0f, -1f, settings));
    //endregion
    //region === OTHER ===
    public static Item TOOL_HANDLE = registerItem("tool_handle", Item::new);
    public static Item MACE_HANDLE = registerItem("mace_handle", Item::new);
    //endregion

    public static <T extends Item> T registerItem(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        // Create the item key.
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SmithingPlus.MOD_ID, name));

        // Create the item instance.
        T item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return registerItem(name, function, new Item.Properties());
    }
    private static Item registerItem(String name, Item.Properties properties) {
        return  registerItem(name, Item::new, properties);
    }
    public static void registerModItems() {
        SmithingPlus.LOGGER.info("Registering Items for " + SmithingPlus.MOD_ID);
    }

}

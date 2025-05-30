package com.sg143.smithing_plus.item;

import com.sg143.smithing_plus.SmithingPlus;
import com.sg143.smithing_plus.item.customtype.RefiningTemplate;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
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


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(SmithingPlus.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SmithingPlus.MOD_ID, name)))));
    }
    public static void registerModItems() {
        SmithingPlus.LOGGER.info("Registering Items for " + SmithingPlus.MOD_ID);
    }

}

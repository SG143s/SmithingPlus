package com.sg143.smithing_plus.util;

import com.sg143.smithing_plus.SmithingPlus;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> UNREFINED_DIAMOND_ITEM = createTag("unrefined_diamond_item");
        public static final TagKey<Item> UNREFINED_IRON_ITEM = createTag("unrefined_iron_item");
        public static final TagKey<Item> UNREFINED_GOLD_ITEM = createTag("unrefined_gold_item");
        public static final TagKey<Item> REFINING_TEMPLATE = createTag("refining_template_item");

        public static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SmithingPlus.MOD_ID, name));
        }
    }
}

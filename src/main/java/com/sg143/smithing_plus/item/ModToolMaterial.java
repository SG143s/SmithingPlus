package com.sg143.smithing_plus.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

public class ModToolMaterial {
    public static ToolMaterial UNREFINED_DIAMOND = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            178,
            5.0f,
            2.75f,
            5,
            ItemTags.DIAMOND_TOOL_MATERIALS
    );
    public static ToolMaterial UNREFINED_IRON = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            151,
            4.75f,
            2.25f,
            5,
            ItemTags.IRON_TOOL_MATERIALS
    );
    public static ToolMaterial UNREFINED_GOLD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_GOLD_TOOL,
            10,
            9.0f,
            0.25f,
            5,
            ItemTags.GOLD_TOOL_MATERIALS
    );
}

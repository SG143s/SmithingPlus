package com.sg143.smithing_plus.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;

public class ModToolMaterial {
    public static ToolMaterial UNREFINED_DIAMOND = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            178,
            5.0f,
            1.75f,
            20,
            ItemTags.DIAMOND_TOOL_MATERIALS
    );
    public static ToolMaterial UNREFINED_IRON = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            151,
            4.75f,
            1.25f,
            28,
            ItemTags.IRON_TOOL_MATERIALS
    );
    public static ToolMaterial UNREFINED_GOLD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_GOLD_TOOL,
            10,
            9.0f,
            -0.5f,
            44,
            ItemTags.GOLD_TOOL_MATERIALS
    );
    public static ToolMaterial UNREFINED_COPPER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_COPPER_TOOL,
            100,
            4.25f,
            0.75f,
            26,
            ItemTags.COPPER_TOOL_MATERIALS
    );
}

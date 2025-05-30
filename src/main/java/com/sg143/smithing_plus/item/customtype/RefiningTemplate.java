package com.sg143.smithing_plus.item.customtype;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class RefiningTemplate extends Item {
    private final String templatetype;
    public RefiningTemplate(String type, Settings settings) {
        super(settings);
        this.templatetype = type;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        switch (this.templatetype) {
            case "pickaxe":
                tooltip.add(Text.translatable("tooltip.smithingplus.pickaxe_refining_template.applyOption").formatted(Formatting.BLUE));
                break;
            case "axe":
                tooltip.add(Text.translatable("tooltip.smithingplus.axe_refining_template.applyOption").formatted(Formatting.BLUE));
                break;
            case "shovel":
                tooltip.add(Text.translatable("tooltip.smithingplus.shovel_refining_template.applyOption").formatted(Formatting.BLUE));
                break;
            case "hoe":
                tooltip.add(Text.translatable("tooltip.smithingplus.hoe_refining_template.applyOption").formatted(Formatting.BLUE));
                break;
            default:
                tooltip.add(Text.translatable("tooltip.smithingplus.sword_refining_template.applyOption").formatted(Formatting.BLUE));
        }
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, context, tooltip, type);
    }
}

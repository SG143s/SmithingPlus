package com.sg143.smithing_plus.item.customtype;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.component.TooltipDisplay;
import org.jspecify.annotations.NonNull;

import java.util.function.Consumer;

public class RefiningTemplate extends Item {
    private final String templatetype;
    public RefiningTemplate(String type, Properties settings) {
        super(settings);
        this.templatetype = type;
    }

    @Override
    public void appendHoverText(@NonNull ItemStack stack, @NonNull TooltipContext context, @NonNull TooltipDisplay display, Consumer<Component> consumer, TooltipFlag type) {

        consumer.accept(Component.translatable("tooltip.smithing-plus.refining_template.type").withStyle(ChatFormatting.GRAY));
        consumer.accept(Component.empty());
        consumer.accept(Component.translatable("tooltip.smithing-plus.refining_template.applyState").withStyle(ChatFormatting.GRAY));
        switch (this.templatetype) {
            case "pickaxe":
                consumer.accept(Component.translatable("tooltip.smithing-plus.pickaxe_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
                break;
            case "axe":
                consumer.accept(Component.translatable("tooltip.smithing-plus.axe_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
                break;
            case "shovel":
                consumer.accept(Component.translatable("tooltip.smithing-plus.shovel_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
                break;
            case "hoe":
                consumer.accept(Component.translatable("tooltip.smithing-plus.hoe_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
                break;
            case "spear":
                consumer.accept(Component.translatable("tooltip.smithing-plus.spear_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
            default:
                consumer.accept(Component.translatable("tooltip.smithing-plus.sword_refining_template.applyOption").withStyle(ChatFormatting.BLUE));
        }
        consumer.accept(Component.translatable("tooltip.smithing-plus.refining_template.ingredientState").withStyle(ChatFormatting.GRAY));
        consumer.accept(Component.translatable("tooltip.smithing-plus.refining_template.ingredientOption").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(stack, context, display, consumer, type);
    }
}

package net.plusplus.smithing.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.plusplus.smithing.SmithingPlus;
import org.jetbrains.annotations.Nullable;

import java.util.List;

class PickaxeRefiningTemplate extends Item {

    public PickaxeRefiningTemplate(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.pickaxe_refining_template.applyOption").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

class SwordRefiningTemplate extends Item {

    public SwordRefiningTemplate(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.sword_refining_template.applyOption").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

class AxeRefiningTemplate extends Item {

    public AxeRefiningTemplate(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.axe_refining_template.applyOption").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

class ShovelRefiningTemplate extends Item {

    public ShovelRefiningTemplate(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.shovel_refining_template.applyOption").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

class HoeRefiningTemplate extends Item {

    public HoeRefiningTemplate(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.applyState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.hoe_refining_template.applyOption").formatted(Formatting.BLUE));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientState"));
        tooltip.add(Text.translatable("tooltip.smithingplus.refining_template.ingredientOption").formatted(Formatting.BLUE));
        super.appendTooltip(stack, world, tooltip, context);
    }
}

public class ModItems {

    public static final Item PICK_TEMPLATE = registerItem("pickaxe_refining_template", new PickaxeRefiningTemplate(new FabricItemSettings()));
    public static final Item AXE_TEMPLATE = registerItem("axe_refining_template", new AxeRefiningTemplate(new FabricItemSettings()));
    public static final Item SWORD_TEMPLATE = registerItem("sword_refining_template", new SwordRefiningTemplate(new FabricItemSettings()));
    public static final Item SHOVEL_TEMPLATE = registerItem("shovel_refining_template", new ShovelRefiningTemplate(new FabricItemSettings()));
    public static final Item HOE_TEMPLATE = registerItem("hoe_refining_template", new HoeRefiningTemplate(new FabricItemSettings()));


    public static final Item UNREFINED_DIAMOND_PICKAXE = registerItem("unrefined_diamond_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_DIAMOND, 1, -2.8f, new FabricItemSettings()));

    public static final Item UNREFINED_IRON_PICKAXE = registerItem("unrefined_iron_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_IRON, 1, -2.8f, new FabricItemSettings()));

    public static final Item UNREFINED_GOLDEN_PICKAXE = registerItem("unrefined_golden_pickaxe",
            new PickaxeItem(ModToolMaterial.UNREFINED_GOLD, 1, -2.8f, new FabricItemSettings()));

    private static void addIngredientMenu (FabricItemGroupEntries entries) {
        entries.add(SWORD_TEMPLATE);
        entries.add(PICK_TEMPLATE);
        entries.add(AXE_TEMPLATE);
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

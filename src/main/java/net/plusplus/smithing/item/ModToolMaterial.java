package net.plusplus.smithing.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    UNREFINED_DIAMOND(178, 5f, 2.75f, MiningLevels.DIAMOND, 0,
            () -> Ingredient.ofItems(Items.DIAMOND)),
    UNREFINED_IRON(151, 4.75f, 2.25f, MiningLevels.IRON, 0,
            () -> Ingredient.ofItems(Items.IRON_INGOT)),
    UNREFINED_GOLD(10, 9f, 0.5f, MiningLevels.WOOD, 0,
            () -> Ingredient.ofItems(Items.GOLD_INGOT));

    public final int itemDur;
    public final float mineSpeed;
    public final float attDamage;
    public final int mineLevel;
    public final int enchant;
    public final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int itemDur, float mineSpeed, float attDamage, int mineLevel, int enchant, Supplier<Ingredient> repairIngredient) {
        this.itemDur = itemDur;
        this.mineSpeed = mineSpeed;
        this.attDamage = attDamage;
        this.mineLevel = mineLevel;
        this.enchant = enchant;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDur;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.mineSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.mineLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchant;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}

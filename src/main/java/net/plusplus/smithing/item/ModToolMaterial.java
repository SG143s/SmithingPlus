package net.plusplus.smithing.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    UNREFINED_DIAMOND(178, 5f, 2.25f, MiningLevels.DIAMOND, 0);
    public final int itemDur;
    public final float mineSpeed;
    public final float attDamage;
    public final int mineLevel;
    public final int enchant;

    ModToolMaterial(int itemDur, float mineSpeed, float attDamage, int mineLevel, int enchant) {
        this.itemDur = itemDur;
        this.mineSpeed = mineSpeed;
        this.attDamage = attDamage;
        this.mineLevel = mineLevel;
        this.enchant = enchant;
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
        return null;
    }
}
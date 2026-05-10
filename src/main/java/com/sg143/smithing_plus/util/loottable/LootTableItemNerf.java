package com.sg143.smithing_plus.util.loottable;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;

public class LootTableItemNerf implements LootItemFunction {
    // Singleton instance since this is a static function with no parameters
    public static final LootTableItemNerf INSTANCE = new LootTableItemNerf();


    private LootTableItemNerf() {
        // Private constructor to enforce singleton
    }


    @Override
    public ItemStack apply(ItemStack stack, LootContext ctx) {
        //region INGREDIENTS
        if (stack.is(Items.IRON_INGOT)) {
            return new ItemStack(Items.IRON_NUGGET);
        }
        if (stack.is(Items.GOLD_INGOT)) {
            return new ItemStack(Items.GOLD_NUGGET);
        }
        if (stack.is(Items.DIAMOND)) {
            return new ItemStack(Items.DIAMOND, 1);
        }
        //endregion
        //region IRON TOOLS
        if (stack.is(Items.IRON_PICKAXE)) {
            return new ItemStack(Items.STONE_PICKAXE);
        }
        if (stack.is(Items.IRON_SHOVEL)) {
            return new ItemStack(Items.STONE_SHOVEL);
        }
        if (stack.is(Items.IRON_SWORD)) {
            return new ItemStack(Items.STONE_SWORD);
        }
        //endregion
        //region IRON ARMOR
        if (stack.is(Items.IRON_BOOTS)) {
            return new ItemStack(Items.CHAINMAIL_BOOTS);
        }
        if (stack.is(Items.IRON_CHESTPLATE)) {
            return new ItemStack(Items.CHAINMAIL_CHESTPLATE);
        }
        if (stack.is(Items.IRON_LEGGINGS)) {
            return new ItemStack(Items.CHAINMAIL_LEGGINGS);
        }
        if (stack.is(Items.IRON_HELMET)) {
            return new ItemStack(Items.CHAINMAIL_HELMET);
        }
        //endregion
        return stack;
    }



    public static final MapCodec<LootTableItemNerf> CODEC = MapCodec.unit(LootTableItemNerf.INSTANCE);


    @Override
    public MapCodec<? extends LootItemFunction> codec() {
        return null;
    }
}

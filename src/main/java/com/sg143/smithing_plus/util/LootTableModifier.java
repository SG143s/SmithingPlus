package com.sg143.smithing_plus.util;

import com.sg143.smithing_plus.item.ModItems;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTableModifier {
    private static final Identifier Toolsmith_Chest_ID =
            Identifier.of("minecraft", "chests/village/village_toolsmith");
    private static final Identifier Weaponsmith_Chest_ID =
            Identifier.of("minecraft", "chests/village/village_weaponsmith");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            Identifier id = registryKey.getValue();

            if (id.equals(Toolsmith_Chest_ID)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .equals()
            }
            if (id.equals(Weaponsmith_Chest_ID)) {
                Object2IntMap<ItemConvertible> lootChoices = new Object2IntOpenHashMap<>();
                lootChoices.put(ModItems.AXE_TEMPLATE, 39);
                lootChoices.put(ModItems.SWORD_TEMPLATE, 61);

                LootPool groupPool = createMutuallyExclusivePool(2, 0.89f, lootChoices);
                builder.pool(groupPool);
            }
                })

        );
    }
    private static LootPool createModItemPool(ItemConvertible item, int rolls, float minCount, float maxCount, float dropChance) {
        return LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .conditionally(RandomChanceLootCondition.builder(dropChance))
                .with(ItemEntry.builder(item))
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minCount, maxCount)))
                .build();
    }

    private static LootPool createMutuallyExclusivePool(int rolls, float activationChance, Object2IntMap<ItemConvertible> weightedItems) {
        LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantLootNumberProvider.create(rolls))
                .conditionally(RandomChanceLootCondition.builder(activationChance));

        for (ItemConvertible item : weightedItems.keySet()) {
            builder.with(ItemEntry.builder(item).weight(weightedItems.getInt(item)));
        }

        return builder.build();
    }

}

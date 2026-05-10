package com.sg143.smithing_plus.util.loottable;

import com.sg143.smithing_plus.item.ModItems;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraft.resources.Identifier;

public class LootTableModifier {
    private static final Identifier Toolsmith_Chest_ID =
            Identifier.fromNamespaceAndPath("minecraft", "chests/village/village_toolsmith");
    private static final Identifier Weaponsmith_Chest_ID =
            Identifier.fromNamespaceAndPath("minecraft", "chests/village/village_weaponsmith");
    private static final Identifier Armorer_Chest_ID =
            Identifier.fromNamespaceAndPath("minecraft", "chests/village/village_armorer");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((registryKey, builder, lootTableSource, wrapperLookup) -> {
            Identifier id = registryKey.identifier();

            if (id.equals(Armorer_Chest_ID)) {
                builder.apply(LootTableItemNerf.INSTANCE);
                Object2IntMap<ItemLike> lootChoices = new Object2IntOpenHashMap<>();
                lootChoices.put(ModItems.AXE_TEMPLATE, 25);
                lootChoices.put(ModItems.SHOVEL_TEMPLATE, 25);
                lootChoices.put(ModItems.PICKAXE_TEMPLATE, 25);
                lootChoices.put(ModItems.HOE_TEMPLATE, 25);

                LootPool groupPool = createMutuallyExclusivePool(2, 0.49f, lootChoices);
                builder.pool(groupPool);
            }
            if (id.equals(Toolsmith_Chest_ID)) {
                builder.apply(LootTableItemNerf.INSTANCE);
                Object2IntMap<ItemLike> lootChoices = new Object2IntOpenHashMap<>();
                lootChoices.put(ModItems.AXE_TEMPLATE, 19);
                lootChoices.put(ModItems.SHOVEL_TEMPLATE, 27);
                lootChoices.put(ModItems.PICKAXE_TEMPLATE, 27);
                lootChoices.put(ModItems.HOE_TEMPLATE, 27);

                LootPool groupPool = createMutuallyExclusivePool(3, 0.49f, lootChoices);
                builder.pool(groupPool);
                builder.pool(createModItemPool(ModItems.TOOL_HANDLE, 2, 1, 2, 0.7f));
            }
            if (id.equals(Weaponsmith_Chest_ID)) {
                builder.apply(LootTableItemNerf.INSTANCE);
                Object2IntMap<ItemLike> lootChoices = new Object2IntOpenHashMap<>();
                lootChoices.put(ModItems.AXE_TEMPLATE, 39);
                lootChoices.put(ModItems.SWORD_TEMPLATE, 61);

                LootPool groupPool = createMutuallyExclusivePool(2, 0.3f, lootChoices);
                builder.pool(groupPool);
                builder.pool(createModItemPool(ModItems.TOOL_HANDLE, 1, 1, 3, 0.73f));
            }
                })

        );
    }
    private static LootPool createModItemPool(ItemLike item, int rolls, float minCount, float maxCount, float dropChance) {
        return LootPool.lootPool()
                .setRolls(ConstantValue.exactly(rolls))
                .when(LootItemRandomChanceCondition.randomChance(dropChance))
                .add(LootItem.lootTableItem(item))
                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minCount, maxCount)))
                .build();
    }

    private static LootPool createMutuallyExclusivePool(int rolls, float activationChance, Object2IntMap<ItemLike> weightedItems) {
        LootPool.Builder builder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(rolls))
                .when(LootItemRandomChanceCondition.randomChance(activationChance));

        for (ItemLike item : weightedItems.keySet()) {
            builder.add(LootItem.lootTableItem(item).setWeight(weightedItems.getInt(item)));
        }

        return builder.build();
    }

}

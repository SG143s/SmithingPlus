package net.plusplus.smithing.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.plusplus.smithing.item.ModItems;

public class LootTableModifier {
    private static final Identifier ToolSmith_Chest_ID =
            new Identifier("minecraft", "chests/village/village_toolsmith");
    private static final Identifier WeaponSmith_Chest_ID =
            new Identifier("minecraft", "chests/village/village_weaponsmith");
    public static void ModifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (ToolSmith_Chest_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.PICK_TEMPLATE))
                        .with(ItemEntry.builder(ModItems.AXE_TEMPLATE))
                        .with(ItemEntry.builder(ModItems.SHOVEL_TEMPLATE))
                        .with(ItemEntry.builder(ModItems.HOE_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
            if (WeaponSmith_Chest_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1f))
                        .with(ItemEntry.builder(ModItems.SWORD_TEMPLATE))
                        .with(ItemEntry.builder(ModItems.AXE_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}

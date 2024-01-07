package net.plusplus.smithing;

import net.fabricmc.api.ModInitializer;

import net.plusplus.smithing.item.ModItems;
import net.plusplus.smithing.util.LootTableModifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmithingPlus implements ModInitializer {
	public static final String MODID = "smithingplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		LootTableModifier.ModifyLootTables();
	}
}
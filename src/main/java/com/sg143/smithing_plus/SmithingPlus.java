package com.sg143.smithing_plus;

import com.sg143.smithing_plus.item.ModItemGroup;
import com.sg143.smithing_plus.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmithingPlus implements ModInitializer {
	public static final String MOD_ID = "smithing-plus";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModItemGroup.registerModItemGroup();

		LOGGER.info("Hello Fabric world!");
	}
}
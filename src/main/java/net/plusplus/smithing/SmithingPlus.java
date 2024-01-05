package net.plusplus.smithing;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmithingPlus implements ModInitializer {
	public static final String MODID = "smithplus";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
	}
}
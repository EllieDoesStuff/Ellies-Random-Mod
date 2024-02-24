package net.ellie.ellieshenanigans;

import net.ellie.ellieshenanigans.block.ModBlocks;
import net.ellie.ellieshenanigans.item.ModItemGroup;
import net.ellie.ellieshenanigans.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EllieMod implements ModInitializer {
	public static final String MOD_ID = "ellieshenanigans";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItemGroup.registerItemsToGroup();
		ModItems.registerItems();
		ModBlocks.registerModBlocks();

	}
}
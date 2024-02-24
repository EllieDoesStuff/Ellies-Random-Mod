package net.ellie.ellieshenanigans.item;

import net.ellie.ellieshenanigans.EllieMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HEART_CRYSTAL = registerItem("heart_crystal", new Item(new FabricItemSettings()));

    public static final Item MIRROR = registerItem("mirror", new MirrorItem(new FabricItemSettings().maxCount(1)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(EllieMod.MOD_ID, name), item);
    }

    public static void registerItems() {
        EllieMod.LOGGER.info("giving info for elliemod class" + EllieMod.MOD_ID);
    }
}

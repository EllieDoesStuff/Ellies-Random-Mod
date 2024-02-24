package net.ellie.ellieshenanigans.item;

import net.ellie.ellieshenanigans.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ellie.ellieshenanigans.EllieMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ELLIE_SHENANIGANS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(EllieMod.MOD_ID, "ellie_shenanigans"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ellie_shenanigans"))
                    .icon(() -> new ItemStack(ModItems.HEART_CRYSTAL)).entries((displayContext, entries) -> {
                        entries.add(ModItems.HEART_CRYSTAL);
                        entries.add(ModItems.MIRROR);

                        entries.add(ModBlocks.AMETHYST_BRICK);
                        entries.add(ModBlocks.AMETHYST_BRICK_WALL);
                        entries.add(ModBlocks.AMETHYST_BRICK_STAIR);
                        entries.add(ModBlocks.AMETHYST_BRICK_SLAB);


                    }).build());

    public static void registerItemsToGroup() {
        EllieMod.LOGGER.info("letting ellie mod know that there's a custom item group." + EllieMod.MOD_ID);
    }
}

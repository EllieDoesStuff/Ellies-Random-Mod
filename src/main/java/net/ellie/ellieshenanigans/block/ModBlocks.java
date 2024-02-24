package net.ellie.ellieshenanigans.block;

import net.ellie.ellieshenanigans.EllieMod;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block DARK_STEEL_PATTERN = registerBlock("dark_steel_pattern",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.COPPER)));

    public static final Block DARK_STEEL_PATTERN_STAIR = registerBlock("dark_steel_pattern_stair",
            new StairsBlock(ModBlocks.DARK_STEEL_PATTERN.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.COPPER)));

    public static final Block DARK_STEEL_PATTERN_SLAB = registerBlock("dark_steel_pattern_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.COPPER)));


    //AMETHYST BLOCK FAMILY
    public static final Block AMETHYST_BRICK = registerBlock("amethyst_brick",
            new Block(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_BRICK_STAIR = registerBlock("amethyst_brick_stair",
            new StairsBlock(ModBlocks.DARK_STEEL_PATTERN.getDefaultState(),
                    FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_BRICK_SLAB = registerBlock("amethyst_brick_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    public static final Block AMETHYST_BRICK_WALL = registerBlock("amethyst_brick_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.AMETHYST_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(EllieMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(EllieMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        EllieMod.LOGGER.info("Giving info for ellie mod about blocks" + EllieMod.MOD_ID);
    }
}

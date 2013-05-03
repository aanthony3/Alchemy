package aka.alchemy.common.gen;

import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.WorldGenReference;
import cpw.mods.fml.common.registry.GameRegistry;

public class AlchemyWorldGenerator
{
    // Ore generators
    static AlchemyOreGen copperGen = new AlchemyOreGen(BlockIds.ORE, 0,
            WorldGenReference.COPPER_MIN_HEIGHT,
            WorldGenReference.COPPER_MAX_HEIGHT,
            WorldGenReference.COPPER_BLOCKS_PER_VEIN,
            WorldGenReference.COPPER_VEINS_PER_CHUNK);
    static AlchemyOreGen tinGen = new AlchemyOreGen(BlockIds.ORE, 1,
            WorldGenReference.TIN_MIN_HEIGHT, WorldGenReference.TIN_MAX_HEIGHT,
            WorldGenReference.TIN_BLOCKS_PER_VEIN,
            WorldGenReference.TIN_VEINS_PER_CHUNK);
    static AlchemyOreGen titaniumGen = new AlchemyOreGen(BlockIds.ORE, 2,
            WorldGenReference.TITANIUM_MIN_HEIGHT,
            WorldGenReference.TITANIUM_MAX_HEIGHT,
            WorldGenReference.TITANIUM_BLOCKS_PER_VEIN,
            WorldGenReference.TITANIUM_VEINS_PER_CHUNK);

    public static void registerGenerators()
    {
        GameRegistry.registerWorldGenerator(copperGen);
    }

}

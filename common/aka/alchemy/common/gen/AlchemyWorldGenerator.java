package aka.alchemy.common.gen;

import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.WorldGen;
import cpw.mods.fml.common.registry.GameRegistry;

public class AlchemyWorldGenerator
{
    // Ore generators
    static AlchemyOreGen copperGen = new AlchemyOreGen(BlockIds.ORE, 0,
            WorldGen.COPPER_MIN_HEIGHT, WorldGen.COPPER_MAX_HEIGHT,
            WorldGen.COPPER_BLOCKS_PER_VEIN, WorldGen.COPPER_VEINS_PER_CHUNK);
    static AlchemyOreGen tinGen = new AlchemyOreGen(BlockIds.ORE, 1,
            WorldGen.TIN_MIN_HEIGHT, WorldGen.TIN_MAX_HEIGHT,
            WorldGen.TIN_BLOCKS_PER_VEIN, WorldGen.TIN_VEINS_PER_CHUNK);
    static AlchemyOreGen titaniumGen = new AlchemyOreGen(BlockIds.ORE, 2,
            WorldGen.TITANIUM_MIN_HEIGHT, WorldGen.TITANIUM_MAX_HEIGHT,
            WorldGen.TITANIUM_BLOCKS_PER_VEIN,
            WorldGen.TITANIUM_VEINS_PER_CHUNK);

    public static void registerGenerators()
    {
        if (WorldGen.GENERATE_COPPER)
        {
            GameRegistry.registerWorldGenerator(copperGen);
        }
    }

}

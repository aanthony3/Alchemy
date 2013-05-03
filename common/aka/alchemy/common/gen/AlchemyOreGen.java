package aka.alchemy.common.gen;

import java.util.Random;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import aka.alchemy.common.helper.LogHelper;
import aka.alchemy.common.lib.Reference;
import cpw.mods.fml.common.IWorldGenerator;

public class AlchemyOreGen implements IWorldGenerator
{
    private int blockID;
    private int blockMeta;
    private int minHeight;
    private int maxHeight;
    private int blocksPerVein;
    private int veinsPerChunk;

    AlchemyOreGen(int blockID, int blockMeta, int minHeight,
            int maxHeightOfOre, int blocksPerVein, int veinsPerChunk)
    {
        this.blockID = blockID;
        this.blockMeta = blockMeta;
        this.minHeight = minHeight;
        maxHeight = maxHeightOfOre;
        this.blocksPerVein = blocksPerVein;
        this.veinsPerChunk = veinsPerChunk;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.isSurfaceWorld()) {
            WorldGenerator generator = new WorldGenMinable(blockID, blockMeta,
                    blocksPerVein, Block.stone.blockID);

            for (int iii = 0; iii < veinsPerChunk; iii++) {
                int x = chunkX * 16 + random.nextInt(16);
                int y = minHeight + random.nextInt(maxHeight - minHeight);
                int z = chunkZ * 16 + random.nextInt(16);

                generator.generate(world, random, x, y, z);

                if (Reference.DEBUG_MODE) {
                    LogHelper.log(Level.FINEST, "Ore spwaned at: " + x + ", "
                            + y + ", " + z);
                }
            }
        }

    }

}

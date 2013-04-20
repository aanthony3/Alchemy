package aka.alchemy.common.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.Strings;
import net.minecraft.block.Block;

public class ModBlocks
{
    /* Public mod block instances */
    public static Block ores;

    public static void init()
    {
        ores = new BlockOre(BlockIds.ORE);

        GameRegistry.registerBlock(ores, Strings.ORE_BLOCK_NAME);
    }

    public static void initBlockRecipies()
    {

    }

}

package aka.alchemy.common.blocks;

import net.minecraft.block.Block;
import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
    /* Public mod block instances */
    public static Block ores;

    public static void init()
    {
        ores = new BlockOre(BlockIds.ORE);

        GameRegistry.registerBlock(ores, Strings.ORE_BLOCK_NAME);

        registerNames();
    }

    private static void registerNames()
    {

    }

    public static void initBlockRecipies()
    {

    }

}

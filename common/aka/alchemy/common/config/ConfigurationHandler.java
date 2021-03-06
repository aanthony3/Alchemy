package aka.alchemy.common.config;

import java.io.File;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import aka.alchemy.common.helper.LogHelper;
import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.ItemIds;
import aka.alchemy.common.lib.Reference;
import aka.alchemy.common.lib.Strings;
import aka.alchemy.common.lib.WorldGen;
import cpw.mods.fml.common.FMLLog;

public class ConfigurationHandler
{
    public static Configuration config;

    public static void init(File configFile)
    {
        config = new Configuration(configFile);

        try
        {
            // load the file
            config.load();

            // Block IDs
            BlockIds.ORE = config.getBlock(Strings.ORE_BLOCK_NAME,
                    BlockIds.ORE_DFLT).getInt(BlockIds.ORE_DFLT);

            // Item IDs
            ItemIds.TITANIUM_CHUNK = config.getItem(
                    Strings.TITANIUM_CHUNK_NAME, ItemIds.TITANIUM_CHUNK_DFLT)
                    .getInt(ItemIds.TITANIUM_CHUNK_DFLT);
            ItemIds.TITANIUM_NUGGET = config.getItem(
                    Strings.TITANIUM_NUGGET_NAME, ItemIds.TITANIUM_NUGGET_DFLT)
                    .getInt(ItemIds.TITANIUM_NUGGET_DFLT);
            ItemIds.VILLAGER_BREEDER = config.getItem(
                    Strings.VILLAGER_BREEDER_NAME,
                    ItemIds.VILLAGER_BREEDER_DFLT).getInt(
                    ItemIds.VILLAGER_BREEDER_DFLT);

            // World gen parameters
            WorldGen.COPPER_MIN_HEIGHT = config.get("WorldGen",
                    "CopperMinHeight", WorldGen.COPPER_MIN_HEIGHT_DFLT).getInt(
                    WorldGen.COPPER_MIN_HEIGHT_DFLT);
            WorldGen.COPPER_MAX_HEIGHT = config.get("WorldGen",
                    "CopperMaxHeight", WorldGen.COPPER_MAX_HEIGHT_DFLT).getInt(
                    WorldGen.COPPER_MAX_HEIGHT_DFLT);
            WorldGen.COPPER_BLOCKS_PER_VEIN = config.get("WorldGen",
                    "CopperBlocksInVein", WorldGen.COPPER_BLOCKS_PER_VEIN_DFLT)
                    .getInt(WorldGen.COPPER_BLOCKS_PER_VEIN_DFLT);
            WorldGen.COPPER_VEINS_PER_CHUNK = config
                    .get("WorldGen", "CopperVeinsPerChunk",
                            WorldGen.COPPER_VEINS_PER_CHUNK_DFLT).getInt(
                            WorldGen.COPPER_VEINS_PER_CHUNK_DFLT);
            WorldGen.GENERATE_COPPER = config.get("WorldGen", "GenerateCopper",
                    WorldGen.GENERATE_COPPER_DFLT).getBoolean(
                    WorldGen.GENERATE_COPPER_DFLT);

            // If debug mode is one print all ids
            if (Reference.DEBUG_MODE)
            {
                // block Ids
                LogHelper.log(Level.INFO, "Ore ID is " + BlockIds.ORE);

                // Item Ids
                LogHelper.log(Level.INFO, "chunkTitanium ID is "
                        + ItemIds.TITANIUM_CHUNK);
                LogHelper.log(Level.INFO, "nuggetTitanium ID is "
                        + ItemIds.TITANIUM_NUGGET);
            }

        } catch (Exception e)
        {
            FMLLog.log(Level.SEVERE, e,
                    "Alchemicraft had a problem loading its configuration");
        } finally
        {
            config.save();
        }
    }
}

package aka.alchemy.common.config;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;

import aka.alchemy.common.lib.BlockIds;
import aka.alchemy.common.lib.Strings;

import net.minecraftforge.common.Configuration;

public class ConfigurationHandler 
{
	public static Configuration config;
	
	public static void init(File configFile)
	{
		config = new Configuration(configFile);
		
		try
		{
			config.load();
			
			//Block IDs
			BlockIds.ORE = config.getBlock(Strings.ORE_BLOCK_NAME, BlockIds.ORE_DEFAULT).getInt(BlockIds.ORE_DEFAULT);
			
			//Item IDs
		}
		catch (Exception e)
		{
			FMLLog.log(Level.SEVERE, e, "Alchemicraft had a problem loading its configuration");
		}
		finally
		{
			config.save();
		}
	}
}

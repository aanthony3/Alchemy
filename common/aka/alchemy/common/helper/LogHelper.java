package aka.alchemy.common.helper;

import java.util.logging.Level;
import java.util.logging.Logger;

import aka.alchemy.common.lib.Reference;

import cpw.mods.fml.common.FMLLog;

public class LogHelper
{

    private static Logger alchemyLogger = Logger.getLogger(Reference.MOD_ID);

    public static void init() {

        alchemyLogger.setParent(FMLLog.getLogger());
    }

    public static void log(Level logLevel, String message) {

        alchemyLogger.log(logLevel, message);
    }

}

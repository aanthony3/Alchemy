package aka.alcheemy.common.items;

import net.minecraft.item.ItemStack;
import aka.alchemy.common.blocks.ModBlocks;
import aka.alchemy.common.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems
{
    public static ItemBlockOre itemBlockOre;

    public static void init()
    {
        itemBlockOre = new ItemBlockOre(ModBlocks.ores.blockID - 256);

        GameRegistry.registerItem(itemBlockOre, Strings.ORE_ITEM_NAME);

        registerNames();
    }

    private static void registerNames()
    {
        LanguageRegistry.addName(new ItemStack(itemBlockOre, 1, 0),
                "Copper Ore");
        LanguageRegistry.addName(new ItemStack(itemBlockOre, 1, 1), "Tin Ore");
        LanguageRegistry.addName(new ItemStack(itemBlockOre, 1, 2),
                "Titanium Ore");
    }

}

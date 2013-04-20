package aka.alcheemy.common.items;

import net.minecraft.item.ItemStack;
import aka.alchemy.common.blocks.ModBlocks;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems
{

    public static void init()
    {
        ItemStack stack = new ItemStack(ModBlocks.ores, 1, 0);
        LanguageRegistry.addName(stack, "hi");

        stack = new ItemStack(ModBlocks.ores, 1, 1);
        LanguageRegistry.addName(stack, "hi1");

        stack = new ItemStack(ModBlocks.ores, 1, 2);
        LanguageRegistry.addName(stack, "hi2");
    }
}

package aka.alchemy.common.items;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import aka.alchemy.common.blocks.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlockOre extends ItemBlock
{

    public static final String[] oreNames = new String[] { "coper", "tin",
            "titanium" };

    public ItemBlockOre(int itemId)
    {
        super(itemId);
        setHasSubtypes(true);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Icon getIconFromDamage(int damageValue)
    {
        return ModBlocks.ores.getIcon(2, damageValue);
    }

    @Override
    public int getMetadata(int damageValue)
    {
        return damageValue;
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return super.getUnlocalizedName() + "."
                + oreNames[itemStack.getItemDamage() % oreNames.length];
    }

}

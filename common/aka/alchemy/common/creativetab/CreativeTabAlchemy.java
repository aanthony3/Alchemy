package aka.alchemy.common.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAlchemy extends CreativeTabs
{

    public CreativeTabAlchemy(int par1, String par2Str)
    {
        super(par1, par2Str);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex()
    {
        return Item.appleGold.itemID;
    }

}

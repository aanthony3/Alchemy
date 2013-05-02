package aka.alchemy.common.items;

import aka.alchemy.common.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemAlchemy extends Item
{

    public ItemAlchemy(int itemId)
    {
        super(itemId - Reference.SHIFTED_ID_RANGE_CORRECTION);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

}

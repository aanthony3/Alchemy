package aka.alchemy.common.items;

import aka.alchemy.common.Alchemy;
import aka.alchemy.common.creativetab.CreativeTabAlchemy;
import aka.alchemy.common.lib.Strings;
import net.minecraft.item.Item;

public class ItemTitaniumChunk extends ItemAlchemy
{

    public ItemTitaniumChunk(int itemId)
    {
        super(itemId);
        this.setUnlocalizedName(Strings.TITANIUM_CHUNK_NAME);
        this.setCreativeTab(Alchemy.instance.alchemyTab);
    }
    

}

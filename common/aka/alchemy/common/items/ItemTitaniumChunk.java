package aka.alchemy.common.items;

import aka.alchemy.common.Alchemy;
import aka.alchemy.common.lib.Strings;

public class ItemTitaniumChunk extends ItemAlchemy
{

    public ItemTitaniumChunk(int itemId)
    {
        super(itemId);
        setUnlocalizedName(Strings.TITANIUM_CHUNK_NAME);
        setCreativeTab(Alchemy.instance.alchemyTab);
    }

}

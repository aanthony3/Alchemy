package aka.alchemy.common.items;

import aka.alchemy.common.Alchemy;
import aka.alchemy.common.lib.Strings;

public class ItemTitaniumNugget extends ItemAlchemy
{

    public ItemTitaniumNugget(int itemId)
    {
        super(itemId);
        setUnlocalizedName(Strings.TITANIUM_NUGGET_NAME);
        setCreativeTab(Alchemy.instance.alchemyTab);
    }

}

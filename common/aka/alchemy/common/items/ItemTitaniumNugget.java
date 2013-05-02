package aka.alchemy.common.items;

import aka.alchemy.common.Alchemy;
import aka.alchemy.common.lib.Strings;
import net.minecraft.item.Item;

public class ItemTitaniumNugget extends ItemAlchemy
{

    public ItemTitaniumNugget(int itemId)
    {
        super(itemId);
        this.setUnlocalizedName(Strings.TITANIUM_NUGGET_NAME);
        this.setCreativeTab(Alchemy.instance.alchemyTab);
    }

}

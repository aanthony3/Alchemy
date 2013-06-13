package aka.alchemy.common.items;

import aka.alchemy.common.Alchemy;
import aka.alchemy.common.lib.Strings;

public class ItemVillagerBreeder extends ItemAlchemy
{

    public ItemVillagerBreeder(int itemId)
    {
        super(itemId);
        this.setUnlocalizedName(Strings.VILLAGER_BREEDER_NAME);
        this.setCreativeTab(Alchemy.instance.alchemyTab);
    }
}

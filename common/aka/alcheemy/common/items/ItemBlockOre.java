package aka.alcheemy.common.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockOre extends ItemBlockWithMetadata
{
    private final static String[] subNames = {"copper","tin","titanium"};
    public ItemBlockOre(int itemID, Block par2Block)
    {
        super(itemID, par2Block);
        this.setMaxDamage(3);  
        this.setUnlocalizedName("blockOre");
    }

    @Override
    public String getLocalizedName(ItemStack itemStack)
    {
        return this.getUnlocalizedName() + "." + subNames[itemStack.getItemDamage()];
    }
}

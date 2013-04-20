package aka.alchemy.common.blocks;

import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import aka.alchemy.common.Alchemy;

public class BlockOre extends BlockAlchemy
{
    /*
     * Metadata Codes Copper = 0 Tin = 1 Titanium = 2
     */

    /* Icons */
    private Icon[] icons;

    public BlockOre(int blockId)
    {
        super(blockId, Material.rock);
        setCreativeTab(Alchemy.instance.alchemyTab);
        setHardness(3.0F);
        this.setUnlocalizedName("blockOre");
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        icons = new Icon[3];

        icons[0] = iconRegister.registerIcon("aka:oreCopper");
        icons[1] = iconRegister.registerIcon("aka:oreTin");
        icons[2] = iconRegister.registerIcon("aka:oreTitanium");
    }

    @Override
    public Icon getIcon(int side, int metadata)
    {
        if (metadata < icons.length)
            return icons[metadata];
        else
            return null;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubBlocks(int i, CreativeTabs tab, List itemStack)
    {
        for (int iii = 0; iii < 3; iii++ )
        {
            itemStack.add(new ItemStack(this, 1, iii));
        }
    }
    
    @Override
    public int damageDropped(int par1)
    {
        return par1;
    }
    @Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        return par9;
    }
}

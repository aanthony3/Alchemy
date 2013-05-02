package aka.alchemy.common.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import aka.alchemy.common.Alchemy;
import aka.alchemy.common.lib.ItemIds;
import aka.alchemy.common.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        icons = new Icon[3];

        icons[0] = iconRegister.registerIcon(Reference.MOD_ID + ":oreCopper");
        icons[1] = iconRegister.registerIcon(Reference.MOD_ID + ":oreTin");
        icons[2] = iconRegister.registerIcon(Reference.MOD_ID + ":oreTitanium");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int metadata)
    {
        if (metadata < icons.length)
            return icons[metadata];
        else
            return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void getSubBlocks(int blockId, CreativeTabs tab, List itemStack)
    {
        for (int iii = 0; iii < icons.length; iii++) {
            itemStack.add(new ItemStack(blockId, 1, iii));
        }
    }

    @Override
    public int idDropped(int damageValue, Random random, int par3)
    {
        if (damageValue == 2)
            return ItemIds.TITANIUM_CHUNK;
        else
            return blockID;
    }

    @Override
    public int damageDropped(int damageValue)
    {
        return damageValue;
    }

    @Override
    public int quantityDropped(int meta, int fortune, Random random)
    {
        // If it's titanium ore
        if (meta == 2) {
            int multiplier = random.nextInt((fortune + 1) * 2);
            return random.nextInt(4) + multiplier;
        } else
            return 1;
    }
}

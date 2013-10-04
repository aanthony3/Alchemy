package aka.alchemy.core.handlers.events;

import java.util.Iterator;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAITaskEntry;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import aka.alchemy.common.entity.ai.EntityAICustomVillagerMating;
import aka.alchemy.common.lib.ItemIds;

public class EntityLivingEventHandler
{
    @SuppressWarnings("rawtypes")
	@ForgeSubscribe
    public void interactWithEntity(EntityInteractEvent event)
    {
        EntityPlayer player = event.entityPlayer;
        Entity target = event.target;

        if (target instanceof EntityVillager)
        {
            ItemStack currentStack = player.getCurrentEquippedItem();

            if (currentStack.getItem().itemID == ItemIds.VILLAGER_BREEDER)
            {
                Iterator taskIterator = ((EntityVillager) target).tasks.taskEntries
                        .iterator();

                while (taskIterator.hasNext())
                {
                    EntityAITaskEntry entry = (EntityAITaskEntry) taskIterator
                            .next();

                    if (entry.action instanceof EntityAICustomVillagerMating)
                    {
                        ((EntityAICustomVillagerMating) entry.action).shouldExecute = true;
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}

package aka.alchemy.core.handlers.events;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import aka.alchemy.common.entity.ai.EntityAICustomVillagerMating;

public class EntityEventHandler
{
    @ForgeSubscribe
    public void onEntityConstruction(EntityJoinWorldEvent event)
    {
        // If it's a villager entity
        if (event.entity instanceof EntityVillager)
        {
            EntityVillager villager = (EntityVillager) event.entity;
            // same priority as normal mate
            villager.tasks.addTask(6,
                    new EntityAICustomVillagerMating(villager));
        }
    }
}

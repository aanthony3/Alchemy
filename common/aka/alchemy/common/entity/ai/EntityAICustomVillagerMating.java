package aka.alchemy.common.entity.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.world.World;

public class EntityAICustomVillagerMating extends EntityAIBase
{
    // variable set by onInteract event
    public boolean shouldExecute = false;
    private boolean foundMate = false;
    private EntityVillager villagerObj;
    private EntityVillager mate;
    private World worldObj;
    private int matingTimeout = 0;

    public EntityAICustomVillagerMating(EntityVillager entityVillager)
    {
        villagerObj = entityVillager;
        worldObj = entityVillager.worldObj;
        this.setMutexBits(3);
    }

    @Override
    public boolean shouldExecute()
    {
        return shouldExecute;
    }

    @Override
    public void startExecuting()
    {
        // find the nearest villager
        EntityVillager entityMate = (EntityVillager) worldObj
                .findNearestEntityWithinAABB(EntityVillager.class,
                        villagerObj.boundingBox.expand(8.0D, 3.0D, 8.0D),
                        villagerObj);

        checkSuitableMate(entityMate);

        matingTimeout = 300;
        villagerObj.setMating(true);
    }

    @Override
    public void resetTask()
    {
        shouldExecute = false;
        foundMate = false;
        villagerObj.setMating(false);
        mate = null;
    }

    @Override
    public boolean continueExecuting()
    {
        return matingTimeout >= 0 && villagerObj.getGrowingAge() == 0;
    }

    @Override
    public void updateTask()
    {
        matingTimeout--;

        // Try to find mate if one isn't selected already
        if (lookForMate())
        {
            // look at mate
            villagerObj.getLookHelper().setLookPositionWithEntity(mate, 10.0F,
                    30.0F);

            // move to mate
            if (villagerObj.getDistanceSqToEntity(mate) > 2.25D)
            {
                villagerObj.getNavigator().tryMoveToEntityLiving(mate, 0.25F);
            }
            // If both are mating give birth
            else if (matingTimeout == 0 && mate.isMating())
            {
                this.giveBirth();
            }
        }
    }

    private void giveBirth()
    {
        // childVillager
        EntityVillager entityvillager = villagerObj.func_90012_b(mate);
        mate.setGrowingAge(3000);
        villagerObj.setGrowingAge(3000);
        entityvillager.setGrowingAge(-24000);
        entityvillager.setLocationAndAngles(villagerObj.posX, villagerObj.posY,
                villagerObj.posZ, 0.0F, 0.0F);
        worldObj.spawnEntityInWorld(entityvillager);
        worldObj.setEntityState(entityvillager, (byte) 12);
    }

    private void checkSuitableMate(EntityVillager entityMate)
    {
        if (entityMate != null && entityMate.getGrowingAge() == 0)
        {
            foundMate = true;
            mate = entityMate;
        }
    }

    private boolean lookForMate()
    {
        // If a mate hasn't been found already try to find one
        if (!foundMate)
        {
            EntityVillager entityMate = (EntityVillager) worldObj
                    .findNearestEntityWithinAABB(EntityVillager.class,
                            villagerObj.boundingBox.expand(8.0D, 3.0D, 8.0D),
                            villagerObj);

            if (entityMate != null && entityMate.getGrowingAge() == 0)
            {
                foundMate = true;
                mate = entityMate;
            }
        }

        return foundMate;
    }

}

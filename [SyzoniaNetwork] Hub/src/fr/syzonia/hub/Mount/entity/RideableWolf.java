package fr.syzonia.hub.Mount.entity;


import java.lang.reflect.Field;


import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;

import fr.syzonia.hub.Hub;
import fr.syzonia.hub.Mount.MountManager;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityWolf;
import net.minecraft.server.v1_8_R3.MathHelper;
import net.minecraft.server.v1_8_R3.World;

public class RideableWolf extends EntityWolf {

	
	protected Field FIELD_JUMP = null;
	private Player rider;
	
	
    public RideableWolf(World world, Player player) {
        super(world);
        
        this.rider = player;
        
        EntityLiving nmsEntity = this;
		LivingEntity mount = (LivingEntity) nmsEntity.getBukkitEntity();
		Wolf wolf = (Wolf) mount;
		Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				wolf.setAngry(false);
			}
		}, 0L, 1L);
        
    }
 
    @Override
    public void g(float f, float f1) {
 
    	
    	if (MountManager.shouldDie(this, rider)) {
    		return;
    	}
    	
    	if(!isAlive()) {
    		return;
    	}
 
        if (this.passenger != null && this.passenger instanceof EntityHuman)  {
            this.lastYaw = this.yaw = this.passenger.yaw;
            this.pitch = this.passenger.pitch * 0.5F;
            this.setYawPitch(this.yaw, this.pitch);
            this.aK = this.aI = this.yaw;
            f = ((EntityLiving)this.passenger).aZ * 0.5F;
            f1 = ((EntityLiving)this.passenger).ba;
 
            if(f1 <= 0.0F) {
                f1 *= 0.25F;
            }
          
            this.S = 1.0F; this.aM = this.bI() * 0.1F; if(!this.world.isClientSide)  {
                this.k((float) MountManager.mountSpeed);
                super.g(f, f1);
            }
 
            this.aA = this.aB; double d0 = this.locX - this.lastX; double d1 = this.locZ - this.lastZ; float f4 = MathHelper.sqrt(d0 * d0 + d1 * d1) * 4.0F;
            if(f4 > 1.0F)
            {
                f4 = 1.0F;
            }
 
            this.aB += (f4 - this.aB) * 0.4F; this.aC += this.aB;
            
            
        } else {
            this.S = 0.5F; this.aM = 0.02F; super.g(f, f1);
        }
    }
	}


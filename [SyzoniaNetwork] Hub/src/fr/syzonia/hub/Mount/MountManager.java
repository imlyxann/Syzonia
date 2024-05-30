package fr.syzonia.hub.Mount;




import org.bukkit.Location;

import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import fr.syzonia.hub.Mount.entity.RideableCow;
import fr.syzonia.hub.Mount.entity.RideablePig;
import fr.syzonia.hub.Mount.entity.RideableSheep;
import fr.syzonia.hub.Mount.entity.RideableWolf;
import fr.syzonia.syzodb.mysql.mount.UseMount;
import net.minecraft.server.v1_8_R3.EntityAgeable;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.World;


public class MountManager implements Listener{

	
	public static double maxHealth = 8;
	public static double mountSpeed = 0.15F;

	
	public static boolean shouldDie(EntityLiving mount, Player rider) {
		if(mount.passenger == null || !(mount.passenger instanceof EntityHuman)) {			
			mount.die();
			return true;
		}
		return false;
	}
	
	public static void killMount(EntityLiving mount, Player rider) {
		mount.die();
	}
	
	
	public static void rideWolf(Player player) {
		Location loc = player.getLocation();
		World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		make(new RideableWolf(nmsWorld, player), player, 1);
	}
	
	public static void rideCow(Player player) {
		Location loc = player.getLocation();
		World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		make(new RideableCow(nmsWorld, player), player, 2);
	}
	
	public static void ridePig(Player player) {
		Location loc = player.getLocation();
		World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		make(new RideablePig(nmsWorld, player), player, 3);
	}
	
	
	public static void rideSheep(Player player) {
		Location loc = player.getLocation();
		World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();;
		make(new RideableSheep(nmsWorld, player), player, 4);
	}

	public static void make(EntityLiving nmsEntity, Player player, int id) {
		
		if(!canSummonMount(player.getLocation())) {
			player.sendMessage("§a[Monture] §cIl n'y a pas assez de place pour invoquer la monture!");
			return;
		}		
   
		
		LivingEntity mount = (LivingEntity) nmsEntity.getBukkitEntity();
		
		if(mount instanceof EntityAgeable) ((EntityAgeable) mount).setAge(0);
		
		Location loc = player.getLocation();
		World nmsWorld = ((CraftWorld) loc.getWorld()).getHandle();
		
		nmsEntity.setPosition(loc.getX(), loc.getY() + 0.3, loc.getZ());
		nmsWorld.addEntity(nmsEntity, SpawnReason.CUSTOM);
		mount.setPassenger(player);
		mount.setHealth(maxHealth);
		
		
		new UseMount().setMountInUse(player.getUniqueId(), id);
	}			
	
	public static boolean canSummonMount(Location loc) {
		org.bukkit.World world = loc.getWorld();
		Block block = loc.getBlock();
		
		for(int x = loc.getBlockX() -1; x <= loc.getBlockX() + 1; x++) {
			for(int y = loc.getBlockY(); y <= loc.getBlockY() + 1; y++) {
				for(int z = loc.getBlockZ(); z <= loc.getBlockZ() + 1; z++) {
					block = world.getBlockAt(x, y, z);
					if(block.getType().isSolid()) return false;
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void PlayerSneak(PlayerToggleSneakEvent event) {
		if(new UseMount().getMountInUse(event.getPlayer().getUniqueId()) > 0) {
			new UseMount().setMountInUse(event.getPlayer().getUniqueId(), 0);
		}
	}
	
}

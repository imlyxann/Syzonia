package fr.syzonia.core.firework;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;


public class FireWorkUtils {

	 public static void launchfw(Location location, final FireworkEffect effect) {
	        Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
	        FireworkMeta fwm = fw.getFireworkMeta();
	        fwm.addEffect(effect);
	        fwm.setPower(0);
	        fw.setFireworkMeta(fwm);
	    }
	
}

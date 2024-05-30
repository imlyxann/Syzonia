package fr.syzonia.core.armorstand;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class ArmorStandManager {

	public static HashMap<Integer, ArmorStand> ArmorStands = new HashMap<>();
	
	public static void createArmorStand(Integer name, String customname, boolean namevisible, Location loc, boolean gravity, boolean small, boolean visibility, ItemStack[] equip) {
		ArmorStand armor;
		
		armor = (ArmorStand) Bukkit.getWorld("world").spawnEntity(loc, EntityType.ARMOR_STAND);
		
		armor.setCustomName(customname);
		armor.setCustomNameVisible(namevisible);
		armor.setGravity(gravity);
		armor.setSmall(small);
		armor.setVisible(visibility);
		
		if(equip[0] != null) {
			armor.setHelmet(equip[0]);
		}
		
		if(equip[1] != null) {
			armor.setChestplate(equip[1]);
		}

		if(equip[2] != null) {
			armor.setLeggings(equip[2]);
		}

		if(equip[3] != null) {
			armor.setBoots(equip[3]);
		}
		
		if(equip[4] != null) {
			armor.setItemInHand(equip[4]);
		}
		
		ArmorStands.put(name, armor);
	}
	
	public void remove(Integer name) {
		ArmorStands.get(name).remove();
		ArmorStands.remove(name);
	}
	
	public ArmorStand get(Integer name) {
		return ArmorStands.get(name);
	}
	
}

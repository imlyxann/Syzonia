package fr.syzonia.hub.pets.pets;


import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import fr.syzonia.core.customskulls.CustomSkulls;
import fr.syzonia.hub.pets.PetsManager;


public class MiniDiamond {
	
	public void spawn(Player player) {
		ArmorStand armor = null;
		
		armor = (ArmorStand) player.getWorld().spawnEntity(new PetsManager().getLoc(player), EntityType.ARMOR_STAND);

		armor.setCustomName("§b§lMini-Diamant");
		armor.setCustomNameVisible(true);
		armor.setSmall(true);
		armor.setHelmet(CustomSkulls.getCustomSkull("https://textures.minecraft.net/texture/1ca8293c832514f253438958bb43caca89e6dd2f9e427e30fa0ff5f1a7d28f51", "Diamond"));
		armor.setGravity(false);
		armor.setVisible(false);
		
		PetsManager.PlayerPets.put(player, armor);
	}
	
	public void killPet(Player player) {
		PetsManager.PlayerPets.get(player).remove();
		
		PetsManager.PlayerPets.remove(player);
	}
	
	public ItemStack getHead(String name) {
		
		ItemStack item = new ItemStack(Material.SKULL_ITEM, 1 , (byte) 3);
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(name);
		item.setItemMeta(meta);
		
		
		return item;
	}

		

	
}

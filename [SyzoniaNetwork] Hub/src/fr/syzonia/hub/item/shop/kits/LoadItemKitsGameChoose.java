package fr.syzonia.hub.item.shop.kits;

import org.bukkit.Material;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemKitsGameChoose {

	public void LoadItem(VirtualMenu menu) {
		menu.setItem(0, new ItemBuilder().type(Material.CAKE).name("§6CakeWars").lore("§7Permet d'acceder à la boutique des kits du cakewars!").build());
	}
	
}

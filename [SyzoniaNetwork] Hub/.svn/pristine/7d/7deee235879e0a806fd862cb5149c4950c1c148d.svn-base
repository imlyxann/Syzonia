package fr.syzonia.hub.item.Profil.vetements;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadPullProfilItem {

	public void load(VirtualMenu menu, Player player) {
	
		if(VetementsManager.havePull(1, player)) {
			menu.setItem(0, new ItemBuilder().type(Material.LEATHER_CHESTPLATE).name("§6Pull Nike").lore("§8------------------------", "§ePull", "§7Dinguerie ce pull?", "§8------------------------", "§6", VetementsManager.havePull(1, player) ? "Achetez cet objet 200 Syzocoins" : "§eVous possédez cet objet!").setLeatherColor(Color.BLACK).build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		menu.setItem(8, new ItemBuilder().type(Material.BLAZE_ROD).name("§eEnlève le pull").lore("§7(clique-droit) §8Permet d'enlever le pull").build());
	}
	
}

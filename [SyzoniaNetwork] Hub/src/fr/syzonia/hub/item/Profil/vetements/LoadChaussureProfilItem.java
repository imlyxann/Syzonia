package fr.syzonia.hub.item.Profil.vetements;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadChaussureProfilItem {

	public void load(VirtualMenu menu, Player player) {
		if(VetementsManager.haveChaussure(1, player)) {
			menu.setItem(0, new ItemBuilder().type(Material.LEATHER_BOOTS).name("§6Jordan 1").lore("§8------------------------", "§eChaussure", "§7Jordan c'est pas une geox frero", "§8------------------------", "§6", VetementsManager.haveChaussure(1, player) ? "Achetez cet objet 180 Syzocoins" : "§eVous possédez cet objet!").setLeatherColor(Color.BLACK).build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		menu.setItem(8, new ItemBuilder().type(Material.BLAZE_ROD).name("§eEnlève la chaussure").lore("§7(clique-droit) §8Permet d'enlever la chaussure").build());
	}
	
}

package fr.syzonia.hub.item.Profil.pets;

import org.bukkit.Material;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.pets.PetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemPetsProfil {

	public void LoadItem(VirtualMenu menu, Player player) {
		if(PetsData.havePet(1, player)) {
			menu.setItem(0, new ItemBuilder().type(Material.SKULL_ITEM).data((byte) 3).setSkullOwner(player.getName()).name("§6Mini-" + player.getName()).lore("§8--------------------", "§eCompagnon", "§6Petit pet mignon!", "§8--------------------", "", (PetsData.havePet(1, player) ? "§eVous possédez cet objet!" : "§eAchetez cet objet")).build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(PetsData.havePet(2, player)) {
			menu.setItem(1, new ItemBuilder().type(Material.DIAMOND).name("§bMini-Diamant").lore("§8--------------------", "§eCompagnon", "§6Petit pet mignon!", "§8--------------------", "", (PetsData.havePet(2, player) ? "§eVous possédez cet objet!" : "§eAchetez cet objet")).build());
		} else {
			menu.setItem(1, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		
		menu.setItem(8, new ItemBuilder().type(Material.BLAZE_POWDER).name("Désactive ton pet").lore("§7(clique-droit) Désactive le pet!").build());
	}
	
}

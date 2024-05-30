package fr.syzonia.hub.item.shop.pets;

import org.bukkit.Material;


import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.pets.PetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadShopPetsItem {

	public void LoadItem(VirtualMenu menu, Player player) {
		menu.setItem(0, new ItemBuilder().type(Material.SKULL_ITEM).data((byte) 3).name("§6Mini-" + player.getName()).lore("§8--------------------", "§eCompagnon", "§6Petit pet mignon!", "§8--------------------", "", (PetsData.havePet(1, player) ? "Vous possédez cet objet" : "Achetez cet objet " + new PriceUtils().Price(200) + " Syzocoins " + new PriceUtils().getPromo(200))).setSkullOwner(player.getName()).build());
		menu.setItem(1, new ItemBuilder().type(Material.DIAMOND).name("§bMini-Diamant").lore("§8--------------------", "§eCompagnon", "§6Petit pet mignon!", "§8--------------------", "", (PetsData.havePet(2, player) ? "Vous possédez cet objet" : "Achetez cet objet " + new PriceUtils().Price(200) + " Syzocoins " + new PriceUtils().getPromo(200))).build());
	}
	
}

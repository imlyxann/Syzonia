package fr.syzonia.hub.item.shop.vetements;

import org.bukkit.Color;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadChapeauxShopItem {

	public void load(VirtualMenu menu, Player player) {
		menu.setItem(0, new ItemBuilder().type(Material.LEATHER_HELMET).setLeatherColor(Color.BLACK).name("§eCasquette Nike").lore("§8--------------------", "§eCheapeaux", "§6Tu as du Style? Oui!", "§8--------------------", "", (VetementsManager.haveChapeau(1, player) ? "Vous possédez cet objet" : "Achetez cet objet " + new PriceUtils().Price(200) + " Syzocoins " + new PriceUtils().getPromo(200))).setSkullOwner(player.getName()).build());
	}
	
}

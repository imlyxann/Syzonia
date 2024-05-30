package fr.syzonia.hub.item.shop.vetements;

import org.bukkit.Color;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.vetements.VetementsManager;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadPullShopItem {

	public void load(VirtualMenu menu, Player player) {
		menu.setItem(0, new ItemBuilder().type(Material.LEATHER_CHESTPLATE).setLeatherColor(Color.BLACK).name("§ePull Nike").lore("§8--------------------", "§ePull", "§6Tu as du Style? Oui!", "§8--------------------", "", (VetementsManager.havePull(1, player) ? "Vous possédez cet objet" : "Achetez cet objet " + new PriceUtils().Price(200) +" Syzocoins " + new PriceUtils().getPromo(200))).setSkullOwner(player.getName()).build());
	}
	
}

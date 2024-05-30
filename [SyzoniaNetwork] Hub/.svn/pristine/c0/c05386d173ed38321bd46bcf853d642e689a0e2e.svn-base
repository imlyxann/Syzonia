package fr.syzonia.hub.item.shop.gadgets;

import org.bukkit.Material;

import org.bukkit.entity.Player;

import fr.syzonia.core.price.PriceUtils;
import fr.syzonia.syzodb.shop.gadgets.GadgetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemShopGadgets {

	public void load(VirtualMenu menu, Player player) {
		menu.setItem(0, new ItemBuilder().type(Material.JUKEBOX).name("§bMusiqua").lore("§8---------------------", "§6Gadgets", "§eInspecteur gadgets!", "§8---------------------", "§b", (!GadgetsData.haveGadget(1, player) ? "Achetez cet objet " + new PriceUtils().Price(280) +" Syzocoins " + new PriceUtils().getPromo(new PriceUtils().Price(280)) : "§cVous possédez cet objet")).build());
	}
	
}

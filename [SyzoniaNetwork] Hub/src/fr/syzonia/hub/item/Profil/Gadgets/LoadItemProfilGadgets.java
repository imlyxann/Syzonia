package fr.syzonia.hub.item.Profil.Gadgets;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.gadgets.GadgetsData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemProfilGadgets {

	public void load(VirtualMenu inv, Player player) {
		if(GadgetsData.haveGadget(1, player)) {
			inv.setItem(0, new ItemBuilder().type(Material.JUKEBOX).name("§6Musiqua").lore("§8-----------------------------", "§6Gadgets", "§eInspecteur gadgets!", "§8-----------------------------", "§6", (GadgetsData.haveGadget(1, player) ? "§eVous possédez cet objet" : "Achetez cet objet!")).build());
		} else {
			inv.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		inv.setItem(8, new ItemBuilder().type(Material.BLAZE_ROD).name("§eDésactive ton gadget").lore("§7(clique-droit) §8Désactive ton gadget").build());
	}
	
}

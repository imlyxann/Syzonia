package fr.syzonia.hub.item.Profil.Mount;

import org.bukkit.Material;


import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.mount.Mountdata;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemMountProfil {

	public void LoadItem(VirtualMenu menu, Player player) {
		if(Mountdata.haveMount(95, player)) {
			menu.setItem(0, new ItemBuilder().type(Material.BONE).name("§eLoup").lore("§8----------§6Loup§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(95, player) ? "Vous possédez cette Monture" : "Achetez cette Monture")).build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(Mountdata.haveMount(92, player)) {
			menu.setItem(1, new ItemBuilder().type(Material.WHEAT).name("§eVache").lore("§8----------§6Vache§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(92, player) ? "Vous possédez cette Monture" : "Achetez cette Monture")).build());
		} else {
			menu.setItem(1, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(Mountdata.haveMount(90, player)) {
			menu.setItem(2, new ItemBuilder().type(Material.CARROT_ITEM).name("§eCochon").lore("§8----------§6Cochon§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(90, player) ? "Vous possédez cette Monture" : "Achetez cette Monture")).build());
		} else {
			menu.setItem(2, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(Mountdata.haveMount(91, player)) {
			menu.setItem(3, new ItemBuilder().type(Material.WOOL).name("§eMouton §eF§ee§bs§6t§di§2f").lore("§8----------§6Mouton §eF§ee§bs§6t§di§2f§8----------", "§6Montures", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(Mountdata.haveMount(91, player) ? "Vous possédez cette Monture" : "Achetez cette Monture")).build());
		} else {
			menu.setItem(3, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
	}
	
}	

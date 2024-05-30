package fr.syzonia.hub.item.Profil.Particules;

import org.bukkit.DyeColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.shop.particules.ParticulesData;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;

public class LoadItemParticulesProfil {

	@SuppressWarnings("deprecation")
	public void LoadItem(VirtualMenu menu, Player player) {
		if(ParticulesData.haveParticules(1, player)) {
			menu.setItem(0, new ItemBuilder().type(Material.FIREBALL).name("§6La Lueur sanglante").lore("§8----------§6La Lueur sanglante§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(1, player) ? "§c§eVous possédez cette Particules" : "Achetez cette Particules")).build());
		} else {
			menu.setItem(0, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(ParticulesData.haveParticules(2, player)) {
			menu.setItem(1, new ItemBuilder().type(Material.FURNACE).name("§6Le Moteur enfumé").lore("§8----------§6Le Moteur enfumé§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(2, player) ? "§eVous possédez cette Particules" : "Achetez cette Particules")).build());
		} else {
			menu.setItem(1, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(ParticulesData.haveParticules(3, player)) {
			menu.setItem(2, new ItemBuilder().type(Material.INK_SACK).data((byte) (15 - DyeColor.PINK.getData())).name("§6Les Coeurs tombants").lore("§8----------§6Les Coeurs tombants§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(3, player) ? "§eVous possédez cette Particules" : "Achetez cette Particules")).build());
		} else {
			menu.setItem(2, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
		
		if(ParticulesData.haveParticules(4, player)) {
			menu.setItem(3, new ItemBuilder().type(Material.NETHER_STAR).name("§6L'Etoile Filante").lore("§8----------§6L'Etoile Filante§8----------", "§6Particules", "§ePermet de se déplacer en toute beauté!", "§8-----------------------------", "§8",(ParticulesData.haveParticules(4, player) ? "§eVous possédez cette Particules" : "Achetez cette Particules")).build());
		} else {
			menu.setItem(3, new ItemBuilder().type(Material.BARRIER).name("§cVous ne possédez pas cet objet!").build());
		}
	
		
		
		
		menu.setItem(8, new ItemBuilder().type(Material.BLAZE_POWDER).name("§6Particule").lore("§7(clique-droit) Désactive La Particule").build());
		
	}
	
}

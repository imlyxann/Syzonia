package fr.syzonia.core.paginatedgui;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PaginatedGui {

	public static HashMap<Integer, ItemStack> stack = new HashMap<>();
	
	public List<Inventory> inv = new ArrayList<Inventory>();
	
	public PaginatedGui(int number, Inventory[] inventory) {
		for(int x = 0; x < number; x ++) {
			inv.add(inventory[x]);
			ItemCheck.Check(inventory[x]);
		}
	}
		
	public void LoadPlayer(Player player) {
		player.openInventory(inv.get(0));
	}
	
	public Inventory next(Inventory playerinv) {
		for(int x = 0; x < inv.size(); x++) {
			if(inv.get(x).equals(playerinv)) {
				if(!inv.get(x + 1).equals(null)) {
					return inv.get(x + 1);
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
	public Inventory Previous(Inventory playerinv) {
		for(int x = 0; x < inv.size(); x++) {
			if(inv.get(x).equals(playerinv)) {
				if(!inv.get(x - 1).equals(null)) {
					return inv.get(x - 1);
				} else {
					return null;
				}
			}
		}
		return null;
	}
	
}

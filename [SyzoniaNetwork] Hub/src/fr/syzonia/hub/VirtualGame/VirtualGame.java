package fr.syzonia.hub.VirtualGame;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class VirtualGame{

	public static int size;
	public static String invname;
	public static String gamename;
	public static int id;
	public Inventory inv;
	
	public VirtualGame(String gamename, String invName, int size, int id) {
		VirtualGame.invname = invName;
		VirtualGame.size = size;
		VirtualGame.id = id;
		VirtualGame.gamename = gamename;
		inv = Bukkit.createInventory(null, size, invName);
	}
	
	public VirtualGame() {
	}
	
	public void setItem(int slot, ItemStack item) {
		inv.setItem(slot, item);	
	}
	
	public void addItem(ItemStack item) {
		inv.addItem(item);
	}
	
	public void clear() {
		inv.clear();
	}
	
	
	public void OpenInventory(Player player) {
		player.openInventory(inv);
	}
	
	public boolean InvCountains(ItemStack item) {
		if(inv.contains(item)) {
			return true;
		}
		return false;
	}
	
	public String getTitle(VirtualGame menu) {
		return menu.inv.getTitle();
	}
	
	public int getSize() {
		return inv.getSize();
	}
	
	public static String getGamename() {
		return gamename;
	}
	
	public static int getId() {
		return id;
	}
	
	
}

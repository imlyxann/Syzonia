package fr.syzonia.core.gui;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

public class GuiManager {
	
	public String invName;
	public int Size;
	public Inventory inv;
	
	public GuiManager(String invname, int size) {
		this.invName = invname;
		this.Size = size;
		inv = Bukkit.createInventory(null, Size, invName);
	}
	

	public Inventory getInv() {
		return inv;
	}
	
}

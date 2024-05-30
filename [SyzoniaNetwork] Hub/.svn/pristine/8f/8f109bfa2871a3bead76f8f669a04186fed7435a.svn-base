package fr.syzonia.hub.itemutils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.syzonia.hub.VirtualGame.VirtualGame;
import fr.syzonia.hub.VirtualMenu.VirtualMenu;

public class ItemUtils {

	public static ItemStack getGlassPane(short data) {
		ItemStack GLASS_PANE = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) data);
		ItemMeta GLASS_PANEMETA = GLASS_PANE.getItemMeta();
		GLASS_PANEMETA.setDisplayName("");
		GLASS_PANE.setItemMeta(GLASS_PANEMETA);
		return GLASS_PANE;
	}
	
	public static void setBorder(VirtualMenu menu, int x) {
		ItemStack GLASS_PANE = getGlassPane((short) x);
		menu.setItem(0, GLASS_PANE);
		menu.setItem(1, GLASS_PANE);
		menu.setItem(7, GLASS_PANE);
		menu.setItem(8, GLASS_PANE);
		menu.setItem(9, GLASS_PANE);
		menu.setItem(17, GLASS_PANE);
		menu.setItem(36, GLASS_PANE);
		menu.setItem(44, GLASS_PANE);
		menu.setItem(45, GLASS_PANE);
		menu.setItem(46, GLASS_PANE);
		menu.setItem(47, GLASS_PANE);
		menu.setItem(51, GLASS_PANE);
		menu.setItem(52, GLASS_PANE);
		menu.setItem(53, GLASS_PANE);
	}
	
	public static void setBorder(VirtualGame menu, int x) {
		ItemStack GLASS_PANE = getGlassPane((short) x);
		menu.setItem(0, GLASS_PANE);
		menu.setItem(1, GLASS_PANE);
		menu.setItem(7, GLASS_PANE);
		menu.setItem(8, GLASS_PANE);
		menu.setItem(9, GLASS_PANE);
		menu.setItem(17, GLASS_PANE);
		menu.setItem(36, GLASS_PANE);
		menu.setItem(44, GLASS_PANE);
		menu.setItem(45, GLASS_PANE);
		menu.setItem(46, GLASS_PANE);
		menu.setItem(47, GLASS_PANE);
		menu.setItem(51, GLASS_PANE);
		menu.setItem(52, GLASS_PANE);
		menu.setItem(53, GLASS_PANE);
	}
	
	public static int getPos(int line, int slot) {
		return slot * line;
	}
	
}

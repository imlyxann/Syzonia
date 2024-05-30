package fr.syzonia.syzodb.shop;

import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopItemUtils {

	public static HashMap<Integer, ItemStack> itemstacks = new HashMap<Integer, ItemStack>();
	
	public ShopItemUtils(String item, int id, List<String> lore, Material type) {
		ItemStack items = new ItemStack(type);
		ItemMeta meta = items.getItemMeta();
		meta.setDisplayName(item);
		meta.setLore(lore);
		items.setItemMeta(meta);
		itemstacks.put(id, items);
	}
	
	public ItemStack getItem(int id) {
		return itemstacks.get(id);
	}

	public void setToInv(Inventory inv, ItemStack stack, int slot) {
		inv.setItem(slot, stack);
	}
	
}

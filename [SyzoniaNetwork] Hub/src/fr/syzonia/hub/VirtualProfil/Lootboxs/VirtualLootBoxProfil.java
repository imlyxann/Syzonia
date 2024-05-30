package fr.syzonia.hub.VirtualProfil.Lootboxs;

import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.itemutils.ItemUtils;
import fr.syzonia.hub.lootbox.LootBox;
import fr.syzonia.syzodb.shop.lootbox.LootBoxData;

public class VirtualLootBoxProfil extends VirtualMenu implements Listener {

	public VirtualLootBoxProfil() {
		super("§c» §aLootboxs §c«", 9*1);
	}

	public void open(Player player) {
		if(new LootBoxData().getRareLootboxsValues(player.getUniqueId()) != 0) {
			this.setItem(3, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§aLootbox Rare §6§kil").lore("§eOuvrez la vite!", "§6" + new LootBoxData().getRareLootboxsValues(player.getUniqueId()) + " §cRestantes").build());
		} else {
			this.setItem(3, new ItemBuilder().type(Material.BARRIER).name("§cVous n'avez aucune Lootboxs Rare :(").build());
		}
		if(new LootBoxData().getEpiqueLootboxsValues(player.getUniqueId()) != 0) {
			this.setItem(4, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§5Lootbox Epique §6§kil").lore("§eOuvrez la vite!", "§6" + new LootBoxData().getEpiqueLootboxsValues(player.getUniqueId()) + " §cRestantes").build());
		} else {
			this.setItem(4, new ItemBuilder().type(Material.BARRIER).name("§cVous n'avez aucune Lootboxs Epique :(").build());
		}
		if(new LootBoxData().getMythiqueLootboxsValues(player.getUniqueId()) != 0) {
			this.setItem(5, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§4Lootbox Mythique §6§kil").lore("§eOuvrez la vite!", "§6" + new LootBoxData().getMythiqueLootboxsValues(player.getUniqueId()) + " §cRestantes").build());
		} else {
			this.setItem(5, new ItemBuilder().type(Material.BARRIER).name("§cVous n'avez aucune Lootboxs Mythique :(").build());
		}
		
		this.setItem(0, ItemUtils.getGlassPane((short) 4));
		this.setItem(1, ItemUtils.getGlassPane((short) 4));
		this.setItem(2, ItemUtils.getGlassPane((short) 4));
		this.setItem(6, ItemUtils.getGlassPane((short) 4));
		this.setItem(7, ItemUtils.getGlassPane((short) 4));
		this.setItem(8, ItemUtils.getGlassPane((short) 4));
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerClickInv(InventoryClickEvent event) {
		if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName() == "§c» §aLootboxs §c«") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			
			switch (event.getSlot()) {
			case 3:
				
				if(new LootBoxData().getRareLootboxsValues(player.getUniqueId()) != 0) {
					LootBoxData.removeLootbox(player.getUniqueId(), 1);
					new LootBox(1).run(player);
				}
				
				break;

			case 4:
				
				if(new LootBoxData().getEpiqueLootboxsValues(player.getUniqueId()) != 0) {
					LootBoxData.removeLootbox(player.getUniqueId(), 2);
					new LootBox(2).run(player);
				}
				
				break;
				
			case 5:
				
				if(new LootBoxData().getMythiqueLootboxsValues(player.getUniqueId()) != 0) {
					LootBoxData.removeLootbox(player.getUniqueId(), 3);
					new LootBox(3).run(player);
				}
				
				break;
				
			default:
				break;
			}
			
		}
	}
	
}

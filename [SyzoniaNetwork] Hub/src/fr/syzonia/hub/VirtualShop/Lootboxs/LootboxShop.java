package fr.syzonia.hub.VirtualShop.Lootboxs;

import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.itemutils.ItemUtils;
import fr.syzonia.hub.msg.LootboxLore;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.shop.lootbox.LootBoxData;

public class LootboxShop extends VirtualMenu implements Listener{

	public LootboxShop() {
		super("§6\\o/ §f« §dLootBox§r §f» §6\\o/", 9 * 1);
	}

	public void open(Player player) {
		this.setItem(3, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§aLootbox Rare §6§kil").lore(LootboxLore.getRare()).build());
		this.setItem(4, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§5Lootbox Epique §6§kil").lore(LootboxLore.getEpique()).build());
		this.setItem(5, new ItemBuilder().type(Material.ENDER_CHEST).name("§6§kil§r " + ChatColor.ITALIC + "§4Lootbox Mythique §6§kil").lore(LootboxLore.getMythique()).build());
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
		
		if(event.getInventory().getName() == "§6\\o/ §f« §dLootBox§r §f» §6\\o/") {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			LootboxShop lootboxshop = new LootboxShop();
			
			switch (event.getSlot()) {
			case 3:
				
				if(playerinfo.getCoinsNumber() >= 250) {
					LootBoxData.addLootBox(1, player.getUniqueId());
					playerinfo.removeCoins(250);
					player.sendMessage("§eVous venez d'acheter une Lootbox");
					player.playSound(player.getEyeLocation(), Sound.LEVEL_UP, 3L, 3L);
				} else {
					player.sendMessage("§cVous n'avez pas assez de syzocoins");
				}
				
				break;

			case 4:
				
				if(playerinfo.getCoinsNumber() >= 350) {
					LootBoxData.addLootBox(2, player.getUniqueId());
					playerinfo.removeCoins(350);
					player.sendMessage("§eVous venez d'acheter une Lootbox");
					player.playSound(player.getEyeLocation(), Sound.LEVEL_UP, 3L, 3L);
				} else {
					player.sendMessage("§cVous n'avez pas assez de syzocoins");
				}
				
				break;
				
			case 5:
				
				if(playerinfo.getCoinsNumber() >= 450) {
					LootBoxData.addLootBox(3, player.getUniqueId());
					playerinfo.removeCoins(450);
					player.sendMessage("§eVous venez d'acheter une Lootbox");
					player.playSound(player.getEyeLocation(), Sound.LEVEL_UP, 3L, 3L);
				} else {
					player.sendMessage("§cVous n'avez pas assez de syzocoins");
				}
				
				break;
				
			default:
				break;
			}
			
			lootboxshop.open(player);
		}
	}
	
	
}

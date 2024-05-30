package fr.syzonia.hub.VirtualMenu.vip;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import fr.syzonia.hub.VirtualMenu.VirtualMenu;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.itemutils.ItemUtils;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class VirtualVipMenu extends VirtualMenu implements Listener{

	public VirtualVipMenu() {
		super("§cVip", 9 * 6);
	}

	public void open(Player player) {
		ItemStack GLASS_PANE = ItemUtils.getGlassPane((short) 14);
		PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
		this.setItem(4, new ItemBuilder().type(Material.DIAMOND).name("§dRank §3Legend").lore("§eCustomisation du rank!", (playerinfo.getRank() == 3 ? "§aTu es §3Legend" : "§cTu n'es pas §3Legend")).build());
		this.setItem(0, GLASS_PANE);
		this.setItem(1, GLASS_PANE);
		this.setItem(7, GLASS_PANE);
		this.setItem(8, GLASS_PANE);
		this.setItem(9, GLASS_PANE);
		this.setItem(17, GLASS_PANE);
		this.setItem(36, GLASS_PANE);
		this.setItem(44, GLASS_PANE);
		this.setItem(45, GLASS_PANE);
		this.setItem(46, GLASS_PANE);
		this.setItem(47, GLASS_PANE);
		this.setItem(51, GLASS_PANE);
		this.setItem(52, GLASS_PANE);
		this.setItem(53, GLASS_PANE);
		OpenInventory(player);
	}
	
	@EventHandler
	public void PlayerClickInv(InventoryClickEvent event) {
		
	}
	
}

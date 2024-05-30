package fr.syzonia.hub.lootbox;


import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import fr.syzonia.core.firework.FireWorkUtils;
import fr.syzonia.hub.Hub;
import fr.syzonia.hub.item.ItemBuilder;
import fr.syzonia.hub.itemutils.ItemUtils;

public class LootBox implements Listener{

	BukkitTask task;
	int type;
	int count = 0;
	int timer = 0;
	boolean isstart;
    public static final FireworkEffect FIREWORK = FireworkEffect.builder().with(FireworkEffect.Type.STAR).withColor(Color.GRAY, Color.ORANGE, Color.ORANGE).withFade(Color.ORANGE).withTrail().withFlicker().build();

	
	public LootBox(int type) {
		this.type = type;
		this.isstart = true;
	}
	
	public void open(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9 * 1, "§c» §eLootboxs §c«");
		
		inv.setItem(0, ItemUtils.getGlassPane((short) 4));
		inv.setItem(1, ItemUtils.getGlassPane((short) 4));
		inv.setItem(2, ItemUtils.getGlassPane((short) 4));
		inv.setItem(3, ItemUtils.getGlassPane((short) 4));
		inv.setItem(4, getItem(player));
		inv.setItem(5, ItemUtils.getGlassPane((short) 4));
		inv.setItem(6, ItemUtils.getGlassPane((short) 4));
		inv.setItem(7, ItemUtils.getGlassPane((short) 4));
		inv.setItem(8, ItemUtils.getGlassPane((short) 4));
		player.openInventory(inv);
	}
	
	public ItemStack getItem(Player player) {
		if(type == 1) {
			if(count > 3) count = 0;
			
			switch (count) {
			case 0:
				
				count++;
				return new ItemBuilder().type(Material.SADDLE).build();
				
			case 1:
				
				count++;
				return new ItemBuilder().type(Material.LEATHER_HELMET).setLeatherColor(Color.BLACK).build();
				
			case 2:

				count++;
				return new ItemBuilder().type(Material.SNOW_BALL).build();
				
			case 3:
				
				count++;
				return new ItemBuilder().type(Material.GOLD_INGOT).build();

			default:
				break;
			}
			

		}
		
		if(type == 2) {
			if(count > 4) count = 0;
			
			switch (count) {
			case 0:
				
				count++;
				return new ItemBuilder().type(Material.SADDLE).build();
				
			case 1:
				
				count++;
				return new ItemBuilder().type(Material.MAGMA_CREAM).build();
				
			case 2:
				
				count++;
				return new ItemBuilder().type(Material.LEATHER_HELMET).setLeatherColor(Color.BLACK).build();
				
			case 3:
				
				count++;
				return new ItemBuilder().type(Material.BOOK).build();
				
				
			case 4:
				
				count++;
				return new ItemBuilder().type(Material.GOLD_INGOT).build();

			default:
				break;
			}
		}
		
		if(type == 3) {
			if(count > 7) count = 0;
			
			switch (count) {
			case 0:
				
				count++;
				return new ItemBuilder().type(Material.SADDLE).build();
				
			case 1:
				
				count++;
				return new ItemBuilder().type(Material.DRAGON_EGG).build();
				
			case 2:
				
				count++;
				return new ItemBuilder().type(Material.MAGMA_CREAM).build();
				
				
			case 3:
				
				count++;
				return new ItemBuilder().type(Material.LEATHER_HELMET).setLeatherColor(Color.BLACK).build();
				
			case 4:
				
				count++;
				return new ItemBuilder().type(Material.SNOW_BALL).build();
				
				
			case 5:
				
				count++;
				return new ItemBuilder().type(Material.PAPER).build();
				
			case 6:
				
				count++;
				return new ItemBuilder().type(Material.BOOK).build();
				
			case 7:
				
				count++;
				return new ItemBuilder().type(Material.GOLD_INGOT).build();
				

			default:
				break;
			}
		}
		
		return null;
	}
	
	public void end(Player player) {
		player.closeInventory();
		player.sendMessage("Test123");
		FireWorkUtils.launchfw(player.getEyeLocation(), FIREWORK);
	}
	
	
	@EventHandler
	public void onClose(InventoryCloseEvent event) {
		if(event.getInventory().getName() == "§c» §eLootboxs §c«") {
			if(isstart == true) {
				Player player = (Player) event.getPlayer();
				open(player);
			}
		}
	}
	
	public void run(Player player) {
		task = Bukkit.getScheduler().runTaskTimer(Hub.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				open(player);

				if(timer >= 20) {
					task.cancel();
					end(player);
					isstart = false;
				}
				
				timer++;
			}
		}, 0, 5L);
	}
	
}

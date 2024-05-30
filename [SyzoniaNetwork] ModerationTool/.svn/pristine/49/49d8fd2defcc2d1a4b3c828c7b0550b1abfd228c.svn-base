package fr.syzonia.moderationtool.cmds;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


import fr.syzonia.core.gui.GuiManager;
import fr.syzonia.core.item.ItemBuilder;
import fr.syzonia.core.syzowolf.SyzoWolfUtils;
import fr.syzonia.moderationtool.Main;

public class ReportCommand implements CommandExecutor, Listener {

    public List<String> Reports = new ArrayList<>();
    public List<String> MSG = new ArrayList<>();
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        
        if(args.length != 1) {
        	sender.sendMessage("§c/report <player> <raison>");
        	sender.sendMessage("§4Si tu fais des faux signalements tu seras warn / mute / ban suivants la quantité.");
        	return false;
        }
        


        Player player = (Player) sender;
        
        if(Reports.contains(player.getName())) return false;
        
        String target = args[0];
        Player targetPlayer = Bukkit.getPlayer(target);
        
		if(targetPlayer == null) {
			player.sendMessage("§cLe(a) joueur(se) est inconnu(e) ou Hors-Ligne!");
			return false;
		}
		
		openinv(player, target);
		
        return true;
    }
    
    public void openinv(Player player, String target) {
    	GuiManager gui = new GuiManager("§cReport: " + target, 9 * 1);
    	gui.getInv().setItem(0, new ItemBuilder().type(Material.DIAMOND_SWORD).name("§bAura").build());
    	gui.getInv().setItem(1, new ItemBuilder().type(Material.POTION).name("§bSpeed").build());
    	gui.getInv().setItem(2, new ItemBuilder().type(Material.IRON_BOOTS).name("§bFly").build());
    	gui.getInv().setItem(3, new ItemBuilder().type(Material.ANVIL).name("§bAnti-Kb").build());
    	gui.getInv().setItem(4, new ItemBuilder().type(Material.STICK).name("§bReach").build());
    	gui.getInv().setItem(5, new ItemBuilder().type(Material.BED).name("§bNoFall").build());
    	gui.getInv().setItem(6, new ItemBuilder().type(Material.LADDER).name("§bClimb").build());
    	player.openInventory(gui.getInv());

    }
    
    @EventHandler
    public void ReportClickInvEvent(InventoryClickEvent event) {
    	if(event.getCurrentItem() == null && event.getAction() != null) return;
		
		if(event.getInventory().getName().contains("§cReport")) {
			event.setCancelled(true);
			
			Player player = (Player) event.getWhoClicked();
			String target = event.getInventory().getName().substring(10);
			
			switch (event.getCurrentItem().getType()) {
			case DIAMOND_SWORD:
				
				Reports.add(player.getName());
				
			    new SyzoWolfUtils().sendReport(Main.Instance, target, "Aura");
				
		        player.closeInventory();
				
				break;
				
				case POTION:
				
				Reports.add(player.getName());
				
			    new SyzoWolfUtils().sendReport(Main.Instance, target, "Speed");
				
		        player.closeInventory();
				
				break;
				
				case IRON_BOOTS:
					
					Reports.add(player.getName());
					
				    new SyzoWolfUtils().sendReport(Main.Instance, target, "Fly");
					
			        player.closeInventory();
					
				break;
				
				case ANVIL:
					
					Reports.add(player.getName());
					
				    new SyzoWolfUtils().sendReport(Main.Instance, target, "Anti-Kb");
					
			        player.closeInventory();
					
				break;
				
				case STICK:
					
					Reports.add(player.getName());
					
				    new SyzoWolfUtils().sendReport(Main.Instance, target, "Reach");
					
			        player.closeInventory();
					
				break;

				case BED:
					
					Reports.add(player.getName());
					
				    new SyzoWolfUtils().sendReport(Main.Instance, target, "NoFall");
					
			        player.closeInventory();
					
				break;
				
				case LADDER:
					
					Reports.add(player.getName());
					
				    new SyzoWolfUtils().sendReport(Main.Instance, target, "Climb");
					
			        player.closeInventory();
					
				break;
				
			default:
				break;
			}
		}
    }
}



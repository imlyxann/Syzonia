package fr.syzonia.moderationtool.sanctions;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.core.gui.GuiManager;
import fr.syzonia.core.item.ItemBuilder;
import fr.syzonia.syzodb.mysql.PlayerInfo;

public class Sanction extends GuiManager implements CommandExecutor{

	public Sanction() {
		super("§4/ss   §7#We're Not Nazi", 9*6);
	}
	
	public void open(Player player) {
		inv.setItem(1, new ItemBuilder().type(org.bukkit.Material.BOOK).name("§cMessage").lore("§aMettez une sanction pour Message").build());
		inv.setItem(2, new ItemBuilder().type(org.bukkit.Material.BLAZE_ROD).name("§cCheat").lore("§aMettez une sanction pour Cheat").build());
		inv.setItem(3, null);
		player.openInventory(inv);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
			open(player);
		} 
		
		return false;
	}
	
	
	
	

}

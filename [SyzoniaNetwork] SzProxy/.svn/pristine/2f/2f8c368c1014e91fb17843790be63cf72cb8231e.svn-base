package fr.syzonia.syzobungee.commands;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.syzobungee.Main;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MaintenanceCmd extends Command {

	
	public MaintenanceCmd() {
		super("maintenance");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(sender instanceof ProxiedPlayer) {
			
			if(DatabaseManager.getPlayerRank(player.getUniqueId()) == 7) {
				if(Main.Maintenance == 0) {
					Main.Maintenance = 1;
					sender.sendMessage(new TextComponent("§cVous venez de Mettre la Maintenance en " +  Main.Maintenance));
					
					for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
						if(DatabaseManager.getPlayerRank(players.getUniqueId()) < 4) {
							players.disconnect(new TextComponent("§r----- §6§lSyzonia §r- §eMaintenance §r-----\n " +
									 "§7» §e§lSyzonia est en Maintenance" +
									 "\n " +
									 "\n Merci de patienter..." +
									 "\n " +
									 "\n§bSi il y a un problème merci de nous contacter sur le discord." +
									 "\nhttps://dsc.gg/syzonia" + 
									 "\n§r---------------------------"));
						}
					}
					
					for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
						if(DatabaseManager.getPlayerRank(players.getUniqueId()) > 4) {
							players.sendMessage(new TextComponent("§r[§4Alert§r] §rLe serveur est en Maintenance"));
						}
					}
					
					return;
				}	
				
				if(Main.Maintenance == 1) {
					Main.Maintenance = 0;
					sender.sendMessage(new TextComponent("§cVous venez de Mettre la Maintenance en " +  Main.Maintenance));
					
					for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
						if(DatabaseManager.getPlayerRank(players.getUniqueId()) > 4) {
							players.sendMessage(new TextComponent("§r[§4Alert§r] §rLe serveur n'est plus en Maintenance"));
						}
					}
					
					return;
				}
			}
					
		} else {
			return;
		}
		
	}

}

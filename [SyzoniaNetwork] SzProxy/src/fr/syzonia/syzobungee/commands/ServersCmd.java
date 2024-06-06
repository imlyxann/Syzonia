package fr.syzonia.syzobungee.commands;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.mysql.HubManager;
import fr.syzonia.syzobungee.server.Servers;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ServersCmd extends Command {

	public ServersCmd() {
		super("servers");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		
		if(sender instanceof ProxiedPlayer) {
			ProxiedPlayer player = (ProxiedPlayer) sender;
			Servers servers = new Servers();
			HubManager hubManager = new HubManager();
			
			if(!(args.length > 0)) {
				player.sendMessage(new TextComponent("§cERROR CMD (Invalid ARGS)"));
				return;
			}
			
			if(DatabaseManager.getPlayerRank(player.getUniqueId()) == 7) {
				switch (args[0]) {
				case "create":
					
					if(args[1].equalsIgnoreCase("Lobby")) {
						Deque<String> deque = new ArrayDeque<String>(hubManager.getHubs());
						int x = Integer.parseInt(deque.getLast().substring(5)) + 1;
						servers.create("Lobby" + x, new Random().nextInt(24000));
						
					}
					
					break;
					
				case "remove":
					
					try {
						try {
							servers.setStatus(0, args[1]);
							servers.removeInDb(args[1]);
						} finally {
							servers.removeServer(args[1]);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					break;

				default:
					break;
				}
			}
			
		}
		
	}
	
	
	
	

}

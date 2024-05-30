package fr.syzonia.syzobungee.commands;

import fr.syzonia.syzobungee.loadbalancer.HubBalancer;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {

	public HubCommand() {
		super("hub");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(!(sender instanceof ProxiedPlayer)) {
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		ServerInfo info = new HubBalancer().ConnectPlayerWithLeastPlayers();
		player.connect(info);
		
	}

}

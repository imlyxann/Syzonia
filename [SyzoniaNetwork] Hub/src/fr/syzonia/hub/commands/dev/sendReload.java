package fr.syzonia.hub.commands.dev;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.syzonia.syzodb.server.Servers;


public class sendReload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		new Servers(Bukkit.getServerName()).setStatus(2);
			
		return true;
	}

}

package fr.syzonia.syzowolf.commandes;

import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.syzonia.syzowolf.Main;

public class SyzoWolfCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		String args0 = args[0];
		
		if(args0.equalsIgnoreCase("start")) {
			start();
		} else if(args0.equalsIgnoreCase("stop")) {
			stop();
		} else if(args0.equalsIgnoreCase("packet")) {
		}
		
		return true;
	}
	
	
	public void start() {
		if(!isStart()) {
			Main.Instance.onEnable();
		}
	}
	
	public void stop() {
		if(isStart()) {
			Main.Instance.onDisable();
		}
	}
	
	public boolean isStart() {
		return Main.Instance.isEnabled();
	}

}

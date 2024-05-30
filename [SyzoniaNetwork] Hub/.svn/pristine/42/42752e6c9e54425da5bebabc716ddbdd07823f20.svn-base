package fr.syzonia.hub.commands;


import fr.syzonia.hub.Hub;
import fr.syzonia.hub.commands.admin.EventCommand;
import fr.syzonia.hub.commands.dev.sendReload;
import fr.syzonia.hub.commands.player.AccountCommand;
import fr.syzonia.hub.commands.player.HelpCommand;
import fr.syzonia.hub.commands.player.SpawnCommand;
import fr.syzonia.hub.commands.staff.AboutCommand;
import fr.syzonia.hub.commands.staff.CoinsCommand;
import fr.syzonia.hub.commands.staff.RankCommand;
import fr.syzonia.hub.commands.staff.ShutUpCommand;

public class CommandManager {

	public void registerCmds(Hub hub) {
		hub.getCommand("coins").setExecutor(new CoinsCommand());
		hub.getCommand("rank").setExecutor(new RankCommand());
		hub.getCommand("sendreload").setExecutor(new sendReload());
		hub.getCommand("account").setExecutor(new AccountCommand());
		hub.getCommand("spawn").setExecutor(new SpawnCommand());
		hub.getCommand("help").setExecutor(new HelpCommand());
		hub.getCommand("about").setExecutor(new AboutCommand());
		hub.getCommand("shutup").setExecutor(new ShutUpCommand());
		hub.getCommand("event").setExecutor(new EventCommand());
	}
	
}

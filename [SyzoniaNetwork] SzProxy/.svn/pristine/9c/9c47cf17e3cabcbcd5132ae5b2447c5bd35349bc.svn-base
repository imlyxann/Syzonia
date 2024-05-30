package fr.syzonia.syzobungee.commands;

import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class TestCommand extends Command {

	public TestCommand() {
		super("testcmd");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {

		if(!(sender instanceof ProxiedPlayer)) {
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(DatabaseManager.getPlayerRank(player.getUniqueId()) == 7) {
			// Target: Prochain test si use cette commande avec bungeecord
		
		}
		
	}

}

package fr.syzonia.syzobungee.commands;

import java.util.UUID;

import fr.syzonia.bungeedb.Main;
import fr.syzonia.bungeedb.mysql.DatabaseManager;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class UnMuteCommand extends Command {

	public UnMuteCommand() {
		super("unmute");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(DatabaseManager.getPlayerRank(player.getUniqueId()) >= 5) {
		     if(args.length != 1){
		           	helpMessage(player);
		            return;
		        }
			
			String targetName = args[0];
			
			UUID targetUUID = DatabaseManager.getUUID(targetName);
			System.out.println(targetUUID);
			   
			if(!Main.INSTANCE.muteManager.IsMuted(targetUUID)) {
				player.sendMessage(new TextComponent("§cCe(tte) joueur(seu) n'est pas mute"));
				return;
			} else {
				if (Main.INSTANCE.muteManager.IsMuted(targetUUID)) {
					Main.INSTANCE.muteManager.unmute(targetUUID);
					player.sendMessage(new TextComponent("§6Vous avez unmute §a" + targetName));
				}
			}
		} else {
			player.sendMessage(new TextComponent("§cTu n'as pas la perm petit debilos!"));
		}
		
	  
		
	}

		private void helpMessage(CommandSender sender) {
		sender.sendMessage(new TextComponent("§c§lSystème || Mute"));
		sender.sendMessage(new TextComponent("§c/mute <joueur> <perm>:<durée:unité> <raison> §b> Permet de Mute un joueur!"));
		sender.sendMessage(new TextComponent("§c/unmute <joueur> §b> Permet de UnMute un joueur."));
		
	}
}

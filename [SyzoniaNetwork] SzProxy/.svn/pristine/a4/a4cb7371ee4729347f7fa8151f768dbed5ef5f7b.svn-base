package fr.syzonia.syzobungee.commands;

import java.util.UUID;

import fr.syzonia.bungeedb.Main;
import fr.syzonia.bungeedb.mysql.DatabaseManager;
import fr.syzonia.bungeedb.utils.TimeUnit;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MuteCommand extends Command {

	public MuteCommand() {
		super("mute", null, "m");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if(DatabaseManager.getPlayerRank(player.getUniqueId()) >= 5) {
			
	    		if(args.length < 3){
	                helpMessage(sender);
	                return;
	            }
	     
	            String targetName = args[0];
	     
	            UUID targetUUID = DatabaseManager.getUUID(targetName);
	     
	            if(Main.INSTANCE.muteManager.IsMuted(targetUUID)){
	                player.sendMessage(new TextComponent("§cCe joueur est déjà Mute !"));
	                return;
	            }
	     
	            String reason = "";
	            for(int i = 2; i < args.length; i++){
	                reason += args[i] + " ";
	            }
	     
	            if(args[1].equalsIgnoreCase("perm")){
	                Main.INSTANCE.muteManager.mute(targetUUID, -1, reason);;
	                player.sendMessage(new TextComponent("§aVous avez Mute §6" + targetName + " §c(Permanent) §apour : §e" + reason));
	                return;
	            }
	     
	            if(!args[1].contains(":")){
	                helpMessage(sender);
	                return;
	            }
	     
	            int duration = 0;
	            try {
	                duration = Integer.parseInt(args[1].split(":")[0]);
	            } catch(NumberFormatException e){
	            	player.sendMessage(new TextComponent("§cLa valeur 'durée' doit être un nombre !"));
	                return;
	            }
	     
	            if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
	                sender.sendMessage(new TextComponent("§cCette unité de temps n'existe pas !"));
	                for(TimeUnit units : TimeUnit.values()){
	                    sender.sendMessage(new TextComponent("§b" + units.getName() + " §f: §e" + units.getShortcut()));
	                }
	                return;
	            }
	     
	            TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
	            long MuteTime = unit.getToSecond() * duration;
	     
	            Main.INSTANCE.muteManager.mute(targetUUID, MuteTime, reason);
	            sender.sendMessage(new TextComponent("§aVous avez Mute §6" + targetName + " §b(" + duration + " " + unit.getName() + ") §apour : §e" + reason));
	            return;	
		} else {
			player.sendMessage(new TextComponent("§4Tu n'as pas le droit petit chenapan!"));
		}

	}

	private void helpMessage(CommandSender sender) {
		sender.sendMessage(new TextComponent("§c§lSystème || Mute"));
		sender.sendMessage(new TextComponent("§c/mute <joueur> <perm>:<durée:unité> <raison> §b> Permet de Mute un joueur!"));
		sender.sendMessage(new TextComponent("§c/unmute <joueur> §b> Permet de UnMute un joueur."));
		
	}

}

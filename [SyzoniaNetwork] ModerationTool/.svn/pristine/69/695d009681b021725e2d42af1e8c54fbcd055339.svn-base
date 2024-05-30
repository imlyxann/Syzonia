package fr.syzonia.moderationtool.cmds;

import java.util.UUID;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.syzonia.core.timeunit.TimeUnit;
import fr.syzonia.syzodb.mysql.BanManager;
import fr.syzonia.syzodb.mysql.MySql;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.moderationtool.Main;
import fr.syzonia.moderationtool.ban.Ban;

public class BanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player player = (Player) sender;
		
		if(PlayerInfo.getInfos(player.getUniqueId()).getRank() >= 5) {
			if(args.length < 3){
	            helpMessage(sender);
	            return false;
	        }
	 
	        String targetName = args[0];
	        UUID targetUUID = MySql.getUUID(targetName);
	 
	        if(new BanManager().isBanned(targetUUID)){
	            sender.sendMessage("§cCe joueur est déjà banni !");
	            return false;
	        }
	 
	        String reason = "";
	        for(int i = 2; i < args.length; i++){
	            reason += args[i] + " ";
	        }
	 
	        if(args[1].equalsIgnoreCase("perm")){
				Ban.disconnectBungee(targetName, -1, reason);
				new Ban(targetUUID, -1, reason).runTaskTimer(Main.Instance, 0L, 20L);
	            sender.sendMessage("§aVous avez banni §6" + targetName + " §c(Permanent) §apour : §e" + reason);
	            return true;
	        }
	 
	        if(!args[1].contains(":")){
	            helpMessage(sender);
	            return false;
	        }
	 
	        int duration = 0;
	        try {
	            duration = Integer.parseInt(args[1].split(":")[0]);
	        } catch(NumberFormatException e){
	            sender.sendMessage("§cLa valeur 'durée' doit être un nombre !");
	            return false;
	        }
	 
	        if(!TimeUnit.existFromShortcut(args[1].split(":")[1])){
	            sender.sendMessage("§cCette unité de temps n'existe pas !");
	            for(TimeUnit units : TimeUnit.values()){
	                sender.sendMessage("§b" + units.getName() + " §f: §e" + units.getShortcut());
	            }
	            return false;
	        }
	 
	        TimeUnit unit = TimeUnit.getFromShortcut(args[1].split(":")[1]);
	        long banTime = unit.getToSecond() * duration;
	 
	        Ban.disconnectBungee(targetName, -1, reason);
	        new Ban(targetUUID, banTime, reason).runTaskTimer(Main.Instance, 0L, 20L);
	        sender.sendMessage("§aVous avez banni §6" + targetName + " §b(" + duration + " " + unit.getName() + ") §apour : §e" + reason);
	      
	    	}
		  return true;
		}
	 
	    public void helpMessage(CommandSender sender){
	        sender.sendMessage("§c/ban <joueur> perm <raison>");
	        sender.sendMessage("§c/ban <joueur> <durée>:<unité> <raison>");
	    }
}

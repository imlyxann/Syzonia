package fr.syzonia.hub.commands.player;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.syzonia.syzodb.Main;
import fr.syzonia.syzodb.token.TokenManager;
import fr.syzonia.hub.runnable.divers.TokenRunnable;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class AccountCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player player = (Player) sender;
		
		if(!(sender instanceof Player)) {
			return false;
		}
		
		TokenManager token = new TokenManager();
		
		token.createToken(player.getUniqueId(), 60 * 20, "");
		
		Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new TokenRunnable(player), 0, 1L);
		
		String tellraw = "{text:\"" +  "§eWebsite §7» §6 '" + new TokenManager().getToken(player.getUniqueId()) + "'" + "\",clickEvent:{action:\"suggest_command\",value:\""+ new TokenManager().getToken(player.getUniqueId()) +"\"}}";
		IChatBaseComponent comp = ChatSerializer.a(tellraw);
		PacketPlayOutChat packet = new PacketPlayOutChat(comp);
		
		player.sendMessage("\n");
		player.sendMessage("§7----§6Votre Syzo Compte§7----");
		player.sendMessage("§eWebsite §7» §6copiez votre token sur https://syzonia.fr/login");
		player.sendMessage("§eWebsite §7» §eil expire dans " + new TokenManager().getTimeLeft(player.getUniqueId()) + " !");
		((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
		player.sendMessage("§7----§6Ne le partagez pas§7----");
		player.sendMessage("\n");

		return true;
	}
	


}

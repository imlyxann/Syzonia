package fr.syzonia.core.server;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.syzonia.core.Main;

public class ServerComponent {

	public String getIp() {
		if(!isFake()) {
			return Bukkit.getIp();
		} else {
			return "Localhost";
		}
	}
	
	public boolean isFake() {
		if(Bukkit.getIp().contains("localhost")) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getPlayers() {
		int count = 0;
		
		count = Bukkit.getOnlinePlayers().size();
		
		return count;
	}
	
	public int getPort() {
		if(!isFake()) {
			return Bukkit.getPort();
		} else {
			return 0;
		}
	}
	
	public static void MoveToServer(Player player, String servername) {
		if(player != null) {
			ByteArrayOutputStream b = new ByteArrayOutputStream();
			DataOutputStream out = new DataOutputStream(b);
			
			try {
				
				out.writeUTF("Connect");
				out.writeUTF(servername);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			player.sendPluginMessage(Main.Instance, "BungeeCord", b.toByteArray());
		}
	}
	
}

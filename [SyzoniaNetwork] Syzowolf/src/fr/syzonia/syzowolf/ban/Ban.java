package fr.syzonia.syzowolf.ban;

import java.util.ArrayList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

import fr.syzonia.core.firework.FireWorkUtils;
import fr.syzonia.syzodb.mysql.BanManager;
import fr.syzonia.syzowolf.Main;

public class Ban {


    public static final String TAG = ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "[" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Syzo-Wolf" + ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "] ";
    public static final FireworkEffect FIREWORK = FireworkEffect.builder().with(FireworkEffect.Type.STAR).withColor(Color.FUCHSIA, Color.PURPLE, Color.WHITE).withFade(Color.PURPLE).withTrail().withFlicker().build();
    
    List<String> msg = new ArrayList<String>();
    
	public void SyzoWolfBan(String target) {

			Player targetPlayer = Bukkit.getPlayer(target);
			Location loc = targetPlayer.getLocation();
			
			if(!new BanManager().isBanned(targetPlayer.getUniqueId())) {
			new BanManager().ban(targetPlayer.getUniqueId(), -1, "Client Cheats", "AntiCheat");
			
			FireWorkUtils.launchfw(loc, FIREWORK);
			Bukkit.getWorld("world").strikeLightningEffect(loc);
			
			if(!msg.contains(target)) {
				ByteArrayDataOutput out;
				out = ByteStreams.newDataOutput();
	    	 	out.writeUTF("syzowolfalert");
	            out.writeUTF(target);
	            out.writeUTF("Client Cheats");
	            out.writeUTF(TAG);
	            Bukkit.getServer().sendPluginMessage(Main.Instance, "BungeeCord", out.toByteArray());
				
			    out = ByteStreams.newDataOutput();
		    	 	out.writeUTF("alertmod");
		            out.writeUTF(target);
		            out.writeUTF("Client Cheats");
		        Bukkit.getServer().sendPluginMessage(Main.Instance, "BungeeCord", out.toByteArray());
		        
		        msg.add(target);
			}
		}
	}
	
}

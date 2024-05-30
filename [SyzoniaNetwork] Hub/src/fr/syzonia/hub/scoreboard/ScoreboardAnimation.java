package fr.syzonia.hub.scoreboard;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.syzonia.core.scoreboard.ScoreboardSign;


public class ScoreboardAnimation extends BukkitRunnable{

	public Player player;
    public int ipCharIndex;
    public int cooldown;
	
  	public ScoreboardAnimation(Player player) {
  		this.player = player;
		this.ipCharIndex = 0;
	    this.cooldown = 0;
  	}

	
	@Override
	public void run() {
		if(player.isOnline()) {
			((ScoreboardSign) ScoreboardManager.scoreboardGame.get(player)).setLine(1, colorIpAt());
		}
	}
	

    public String colorIpAt()
    {
        String ip = "https://syzonia.fr";

        if (this.cooldown > 0)
        {
            this.cooldown--;
            return ip;
        }

        StringBuilder formattedIp = new StringBuilder();

        if (this.ipCharIndex > 0)
        {
            formattedIp.append(ip.substring(0, this.ipCharIndex - 1));
            formattedIp.append(ChatColor.GOLD).append(ip.substring(this.ipCharIndex - 1, this.ipCharIndex));
        }
        else
        {
            formattedIp.append(ip.substring(0, this.ipCharIndex));
        }

        formattedIp.append(ChatColor.RED).append(ip.charAt(this.ipCharIndex));
        
        if (this.ipCharIndex + 1 < ip.length())
        {
            formattedIp.append(ChatColor.GOLD).append(ip.charAt(this.ipCharIndex + 1));

            if (this.ipCharIndex + 2 < ip.length())
                formattedIp.append(ChatColor.YELLOW).append(ip.substring(this.ipCharIndex + 2));

            this.ipCharIndex++;
        }
        else
        {
            this.ipCharIndex = 0;
            this.cooldown = 50;
        }

        return formattedIp.toString();
    }
}
package fr.syzonia.hub.runnable.divers;

import org.bukkit.entity.Player;

import fr.syzonia.syzodb.token.TokenManager;


public class TokenRunnable implements Runnable{

	Player player;

	public TokenRunnable(Player player) {
		this.player = player;
	}
	
	@Override
	public void run() {

		if(new TokenManager().TokenIsCreate(player.getUniqueId())) {
			new TokenManager().checkDuration(player.getUniqueId());
		}
		
	}

}

package fr.syzonia.syzowolf;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import fr.syzonia.syzowolf.ban.Ban;

public class SyzoPlayer {

	public Player player;
	
	int speedViolations = 0;

	public Location LastLocationSpeed;
	public Long SpeedHackLastMove;
	
	public Ban ban = new Ban();
	
	public SyzoPlayer(Player player) {
		this.player = player;
	}
	
	public Location getLastLocationSpeed() {
		return LastLocationSpeed;
	}
	
	public void setLastLocationSpeed(Location lastLocationSpeed) {
		LastLocationSpeed = lastLocationSpeed;
	}

	
	public void updatedSpeedViolations() {
		speedViolations++;
		if(speedViolations >= Main.speedViolations) {
			ban.SyzoWolfBan(player.getName());
		}
	}
	
	public Player getPlayer() {
		return player;
	}

	public long getLastMove() {
		return SpeedHackLastMove;
	}
	
	public void setLastMove(Long speedHackLastMove) {
		SpeedHackLastMove = speedHackLastMove;
	}
	
}

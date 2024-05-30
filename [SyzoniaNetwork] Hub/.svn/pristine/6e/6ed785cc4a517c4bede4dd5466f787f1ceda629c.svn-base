package fr.syzonia.hub.particules;


import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ParticulesManager {

	private Player player;
	private Effect effect;
	private Location loc;
	private int size;

	public ParticulesManager(Location loc, Player player, Effect effect, int Size) {
		this.setLoc(loc);
		this.setPlayer(player);
		this.setEffect(effect);
		this.setSize(Size);
	}
	
	public ParticulesManager() {}
	
	@SuppressWarnings("deprecation")
	public void CreateParticules() {
		player.playEffect(loc, effect, size);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	
	
	public void spawnParticles(Effect effect, int size, Location loc) {
		for(Player players : Bukkit.getOnlinePlayers()) {
			players.getWorld().playEffect(loc, effect, size);
		}
	}
	
	
}

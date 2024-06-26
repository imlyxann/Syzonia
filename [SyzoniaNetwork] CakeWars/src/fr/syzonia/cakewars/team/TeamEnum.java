package fr.syzonia.cakewars.team;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public enum TeamEnum {

	ROUGE(0, "§cRouge"),
	VERT(1, "§aVert"),
	JAUNE(2, "§eJaune"),
	BLEU(3, "§3Bleu"),
	MAGENTA(4, "§dMagenta"),
	AQUA(5, "§bAqua"),
	BLANC(6, "§fBlanc"),
	GRIS(7, "§8Gris");
	
	int power;
	String name;
	Set<Player> set;
	boolean isLock;
	
	private TeamEnum(int power, String name) {
		this.power = power;
		this.name = name;
		set = new HashSet<>();
		isLock = false;
	}
	
	public static HashMap<Integer, TeamEnum> TeamNumber = new HashMap<Integer, TeamEnum>();
	
	static {
		for(TeamEnum team : TeamEnum.values()) {
			TeamEnum.TeamNumber.put(team.getPower(), team);
		}
	}
	
	public void addPlayer(Player player) {
		if(!isLock) set.add(player);
	}
	
	public void removePlayer(Player player) {
		if(!isLock) set.remove(player);
	}
	
	public boolean isFull() {
		if(Bukkit.getServerName().contains("cksp")) {
			return set.size() >= 1;
		} else {
			return set.size() >= 2;
		}
	}
	
	public int getPower() {
		return power;
	}
	
	public String getName() {
		return name;
	}
	
	public static TeamEnum getTeamByAnNumber(int x) {
		return TeamEnum.TeamNumber.get(x);
	}
	
	
}

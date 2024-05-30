package fr.syzonia.cakewars.team;

import java.util.HashMap;

public enum TeamEnum {

	ROUGE(1, "§cRouge"),
	VERT(2, "§aVert"),
	JAUNE(3, "§eJaune"),
	BLEU(4, "§3Bleu"),
	MAGENTA(5, "§dMagenta"),
	AQUA(6, "§bAqua"),
	BLANC(7, "§fBlanc"),
	GRIS(8, "§8Gris");
	
	int power;
	String name;
	
	private TeamEnum(int power, String name) {
		this.power = power;
		this.name = name;
	}
	
	public static HashMap<Integer, TeamEnum> TeamNumber = new HashMap<Integer, TeamEnum>();
	
	static {
		for(TeamEnum team : TeamEnum.values()) {
			TeamEnum.TeamNumber.put(team.getPower(), team);
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

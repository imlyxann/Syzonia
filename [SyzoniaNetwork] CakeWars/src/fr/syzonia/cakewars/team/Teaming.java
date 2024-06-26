package fr.syzonia.cakewars.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.syzonia.cakewars.team.inv.InvTeam;


public class Teaming {

	public Random random;
	
	public Teaming() {
		random = new Random();
	}
	
	public boolean loadToStartGame() {
		List<Player> list = new ArrayList<Player>();
		
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(!InvTeam.isInTeam.contains(player)) list.add(player);
		}
		
		if(16 - Bukkit.getOnlinePlayers().size() != 0 && !list.isEmpty()){
			TeamEnum tenum = null;
			int count = 0;
			if (16 - Bukkit.getOnlinePlayers().size() <= 4) {
				do {
					count++;
					if(count > 2) break;
					tenum.isLock = true;
					tenum = null;
				} while (!(tenum = TeamEnum.getTeamByAnNumber(new Random().nextInt(7 - 1))).isFull());
			} else { return true; } 
		}
		
		for(TeamEnum entry : TeamEnum.TeamNumber.values()) {
			if(!entry.isLock && !entry.isFull()) {
				Player player = list.get(new Random().nextInt(list.size() - 1));
				entry.addPlayer(player);
			}
		}
		
		
		return true;
	}
	
	
}

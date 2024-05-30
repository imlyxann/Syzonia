package fr.syzonia.core.actionbar;

import org.bukkit.entity.Player;

import fr.syzonia.core.title.Title;

public class ActionBarManager {

	public void sendActionBar(Player player, String text) {
		new Title().sendActionBar(player, text);
	}
	
}

package fr.syzonia.syzowolf.check;

import java.time.LocalDateTime;

public class Cache {

	String type;
	Object Level;
	LocalDateTime when;
	String player;
	String cache;
	
	public Cache(String player, String type, Object Level, LocalDateTime when, String cache) {
		this.player = player;
		this.type = type;
		this.Level = Level;
		this.when = when;
		this.cache = cache;
	}
	
	public String flag() {
		return "type=" + type + "{Player: " + player + "} Level=" + Level + " date(when= " + when + ") flags(" + cache + ")";
	}
	
	public static String getLevel(String string) {
		for(String ids : string.split(" ")) {
			if(ids.contains("Level=")) {
				return ids.substring(6);
			}
		}
		
		return null;
	}
	
}

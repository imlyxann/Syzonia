package fr.syzonia.lydrageanas.servers;

public enum ServerType {

	LOBBY("LOBBY", 5),
	CAKEWARS("CAKEWARS", 5);
	
	private String name;
	private int limit;
	
	private ServerType(String name, int limit) {
		this.name = name;
		this.limit = limit;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public String getName() {
		return name;
	}
	
	
}

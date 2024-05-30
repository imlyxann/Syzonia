package fr.syzonia.syzodb.utils;

import java.util.HashMap;

public enum ServerType {

	HUB(1, "Hub"),
	CAKEWARS(2, "Cakewars");
	
	String name;
	int id;
	
	private ServerType(int id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public static HashMap<String, ServerType> ServersType = new HashMap<String, ServerType>();
	
	static {
		for(ServerType type : ServerType.values()) {
			ServersType.put(type.getName(), type);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	
}

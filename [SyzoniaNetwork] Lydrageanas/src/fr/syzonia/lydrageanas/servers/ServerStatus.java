package fr.syzonia.lydrageanas.servers;

public enum ServerStatus {

	ONLINE(1),
	OFFLINE(0);
	
	public int status;
	
	private ServerStatus(int status) {
		this.status = status;
	}
	
}

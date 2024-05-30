package fr.syzonia.lydrageanas.servers;


import fr.syzonia.lydrageanas.Main;


public class ServerScanner {
	public ServerScanner() {}
	
	public void check() {
		for(Server server : Main.INSTANCE.servers.values()) {
			int status = server.common.getStatus();
			
			if(status == 0) {
				server.start();
			}
		}
		
	}

	
	
}
	

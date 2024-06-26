package fr.syzonia.lydrageanas.servers;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.syzonia.bungeedb.mysql.DatabaseManager;


public class ServerScanner {
	
	public void check() {
		List<Server> servers = new ArrayList<Server>();
		
		
		try {
			PreparedStatement stat = DatabaseManager.getConnexion().prepareStatement("SELECT * FROM servers WHERE 1");
			try(ResultSet set = stat.executeQuery()) {
				while(set.next()) {
					if(set.getString("server_name").startsWith("Lobby")) {
						servers.add(new Server(ServerType.LOBBY, new ServersCommon(set.getString("server_name"))));
					} else if(set.getString("server_name").startsWith("ck")) {
						servers.add(new Server(ServerType.CAKEWARS, new ServersCommon(set.getString("server_name"))));
					}
					
				}
			}
			stat.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		for(Server server : servers) {
			int status = server.common.getStatus();
			
			if(status == 0) {
				server.start();
			}
		}
		
	}

	
	
}
	

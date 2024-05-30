package fr.syzonia.syzobungee.loadbalancer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fr.syzonia.bungeedb.mysql.HubManager;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;

public class HubBalancer {

	/**
	 * 
	 * Fonction permettant de connecter un joueur sur le Hub ayant le moins de joueurs
	 * 
	 * @author Lyxann
	 */
	
	public ServerInfo ConnectPlayerWithLeastPlayers() {
		HubManager hub = new HubManager();
	    HashMap<String, Integer> hubMap = new HashMap<>();
		for(String hubs : hub.getHubs()) {
			hubMap.put(hubs, hub.getHubPlayers(hubs));
		}
		
		String hubName = getLessHub(hubMap);
		ServerInfo info = ProxyServer.getInstance().constructServerInfo(hubName, new InetSocketAddress(hub.getIp(hubName), hub.getPort(hubName)), "Lydrageanas System powered by Syzonia", false); 
		return info;
	}
	
	/**
	 * 
	 * Fonction permettant de récupérer un hub ayant le moins de joueurs
	 * 
	 * @author Lyxann
	 */
	
	public String getLessHub(HashMap<String, Integer> map) {
		HubManager hubmanager = new HubManager();
		List<String> hubs = new ArrayList<String>();
		
		for(String x : hubmanager.getHubs()) {
			if(hubmanager.getHubPlayers(x) == Collections.min(map.values())) {
				hubs.add(x);
			}
		}
		String hub = hubs.get(0);
		return hub;
	}
	
	/**
	 * 
	 * Fonction permettant de récupérer un hub ayant le Plus de joueurs
	 * 
	 * @author Lyxann
	 */
	
	public String getMaxHub(HashMap<String, Integer> map) {
		HubManager hubmanager = new HubManager();
		List<String> hubs = new ArrayList<String>();

		for(String x : hubmanager.getHubs()) {
			if(hubmanager.getHubPlayers(x) == Collections.max(map.values())) {
				hubs.add(x);
			}
		}
		String hub = hubs.get(0);
		return hub;
	}
	
	/**
	 * 
	 * Fonction permettant de regarder si un hub est présent et le return
	 * 
	 * @author Lyxann
	 */
	
	public boolean isHubPresent() {
		HubManager hub = new HubManager();
		if(hub.getAllHubs() > 0) {
			return true;
		}
		return false;
	}
}

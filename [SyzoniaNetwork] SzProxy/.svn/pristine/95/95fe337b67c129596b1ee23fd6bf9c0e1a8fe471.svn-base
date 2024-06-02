package fr.syzonia.syzobungee.security;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AntiDdos {

	public static Map<UUID, Integer> connections = new HashMap<>();
    public static int maxConnectionsPerIP = 20;
    
    
    public static int getConnectionCount(String address) {
        return connections.getOrDefault(UUID.nameUUIDFromBytes(address.getBytes()), 0);
    }

    public static void incrementConnectionCount(String address) {
        UUID uuid = UUID.nameUUIDFromBytes(address.getBytes());
        int count = connections.getOrDefault(uuid, 0);
        connections.put(uuid, count + 1);
    }
    
	
}

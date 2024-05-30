package fr.syzonia.core.npc;

import java.io.InputStreamReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.scoreboard.CraftScoreboard;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import net.minecraft.server.v1_8_R3.DataWatcher;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityHeadRotation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardTeam;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.ScoreboardTeam;
import net.minecraft.server.v1_8_R3.ScoreboardTeamBase;
import net.minecraft.server.v1_8_R3.WorldServer;

public class NpcManager {

	
	// Npc 
	public static final List<EntityPlayer> NPC = new ArrayList<>();
	public static final HashMap<EntityPlayer, ArmorStand> ARMORSTAND = new HashMap<>();
	public static final Map<EntityPlayer, Float> NpcYaw =  new HashMap<>();
	
	// Utils
	public static final Map<EntityPlayer, String> METADATACUSTOM =  new HashMap<>();
	
	//Event
	public static final Map<Integer, EntityPlayer> EventNpc =  new HashMap<>();
	
	public static void spawnNpc(Location loc, int npcid, int invid, String name, String skin, float yaw) {
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Objects.requireNonNull(Bukkit.getWorld("world"))).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "§fNPC-" + npcid +  "");
        PlayerInteractManager interact =  new PlayerInteractManager(((CraftWorld) Bukkit.getWorld("world")).getHandle());
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, interact);

		npc.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		
		npc.setCustomNameVisible(false);
		npc.getBukkitEntity().setCustomNameVisible(false);
		
		
	    String[] skin1 = getSkin(skin);
	    gameProfile.getProperties().put("textures", new Property("textures", skin1[0], skin1[1]));
	    
        ScoreboardTeam team = new ScoreboardTeam(((CraftScoreboard) Bukkit.getScoreboardManager().getMainScoreboard()).getHandle(), name);
        team.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);
        ArrayList<String> playerToAdd = new ArrayList<>();
 
        playerToAdd.add(npc.getName()); 
        PacketPlayOutScoreboardTeam scoreboard1 = new PacketPlayOutScoreboardTeam(team, 1);
        PacketPlayOutScoreboardTeam scoreboard0 = new PacketPlayOutScoreboardTeam(team, 0);
        PacketPlayOutScoreboardTeam scoreboard3 = new PacketPlayOutScoreboardTeam(team, playerToAdd, 3);
		
        ArmorStand armorStand;
        
		for(Player p : Bukkit.getOnlinePlayers()) {
	            PlayerConnection connection = (((CraftPlayer) p).getHandle()).playerConnection;
	            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
	            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
	            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (yaw * 256.0F / 360.0F)));
	            DataWatcher dw = new DataWatcher(null);
	            dw.a(10, (byte) (0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40));
	            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(npc.getId(), dw, true);
	            connection.sendPacket(packet);
	            connection.sendPacket(scoreboard1);
	            connection.sendPacket(scoreboard0);
	            connection.sendPacket(scoreboard3);            
			}
		
		NPC.add(npc);
		NpcYaw.put(npc, yaw);
		
		armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(loc, EntityType.ARMOR_STAND);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		armorStand.setVisible(false);
		armorStand.setGravity(false);
	
		NpcManager.ARMORSTAND.put(npc, armorStand);
		METADATACUSTOM.put(npc, "N" + invid);
	}
	
	public static void spawnEventNpc(Location loc, int id, String name, int eventid, String skin, float yaw) {
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer world = ((CraftWorld) Objects.requireNonNull(Bukkit.getWorld("world"))).getHandle();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), "§r§o[E-" + id +  "]");
        PlayerInteractManager interact =  new PlayerInteractManager(((CraftWorld) Bukkit.getWorld("world")).getHandle());
        EntityPlayer npc = new EntityPlayer(server, world, gameProfile, interact);

		npc.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		
		npc.setCustomNameVisible(false);
		npc.getBukkitEntity().setCustomNameVisible(false);
		
		
	    String[] skin1 = getSkin(skin);
	    gameProfile.getProperties().put("textures", new Property("textures", skin1[0], skin1[1]));
	    
        ScoreboardTeam team = new ScoreboardTeam(((CraftScoreboard) Bukkit.getScoreboardManager().getMainScoreboard()).getHandle(), name);
        team.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);
        ArrayList<String> playerToAdd = new ArrayList<>();
 
        playerToAdd.add(npc.getName()); 
        PacketPlayOutScoreboardTeam scoreboard1 = new PacketPlayOutScoreboardTeam(team, 1);
        PacketPlayOutScoreboardTeam scoreboard0 = new PacketPlayOutScoreboardTeam(team, 0);
        PacketPlayOutScoreboardTeam scoreboard3 = new PacketPlayOutScoreboardTeam(team, playerToAdd, 3);
		
        ArmorStand armorStand;
        
		for(Player p : Bukkit.getOnlinePlayers()) {
	            PlayerConnection connection = (((CraftPlayer) p).getHandle()).playerConnection;
	            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
	            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
	            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (yaw * 256.0F / 360.0F)));
	            DataWatcher dw = new DataWatcher(null);
	            dw.a(10, (byte) (0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40));
	            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(npc.getId(), dw, true);
	            connection.sendPacket(packet);
	            connection.sendPacket(scoreboard1);
	            connection.sendPacket(scoreboard0);
	            connection.sendPacket(scoreboard3);            
			}
		
		NPC.add(npc);
		EventNpc.put(id, npc);
		NpcYaw.put(npc, yaw);
		
		armorStand = (ArmorStand) Bukkit.getWorld("world").spawnEntity(loc, EntityType.ARMOR_STAND);
		armorStand.setCustomName(name);
		armorStand.setCustomNameVisible(true);
		armorStand.setVisible(false);
		armorStand.setGravity(false);
	
		NpcManager.ARMORSTAND.put(npc, armorStand);
		METADATACUSTOM.put(npc, "E" + eventid);
	}
    
    public static void removeNpcEvent(int npcid) {
    	if(!EventNpc.containsKey(npcid)) return;
    	
    	EntityPlayer npc = EventNpc.get(npcid);
    	
        	for(Player player : Bukkit.getOnlinePlayers()){
        		PlayerConnection connection = (((CraftPlayer) player).getHandle()).playerConnection;
        		connection.sendPacket(new PacketPlayOutEntityDestroy(npc.getBukkitEntity().getEntityId()));
        		connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        	}
        	
        	ArmorStand armor = ARMORSTAND.get(npc);
        	armor.remove();
        	
        	npc.die();
        	npc.getBukkitEntity().remove();
    	
    	NPC.remove(npc);
    	EventNpc.remove(npcid);
    	ARMORSTAND.remove(npc);
    }
	
    public static void removeAll() {
    	
    	for(EntityPlayer npc : NPC) {
        	for(Player player : Bukkit.getOnlinePlayers()){
        		PlayerConnection connection = (((CraftPlayer) player).getHandle()).playerConnection;
        		connection.sendPacket(new PacketPlayOutEntityDestroy(npc.getBukkitEntity().getEntityId()));
        		connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc));
        	}
        	
        	ArmorStand armor = ARMORSTAND.get(npc);
        	armor.remove();
        	
        	npc.die();
        	npc.getBukkitEntity().remove();
    	}
    	
    	NPC.removeAll(NPC);
    	ARMORSTAND.keySet().removeAll(ARMORSTAND.keySet());
    	METADATACUSTOM.keySet().removeAll(METADATACUSTOM.keySet());
    	EventNpc.keySet().removeAll(EventNpc.keySet());
    }
    
	public static String[] getSkin(String name) {
        try {
			URL url = new URL("https://api.mojang.com/users/profiles/minecraft/" + name);
            InputStreamReader reader = new InputStreamReader(url.openStream());
            String uuid = new JsonParser().parse(reader).getAsJsonObject().get("id").getAsString();

			URL url2 = new URL("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid + "?unsigned=false");
            InputStreamReader reader2 = new InputStreamReader(url2.openStream());
            JsonObject property = new JsonParser().parse(reader2).getAsJsonObject().get("properties").getAsJsonArray().get(0).getAsJsonObject();
            String texture = property.get("value").getAsString();
            String signature = property.get("signature").getAsString();
            return new String[]{texture, signature};
        } catch (Exception e) {
        	System.out.println("Skin Inconnue!");
        	return null;
        }
    }
    
    
    public static void addJoinPacket(Player player) {

    	for(EntityPlayer npcscoreboard : NPC) {
    		PlayerConnection connection = (((CraftPlayer) player).getHandle()).playerConnection;
    		ScoreboardTeam team = new ScoreboardTeam(((CraftScoreboard) Bukkit.getScoreboardManager().getMainScoreboard()).getHandle(),npcscoreboard.getName());
    		
            team.setNameTagVisibility(ScoreboardTeamBase.EnumNameTagVisibility.NEVER);
            ArrayList<String> playerToAdd = new ArrayList<>();
            playerToAdd.add(npcscoreboard.getName()); //Add the fake player so this player will not have a nametag
            
            PacketPlayOutScoreboardTeam scoreboard1 = new PacketPlayOutScoreboardTeam(team, 1);
            PacketPlayOutScoreboardTeam scoreboard0 = new PacketPlayOutScoreboardTeam(team, 0);
            PacketPlayOutScoreboardTeam scoreboard3 = new PacketPlayOutScoreboardTeam(team, playerToAdd, 3); 

            connection.sendPacket(scoreboard1);
            connection.sendPacket(scoreboard0);
            connection.sendPacket(scoreboard3);  
    	}

    	
        for (EntityPlayer npc : NPC) {
        	PlayerConnection connection = (((CraftPlayer) player).getHandle()).playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (NpcYaw.get(npc) * 256.0F / 360.0F)));
            DataWatcher dw = new DataWatcher(null);
            dw.a(10, (byte) (0x01 | 0x02 | 0x04 | 0x08 | 0x10 | 0x20 | 0x40));
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(npc.getId(), dw, true);
            connection.sendPacket(packet);
        }
    }
    
    public static List<EntityPlayer> getNpcs(){
        return NPC;
    }
	
}

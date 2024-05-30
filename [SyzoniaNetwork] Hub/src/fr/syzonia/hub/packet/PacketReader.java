package fr.syzonia.hub.packet;

import io.netty.channel.Channel;




import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.Packet;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.syzonia.core.npc.NpcManager;
import fr.syzonia.hub.Hub;
import fr.syzonia.hub.events.NpcRightClickEvent;

import java.lang.reflect.Field;
import java.util.*;


public class PacketReader {

	Player player;
    Channel channel;
    private int count = 0;
    
    public PacketReader(Player player) {
        this.player = player;
    }
    
    public void inject(){
        CraftPlayer cPlayer = (CraftPlayer)this.player;
        channel = cPlayer.getHandle().playerConnection.networkManager.channel;
        channel.pipeline().addAfter("decoder", "PacketInjector", new MessageToMessageDecoder<Packet<?>>() {@Override protected void decode(ChannelHandlerContext arg0, Packet<?> packet,List<Object> arg2) throws Exception {arg2.add(packet);readPacket(packet);}});
    }
    
    public void uninject(){
    	CraftPlayer cPlayer = (CraftPlayer)this.player;
        channel = cPlayer.getHandle().playerConnection.networkManager.channel;
    	
        if(channel.pipeline().get("PacketInjector") != null){	
            channel.pipeline().remove("PacketInjector");
        }
    }
    
 
    public void readPacket(Packet<?> packet){
        if(packet.getClass().getSimpleName().equalsIgnoreCase("PacketPlayInUseEntity")){
        	   // Counts all actions
            count++;
            if (count == 2) {
                count = 0;
                int id = (int) getValue(packet, "a");
                for (EntityPlayer npc : NpcManager.NPC) {
                    if (npc.getBukkitEntity().getEntityId() == id) {
                        Bukkit.getScheduler().scheduleSyncDelayedTask(Hub.getPlugin(Hub.class), () -> Bukkit.getPluginManager().callEvent(new NpcRightClickEvent(player, npc)), 0);
                       
                    }
                 }
             }   
        }
    }
    
    
 
    public void setValue(Object obj,String name,Object value){
        try{
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        field.set(obj, value);
        }catch(Exception e){}
    }
    
    public Object getValue(Object obj,String name){
        try{
        Field field = obj.getClass().getDeclaredField(name);
        field.setAccessible(true);
        return field.get(obj);
        }catch(Exception e){}
        return null;
    }
	
}

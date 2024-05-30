package fr.syzonia.core.packet;

import java.lang.reflect.Field;


import java.util.List;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import net.minecraft.server.v1_8_R3.Packet;

public class PacketManager {

	 Channel channel;
	 Player player;
	 
	 public PacketManager(Player player) {
		 this.player = player;
	}
	 
	   public void inject(){
	        CraftPlayer cPlayer = (CraftPlayer) this.player;
	        channel = cPlayer.getHandle().playerConnection.networkManager.channel;
	        channel.pipeline().addAfter("decoder", "PacketSub", new MessageToMessageDecoder<Packet<?>>() {@Override protected void decode(ChannelHandlerContext arg0, Packet<?> packet,List<Object> arg2) throws Exception {arg2.add(packet);readPacket(packet);}});
	    }
	    
	    public void uninject(){
	    	CraftPlayer cPlayer = (CraftPlayer)this.player;
	        channel = cPlayer.getHandle().playerConnection.networkManager.channel;
	    	
	        if(channel.pipeline().get("PacketSub") != null){	
	            channel.pipeline().remove("PacketSub");
	        }
	    }
	    
	 
	    public void readPacket(Packet<?> packet){
	        if(packet != null){
	        	Subscribe.call(packet, player);
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

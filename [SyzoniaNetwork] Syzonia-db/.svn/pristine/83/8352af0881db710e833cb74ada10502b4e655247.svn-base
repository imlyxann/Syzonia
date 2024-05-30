package fr.syzonia.syzodb.mysql;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;


public class MessageInfo {

	private static Map<Player, MessageInfo> messageInfo = new HashMap<Player, MessageInfo>();
	private Player player;
	
	public MessageInfo(Player player) {
		this.player = player;
		MessageInfo.messageInfo.put(player, this);
		
	}
	
	public static MessageInfo getMessagesPlayer(Player player) {
		return messageInfo.get(player);
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public String getLastMessage() {
		return new MessageManager().getLastMessage(player.getUniqueId());
	}
	
	public void setLastMessage(String message) {
		new MessageManager().setLastMessage(player.getUniqueId(), message);
	}
	
}

package fr.syzonia.syzobungee.listeners;

import fr.syzonia.bungeedb.Main;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class AsyncChatListener implements Listener {

	@EventHandler
	public void AsyncChat(ChatEvent event) {
		ProxiedPlayer player = (ProxiedPlayer) event.getSender();
		
		if(Main.INSTANCE.muteManager.IsMuted(player.getUniqueId())) {
			Main.INSTANCE.muteManager.checkDuration(player.getUniqueId());
			
			if(!(event.getMessage().charAt(0) == '/')) {
				player.sendMessage(new TextComponent("§r[§6Syzonia§r] §cTu est Mute pendant " + Main.INSTANCE.muteManager.getTimeLeft(player.getUniqueId())));
				event.setMessage(null);
				event.setCancelled(true);
				return;
			} else {
				event.setCancelled(false);	
			}
			
			return;
		}
	}	
	
	
}

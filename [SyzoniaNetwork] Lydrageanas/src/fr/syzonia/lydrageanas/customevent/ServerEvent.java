package fr.syzonia.lydrageanas.customevent;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Event;

public class ServerEvent extends Event{

	   private ServerInfo serverModified;

	    public ServerEvent(ServerInfo serverModified) {
	        this.serverModified = serverModified;
	    }

	    public ServerInfo getServerModified() {
	        return serverModified;
	    }
	
}

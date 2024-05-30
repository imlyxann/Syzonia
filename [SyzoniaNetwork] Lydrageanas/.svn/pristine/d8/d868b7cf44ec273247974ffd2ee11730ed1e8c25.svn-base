package fr.syzonia.lydrageanas.customevent;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Cancellable;

public class ServerAddEvent extends ServerEvent implements Cancellable{

    private boolean cancelled;

    public ServerAddEvent(ServerInfo serverModified) {
        super(serverModified);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
	
}

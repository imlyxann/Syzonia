package fr.syzonia.lydrageanas.customevent;

import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.plugin.Cancellable;

public class ServerModifEvent<T> extends ServerEvent implements Cancellable{

    private ServerField modified;
    private T newValue;
    private boolean cancelled;

    public ServerModifEvent(ServerInfo serverModified, ServerField modified, T newValue) {
        super(serverModified);
        this.modified = modified;
        this.newValue = newValue;
    }

    public ServerField getModified() {
        return modified;
    }

    public T getNewValue() {
        return newValue;
    }

    public void setNewValue(T newValue) {
        this.newValue = newValue;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public enum ServerField {
        NAME, IP, MOTD, RESTRICTED
    }
	
}

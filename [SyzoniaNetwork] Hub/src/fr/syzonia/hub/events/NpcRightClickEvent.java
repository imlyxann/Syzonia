package fr.syzonia.hub.events;

import org.bukkit.entity.Player;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import net.minecraft.server.v1_8_R3.EntityPlayer;


public class NpcRightClickEvent extends Event implements Cancellable{

	  private static final HandlerList HANDLERS = new HandlerList();
	    private final Player player;
	    private final EntityPlayer npc;
	    private boolean isCancelled;

	    public NpcRightClickEvent(Player player, EntityPlayer npc) {
	        this.player = player;
	        this.npc = npc;
	    }

	    public static HandlerList getHandlerList() {
	        return HANDLERS;
	    }

	    public Player getPlayer() {
	        return player;
	    }

	    public EntityPlayer getNpc() {
			return npc;
		}

	    @Override
	    public HandlerList getHandlers() {
	        return HANDLERS;
	    }

	    @Override
	    public boolean isCancelled() {
	        return isCancelled;
	    }

	    @Override
	    public void setCancelled(boolean arg) {
	        isCancelled = arg;
	    }
	
}

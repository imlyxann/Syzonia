package fr.syzonia.hub.listeners;

import org.bukkit.Bukkit;




import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.syzonia.hub.Mount.MountManager;
import fr.syzonia.hub.VirtualGame.VirtualGameListener;
import fr.syzonia.hub.VirtualHubs.VirtualHubs;
import fr.syzonia.hub.VirtualMenu.Friends.VirtualFriends;
import fr.syzonia.hub.VirtualMenu.Legend.VirtualLegendSymbol;
import fr.syzonia.hub.VirtualMenu.MainMenu.VirtualMainMenu;
import fr.syzonia.hub.VirtualMenu.Preferences.VirtualPref;
import fr.syzonia.hub.VirtualMenu.minigames.VirtualMiniGamesMenu;
import fr.syzonia.hub.VirtualMenu.vip.VirtualVipMenu;
import fr.syzonia.hub.VirtualProfil.ProfilListener;
import fr.syzonia.hub.VirtualShop.ShopListener;
import fr.syzonia.hub.item.gadget.ItemListenerGadgets;
import fr.syzonia.hub.item.listener.PlayerItemInteract;
import fr.syzonia.hub.listeners.game.NpcCkickListener;
import fr.syzonia.hub.listeners.game.PlayerJoinListener;
import fr.syzonia.hub.listeners.game.PlayerMoveListener;
import fr.syzonia.hub.listeners.game.PlayerQuitListener;
import fr.syzonia.hub.listeners.gameplay.PlayerChatListener;
import fr.syzonia.hub.listeners.gameplay.PlayerDamageListener;
import fr.syzonia.hub.listeners.gameplay.PlayerInteractEvent;
import fr.syzonia.hub.listeners.gameplay.PlayerInventoryDropEvent;
import fr.syzonia.hub.listeners.gameplay.PlayerPickUpListener;
import fr.syzonia.hub.listeners.gameplay.PlayerSuccesListener;
import fr.syzonia.hub.particules.listener.PlayerParticulesMoveListener;
import fr.syzonia.hub.pets.PetsManager;

public class ListenerManager {

	PluginManager pm;
	Plugin plugin;
	
	public ListenerManager(Plugin plugin) {
		this.plugin = plugin;
		this.pm = Bukkit.getPluginManager();
	}
	
	public void registerListeners() {
		
		// Système
		pm.registerEvents(new PlayerPickUpListener(), this.plugin);
		pm.registerEvents(new PlayerJoinListener(), this.plugin);
		pm.registerEvents(new PlayerDamageListener(), this.plugin);
		pm.registerEvents(new PlayerSuccesListener(), this.plugin);
		pm.registerEvents(new PlayerChatListener(), this.plugin);
		pm.registerEvents(new PlayerMoveListener(), this.plugin);
		pm.registerEvents(new PlayerQuitListener(), this.plugin);
		pm.registerEvents(new PlayerInventoryDropEvent(), this.plugin);
		pm.registerEvents(new PlayerInteractEvent(), this.plugin);
	
		// Principal
		pm.registerEvents(new PlayerItemInteract(), this.plugin);
		pm.registerEvents(new VirtualMainMenu(), this.plugin);
		pm.registerEvents(new VirtualFriends(), this.plugin);
		pm.registerEvents(new UtilsListener(), this.plugin);
		pm.registerEvents(new VirtualPref(), this.plugin);
		pm.registerEvents(new VirtualLegendSymbol(), this.plugin);
		pm.registerEvents(new VirtualMiniGamesMenu(), this.plugin);
		pm.registerEvents(new VirtualVipMenu(), this.plugin);

			new ShopListener(this.plugin).registerShopListeners();
			new ProfilListener(this.plugin).registerProfilListeners();

			// Particules Manager
			pm.registerEvents(new PlayerParticulesMoveListener(), this.plugin);
			
			// Hubs
			pm.registerEvents(new VirtualHubs(), this.plugin);
			
		// Pets
			
			pm.registerEvents(new PetsManager(), this.plugin);
		
		// Game
			new VirtualGameListener(this.plugin).registerGameListeners();
			
		
		// divers
			pm.registerEvents(new MountManager(), this.plugin);
			pm.registerEvents(new NpcCkickListener(), this.plugin);
			pm.registerEvents(new ItemListenerGadgets(), this.plugin);
			
	
	}
	
	
	
	
}

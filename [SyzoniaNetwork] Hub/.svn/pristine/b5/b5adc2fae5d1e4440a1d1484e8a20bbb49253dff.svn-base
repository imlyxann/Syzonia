package fr.syzonia.hub.VirtualShop;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.syzonia.hub.VirtualShop.Gadgets.GadgetsShop;
import fr.syzonia.hub.VirtualShop.Kit.KitGameChooseMenu;
import fr.syzonia.hub.VirtualShop.Kit.CakeWars.KitCakeWarsShop;
import fr.syzonia.hub.VirtualShop.Lootboxs.LootboxShop;
import fr.syzonia.hub.VirtualShop.Mounts.MountShop;
import fr.syzonia.hub.VirtualShop.Particules.ParticulesShop;
import fr.syzonia.hub.VirtualShop.Pets.PetsShop;
import fr.syzonia.hub.VirtualShop.Vetements.ChapeauxShop;
import fr.syzonia.hub.VirtualShop.Vetements.ChaussureShop;
import fr.syzonia.hub.VirtualShop.Vetements.PantalonShop;
import fr.syzonia.hub.VirtualShop.Vetements.PullShop;

public class ShopListener {

	PluginManager pm;
	Plugin plugin;
	
	public ShopListener(Plugin plugin) {
		this.plugin = plugin;
		this.pm = Bukkit.getPluginManager();
	}
	
	public void registerShopListeners() {

		// Boutique
		pm.registerEvents(new VirtualShopMenu(), plugin);
			// Montures
			pm.registerEvents(new MountShop(), this.plugin);
			// Kits
			pm.registerEvents(new KitGameChooseMenu(), this.plugin);
				// CakeWars
				pm.registerEvents(new KitCakeWarsShop(), this.plugin);
			// Particules
			pm.registerEvents(new ParticulesShop(), this.plugin);
			// Pets
			pm.registerEvents(new PetsShop(), this.plugin);
			// Gadgets
			pm.registerEvents(new GadgetsShop(), this.plugin);
			// Vêtements
			pm.registerEvents(new ChapeauxShop(), this.plugin);
			pm.registerEvents(new PullShop(), this.plugin);
			pm.registerEvents(new PantalonShop(), this.plugin);
			pm.registerEvents(new ChaussureShop(), this.plugin);
			// Lootbox
			pm.registerEvents(new LootboxShop(), this.plugin);
		
		
	}
}

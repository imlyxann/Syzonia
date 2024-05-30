package fr.syzonia.hub.VirtualProfil;

import org.bukkit.Bukkit;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import fr.syzonia.hub.VirtualProfil.Gadgets.VirtualProfilGadgets;
import fr.syzonia.hub.VirtualProfil.Lootboxs.VirtualLootBoxProfil;
import fr.syzonia.hub.VirtualProfil.Mount.VirtualProfilMount;
import fr.syzonia.hub.VirtualProfil.Particules.VirtualProfilParticules;
import fr.syzonia.hub.VirtualProfil.pets.VirtualProfilPets;
import fr.syzonia.hub.VirtualProfil.vetements.ChapeauxProfil;
import fr.syzonia.hub.VirtualProfil.vetements.ChaussuresProfil;
import fr.syzonia.hub.VirtualProfil.vetements.PantalonProfil;
import fr.syzonia.hub.VirtualProfil.vetements.PullProfil;




public class ProfilListener {

	PluginManager pm;
	Plugin plugin;
	
	public ProfilListener(Plugin plugin) {
		this.plugin = plugin;
		this.pm = Bukkit.getPluginManager();
	}
	
	public void registerProfilListeners() {

		
		// Profil
		pm.registerEvents(new VirtualProfilMain(), this.plugin);
			// Montures
			pm.registerEvents(new VirtualProfilMount(), this.plugin);
			// Particules
			pm.registerEvents(new VirtualProfilParticules(), this.plugin);
			// Pets
			pm.registerEvents(new VirtualProfilPets(), this.plugin);
			// Gadgets
			pm.registerEvents(new VirtualProfilGadgets(), this.plugin);
			// Vetements
			pm.registerEvents(new ChapeauxProfil(), this.plugin);
			pm.registerEvents(new PullProfil(), this.plugin);
			pm.registerEvents(new PantalonProfil(), this.plugin);
			pm.registerEvents(new ChaussuresProfil(), this.plugin);
			//LootBoxs
			pm.registerEvents(new VirtualLootBoxProfil(), this.plugin);
		
	}
	
}

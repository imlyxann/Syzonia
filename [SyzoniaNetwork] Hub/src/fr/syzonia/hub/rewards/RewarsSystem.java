package fr.syzonia.hub.rewards;

import org.bukkit.entity.Player;


import fr.syzonia.syzodb.kits.cakewars.CakeWarsKitsManager;
import fr.syzonia.syzodb.mysql.PlayerInfo;
import fr.syzonia.syzodb.mysql.RewardsManager;
import fr.syzonia.syzodb.rank.Rank;
import fr.syzonia.syzodb.shop.mount.Mountdata;
import fr.syzonia.syzodb.shop.particules.ParticulesData;
import fr.syzonia.syzodb.shop.pets.PetsData;


public class RewarsSystem {

	public void load(Player player) {
		if(new RewardsManager().getRewardsFound(player.getUniqueId())) {
			PlayerInfo playerinfo = PlayerInfo.getInfos(player.getUniqueId());
			
			if(playerinfo.getRank() == 1) {
				playerinfo.addCoins(350);
				if(!Mountdata.haveMount(90, player)) {
					Mountdata.addMount(90, player.getUniqueId());
				}
				if(!ParticulesData.haveParticules(1, player)) {
					ParticulesData.addParticules(1, player.getUniqueId());

				}
				new RewardsManager().setRewardsFound(player.getUniqueId(), false);
				player.sendMessage("§2Vous avez reçu vos §aRécompenses §2de " + Rank.PowerToRank(playerinfo.getRank()).getName() + "§2!");
			}
			if(playerinfo.getRank() == 2) {
				playerinfo.addCoins(450);
				if(!Mountdata.haveMount(90, player)) {
					Mountdata.addMount(90, player.getUniqueId());
				}
				if(!Mountdata.haveMount(92, player)) {
					Mountdata.addMount(92, player.getUniqueId());

				}
				if(!ParticulesData.haveParticules(1, player)) {
					ParticulesData.addParticules(1, player.getUniqueId());

				}
				if(!ParticulesData.haveParticules(2, player)) {
					ParticulesData.addParticules(2, player.getUniqueId());
				}
				CakeWarsKitsManager.Gladiator.addKit(player.getUniqueId());
				new RewardsManager().setRewardsFound(player.getUniqueId(), false);
				player.sendMessage("§2Vous avez reçu vos §aRécompenses §2de " + Rank.PowerToRank(playerinfo.getRank()).getName() + "§2!");
			}
			if(playerinfo.getRank() == 3) {
				playerinfo.addCoins(900);
				if(!Mountdata.haveMount(90, player)) {
					Mountdata.addMount(90, player.getUniqueId());
				}
				if(!Mountdata.haveMount(92, player)) {
					Mountdata.addMount(92, player.getUniqueId());

				}
				if(!Mountdata.haveMount(91, player)) {
					Mountdata.addMount(91, player.getUniqueId());

				}
				if(!Mountdata.haveMount(95, player)) {
					Mountdata.addMount(95, player.getUniqueId());

				}
				if(!ParticulesData.haveParticules(1, player)) {
					ParticulesData.addParticules(1, player.getUniqueId());

				}
				
				if(!ParticulesData.haveParticules(2, player)) {
					ParticulesData.addParticules(2, player.getUniqueId());
				}
				if(!PetsData.havePet(1, player)) {
					PetsData.addPet(1, player.getUniqueId());
				}
				CakeWarsKitsManager.Gladiator.addKit(player.getUniqueId());
				CakeWarsKitsManager.Ranger.addKit(player.getUniqueId());
				new RewardsManager().setRewardsFound(player.getUniqueId(), false);
				player.sendMessage("§2Vous avez reçu vos §aRécompenses §2de " + Rank.PowerToRank(playerinfo.getRank()).getName() + "§2! §aMerci Beaucoup!");
			}
		}
	}
	
}

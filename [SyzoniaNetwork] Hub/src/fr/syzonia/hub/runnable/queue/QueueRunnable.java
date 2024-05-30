package fr.syzonia.hub.runnable.queue;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.syzonia.syzodb.mysql.game.CakeWarsGameManager;
import fr.syzonia.syzodb.mysql.queue.QueueManager;

public class QueueRunnable extends BukkitRunnable{

	protected static Player player;
	
	public QueueRunnable(Player player) {
		QueueRunnable.player = player;
	}
	
	@Override
	public void run() {
		
		CKConnect();
		
	}

	public void CKConnect() {
		QueueManager queue = new QueueManager();
		if(queue.isInQueue(player)) {
			if(queue.getMiniGame(player) == 1) {
				
				if(queue.getMiniGameType(player).equalsIgnoreCase("SOLO")) {
					int Result = new Random().nextInt(new CakeWarsGameManager().getAllGames() + 1);
					
					if(Result == 0) Result++;
					
					
					if(new CakeWarsGameManager().getStatus("cksp" + Result).equalsIgnoreCase("LIGNE")) {

					} 
					
				}
				
				if(queue.getMiniGameType(player).equalsIgnoreCase("DUO")) {
					int Result = new Random().nextInt(new CakeWarsGameManager().getAllGames() + 1);
					
					if(Result == 0) Result++;
					
					if(new CakeWarsGameManager().getStatus("ckdp" + Result).equalsIgnoreCase("LIGNE")) {

					} 		
				}
			}
			
		} 
	}
}

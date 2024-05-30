package fr.syzonia.hub.gadgets;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Effect;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Note;
import org.bukkit.Note.Tone;
import org.bukkit.entity.Player;

import fr.syzonia.hub.particules.ParticulesManager;




public class MusiquaGadget {

	   public HashMap<String, Long> cooldowns = new HashMap<String, Long>();

	
	public void Use(Player player) {
        
		Location loc = player.getLocation();
		loc.add(0, 2, 0);
		
		new ParticulesManager().spawnParticles(Effect.NOTE, 1, loc);
		player.playNote(loc, Instrument.PIANO, Note.flat(1, Random()));
		
	}
	
	public Tone Random() {
		switch (new Random().nextInt(3)) {
	
		case 0:
			
			return Tone.A;
	
		case 1:
			
			return Tone.B;
			
		case 2:
			
			return Tone.C;
			
			
		case 3:
			
			return Tone.D;
			
		}
		
		
		return null;
	}
	
	
}
	
	


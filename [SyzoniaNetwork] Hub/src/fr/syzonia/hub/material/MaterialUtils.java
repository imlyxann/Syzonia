package fr.syzonia.hub.material;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Material;

public class MaterialUtils {

	public static Material RandomMaterial(int random) {
		int count = 0;
		HashMap<Integer, Material> Materials = new HashMap<>();
		for(Material material : Material.values()) {
			Materials.put(count, material);
			count++;
		}
		if(random > Materials.size()) return null;
		return Materials.get(new Random().nextInt(random));
	}
	
}

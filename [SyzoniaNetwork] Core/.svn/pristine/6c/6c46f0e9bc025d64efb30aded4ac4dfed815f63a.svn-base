package fr.syzonia.core.paginatedgui;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.Inventory;

import fr.syzonia.core.array.SyzoArray;

public class ItemCheck {

	public static void Check(Inventory inv) {
		List<String> bools = new ArrayList<String>();
		
		if(inv.getItem(46) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(47) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(48) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(49) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(50) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(51) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(52) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(53) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(inv.getItem(54) != null) {
			bools.add("true");
		} else {
			bools.add("false");
		}
		
		if(SyzoArray.verifyAllEqual(bools) && bools.get(0).equals("false")) {
			System.out.println("Paginated Gui Error !! > IndexOutOfBound Inventory " + inv.getName() + " lat line isn't empty!");
		}
	}
	
}

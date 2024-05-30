package fr.syzonia.core.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class SyzoArray {
	
	public static List<String> StringArrayToList(String[] strs) {
		List<String> list = new ArrayList<String>();
		for(String str : strs) {
			list.add(str);
		}
		return list;
	}
	
	public static List<Character> CharArrayToList(char[] strs) {
		List<Character> list = new ArrayList<Character>();
		for(char str : strs) {
			list.add(str);
		}
		return list;
	}
	
	public static boolean verifyAllEqual(List<String> list) {
	    return list.isEmpty() || list.stream().allMatch(list.get(0)::equals);
	}
	
	public static boolean verifyAllEqualUsingFrequency(List<String> list) {
	    return list.isEmpty() || Collections.frequency(list, list.get(0)) == list.size();
	}
	
	public static boolean verifyAllEqualUsingHashSet(List<String> list) {
	    return new HashSet<String>(list).size() <= 1;
	}
}


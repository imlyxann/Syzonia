package fr.syzonia.syzodb.server.serilization;

import java.util.ArrayList;
import java.util.List;

public class Serilization {

	public static List<String> toList(String keys) {
	    List<String> list = new ArrayList<>();
	    if (keys != null && !keys.isEmpty()) {
	        String[] keyArray = keys.split("-");
	        for (String key : keyArray) {
	            list.add(key);
	        }
	    }
	    return list;
	}
	
	public static String toDb(List<String> list) {
	    StringBuilder builder = new StringBuilder();
	    for (String key : list) {
	        builder.append(key).append("-");
	    }
	    if (builder.length() > 0) {
	        builder.setLength(builder.length() - 1); 
	    }
	    return builder.toString();
	}
	
}

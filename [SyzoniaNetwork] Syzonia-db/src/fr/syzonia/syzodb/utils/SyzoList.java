package fr.syzonia.syzodb.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SyzoList {

	public static List<String> getList(List<String> list, String string) {
		return Stream.concat(list.stream(), Stream.of(string)).collect(Collectors.toList());
	}
	
}

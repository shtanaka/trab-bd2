package application;

import java.util.HashMap;
import java.util.Map;

public class UtilStaticMethods {

	public static int parseComparable(String text) {
		if (text.contains("[a-zA-Z]+") == false) {
			return Integer.parseInt(text);
		} else {
			return Integer.parseInt(alphaToNumber(text));
		}
	}

	private static String alphaToNumber(String text) {
		Map<Character, String> map;
		String str = "hello world";

		map = new HashMap<>();
		map.put(' ', "0");
		map.put('a', "1");
		map.put('b', "2");
		map.put('c', "3");
		map.put('d', "4");
		map.put('e', "5");
		map.put('f', "6");
		map.put('g', "7");
		map.put('h', "8");
		map.put('i', "9");
		map.put('j', "10");
		map.put('k', "11");
		map.put('l', "12");
		map.put('m', "13");
		map.put('n', "14");
		map.put('o', "15");
		map.put('p', "16");
		map.put('q', "17");
		map.put('r', "18");
		map.put('s', "19");
		map.put('t', "20");
		map.put('u', "21");
		map.put('v', "22");
		map.put('w', "23");
		map.put('x', "24");
		map.put('y', "25");
		map.put('z', "26");
		String val = "";
		for (char c : str.toCharArray()) {
			val = val + map.get(c);
		}
		return val;

	}

}

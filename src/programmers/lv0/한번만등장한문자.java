package programmers.lv0;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 한번만등장한문자 {

	public String solution(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c ,0) + 1);
		}
		ArrayList<Character> arr = new ArrayList<>();
		for (char ss : map.keySet()) {
			if (map.get(ss) == 1) {
				arr.add(ss);
			}
		}
		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for (Character cc : arr) {
			sb.append(cc);
		}
		return sb.toString();
	}
}

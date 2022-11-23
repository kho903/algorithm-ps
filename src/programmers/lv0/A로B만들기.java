package programmers.lv0;

import java.util.HashMap;
import java.util.Map;

public class A로B만들기 {

	public int solution(String before, String after) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : before.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (char c : after.toCharArray()) {
			map.put(c, map.getOrDefault(c, -1) - 1);
		}

		for (Integer v : map.values()) {
			if (v != 0) return 0;
		}
		return 1;
	}
}

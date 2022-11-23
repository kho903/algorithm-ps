package programmers.lv0;

import java.util.HashMap;
import java.util.Map;

public class 중복된문자제거 {

	public String solution(String my_string) {
		StringBuilder answer = new StringBuilder();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : my_string.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, 0);
				answer.append(c);
			}
		}

		return answer.toString();
	}
}

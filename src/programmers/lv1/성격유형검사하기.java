package programmers.lv1;

import java.util.*;

public class 성격유형검사하기 {
	public String solution(String[] survey, int[] choices) {

		Map<Character, Integer> map = new HashMap<>();
		int N = choices.length;
		for (int i = 0; i < N; i++) {
			int value = choices[i];

			if (0 < value && value < 4) {
				char ch = survey[i].charAt(0);
				map.put(ch, map.getOrDefault(ch, 0) - value + 4);
			} else {
				char ch = survey[i].charAt(1);
				map.put(ch, map.getOrDefault(ch, 0) + value - 4);
			}
		}
		StringBuilder sb = new StringBuilder();
		return sb
			.append(map.getOrDefault('R', 0) >= map.getOrDefault('T', 0) ? 'R' : 'T')
			.append(map.getOrDefault('C', 0) >= map.getOrDefault('F', 0) ? 'C' : 'F')
			.append(map.getOrDefault('J', 0) >= map.getOrDefault('M', 0) ? 'J' : 'M')
			.append(map.getOrDefault('A', 0) >= map.getOrDefault('N', 0) ? 'A' : 'N')
			.toString();
	}
}
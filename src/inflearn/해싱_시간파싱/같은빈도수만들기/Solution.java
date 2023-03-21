package inflearn.해싱_시간파싱.같은빈도수만들기;

import java.util.*;

public class Solution {
	public int[] solution(String s) {
		int[] answer = new int[5];

		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int max = 0;
		for (Integer value : map.values()) {
			max = Math.max(max, value);
		}

		/*answer[0] = max - map.getOrDefault('a', 0);
		answer[1] = max - map.getOrDefault('b', 0);
		answer[2] = max - map.getOrDefault('c', 0);
		answer[3] = max - map.getOrDefault('d', 0);
		answer[4] = max - map.getOrDefault('e', 0);*/

		// refactor

		String str = "abcde";
		for (int i = 0; i < 5; i++) {
			answer[i] = max - map.getOrDefault(str.charAt(i), 0);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaabc")));
		System.out.println(Arrays.toString(T.solution("aabb")));
		System.out.println(Arrays.toString(T.solution("abcde")));
		System.out.println(Arrays.toString(T.solution("abcdeabc")));
		System.out.println(Arrays.toString(T.solution("abbccddee")));
	}
}
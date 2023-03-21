package inflearn.해싱_시간파싱.한번사용한최초문자;

import java.util.*;

public class Solution {
	public int solution(String s) {
		int N = s.length();
		Map<Character, Integer> map = new HashMap<>();

		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (int i = 0; i < N; i++) {
			if (map.get(s.charAt(i)) == 1) return i + 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
}
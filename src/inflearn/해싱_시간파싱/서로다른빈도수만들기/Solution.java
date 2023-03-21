package inflearn.해싱_시간파싱.서로다른빈도수만들기;

import java.util.*;

public class Solution {
	public int solution(String s) {
		int answer = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		Set<Integer> set = new HashSet<>();
		for (Character ch : map.keySet()) {
			while (set.contains(map.get(ch))) {
				answer++;
				map.put(ch, map.get(ch) - 1);
			}

			if (map.get(ch) == 0) continue;
			set.add(map.get(ch));
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("aaabbbcc"));
		System.out.println(T.solution("aaabbc"));
		System.out.println(T.solution("aebbbbc"));
		System.out.println(T.solution("aaabbbcccde"));
		System.out.println(T.solution("aaabbbcccdddeeeeeff"));
	}
}
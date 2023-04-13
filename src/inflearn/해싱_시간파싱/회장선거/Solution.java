package inflearn.해싱_시간파싱.회장선거;

import java.util.*;

public class Solution {
	public String solution(String[] votes, int k) {
		int N = votes.length;
		String[][] voteArr = new String[N][2];
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			voteArr[i] = votes[i].split(" ");
			map.put(voteArr[i][1], map.getOrDefault(voteArr[i][1], 0) + 1);
		}

		ArrayList<String> arr = new ArrayList<>();

		Map<String, Integer> cnt = new HashMap<>();

		for (String[] strings : voteArr) {
			if (map.get(strings[1]) >= k) {
				arr.add(strings[0]);
				cnt.put(strings[0], cnt.getOrDefault(strings[0], 0) + 1);
			}
		}

		int max = 0;

		for (String s : cnt.keySet())
			max = Math.max(cnt.get(s), max);

		List<String> ans = new ArrayList<>();
		for (String s : cnt.keySet()) {
			if (cnt.get(s) == max)
				ans.add(s);
		}
		Collections.sort(ans);
		return ans.get(0);
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(
			T.solution(new String[] {"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"},
				2));
		System.out.println(T.solution(
			new String[] {"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park",
				"park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(
			new String[] {"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom",
				"luis john"}, 2));
		System.out.println(T.solution(
			new String[] {"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis",
				"tom bob", "tom luis", "john park", "park john"}, 3));
	}
}
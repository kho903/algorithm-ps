package inflearn.greedy.스프링쿨러;

import java.util.*;

public class Solution {
	public int solution(int n, int[] nums) {
		int answer = 0;
		int[][] range = new int[nums.length + 1][2];
		for (int i = 0; i <= n; i++) {
			int x = nums[i];
			range[i][0] = Math.max(0, i - x);
			range[i][1] = Math.min(n, i + x);
		}

		Arrays.sort(range, Comparator.comparingInt(o -> o[0]));

		int s = 0;
		int e = 0;
		int i = 0;
		while (i < range.length) {
			while (i < range.length && range[i][0] <= s) {
				e = Math.max(e, range[i][1]);
				i++;
			}
			answer++;
			if (e == n) return answer;
			if (s == e) return -1;
			s = e;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(8, new int[] {1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(T.solution(4, new int[] {1, 2, 2, 0, 0}));
		System.out.println(T.solution(5, new int[] {2, 0, 0, 0, 0, 2}));
		System.out.println(T.solution(11, new int[] {1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}
}

package inflearn.dfs.줄다리기;

import java.util.*;

public class Solution {
	static int answer;
	static boolean[] ch = new boolean[8];
	static String[] fig;
	public int solution(int[][] fight) {
		answer = 0;
		int N = fight.length * 2;
		fig = new String[N];
		for (int i = 0; i < fight.length; i++) {
			fig[2 * i] = fight[i][0] + String.valueOf(fight[i][1]);
			fig[2 * i + 1] = fight[i][1] + String.valueOf(fight[i][0]);
		}

		dfs(0, "");
		return answer;
	}

	private void dfs(int L, String num) {
		if (L == 7) {
			if (check(num, fig)) answer++;
			return;
		}
		for (int i = 1; i <= 7; i++) {
			if (!ch[i] && check(num, fig)) {
				ch[i] = true;
				dfs(L + 1, num + i);
				ch[i] = false;
			}
		}
	}

	private boolean check(String num, String[] fig) {
		for (String s : fig) {
			if (num.contains(s)) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] {{1, 3}, {5, 7}, {4, 2}}));
		System.out.println(T.solution(new int[][] {{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
		System.out.println(T.solution(new int[][] {{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
		System.out.println(T.solution(new int[][] {{1, 7}}));
		System.out.println(T.solution(new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}
}

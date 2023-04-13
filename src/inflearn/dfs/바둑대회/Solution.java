package inflearn.dfs.바둑대회;

import java.util.*;

public class Solution {
	static int N;
	static int answer;

	public int solution(int[][] cans) {
		N = cans.length;
		answer = Integer.MAX_VALUE;
		dfs(0, 0, 0, 0, 0, cans);
		return answer;
	}

	private void dfs(int n, int blackN, int blackScore, int whiteN, int whiteScore, int[][] cans) {
		if (n == N) {
			answer = Math.min(answer, Math.abs(blackScore - whiteScore));
			return;
		}
		if (blackN < N / 2)
			dfs(n + 1, blackN + 1, blackScore + cans[n][0], whiteN, whiteScore, cans);
		if (whiteN < N / 2)
			dfs(n + 1, blackN, blackScore, whiteN + 1, whiteScore + cans[n][1], cans);
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] {{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
		System.out.println(T.solution(new int[][] {{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
		System.out.println(
			T.solution(new int[][] {{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33}, {25, 32}, {37, 59}, {33, 47}}));
	}
}

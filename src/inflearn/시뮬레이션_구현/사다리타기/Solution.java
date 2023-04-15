package inflearn.시뮬레이션_구현.사다리타기;

import java.util.*;

public class Solution {
	public char[] solution(int n, int[][] ladder) {
		char[] answer = new char[n];
		for (int i = 65; i < 65 + n; i++) {
			answer[i - 65] = (char)i;
		}

		for (int[] lad : ladder) {
			for (int x : lad) {
				char t = answer[x - 1];
				answer[x - 1] = answer[x];
				answer[x] = t;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][] {{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][] {{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][] {{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(
			T.solution(12, new int[][] {{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}
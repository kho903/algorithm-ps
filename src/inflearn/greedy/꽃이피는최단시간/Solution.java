package inflearn.greedy.꽃이피는최단시간;

import java.util.*;

public class Solution {
	public int solution(int[] plantTime, int[] growTime) {
		int answer = 0;
		int s = 0;
		int e = 0;
		int N = plantTime.length;
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = plantTime[i];
			arr[i][1] = growTime[i];
		}
		Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

		for (int i = 0; i < N; i++) {
			e = s + arr[i][0] + arr[i][1];
			answer = Math.max(answer, e);
			s += arr[i][0];
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {1, 3, 2}, new int[] {2, 3, 2}));
		System.out.println(T.solution(new int[] {2, 1, 4, 3}, new int[] {2, 5, 3, 1}));
		System.out.println(T.solution(new int[] {1, 1, 1}, new int[] {7, 3, 2}));
		System.out.println(T.solution(new int[] {5, 7, 10, 15, 7, 3, 5}, new int[] {6, 7, 2, 10, 15, 6, 7}));
		System.out.println(T.solution(new int[] {1, 2, 3, 4, 5, 6, 7}, new int[] {7, 5, 4, 3, 2, 1, 6}));
	}
}
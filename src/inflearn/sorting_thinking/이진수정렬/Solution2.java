package inflearn.sorting_thinking.이진수정렬;

import java.util.*;

public class Solution2 {
	public int[] solution(int[] nums) {
		int N = nums.length;
		int[] answer = new int[N];
		int[][] count = new int[N][2];

		for (int i = 0; i < N; i++) {
			int num = nums[i];
			count[i][0] = num;
			int cnt = 0;
			while (num > 0) {
				if (num % 2 == 1) cnt++;
				num /= 2;
			}
			count[i][1] = cnt;
		}

		Arrays.sort(count, (o1, o2) -> {
			if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
			return Integer.compare(o1[1], o2[1]);
		});

		for (int i = 0; i < N; i++) {
			answer[i] = count[i][0];
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution(new int[] {5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[] {5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[] {12, 5, 7, 23, 45, 21, 17})));
	}
}
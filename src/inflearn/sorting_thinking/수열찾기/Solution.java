package inflearn.sorting_thinking.수열찾기;

import java.util.*;

public class Solution {
	public int[] solution(int[] nums) {
		int N = nums.length;
		int[] answer = new int[N / 2];
		int[] count = new int[200001];

		Arrays.sort(nums);
		for (int num : nums) {
			count[num]++;
		}
		int idx = 0;
		for (int num : nums) {
			if (count[num] == 0)
				continue;
			answer[idx] = num;
			count[num]--;
			count[num * 2]--;
			idx++;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[] {1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[] {1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[] {14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}
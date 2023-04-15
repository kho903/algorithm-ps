package inflearn.시뮬레이션_구현.최대길이바이토닉수열;

import java.util.*;

public class Solution {
	public int solution(int[] nums) {
		int answer = 0;

		int N = nums.length;
		List<Integer> peak = new ArrayList<>();
		for (int i = 1; i < N - 1; i++) {
			if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
				peak.add(i);
			}
		}
		for (Integer x : peak) {
			int l = x;
			int r = x;
			while (l - 1 > 0 && nums[l - 1] < nums[l]) {
				l--;
			}
			while (r + 1 < N && nums[r] > nums[r + 1]) {
				r++;
			}
			answer = Math.max(answer, r - l + 1);

		}
		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.solution(new int[] {1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[] {3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[] {1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}

package inflearn.sorting_thinking.이진수정렬;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
	public int[] solution(int[] nums) {
		int N = nums.length;
		int[] answer = new int[N];

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = nums[i];
			int cnt = 0;
			while (num > 0) {
				if (num % 2 == 1) cnt++;
				num /= 2;
			}
			map.put(nums[i], cnt);
		}

		List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.sorted(Map.Entry.comparingByValue())
			.collect(Collectors.toList());
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : collect) {
			answer[i++] = entry.getKey();
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[] {5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[] {5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[] {12, 5, 7, 23, 45, 21, 17})));
	}
}
package inflearn.bfs.타일점프;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
	static int N, answer;

	public int solution(int[] nums) {
		answer = Integer.MAX_VALUE;
		N = nums.length;
		bfs(nums);
		if (answer == Integer.MAX_VALUE) return -1;
		return answer;
	}

	private void bfs(int[] nums) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, nums[0], 0});
		while (!queue.isEmpty()) {
			int[] arr = queue.poll();
			int x = arr[0];
			int jump = arr[1];
			int curCnt = arr[2];
			if (x == N - 1) answer = Math.min(answer, curCnt);
			else {
				for (int i = 1; i <= jump; i++) {
					if (x + i < N) {
						queue.add(new int[] {x + i, nums[x + i], curCnt + 1});
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution2 T = new Solution2();
		System.out.println(T.solution(new int[] {2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[] {1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[] {2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[] {1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[] {1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
}
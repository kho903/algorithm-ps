package inflearn.bfs.타일점프;

class Solution {
	static int N, answer;

	public int solution(int[] nums) {
		answer = Integer.MAX_VALUE;
		N = nums.length;
		bfs(nums, 0, 0);
		if (answer == Integer.MAX_VALUE) return -1;
		return answer;
	}

	private void bfs(int[] nums, int x, int cnt) {
		if (x == N - 1) {
			answer = Math.min(answer, cnt);
		} else {
			for (int i = 1; i <= nums[x]; i++) {
				if (x + i < N) {
					bfs(nums, x + i, cnt + 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[] {1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[] {2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[] {1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[] {1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
}
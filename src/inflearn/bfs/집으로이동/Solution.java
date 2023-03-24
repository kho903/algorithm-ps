package inflearn.bfs.집으로이동;

import java.util.*;

class Solution {
	public int solution(int[] pool, int a, int b, int home) {
		boolean[][] visited = new boolean[2][10001];
		for (int x : pool) {
			visited[0][x] = true; // 앞
			visited[1][x] = true; // 뒤
		}
		visited[0][0] = true;
		visited[1][0] = true;
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});

		int cnt = 0;
		while (!q.isEmpty()) {
			int N = q.size();
			for (int i = 0; i < N; i++) {
				int[] poll = q.poll();
				int x = poll[0];
				if (x == home) return cnt;
				if (x + a < 10001 && !visited[0][x + a]) {
					visited[0][x + a] = true;
					q.offer(new int[] {x + a, 0});
				}
				if (x - b >= 0 && !visited[1][x - b] && poll[1] == 0) {
					visited[1][x - b] = true;
					q.offer(new int[] {x - b, 1});
				}
			}
			cnt++;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {11, 7, 20}, 3, 2, 10));
		System.out.println(T.solution(new int[] {1, 15, 11}, 3, 2, 5));
		System.out.println(T.solution(new int[] {9, 15, 35, 30, 20}, 2, 1, 25));
		System.out.println(T.solution(new int[] {5, 12, 7, 19, 23}, 3, 5, 18));
		System.out.println(T.solution(new int[] {10, 15, 20}, 3, 2, 2));
	}
}
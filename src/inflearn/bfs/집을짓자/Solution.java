package inflearn.bfs.집을짓자;

import java.util.*;

class Solution {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		N = board.length;
		int[][] dist = new int[N][N];
		Queue<int[]> building = new LinkedList<>();
		// 먼저 빌딩인 인덱스를 building 큐에 넣어줌.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) building.offer(new int[]{i, j});
			}
		}

		int empty = 0;
		Queue<int[]> queue = new LinkedList<>();
		while (!building.isEmpty()) {
			queue.offer(building.poll());
			int cnt = 0;
			while (!queue.isEmpty()) {
				cnt++;
				int len = queue.size();
				while (len-- > 0) {
					int[] poll = queue.poll();
					for (int i = 0; i < 4; i++) {
						int nx = poll[0] + dx[i];
						int ny = poll[1] + dy[i];
						if (check(nx, ny, board, empty)) {
							board[nx][ny] = empty - 1;
							dist[nx][ny] += cnt;
							queue.add(new int[] {nx, ny});
						}
					}
				}
			}
			empty--;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == empty)
					answer = Math.min(answer, dist[i][j]);
			}
		}
		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	private boolean check(int nx, int ny, int[][] board, int empty) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == empty;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(
			new int[][] {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 2, 1, 0, 0}, {2, 0, 0, 2, 2}, {0, 0, 0, 0, 0}}));
		System.out.println(T.solution(new int[][] {{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 0}}));
		System.out.println(T.solution(new int[][] {{1, 2, 0, 0}, {0, 0, 1, 2}, {0, 2, 0, 0}, {0, 2, 1, 0}}));
		System.out.println(T.solution(new int[][] {{1, 0, 0, 1}, {0, 0, 2, 0}, {0, 0, 1, 0}, {2, 2, 0, 1}}));
	}
}
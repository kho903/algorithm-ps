package inflearn.bfs.숲속의기사;

import java.util.*;

public class Solution {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int r, c;

	public int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		r = board.length;
		c = board[0].length;
		int[][] dist1 = new int[r][c];
		int[][] dist2 = new int[r][c];

		int x = 0;
		int y = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 2) {
					x = i;
					y = j;
					break;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, 0, 0});

		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			if (poll[3] == 0) {
				for (int i = 0; i < 4; i++) {
					int nx = poll[0] + dx[i];
					int ny = poll[1] + dy[i];
					if (check(nx, ny, board, dist1)) {
						dist1[nx][ny] = 1;
						queue.offer(new int[] {nx, ny, poll[2] + 1, 0});
					} else if (0 <= nx && nx < r && 0 <= ny && ny < c && board[nx][ny] == 4) {
						queue.offer(new int[] {nx, ny, poll[2] + 1, 1});
					}
				}
			} else if (poll[3] == 1) {
				for (int i = 0; i < 4; i++) {
					int nx = poll[0] + dx[i];
					int ny = poll[1] + dy[i];
					if (check(nx, ny, board, dist2) && board[nx][ny] != 3) {
						dist2[nx][ny] = 1;
						queue.offer(new int[] {nx, ny, poll[2] + 1, 1});
					} else if (0 <= nx && nx < r && 0 <= ny && ny < c && board[nx][ny] == 3) {
						answer = Math.min(answer, poll[2] + 1);
					}
				}
			}
		}

		return answer;
	}

	private boolean check(int nx, int ny, int[][] board, int[][] dist) {
		return
			0 <= nx && nx < r && 0 <= ny && ny < c &&
				(board[nx][ny] == 0 || board[nx][ny] == 2|| board[nx][ny] == 3) && dist[nx][ny] == 0;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[][] {
			{4, 1, 0, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 0, 0},
			{0, 2, 1, 1, 3, 0, 4, 0},
			{0, 0, 0, 4, 1, 1, 1, 0}
		}));
		System.out.println(T.solution(new int[][] {
			{3, 0, 0, 0, 1, 4, 4, 4},
			{0, 1, 1, 0, 0, 0, 1, 0},
			{0, 1, 4, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{1, 0, 1, 0, 0, 1, 1, 0},
			{4, 0, 0, 0, 1, 0, 0, 0},
			{4, 1, 0, 0, 1, 0, 0, 0},
			{4, 0, 0, 0, 0, 0, 1, 2}
		}));
		System.out.println(T.solution(new int[][] {
			{4, 1, 0, 1, 0},
			{0, 1, 0, 1, 0},
			{0, 0, 2, 3, 4},
			{0, 1, 0, 1, 0}
		}));
	}
}
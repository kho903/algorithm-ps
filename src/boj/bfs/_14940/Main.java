package boj.bfs._14940;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {-1, 1, 0, 0};
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		arr = new int[N][M];

		int x = -1;
		int y = -1;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if (arr[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}

		visited = new boolean[N][M];
		bfs(x, y);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) arr[i][j] = -1;
				sb.append(arr[i][j]).append(" ");
			}
			sb.append('\n');
		}
		System.out.println(sb);

	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x, y, 0});
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int xx = poll[0];
			int yy = poll[1];
			int cnt = poll[2];
			arr[xx][yy] = cnt;
			visited[xx][yy] = true;

			for (int i = 0; i < 4; i++) {
				int nx = xx + dx[i];
				int ny = yy + dy[i];
				if (check(nx, ny)) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, cnt + 1});
				}
			}
		}
	}

	private static boolean check(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M && !visited[x][y] && arr[x][y] != 0;
	}
}

package boj.bfs._1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		n = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		arr = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++)
				arr[i][j] =  Integer.parseInt(stk.nextToken());
		}

		for (int x : bfs()) {
			System.out.println(x);
		}
	}

	private static int[] bfs() {
		int[] answer = new int[2];
		Queue<int[]> queue = new LinkedList<>();
		int area = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 || visited[i][j]) continue;
				answer[0]++;
				queue.add(new int[] {i, j});
				visited[i][j] = true;
				area = 0;
				while (!queue.isEmpty()) {
					int[] poll = queue.poll();
					int x = poll[0];
					int y = poll[1];
					area++;
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (check(nx, ny)) {
							queue.add(new int[] {nx, ny});
							visited[nx][ny] = true;
						}
					}
				}
				answer[1] = Math.max(answer[1], area);
			}
		}
		return answer;
	}

	private static boolean check(int nx, int ny) {
		return 0 <= nx && nx < n && 0 <= ny && ny < m && !visited[nx][ny] && arr[nx][ny] == 1;
	}
}

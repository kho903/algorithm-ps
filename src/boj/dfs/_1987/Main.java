package boj.dfs._1987;

import java.io.*;

public class Main {
	static int R, C;
	static int ans;
	static int[][] arr;
	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {-1, 1, 0, 0};
	static boolean[] visited = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);

		ans = 0;
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			String s1 = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = s1.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 0);
		System.out.println(ans);
	}

	private static void dfs(int x, int y, int cnt) {
		if (visited[arr[x][y]]) {
			ans = Math.max(ans, cnt);
			return;
		}
		visited[arr[x][y]] =true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (check(nx, ny)) {
				dfs(nx, ny, cnt + 1);
			}
		}
		visited[arr[x][y]] = false;
	}

	private static boolean check(int x, int y) {
		return 0 <= x && x < R && 0 <= y && y < C;
	}
}

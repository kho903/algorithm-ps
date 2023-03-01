package softeer.lv2.장애물인식프로그램;

import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static List<Integer> mapLen;

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		arr = new int[N][N];
		mapLen = new ArrayList<>();
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++)
				arr[i][j] = Integer.parseInt(str[j]);
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && arr[i][j] == 1) {
					cnt++;
					bfs(i, j);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		Collections.sort(mapLen);
		for (int x : mapLen)
			sb.append(x).append("\n");
		System.out.print(sb);
	}

	public static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {i, j});
		visited[i][j] = true;
		int size = 0;
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			size++;
			for (int q = 0; q < 4; q++) {
				int nx = x + dx[q];
				int ny = y + dy[q];
				if (isPossible(nx, ny)) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
		mapLen.add(size);
	}

	public static boolean isPossible(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N && !visited[x][y] && arr[x][y] == 1;
	}
}
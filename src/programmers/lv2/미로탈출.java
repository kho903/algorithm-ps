package programmers.lv2;

import java.util.*;

public class 미로탈출 {

	static int[] dx = new int[] {0, 0, -1, 1};
	static int[] dy = new int[] {-1, 1, 0, 0};
	static int[] start, end, lab;
	static int N, M;
	static char[][] map;

	public int solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = maps[i].toCharArray();
			for(int j=0; j< M; j++){
				char c = map[i][j];
				switch(c) {
					case 'S':
						start = new int[] {i, j};
						break;
					case 'E':
						end = new int[] {i, j};
						break;
					case 'L':
						lab = new int[] {i, j};
						break;
				}
			}
		}

		int toLab = bfs(start, lab);
		if (toLab == -1) return -1;

		int toEnd = bfs(lab, end);
		if (toEnd == -1) return -1;
		return toLab + toEnd;
	}

	int bfs(int[] start, int[] end) {
		Queue<int[]> que = new LinkedList<>();
		int[] ss = new int[3];
		ss[0] = start[0];
		ss[1] = start[1];
		que.offer(ss);
		int ans = -1;
		boolean[][] visited = new boolean[N][M];
		while (!que.isEmpty()) {
			int[] cur = que.poll();
			int x = cur[0];
			int y = cur[1];
			if (x == end[0] && y == end[1]) {
				ans = cur[2];
				break;
			}
			visited[x][y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (check(nx, ny, visited) && map[nx][ny] != 'X') {
					visited[nx][ny] = true;
					que.offer(new int[] {nx, ny, cur[2] + 1});
				}
			}
		}

		return ans;
	}

	boolean check(int x, int y, boolean[][] visited) {
		return 0 <= x && x < N && 0 <= y && y < M && !visited[x][y];
	}
}

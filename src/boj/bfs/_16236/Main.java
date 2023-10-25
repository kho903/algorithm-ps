package boj.bfs._16236;

import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		int[] cur = new int[2];
		for (int i = 0; i < N; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
				if (arr[i][j] == 9) {
					cur[0] = i;
					cur[1] = j;
					arr[i][j] = 0;
				}
			}
		}

		int size = 2;
		int eat = 0;
		int move = 0;

		while (true) {
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) ->{
				if (o1[2] != o2[2]) return o1[2] - o2[2];
				else if (o1[0] != o2[0]) return o1[0] - o2[0];
				else return o1[1] - o2[1];
			});

			boolean[][] visited = new boolean[N][N];

			pq.add(new int[] {cur[0], cur[1], 0});
			visited[cur[0]][cur[1]] = true;

			boolean checkEat = false;

			while (!pq.isEmpty()) {
				cur = pq.poll();

				if (arr[cur[0]][cur[1]] != 0 && arr[cur[0]][cur[1]] < size) {
					arr[cur[0]][cur[1]] = 0;
					eat++;
					move += cur[2];
					checkEat = true;
					break;
				}

				for (int k = 0; k < 4; k++) {
					int nx = cur[0] + dx[k];
					int ny = cur[1] + dy[k];
					if (check(nx, ny) && !visited[nx][ny] && arr[nx][ny] <= size) {
						pq.add(new int[] {nx, ny, cur[2] + 1});
						visited[nx][ny] = true;
					}
				}
			}

			if (!checkEat) break;
			if (size == eat) {
				size++;
				eat = 0;
			}
		}
		System.out.println(move);
	}

	private static boolean check(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}
}

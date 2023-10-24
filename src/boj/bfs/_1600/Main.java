package boj.bfs._1600;

import java.io.*;
import java.util.*;

public class Main {
	static int K, W, H;
	static int[][] arr;
	static boolean[][][] check;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
	static int[] hy = {1, -1, 2, -2, 2, -2, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		W = Integer.parseInt(stk.nextToken());
		H = Integer.parseInt(stk.nextToken());
		arr = new int[H][W];
		for (int i = 0; i < H; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		System.out.println(bfs());
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		check = new boolean[H][W][K + 1];
		check[0][0][0] = true;
		queue.add(new int[] {0, 0, 0, 0});

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curX = cur[0];
			int curY = cur[1];
			int curChance = cur[2];
			int curMove = cur[3];
			if (curX == H - 1 && curY == W - 1) {
				return curMove;
			}

			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				if (!checkIdx(nx, ny) || check[nx][ny][curChance])
					continue;
				if (arr[nx][ny] != 1) {
					check[nx][ny][curChance] = true;
					queue.add(new int[] {nx, ny, curChance, curMove + 1});
				}
			}

			if (curChance < K) {
				for (int i = 0; i < 8; i++) {
					int nx = curX + hx[i];
					int ny = curY + hy[i];
					if (!checkIdx(nx, ny) || check[nx][ny][curChance + 1])
						continue;
					if (arr[nx][ny] != 1) {
						check[nx][ny][curChance + 1] = true;
						queue.add(new int[] {nx, ny, curChance + 1, curMove + 1});
					}
				}
			}
		}
		return -1;
	}

	private static boolean checkIdx(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}

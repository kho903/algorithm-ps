package boj.bfs._2146;

import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int land = 2;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1)
					numbering(i, j);
			}
		}
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] > 1) {
					visited = new boolean[N][N];
					bfs(i, j);
				}
			}
		}
		System.out.println(answer);
	}

	private static void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y, 0));
		visited[x][y] = true;
		int cur = arr[x][y];
		while (!que.isEmpty()) {
			Node node = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (check(nx, ny) && arr[nx][ny] != cur) {
					visited[nx][ny] = true;
					if (arr[nx][ny] == 0)
						que.offer(new Node(nx, ny, node.cnt + 1));
					else
						answer = Math.min(answer, node.cnt);
				}
			}
		}
	}

	private static void numbering(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.offer(new Node(x, y, 0));
		visited[x][y] = true;
		arr[x][y] = land;
		while (!que.isEmpty()) {
			Node node = que.poll();
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (check(nx, ny) && arr[nx][ny] == 1) {
					arr[nx][ny] = land;
					visited[nx][ny] = true;
					que.offer(new Node(nx, ny, 0));
				}
			}
		}
		land++;
	}

	private static boolean check(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N && !visited[x][y];
	}
}

class Node {
	int x;
	int y;
	int cnt = 0;

	public Node(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
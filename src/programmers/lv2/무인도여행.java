package programmers.lv2;
import java.util.*;

public class 무인도여행 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static ArrayList<Integer> arr = new ArrayList<>();

	public int[] solution(String[] maps) {
		N = maps.length;
		M = maps[0].length();
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = maps[i].charAt(j);
			}
		}
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 'X' && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		int s = arr.size();
		int[] answer = new int[s];
		for (int i = 0; i < s; i++) {
			answer[i] = arr.get(i);
		}
		if (answer.length == 0) return new int[] {-1};
		Arrays.sort(answer);
		return answer;
	}

	public void bfs(int x, int y) {
		int cnt = 0;
		visited[x][y] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			cnt += Integer.parseInt(map[node.x][node.y] + "");
			for (int i = 0; i < 4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if (check(nx, ny)) {
					visited[nx][ny] = true;
					queue.add(new Node(nx, ny));
				}
			}
		}
		arr.add(cnt);
	}

	boolean check(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M && map[x][y] != 'X' && !visited[x][y];
	}


	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

package inflearn.bfs.송아지를잡자;

import java.util.*;

class Solution {

	public int solution(int s, int e) {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visited = new boolean[2][200001];
		q.add(s);
		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			while (size-- > 0) {
				int x = q.poll();
				int nx = x - 1;
				if (nx >= 0 && !visited[cnt % 2][nx]) {
					visited[cnt % 2][nx] = true;
					q.offer(nx);
				}
				nx = x + 1;
				if (nx < 200001 && !visited[cnt % 2][nx]) {
					visited[cnt % 2][nx] = true;
					q.offer(nx);
				}
				nx = 2 * x;
				if (nx < 200001 && !visited[cnt % 2][nx]) {
					visited[cnt % 2][nx] = true;
					q.offer(nx);
				}
			}
			e += cnt;
			if (e > 200000) return -1;
			if (visited[cnt % 2][e]) return cnt;
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(1, 11));
		System.out.println(T.solution(10, 3));
		System.out.println(T.solution(1, 34567));
		System.out.println(T.solution(5, 6));
		System.out.println(T.solution(2, 54321));
	}
}
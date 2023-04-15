package inflearn.graph.최소환승경로;

import java.util.*;

class Solution {
	public int solution(int[][] routes, int s, int e) {
		int answer = 0;
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		int r = routes.length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				map.putIfAbsent(routes[i][j], new ArrayList<>());
				map.get(routes[i][j]).add(i);
			}
		}

		Queue<Integer> queue = new LinkedList<>();
		int[] ch = new int[r];
		queue.offer(s);
		int L = 0;
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int poll = queue.poll();
				for (int x : map.get(poll)) {
					if (ch[x] == 1) continue;
					ch[x] = 1;
					for (int route : routes[x]) {
						if (route == e) return L;
						queue.offer(route);
					}
				}
			}
			L++;
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(
			new int[][] {{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15},
				{14, 12, 16, 17}}, 1, 12));
		System.out.println(
			T.solution(new int[][] {{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
		System.out.println(T.solution(new int[][] {{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
		System.out.println(T.solution(new int[][] {{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
	}
}

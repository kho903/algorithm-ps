package programmers.lv3;

import java.util.*;

public class 여행경로 {

	static boolean[] visited;
	static ArrayList<String> way;
	static int N;

	public String[] solution(String[][] tickets) {
		way = new ArrayList<>();
		N = tickets.length;
		visited = new boolean[N];
		dfs("ICN", "ICN", tickets, 0);
		Collections.sort(way);
		return way.get(0).split(" ");
	}

	public void dfs(String start, String cur, String[][] tickets, int len) {
		if (len == N) {
			way.add(cur);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (tickets[i][0].equals(start) && !visited[i]) {
				visited[i] = true;
				dfs(tickets[i][1], cur + " " + tickets[i][1], tickets, len + 1);
				visited[i] = false;
			}
		}
	}
}

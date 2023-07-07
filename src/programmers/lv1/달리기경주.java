package programmers.lv1;

import java.util.*;

public class 달리기경주 {

	public String[] solution(String[] players, String[] callings) {
		int N = players.length;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			map.put(players[i], i);
		}

		for (String p : callings) {
			int rank = map.get(p);
			String beforePlayer = players[rank - 1];
			players[rank - 1] = p;
			players[rank] = beforePlayer;

			map.put(p, map.get(p) - 1);
			map.put(beforePlayer, map.get(p) + 1);
		}

		return players;
	}
}

package programmers.lv1;

import java.util.*;

public class 추억점수 {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int N = photo.length;
		int[] answer = new int[N];
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}

		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < photo[i].length; j++) {
				cnt += map.getOrDefault(photo[i][j], 0);
			}
			answer[i] = cnt;
		}

		return answer;
	}
}

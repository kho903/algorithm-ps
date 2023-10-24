package programmers.lv2;

import java.util.*;

public class 요격시스템 {

	public int solution(int[][] targets) {
		int answer = 0;
		Arrays.sort(targets, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		int cur = -1;
		for (int[] target: targets) {
			int l = target[0];
			int r = target[1];
			if (l >= cur) {
				answer++;
				cur = r;
			}
		}

		return answer;
	}
}

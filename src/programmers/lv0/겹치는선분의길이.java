package programmers.lv0;

import java.util.Arrays;

public class 겹치는선분의길이 {

	public int solution(int[][] lines) {
		int answer = 0;
		Arrays.sort(lines, (o1, o2) -> {
			if (o1[1] == o2[1])
				return o1[0] - o2[0];
			return o1[1] - o2[1];
		});

		int[] color = new int[201];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				lines[i][j]+=100;
			}
		}
		for (int[] line : lines) {
			for (int i = line[0]; i < line[1]; i++) {
				color[i]++;
			}
		}
		for (int c : color) {
			if (c > 1) answer++;
		}
		return answer;
	}
}

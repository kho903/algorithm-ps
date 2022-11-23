package programmers.lv0;

import java.util.Arrays;

public class 진료순서정하기 {

	public int[] solution(int[] emergency) {
		int N = emergency.length;
		int[] answer = new int[N];
		int[] cloneEmer = emergency.clone();
		Arrays.sort(cloneEmer);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloneEmer[i] == emergency[j]) {
					answer[i] = N - j;
					break;
				}
			}
		}
		return answer;
	}
}

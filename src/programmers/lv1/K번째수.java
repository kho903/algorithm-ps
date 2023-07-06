package programmers.lv1;

import java.util.*;

public class K번째수 {

	public int[] solution(int[] array, int[][] commands) {
		int N = commands.length;
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			int[] arr = commands[i];
			int from = arr[0] -1;
			int to = arr[1];
			int k = arr[2] - 1;

			int[] sub = Arrays.copyOfRange(array, from, to);
			Arrays.sort(sub);
			answer[i] = sub[k];
		}

		return answer;
	}
}

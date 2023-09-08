package programmers.lv3;

import java.util.*;

public class 숫자게임 {

	public int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);
		int N = A.length;
		int AIdx = 0;
		for (int i = 0; i < N; i++) {
			if (A[AIdx] < B[i]) {
				answer++;
				AIdx++;
			}
		}

		return answer;
	}
}

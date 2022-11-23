package programmers.lv0;

import java.util.ArrayList;

public class n의배수고르기 {

	public int[] solution(int n, int[] numlist) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : numlist) {
			if (x % n == 0) arr.add(x);
		}
		int N = arr.size();
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}

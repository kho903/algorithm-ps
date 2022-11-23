package programmers.lv0;

import java.util.Arrays;

public class 특이한정렬 {

	public int[] solution(int[] numlist, int n) {
		int N = numlist.length;
		int[] answer = new int[N];
		Integer[] num = new Integer[N];
		for (int i = 0; i < N; i++) {
			num[i] = numlist[i];
		}
		Arrays.sort(num, (o1, o2) -> {
			if (Math.abs(o1 - n) == Math.abs(o2 - n)) {
				return o1 > o2 ? -1 : 1;
			}
			return Math.abs(o1 - n) - Math.abs(o2 - n);
		});
		for (int i = 0; i < N; i++) {
			 answer[i] = num[i];
		}
		return answer;
	}
}

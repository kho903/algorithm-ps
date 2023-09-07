package programmers.lv2;

import java.util.*;

public class 줄서는방법 {

	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		List<Integer> arr = new ArrayList<>();
		long num = 1;
		int idx = 0;
		for (int x = 1; x <= n; x++) {
			arr.add(x);
			num *= x;
		}
		k--;
		while (idx < answer.length) {
			num /= (n--);
			int i = (int)(k / num);
			answer[idx++] = arr.get(i);
			arr.remove(i);
			k %= num;
		}
		return answer;
	}

}

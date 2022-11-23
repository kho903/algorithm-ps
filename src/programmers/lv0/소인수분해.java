package programmers.lv0;

import java.util.*;

public class 소인수분해 {

	public int[] solution(int n) {
		Set<Integer> set = new HashSet<>();
		int x = 2;
		while (n > 1) {
			while (n % x == 0) {
				set.add(x);
				n /= x;
			}
			x++;
		}
		int[] answer = new int[set.size()];
		int i = 0;
		for (Integer value : set) {
			answer[i] = value;
			i++;
		}
		Arrays.sort(answer);
		return answer;
	}
}

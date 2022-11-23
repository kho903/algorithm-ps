package programmers.lv0;

import java.util.ArrayList;
import java.util.Arrays;

public class 약수구하기 {

	public int[] solution(int n) {
		ArrayList<Integer> arr = new ArrayList();
		int x = 1;
		while (x <= Math.sqrt(n)) {
			if (n % x == 0) {
				arr.add(x);
				if (n / x != x)
					arr.add(n / x);
			}
			x++;
		}
		int[] answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++)
			answer[i] = arr.get(i);
		Arrays.sort(answer);
		return answer;
	}
}

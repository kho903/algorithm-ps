package programmers.lv0;

import java.util.Arrays;

public class 머쓱이보다키큰사람 {
	public int solution(int[] array, int height) {
		// return (int)Arrays.stream(array).filter(a -> a > height).count();
		int cnt = 0;
		for (int x : array) {
			if (x > height) cnt++;
		}
		return cnt;
	}
}

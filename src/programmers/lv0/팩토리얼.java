package programmers.lv0;

public class 팩토리얼 {
	public int solution(int n) {
		int[] fact = new int[10];
		int x = 1;
		for (int i = 0; i < 10; i++) {
			x *= (i + 1);
			fact[i] = x;
		}
		for (int i = 9; i >= 0; i--) {
			if (fact[i] <= n) return i + 1;
		}
		return 1;
	}
}

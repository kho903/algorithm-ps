package programmers.lv0;

public class 유한소수판별하기 {

	public int solution(int a, int b) {
		int g = gcd(b, a);
		b /= g;
		while (b != 1) {
			int cnt = 0;
			if (b % 2 == 0) {
				b /= 2;
				cnt++;
			}
			if (b % 5 == 0) {
				b /= 5;
				cnt++;
			}
			if (cnt == 0) break;
		}
		if (b == 1) return 1;
		return 2;
	}

	public int gcd(int a, int b) {
		if (a == b) return a;
		while (b != 0) {
			int n = a % b;
			a = b;
			b = n;
		}
		return a;
	}
}

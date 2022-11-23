package programmers.lv0;

public class 분수의덧셈 {
	public int[] solution(int denum1, int num1, int denum2, int num2) {
		int[] answer = new int[2];
		int g = num1 * num2 / gcd(num1, num2);
		answer[0] = denum1 * g / num1 + denum2 * g / num2;
		answer[1] = g;
		int ganswer = gcd(answer[0], answer[1]);
		if (ganswer != 1) {
			answer[0] /= ganswer;
			answer[1] /= ganswer;
		}
		return answer;
	}

	public int gcd(int a, int b) {
		if (a % b == 0) return b;
		return gcd(b, a % b);
	}
}

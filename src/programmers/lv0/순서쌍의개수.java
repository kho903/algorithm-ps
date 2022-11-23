package programmers.lv0;

public class 순서쌍의개수 {
	public int solution(int n) {
		int answer = 0;
		int num = 1;
		for (int i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) answer+=2;
		}
		if (d(n)) answer++;
		return answer;
	}


	public boolean d(int n) {
		int a = 1;
		String as = "";
		while (a * a <= n) {
			if (a * a == n)
				return true;
			a++;
		}
		return false;
	}
}

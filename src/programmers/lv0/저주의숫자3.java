package programmers.lv0;

public class 저주의숫자3 {
	public static void main(String[] args) {
		저주의숫자3 s = new 저주의숫자3();
		System.out.println(s.solution(15));
		System.out.println(s.solution(40));
	}

	private int solution(int n) {
		int answer = 0;
		int cnt = 0;
		while (true) {
			answer++;
			if (answer % 3 == 0 || isThree(answer)) {
				continue;
			}
			cnt++;
			if (cnt == n) break;
		}
		return cnt;
	}

	public boolean isThree(int n) {
		String s = String.valueOf(n);
		for (char c : s.toCharArray()) {
			if (c == '3') return true;
		}
		return false;
	}
}

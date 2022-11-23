package programmers.lv0;

public class 치킨쿠폰 {
	public static void main(String[] args) {
		치킨쿠폰 s = new 치킨쿠폰();
		System.out.println(s.solution(100));
		System.out.println(s.solution(1081));
	}

	public int solution(int chicken) {
		int answer = 0;

		while (chicken >= 10) {
			int cur = chicken / 10;
			int rem = chicken % 10;
			chicken = cur + rem;

			answer += cur;
		}
		return answer;
	}
}

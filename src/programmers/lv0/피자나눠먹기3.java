package programmers.lv0;

public class 피자나눠먹기3 {

	public int solution(int slice, int n) {
		int answer = n / slice;
		if (n % slice != 0) answer++;
		return answer;
	}
}

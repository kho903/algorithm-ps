package programmers.lv2;

public class 점찍기 {

	public long solution(int k, int d) {
		long answer = 0;

		for (long i = 0; i <= d; i += k) {
			long d_pow = (long) Math.pow(d, 2);
			long i_pow = (long) Math.pow(i, 2);
			long point = (long) Math.sqrt(d_pow - i_pow);
			answer += (point / k) + 1;
		}
		return answer;
	}
}

package programmers.lv0;

public class 종이자르기 {
	public int solution(int M, int N) {
		int answer = 0;
		if (M == 1 && N == 1) return 0;

		if (M > N) {
			int t = M;
			M = N;
			N = t;
		}

		if (M == 1) {
			return N - 1;
		}
		int cnt = M - 1;

		return (cnt + 1) * (N - 1) + cnt;
	}
}

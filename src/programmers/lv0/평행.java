package programmers.lv0;

public class 평행 {
	public int solution(int[][] dots) {
		double f1 = (double) (dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);
		double f2 = (double) (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);
		if (f1 == f2) return 1;

		f1 = (double)(dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);
		f2 = (double)(dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);
		if (f1 == f2) return 1;

		f1 = (double)(dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);
		f2 = (double)(dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);
		if (f1 == f2) return 1;

		return 0;
	}
}

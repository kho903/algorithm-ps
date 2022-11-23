package programmers.lv0;

public class 직사각형넓이구하기 {

	public int solution(int[][] dots) {
		int answer = 0;
		int[] leng = new int[2];
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (leng[0] == 0 && dots[i][0] == dots[j][0]) {
					leng[0] = Math.abs(dots[i][1] - dots[j][1]);
				} else if (leng[1] == 0 && dots[i][1] == dots[j][1]) {
					leng[1] = Math.abs(dots[i][0] - dots[j][0]);
				}
			}
			if (leng[0] != 0 && leng[1] != 0) break;
		}
		return leng[0] * leng[1];
	}
}

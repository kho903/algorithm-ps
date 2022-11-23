package programmers.lv0;

public class 삼각형의완성조건2 {

	public int solution(int[] sides) {
		if (sides[0] < sides[1]) {
			int t = sides[0];
			sides[0] = sides[1];
			sides[1] = t;
		}

		return 2 *sides[1] - 1;
	}
}

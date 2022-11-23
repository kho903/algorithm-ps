package programmers.lv0;

public class 주사위의개수 {

	public int solution(int[] box, int n) {
		if (box[0] < n || box[1] < n || box[2] < n)
			return 0;
		return (box[0] / n) * (box[1] / n) * (box[2] / n);
	}
}

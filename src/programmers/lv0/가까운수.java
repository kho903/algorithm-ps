package programmers.lv0;

public class 가까운수 {

	public int solution(int[] array, int n) {
		int answer = 100;
		int tempSub = 100;
		for (int x : array) {
			int sub = Math.abs(n - x);
			if (sub <= tempSub) {
				if (sub == tempSub) {
					answer = Math.min(answer, x);
				}
				else {
					answer = x;
					tempSub = sub;
				}
			}
		}
		return answer;
	}
}

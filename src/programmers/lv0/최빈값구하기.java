package programmers.lv0;

public class 최빈값구하기 {

	public int solution(int[] array) {
		int answer = 0;
		int cur = -1;
		int[] check = new int[1000];
		for (int x : array) {
			check[x]++;
		}

		for (int i = 0; i < 1000; i++) {
			if (check[i] > cur) {
				answer = i;
				cur = check[i];
			} else if (check[i] == cur) {
				answer = -1;
			}
		}
		return answer;
	}
}

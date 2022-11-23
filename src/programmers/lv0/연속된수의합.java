package programmers.lv0;

public class 연속된수의합 {

	public int[] solution(int num, int total) {
		int[] answer = new int[num];
		int n = total / num;
		int idx = num / 2;
		if (num % 2 == 0) idx--;
		answer[idx] = n;
		int x = idx - 1;
		int xx = n - 1;
		int y = idx + 1;
		int yy = n + 1;
		while (x >= 0){
			answer[x--] = xx--;
		}
		while (y < num) {
			answer[y++] = yy++;
		}
		return answer;
	}
}

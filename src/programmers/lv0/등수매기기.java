package programmers.lv0;

public class 등수매기기 {

	public int[] solution(int[][] score) {
		int N = score.length;
		int[] answer = new int[N];
		int[] sum = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = 1;
			sum[i] = score[i][0] + score[i][1];
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (sum[i] < sum[j]) answer[i]++;
				else if (sum[i] > sum[j]) answer[j]++;
			}
		}
		return answer;
	}
}

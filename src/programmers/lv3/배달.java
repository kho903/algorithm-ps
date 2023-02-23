package programmers.lv3;

public class 배달 {

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		int[][] arr = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				arr[i][j] = 500001;
			}
		}

		for (int[] each : road) {
			int a = each[0];
			int b = each[1];
			int c = each[2];
			if (arr[a][b] < c) continue;
			arr[a][b] = c;
			arr[b][a] = c;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if (arr[j][k] > arr[j][i] + arr[i][k])
						arr[j][k] = arr[j][i] + arr[i][k];
				}
			}
		}

		for (int i = 1; i <= N; i++)
			if (arr[1][i] <= K) answer++;


		return answer;
	}
}

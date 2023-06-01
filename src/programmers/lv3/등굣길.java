package programmers.lv3;

public class 등굣길 {
	public int solution(int m, int n, int[][] puddles) {
		int mod = 1_000_000_007;
		int[][] arr = new int[n + 1][m + 1];
		arr[1][1] = 1;

		for (int i = 0; i < puddles.length; i++) {
			arr[puddles[i][1]][puddles[i][0]] = -1;
		}
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (arr[i][j] == -1)
					continue;

				if (arr[i - 1][j] > 0)
					arr[i][j] += arr[i - 1][j] % mod;
				if (arr[i][j - 1] > 0)
					arr[i][j] += arr[i][j - 1] % mod;
			}
		}
		return arr[n][m] % mod;
	}
}

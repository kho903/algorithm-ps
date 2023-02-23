package programmers.lv3;

public class 스티커모으기2 {

	public int solution(int sticker[]) {
		int N = sticker.length;
		if (N == 1) return sticker[0];

		int[] dp = new int[N];
		dp[0] = sticker[0];
		dp[1] = sticker[0];

		for (int i = 2; i < N - 1; i++) {
			dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
		}

		int[] dp2 = new int[N];
		dp2[1] = sticker[1];
		for (int i = 2; i < N; i++) {
			dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
		}
		return Math.max(dp[N - 2], dp2[N - 1]);
	}
}

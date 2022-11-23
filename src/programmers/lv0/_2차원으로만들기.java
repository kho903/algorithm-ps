package programmers.lv0;

public class _2차원으로만들기 {

	public int[][] solution(int[] num_list, int n) {
		int nn = num_list.length;
		int[][] answer = new int[nn / n][n];
		for (int i = 0; i < nn; i++) {
			int a = i / n;
			int b = i % n;
			answer[a][b] = num_list[i];
		}
		return answer;
	}
}

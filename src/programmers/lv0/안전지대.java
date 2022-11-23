package programmers.lv0;

public class 안전지대 {

	int[] dx = new int[] {-1, -1, -1, 1, 1, 1, 0, 0};
	int[] dy = new int[] {-1, 0, 1, -1, 0, 1, -1, 1};
	public int solution(int[][] board) {
		int N = board.length;
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					for (int k = 0; k < 8; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] != 1) {
							board[nx][ny] = 2;
						}
					}
				}
			}
		}
		for (int[] bo : board) {
			for (int b : bo) {
				if (b == 0) answer++;
			}
		}

		return answer;
	}
}

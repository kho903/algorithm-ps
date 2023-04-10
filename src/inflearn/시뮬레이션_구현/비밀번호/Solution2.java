package inflearn.시뮬레이션_구현.비밀번호;

public class Solution2 {
	static int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};

	public int solution(int[] keypad, String password) {
		int answer = 0;
		int[][] key = new int[3][3];
		int[][] dist = new int[10][10];
		int N = 3;
		int idx = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				key[i][j] = keypad[idx++];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < 8; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if (check(nx, ny)) {
						int x = key[i][j];
						int y = key[nx][ny];
						dist[x][y] = 1;
					}
				}
			}
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i == j) dist[i][j] = 0;
				else if (dist[i][j] != 1) dist[i][j] = 2;
			}
		}

		int pN = password.length();
		for (int i = 0; i < pN - 1; i++) {
			int p = password.charAt(i) - '0';
			int q = password.charAt(i + 1) - '0';
			answer+= dist[p][q];
		}

		return answer;
	}

	private boolean check(int pi, int pj) {
		return 0 <= pi && pi < 3 && 0 <= pj && pj < 3;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
		System.out.println(T.solution(new int[] {1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[] {2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[] {1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}

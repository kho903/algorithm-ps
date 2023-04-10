package inflearn.시뮬레이션_구현.비밀번호;

/**
 * 시간 초과가 될 것.
 * password 길이 최대 200,000
 */
public class Solution {
	static int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dy = new int[] {-1, 0, 1, 1, 1, 0, -1, -1};
	public int solution(int[] keypad, String password) {
		int answer = 0;
		int[][] key = new int[3][3];
		int idx = 0;
		int curI = -1;
		int curJ = -1;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				key[i][j] = keypad[idx++];
				if (password.charAt(0) - '0' == key[i][j]) {
					curI = i;
					curJ = j;
				}
			}
		}

		int N = password.length();
		for (int i = 1; i < N; i++) {
			int x = password.charAt(i) - '0';
			if (x == password.charAt(i - 1) - '0') continue;
			int prevI = curI;
			int prevJ = curJ;
			for (int d = 0; d < 8; d++) {
				int pi = curI + dx[d];
				int pj = curJ + dy[d];
				if (check(pi, pj, key, x)) {
					answer++;
					curI = pi;
					curJ = pj;
					break;
				}
			}

			if (prevI == curI && prevJ == curJ) {
				answer += 2;
				for (int z = 0; z < 3; z++) {
					for (int q = 0; q < 3; q++) {
						if (key[z][q] == x) {
							curI = z;
							curJ = q;
							break;
						}
					}
				}
			}
		}
		return answer;
	}

	private boolean check(int pi, int pj, int[][] key, int x) {
		return 0 <= pi && pi < 3 && 0 <= pj && pj < 3 && key[pi][pj] == x;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution(new int[] {2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
		System.out.println(T.solution(new int[] {1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
		System.out.println(T.solution(new int[] {2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
		System.out.println(T.solution(new int[] {1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
	}
}
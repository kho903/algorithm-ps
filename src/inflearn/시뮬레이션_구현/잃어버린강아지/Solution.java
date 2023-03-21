package inflearn.시뮬레이션_구현.잃어버린강아지;

public class Solution {
	static int N = 10;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public int solution(int[][] board) {

		int x = 0, y = 0;
		int dogx = 0, dogy = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 2)  {
					x = i;
					y = j;
				}
				if (board[i][j] == 3) {
					dogx = i;
					dogy = j;
				}
			}
		}

		int i = 0;
		int min = 0;

		int dogi = 0;
		while (min < 10000) {
			min++;
			int nx = x + dx[i];
			int ny = y + dy[i];

			int dognx = dogx + dx[dogi];
			int dogny = dogy + dy[dogi];


			if (!check(nx, ny, board)) {
				i = (i + 1) % 4;
			} else {
				x = nx;
				y = ny;
			}

			if (!check(dognx, dogny, board)) {
				dogi = (dogi + 1) % 4;
			} else {
				dogx = dognx;
				dogy = dogny;
			}
			if (x == dogx && y == dogy) break;
		}
		if (min == 10000) return 0;
		return min;
	}


	private boolean check(int nx, int ny, int[][] board) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] != 1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
		System.out.println(T.solution(arr1));
		int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
			{0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
			{1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
			{0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
			{0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
		System.out.println(T.solution(arr2));
	}
}
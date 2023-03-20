package inflearn.시뮬레이션_구현.청소;

import java.util.*;

public class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static int N;

	public int[] solution(int[][] board, int k) {
		N = board.length;

		int x = 0, y = 0;
		int i = 0;
		while (k > 0) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			k--;
			if (!check(nx, ny, board)) {
				i = (i + 1) % 4;
			} else {
				x = nx;
				y = ny;
			}
		}
		return new int[] {x, y};
	}

	private boolean check(int nx, int ny, int[][] board) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] != 1;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		int[][] arr1 = {
			{0, 0, 0, 0, 0},
			{0, 1, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{1, 0, 1, 0, 1},
			{0, 0, 0, 0, 0}
		};
		System.out.println(Arrays.toString(T.solution(arr1, 10)));
		int[][] arr2 = {
			{0, 0, 0, 1, 0, 1},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 1},
			{1, 1, 0, 0, 1, 0},
			{0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0}
		};
		System.out.println(Arrays.toString(T.solution(arr2, 20)));
		int[][] arr3 = {
			{0, 0, 1, 0, 0},
			{0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{1, 0, 0, 0, 1},
			{0, 0, 0, 0, 0}
		};
		System.out.println(Arrays.toString(T.solution(arr3, 25)));
	}
}

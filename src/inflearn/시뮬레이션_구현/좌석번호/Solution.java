package inflearn.시뮬레이션_구현.좌석번호;import java.util.*;
class Solution {
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	public int[] solution(int c, int r, int k) {
		if (c * r < k) return new int[] {0, 0};
		boolean[][] visited = new boolean[c + 1][r + 1];
		int x = 1, y = 1;
		visited[x][y] = true;
		int d = 0;
		k--;
		while (k > 0) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			if (!(0 < nx && nx <= c && 0 < ny && ny <= r ) || (visited[nx][ny])) {
				d = (d + 1) % 4;
				continue;
			}
			k--;
			visited[nx][ny] = true;
			x = nx;
			y = ny;
		}
		return new int[] {x, y};
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}

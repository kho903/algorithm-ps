package leetcode.medium._54;

import java.util.*;

class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int m, n;
    static boolean[][] visited;
    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        int x = 0, y = 0, di = 0;
        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            visited[x][y] = true;
            int nx = x + dx[di];
            int ny = y + dy[di];
            if (check(nx, ny)) {
                x = nx;
                y = ny;
            } else {
                di = (di + 1) % 4;
                x += dx[di];
                y += dy[di];
            }
        }

        return ans;
    }

    public boolean check(int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n && !visited[x][y];
    }
}

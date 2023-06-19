package programmers.lv2;

import java.util.*;

public class 교점에별만들기 {

	public String[] solution(int[][] line) {
		List<Point> points = new ArrayList<>();
		for (int i = 0; i < line.length; i++) {
			for (int j = i + 1; j < line.length; j++) {
				Point p = intersection(
					line[i][0],line[i][1],line[i][2],
					line[j][0],line[j][1],line[j][2]
				);
				if (p != null) points.add(p);
			}
		}

		Point mini = getMin(points);
		Point maxi = getMax(points);

		int w = (int) (maxi.x - mini.x + 1);
		int h = (int) (maxi.y - mini.y + 1);
		char[][] arr = new char[h][w];

		for (char[] ch : arr) {
			Arrays.fill(ch, '.');
		}
		for (Point p : points) {
			int px = (int) (p.x - mini.x);
			int py = (int) (maxi.y - p.y);
			arr[py][px] = '*';
		}

		String[] answer = new String[arr.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = new String(arr[i]);
		}
		return answer;
	}

	public Point getMin(List<Point> points) {
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;
		for (Point p : points) {
			if (p.x < x) x = p.x;
			if (p.y < y) y = p.y;
		}
		return new Point(x, y);
	}

	public Point getMax(List<Point> points) {
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;
		for (Point p : points) {
			if (p.x > x) x = p.x;
			if (p.y > y) y = p.y;
		}
		return new Point(x, y);
	}

	public Point intersection(long a, long b, long e, long c, long d, long f) {
		double x = (double) (b * f - e * d) / (a * d - b * c);
		double y = (double) (e * c - a * f) / (a * d - b * c);
		if (x % 1 != 0 || y % 1 != 0) return null;

		return new Point((long) x, (long) y);
	}

	private static class Point {
		public long x, y;

		public Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
}

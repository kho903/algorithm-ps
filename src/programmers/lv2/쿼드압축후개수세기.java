package programmers.lv2;

public class 쿼드압축후개수세기 {

	static class Count {
		public int zero;
		public int one;

		public Count(int zero, int one) {
			this.zero = zero;
			this.one = one;
		}

		public Count add(Count other) {
			return new Count(zero + other.zero, one + other.one);
		}
	}

	Count count(int x, int y, int size, int[][] arr) {
		int h = size / 2;
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (arr[i][j] != arr[x][y]) {
					return count(x, y, h, arr)
						.add(count(x + h, y, h, arr))
						.add(count(x, y + h, h, arr))
						.add(count(x + h, y + h, h, arr));
				}
			}
		}
		if (arr[x][y] == 1) return new Count(0, 1);
		return new Count(1, 0);
	}

	public int[] solution(int[][] arr) {
		Count count = count(0, 0, arr.length, arr);
		return new int[] {count.zero, count.one};
	}
}

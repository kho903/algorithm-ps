package programmers.lv2;

public class 숫자변환하기 {
	public int solution(int x, int y, int n) {

		int[] arr = new int[y + 1];

		arr[y] = 0;
		for (int i = 1; i < y; i++) {
			arr[i] = Integer.MAX_VALUE;
		}

		for (int i = y; i >= x; i--) {
			if (arr[i] == Integer.MAX_VALUE) continue;

			if (i - n >= 0) arr[i - n] = Math.min(arr[i] + 1, arr[i - n]);
			if (i % 2 == 0) arr[i / 2] = Math.min(arr[i] + 1, arr[i / 2]);
			if (i % 3 == 0) arr[i / 3] = Math.min(arr[i] + 1, arr[i / 3]);
		}

		if (arr[x] == Integer.MAX_VALUE) return -1;
		return arr[x];
	}

}
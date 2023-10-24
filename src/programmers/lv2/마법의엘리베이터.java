package programmers.lv2;

public class 마법의엘리베이터 {
	public int solution(int storey) {
		int answer = 0;
		String str = String.valueOf(storey);
		int N = str.length();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i) - '0';
		}

		for (int i = N - 1; i >= 0; i--) {
			int x = arr[i];
			if (x > 5) {
				answer += 10 - x;
				if (i == 0) {
					answer++;
				} else {
					arr[i - 1]++;
				}
			} else if (x == 5 && i > 0 && arr[i - 1] >= 5) {
				arr[i - 1]++;
				answer += 5;
			} else {
				answer += x;
			}
		}

		return answer;
	}
}

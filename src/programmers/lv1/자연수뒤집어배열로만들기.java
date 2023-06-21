package programmers.lv1;

public class 자연수뒤집어배열로만들기 {

	public int[] solution(long n) {
		int N = String.valueOf(n).length();
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			long a = n % 10;
			answer[i] = (int) a;
			n /= 10;
		}
		return answer;
	}

	public int[] solution2(long n) {
		String str = Long.toString(n);
		int N = str.length();
		String reversed = new StringBuilder(str).reverse().toString();
		char[] arr = reversed.toCharArray();

		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[i] = arr[i] - '0';
		}
		return answer;
	}
}

package programmers.lv0;

public class 배열뒤집기 {

	public int[] solution(int[] num_list) {
		int N = num_list.length;
		int[] answer = new int[N];
		for (int i = 0; i < N; i++) {
			answer[N - i - 1] = num_list[i];
		}
		return answer;
	}
}

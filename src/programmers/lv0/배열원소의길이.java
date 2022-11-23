package programmers.lv0;

public class 배열원소의길이 {

	public int[] solution(String[] strlist) {
		int N = strlist.length;
		int[] answer = new int[N];
		for (int i = 0; i < N; i++)
			answer[i] = strlist[i].length();
		return answer;
	}
}

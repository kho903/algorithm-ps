package programmers.lv0;

public class 잘라서배열로저장하기 {

	public String[] solution(String my_str, int n) {
		int N = my_str.length() / n;
		if (my_str.length() % n > 0) N++;
		String[] answer = new String[N];

		int cnt = 0;
		int idx = 0;
		while (cnt < my_str.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = cnt; i < cnt + n; i++) {
				if (i >= my_str.length()) break;
				sb.append(my_str.charAt(i));
			}
			answer[idx] = sb.toString();
			idx++;
			cnt += n;
		}
		return answer;
	}
}

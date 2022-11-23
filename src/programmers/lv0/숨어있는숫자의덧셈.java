package programmers.lv0;

public class 숨어있는숫자의덧셈 {

	public int solution(String my_string) {
		int answer = 0;
		my_string = my_string.replaceAll("[a-zA-Z]", " ");
		String[] sp = my_string.split(" ");
		for (String s : sp) {
			if (!s.isBlank()) {
				answer += Integer.parseInt(s);
			}
		}
		return answer;
	}
}

package programmers.lv0;

public class 대문자와소문자 {
	public String solution(String my_string) {
		StringBuilder answer = new StringBuilder();
		for (char c : my_string.toCharArray()) {
			if (65 <= c && c <= 90)
				answer.append((char)(c + 32));
			else answer.append((char)(c - 32));
		}
		return answer.toString();
	}
}

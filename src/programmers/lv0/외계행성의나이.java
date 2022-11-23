package programmers.lv0;

import java.util.Map;

public class 외계행성의나이 {
	public String solution(int age) {
		StringBuilder answer = new StringBuilder();
		String str = String.valueOf(age);
		for (int ch : str.toCharArray()) {
			answer.append((char)(ch + 49));
		}
		return answer.toString();

	}
}

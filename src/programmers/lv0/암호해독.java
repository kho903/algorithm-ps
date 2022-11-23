package programmers.lv0;

public class 암호해독 {

	public String solution(String cipher, int code) {
		StringBuilder answer = new StringBuilder();
		int N = cipher.length();
		for (int i = 0; i < N; i++) {
			if ((i + 1) % code == 0) answer.append(cipher.charAt(i));
		}
		return answer.toString();
	}
}

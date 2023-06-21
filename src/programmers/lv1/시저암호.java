package programmers.lv1;

public class 시저암호 {

	public String solution(String s, int n) {
		StringBuilder answer = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				if ((c + n) > 90) answer.append((char)(c + n - 26));
				else answer.append((char)(c + n));
			} else if (Character.isLowerCase(c)) {
				if ((c + n) > 122) answer.append((char)(c + n - 26));
				else answer.append((char)(c + n));
			} else answer.append(c);
		}
		return answer.toString();
	}

	public String solution2(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(push(c, n));
		}
		return sb.toString();
	}

	private char push(char c, int n) {
		if (!Character.isAlphabetic(c)) return c;

		int offset = Character.isUpperCase(c) ? 'A' : 'a';
		int position = c - offset;
		position = (position + n) % ('Z' - 'A' + 1);
		return (char) (offset + position);
	}
}

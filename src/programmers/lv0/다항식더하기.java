package programmers.lv0;

public class 다항식더하기 {
	public static void main(String[] args) {
		다항식더하기 s = new 다항식더하기();
		System.out.println(s.solution("3x + 7 + x"));
		System.out.println(s.solution("x + x + x"));
	}

	public String solution(String polynomial) {
		String answer = "";
		String[] str = polynomial.split(" \\+ ");
		int x = 0;
		int num = 0;
		for (String s : str) {
			if (s.contains("x")) {
				if (s.length() == 1) x += 1;
				else
					x += Integer.parseInt(s.substring(0, s.length() - 1));

			} else num += Integer.parseInt(s);
		}
		if (x == 1) answer += "x";
		else if (x != 0) answer += x + "x";

		if (answer.length() > 0 && num != 0) answer += (" + " + num);
		else if (num!= 0) answer += num;

		return answer;
	}
}

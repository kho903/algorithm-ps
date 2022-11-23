package programmers.lv0;

public class OX퀴즈 {

	public String[] solution(String[] quiz) {
		int N = quiz.length;
		String[] answer = new String[N];
		for (int i = 0; i < N; i++) {
			String[] split = quiz[i].split(" = | ");
			if (split[1].equals("+")) {
				int calc = Integer.parseInt(split[0]) + Integer.parseInt(split[2]);
				if (calc == Integer.parseInt(split[3])) {
					answer[i] = "O";
				} else answer[i] = "X";
			} else {
				int calc = Integer.parseInt(split[0]) - Integer.parseInt(split[2]);
				if (calc == Integer.parseInt(split[3])) {
					answer[i] = "O";
				} else answer[i] = "X";
			}
		}
		return answer;
	}
}

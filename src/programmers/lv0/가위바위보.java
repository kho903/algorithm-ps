package programmers.lv0;

public class 가위바위보 {

	public String solution(String rsp) {
		StringBuilder answer = new StringBuilder();
		for (char c : rsp.toCharArray()) {
			if (c == '0') answer.append(5);
			if (c == '2') answer.append(0);
			if (c == '5') answer.append(2);
		}

		return answer.toString();
	}
}

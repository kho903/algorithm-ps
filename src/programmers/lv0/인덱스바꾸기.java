package programmers.lv0;

public class 인덱스바꾸기 {

	public String solution(String my_string, int num1, int num2) {
		StringBuilder answer = new StringBuilder();
		int N = my_string.length();
		for (int i = 0; i < N; i++) {
			if (i == num1)
				answer.append(my_string.charAt(num2));
			else if (i == num2)
				answer.append(my_string.charAt(num1));
			else
				answer.append(my_string.charAt(i));
		}
		return answer.toString();
	}
}

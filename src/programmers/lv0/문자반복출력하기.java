package programmers.lv0;

public class 문자반복출력하기 {

	public String solution(String my_string, int n) {
		StringBuilder sb = new StringBuilder();
		int M = my_string.length();
		for (int i = 0; i < M; i++)
			for (int j = 0; j < n; j++)
				sb.append(my_string.charAt(i));

		return sb.toString();
	}
}

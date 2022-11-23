package programmers.lv0;

public class 문자열계산하기 {

	public int solution(String my_string) {
		String[] str = my_string.split(" ");
		int answer = Integer.parseInt(str[0]);
		for (int i = 1; i < str.length; i += 2) {
			if (str[i].equals("+"))
				answer += Integer.parseInt(str[i + 1]);
			else
				answer -= Integer.parseInt(str[i + 1]);
		}
		return answer;
	}
}

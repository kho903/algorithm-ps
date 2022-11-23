package programmers.lv0;

public class 특정문자제거하기 {
	public String solution(String my_string, String letter) {
		StringBuilder answer = new StringBuilder();
		String[] arr = my_string.split(letter);
		for (String str : arr)
			answer.append(str);
		return answer.toString();
	}

	public String solution2(String my_string, String letter) {
		return my_string.replace(letter, "");
	}
}

package programmers.lv0;

import java.util.Arrays;

public class 문자열정렬하기2 {
	public String solution(String my_string) {
		char[] ch = my_string.toLowerCase().toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
}

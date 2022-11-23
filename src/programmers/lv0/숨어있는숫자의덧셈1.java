package programmers.lv0;

import java.util.ArrayList;
import java.util.Arrays;

public class 숨어있는숫자의덧셈1 {

	public int solution(String my_string) {
		int answer = 0;
		char[] ch = my_string.toCharArray();

		for (char c : ch)
			if (Character.isDigit(c))
				answer += Character.getNumericValue(c);
		return answer;
	}
}

package programmers.lv0;

import java.util.ArrayList;
import java.util.Arrays;

public class 문자열정렬하기1 {

	public int[] solution(String my_string) {
		ArrayList<Integer> arr = new ArrayList<>();

		char[] ch = my_string.toCharArray();
		for (char c : ch)
			if (Character.isDigit(c))
				arr.add(Character.getNumericValue(c));
		int N = arr.size();
		int[] answer = new int[N];
		for (int i = 0; i < N; i++)
			answer[i] = arr.get(i);
		Arrays.sort(answer);
		return answer;
	}
}

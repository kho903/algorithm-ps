package programmers.lv2;

import java.util.*;

public class 모음사전 {

	static String[] str;
	static List<String> arr;

	public int solution(String word) {
		int answer = 0;

		str = new String[] {"A", "E", "I", "O", "U"};
		arr = new ArrayList<>();
		makeWord("", 0);

		for (int i = 1; i < arr.size(); i++) {
			if (word.equals(arr.get(i))) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	static void makeWord(String make, int len) {
		arr.add(make);
		if (len == 5) return;
		for (String s : str) {
			makeWord(make + s, len + 1);
		}
	}

}

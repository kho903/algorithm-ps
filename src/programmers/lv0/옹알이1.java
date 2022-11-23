package programmers.lv0;

public class 옹알이1 {

	public int solution(String[] babbling) {
		String[] pron = new String[] {"aya", "ye", "woo", "ma"};
		int answer = 0;

		for (String str : babbling) {
			for (int i = 0; i < 4; i++) {
				str = str.replace(pron[i], " ");
			}
			if (str.isBlank()) answer++;
		}
		return answer;
	}
}

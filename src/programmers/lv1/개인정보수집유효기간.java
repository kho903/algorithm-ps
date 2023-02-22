package programmers.lv1;

import java.util.*;

public class 개인정보수집유효기간 {
	public int[] solution(String today, String[] terms, String[] privacies) {
		ArrayList<Integer> arr = new ArrayList<>();
		String[] todaySplit = today.split("\\.");
		int[] intToday = new int[3];
		for (int i = 0; i < 3; i++) {
			intToday[i] = Integer.parseInt(todaySplit[i]);
		}
		Map<String, Integer> termMap = new HashMap<>();
		for (String str : terms) {
			String[] strS = str.split(" ");
			termMap.put(strS[0], Integer.parseInt(strS[1]));
		}
		int N = privacies.length;
		for (int i = 0; i < N; i++) {
			String[] privacy = privacies[i].split(" ");
			int month = termMap.get(privacy[1]);

			String[] startDate =  privacy[0].split("\\.");
			int[] startDateInt = new int[3];
			for (int j = 0; j < 3; j++) {
				startDateInt[j] = Integer.parseInt(startDate[j]);
			}
			startDateInt[1] += month;
			startDateInt[2] -= 1;
			while (startDateInt[1] > 12) {
				startDateInt[0] += 1;
				startDateInt[1] -= 12;
			}
			while (startDateInt[2] == 0) {
				startDateInt[1] -= 1;
				startDateInt[2] = 28;
				if (startDateInt[1] == 0) {
					startDateInt[0] -= 1;
					startDateInt[1] = 12;
				}
			}

			// 검증
			boolean flag = false;
			if (intToday[0] > startDateInt[0]) {
				flag = true;
			} else if (intToday[0] == startDateInt[0]) {
				if (intToday[1] > startDateInt[1]) flag = true;
				else if (intToday[1] == startDateInt[1]) {
					if (intToday[2] > startDateInt[2]) flag = true;
				}
			}

			if (flag) arr.add(i + 1);
		}
		int M = arr.size();
		int[] answer = new int[M];
		for (int i = 0; i < M; i++) answer[i] = arr.get(i);
		return answer;
	}
}
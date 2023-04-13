package inflearn.해싱_시간파싱.문서도난;

import java.util.*;

public class Solution {
	public String[] solution(String[] reports, String times) {
		String[] answer = {};
		int N = reports.length;
		String[][] repo = new String[N][2];

		for (int i = 0; i < N; i++) {
			String[] s = reports[i].split(" ");
			repo[i][0] = s[0];
			repo[i][1] = s[1];
		}
		Arrays.sort(repo, (o1, o2) -> CharSequence.compare(o1[1], o2[1]));

		List<String> arr = new ArrayList<>();

		for (String[] strings : repo) {
			if (checkTime(strings[1], times)) arr.add(strings[0]);
		}

		return arr.toArray(new String[0]);
	}

	public boolean checkTime(String forCheck, String time) {
		String[] timeArr = time.split(" ");
		if (0 <= forCheck.compareTo(timeArr[0]) && forCheck.compareTo(timeArr[1]) <= 0) return true;
		return false;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(
			T.solution(new String[] {"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"},
				"08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(
			new String[] {"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23",
				"john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(
			T.solution(new String[] {"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"},
				"14:20 15:20")));
	}
}
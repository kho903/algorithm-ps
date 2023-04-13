package inflearn.해싱_시간파싱.경고메일;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public String[] solution(String[] reports, int time) {

		List<String> answer = new ArrayList<>();

		int N = reports.length;
		String[][] rep = new String[N][3];
		for (int i = 0; i < N; i++) {
			String[] s = reports[i].split(" ");
			rep[i] = s;
		}
		Map<String, String> map = new HashMap<>();
		Map<String, Integer> timeMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (!map.containsKey(rep[i][0])) {
				map.put(rep[i][0], rep[i][1]);
			} else {
				String inTime = map.get(rep[i][0]);
				String outTime = rep[i][1];
				String[] in = inTime.split(":");
				String[] out = outTime.split(":");
				timeMap.put(rep[i][0], timeMap.getOrDefault(rep[i][0], 0) + (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60 + (Integer.parseInt(out[1]) - Integer.parseInt(in[1])));
				map.remove(rep[i][0]);
			}
		}
		for (String s : timeMap.keySet()) {
			if (timeMap.get(s) > time) answer.add(s);
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	private boolean check(String inTime, String outTime, int time) {
		String[] in = inTime.split(":");
		String[] out = outTime.split(":");
		int calc = (Integer.parseInt(out[0]) - Integer.parseInt(in[0])) * 60 + (Integer.parseInt(out[1]) - Integer.parseInt(in[1]));
		return calc > time;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(
			new String[] {"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in",
				"john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
		System.out.println(Arrays.toString(T.solution(
			new String[] {"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in",
				"john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
		System.out.println(Arrays.toString(T.solution(
			new String[] {"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out",
				"luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
		System.out.println(Arrays.toString(T.solution(
			new String[] {"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in",
				"emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
	}
}

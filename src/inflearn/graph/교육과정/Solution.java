package inflearn.graph.교육과정;

import java.util.*;

public class Solution {
	public String[] solution(String[] subjects, String[] course) {
		int N = subjects.length;
		Map<String, Integer> subjectMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
			subjectMap.put(subjects[i], i);
		}
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < N; i++){
			graph.add(new ArrayList<>());
		}

		int[] degree = new int[N];
		for (String x : course) {
			String[] s = x.split(" ");
			int a = subjectMap.get(s[0]);
			int b = subjectMap.get(s[1]);
			graph.get(b).add(a);
			degree[a]++;
		}

		ArrayList<Integer> order = new ArrayList<>();
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (degree[i] == 0) queue.offer(i);
		}

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();
			order.add(poll);
			for (Integer x : graph.get(poll)) {
				degree[x]--;
				if (degree[x] == 0) queue.offer(x);
			}
		}

		String[] answer = new String[N];
		for (int i = 0; i < N; i++) {
			int idx = order.get(i);
			answer[i] = subjects[idx];
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[] {"english", "math", "physics", "art", "music"},
			new String[] {"art math", "physics art", "art music", "physics math", "english physics"})));
		System.out.println(Arrays.toString(T.solution(new String[] {"art", "economics", "history", "chemistry"},
			new String[] {"chemistry history", "economics history", "art economics"})));
		System.out.println(Arrays.toString(T.solution(new String[] {"math", "science", "music", "biology"},
			new String[] {"science music", "math music", "math science", "biology math"})));
	}
}

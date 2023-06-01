package programmers.lv3;

import java.util.*;

public class 보석쇼핑 {
	public int[] solution(String[] gems) {
		Set<String> set = new HashSet<>(Arrays.asList(gems));
		int N = gems.length;
		int num = set.size();
		if (num == 1)
			return new int[] {1, 1};
		Map<String, Integer> map = new HashMap<>();
		int s = 0;
		int e = 0;
		map.put(gems[0], 1);
		ArrayList<Node> arr = new ArrayList<>();
		while (s < N && e < N) {
			if (map.size() == num) {
				arr.add(new Node(s, e));
				map.put(gems[s], map.get(gems[s]) - 1);
				if (map.get(gems[s]) == 0)
					map.remove(gems[s]);
				s++;
			}

			if (map.size() < num) {
				if (e + 1 >= N)
					break;
				e++;
				map.put(gems[e], map.getOrDefault(gems[e], 0) + 1);
			}
		}

		arr.sort(Node::compareTo);
		return new int[] {arr.get(0).start + 1, arr.get(0).end + 1};
	}

	static class Node implements Comparable<Node> {
		int start;
		int end;
		int len;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
			this.len = end - start;
		}

		@Override
		public int compareTo(Node o) {
			if (this.len == o.len) {
				return this.start - o.start;
			}
			return this.len - o.len;
		}
	}
}

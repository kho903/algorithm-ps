package programmers.lv2;

import java.util.*;

public class 연속된부분수열의합 {
	public int[] solution(int[] sequence, int k) {
		if (sequence[0] == k) return new int[] {0, 0};
		int s = 0;
		int e = 0;
		int cur = sequence[0];
		int N = sequence.length;
		ArrayList<Node> arr = new ArrayList<>();
		while (s < N && e < N) {
			if (cur == k) arr.add(new Node(s, e));

			if (cur <= k) {
				e++;
				if (e < N) cur += sequence[e];
			} else {
				cur -= sequence[s];
				s++;
			}
		}
		arr.sort(Node::compareTo);
		return new int[] {arr.get(0).start, arr.get(0).end};
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
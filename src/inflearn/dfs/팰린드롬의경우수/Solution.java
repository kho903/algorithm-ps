package inflearn.dfs.팰린드롬의경우수;

import java.util.*;

public class Solution {
	static boolean[] check;
	static Set<String> answer;
	static int N;
	public String[] solution(String s) {
		answer = new HashSet<>();
		N = s.length();
		check = new boolean[N];
		dfs(0, "", s);

		return answer.toArray(new String[0]);
	}

	private void dfs(int L, String tmp, String s) {
		if (L == N) {
			if (isPalin(tmp)) {
				answer.add(tmp);
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!check[i] && isPalin(tmp + s.charAt(i))) {
				check[i] = true;
				dfs(L + 1, tmp + s.charAt(i), s);
				check[i] = false;
			}
		}
	}

	private boolean isPalin(String tmp) {
		int len = tmp.length();
		if (len <= N/2) return true;
		return tmp.charAt(len - 1) == tmp.charAt(N - len);
	}

	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution("aaaabb")));
		System.out.println(Arrays.toString(T.solution("abbcc")));
		System.out.println(Arrays.toString(T.solution("abbccee")));
		System.out.println(Arrays.toString(T.solution("abbcceee")));
		System.out.println(Arrays.toString(T.solution("ffeffaae")));
	}
}
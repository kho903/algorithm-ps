package boj.greedy._1092;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		List<Integer> crane = new ArrayList<>();
		List<Integer> box = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crane.add(Integer.parseInt(stk.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(stk.nextToken()));
		}

		crane.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());
		if (crane.get(0) < box.get(0)) {
			System.out.println(-1);
			return;
		}
		int ans = 0;
		while (!box.isEmpty()) {
			int boxI = 0;
			int craneI = 0;

			while (craneI < N) {
				if (boxI == box.size()) break;
				else if (crane.get(craneI) >= box.get(boxI)) {
					box.remove(boxI);
					craneI++;
				} else boxI++;
 			}
			ans++;
		}
		System.out.println(ans);
	}
}

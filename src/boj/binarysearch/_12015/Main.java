package boj.binarysearch._12015;

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		List<Integer> list = new ArrayList<>();
		list.add(0);
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(stk.nextToken());
			arr[i] = value;
			if (value > list.get(list.size() - 1)) list.add(value);
			else {
				int s = 0;
				int l = list.size() - 1;
				while (s < l) {
					int m = (s + l) / 2;
					if (list.get(m) >= value)
						l = m;
					else s = m + 1;
				}
				list.set(l, value);
			}
		}
		System.out.println(list.size() - 1);
	}
}

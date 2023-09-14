package boj.string._4358;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new TreeMap<>();
		int cnt = 0;
		String s = "";
		while ((s = br.readLine()) != null && !s.equals("")) {
			// if (s.equals("")) break;
			cnt++;
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		StringBuilder sb = new StringBuilder();

		for (String key : map.keySet()) {
			sb.append(key).append(' ');
			Integer x = map.get(key);
			sb.append(String.format("%.4f", (double)x * 100 / (double)cnt)).append('\n');
		}
		System.out.print(sb);
	}
}

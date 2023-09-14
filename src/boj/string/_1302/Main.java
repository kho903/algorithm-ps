package boj.string._1302;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		int max = 0;
		for (String key : map.keySet()) {
			max = Math.max(map.get(key), max);
		}
		for (String key : map.keySet()) {
			if (map.get(key) == max) {
				System.out.println(key);
				break;
			}
		}
	}
}

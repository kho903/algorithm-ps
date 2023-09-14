package boj.string._25206;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 20;
		double allHakjum = 0.0;
		Map<String, Double> scoreMap = putScoreMap();

		double allScore = 0;

		while (N-- > 0) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			stk.nextToken();
			double hakjum = Double.parseDouble(stk.nextToken());
			String score = stk.nextToken();
			if (!score.equals("P")) {
				allHakjum += hakjum;
				allScore += hakjum * scoreMap.get(score);
			}
		}

		System.out.println(allScore / allHakjum);
	}

	private static Map<String, Double> putScoreMap() {
		Map<String, Double> scoreMap = new HashMap<>();
		scoreMap.put("A+", 4.5);
		scoreMap.put("A0", 4.0);
		scoreMap.put("B+", 3.5);
		scoreMap.put("B0", 3.0);
		scoreMap.put("C+", 2.5);
		scoreMap.put("C0", 2.0);
		scoreMap.put("D+", 1.5);
		scoreMap.put("D0", 1.0);
		scoreMap.put("F", 0.0);
		return scoreMap;
	}
}

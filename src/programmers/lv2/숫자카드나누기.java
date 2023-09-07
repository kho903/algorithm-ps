package programmers.lv2;

import java.util.*;

public class 숫자카드나누기 {

	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int N = arrayA.length;
		List<Integer> ansList = new ArrayList<>();
		int gcdA = 0;
		int gcdB = 0;
		if (N != 1) {
			gcdA = getGcd(arrayA, N, gcdA);
			gcdB = getGcd(arrayB, N, gcdB);
		} else {
			gcdA = arrayA[0];
			gcdB = arrayB[0];
		}

		calc(arrayB, gcdA, ansList);
		calc(arrayA, gcdB, ansList);

		if (ansList.size() > 0)
			return Collections.max(ansList);
		return answer;
	}

	private int getGcd(int[] array, int N, int gcd) {
		int a = array[0];
		for (int i = 1; i < N; i++) {
			if (i == N - 1)
				gcd = gcd(a, array[i]);
			else
				a = gcd(a, array[i]);
		}
		return gcd;
	}

	public void calc(int[] array, int gcd, List<Integer> ansList) {
		if (gcd != 1) {
			List<Integer> gcdList = get약수(gcd);
			for (Integer g : gcdList) {
				boolean flag = true;
				for (int x : array) {
					if (x % g == 0) {
						flag = false;
						break;
					}
				}
				if (flag) ansList.add(g);
			}
		}
	}

	public int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return gcd(b, a % b);
		}
	}

	private List<Integer> get약수(int gcdA) {
		List<Integer> gcdAlist = new ArrayList<>();
		for (int i = 2; i <= gcdA; i++) {
			if (gcdA % i == 0) gcdAlist.add(i);
		}
		return gcdAlist;
	}
}

package softeer.lv2._8단변속기;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		for (int i = 0; i < 8; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}
		int x = 1;
		boolean ascendFlag = true;
		for (int i = 0; i < 8; i++) {
			if (arr[i] != x) {
				ascendFlag = false;
				break;
			}
			x++;
		}
		x = 8;
		boolean descendFlag = true;
		for (int i = 0; i < 8; i++) {
			if (arr[i] != x) {
				descendFlag = false;
				break;
			}
			x--;
		}
		if (ascendFlag)
			System.out.println("ascending");
		else if (descendFlag)
			System.out.println("descending");
		else
			System.out.println("mixed");
	}
}

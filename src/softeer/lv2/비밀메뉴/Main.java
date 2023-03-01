package softeer.lv2.비밀메뉴;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		int k = Integer.parseInt(stk.nextToken());
		String str = br.readLine();
		String button = br.readLine();
		if (button.contains(str))
			System.out.println("secret");
		else
			System.out.println("normal");
	}
}

package softeer.lv1.근무시간;

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws IOException
	{
		int answer = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 5; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			String[] start = stk.nextToken().split(":");
			int s = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
			String[] finish = stk.nextToken().split(":");
			int f = Integer.parseInt(finish[0]) * 60 + Integer.parseInt(finish[1]);
			answer += f - s;
		}
		System.out.println(answer);
	}
}

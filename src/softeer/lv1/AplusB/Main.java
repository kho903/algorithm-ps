package softeer.lv1.AplusB;
import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(stk.nextToken());
		for (int i = 1; i <= T; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			sb.append("Case #").append(i).append(": ").append(a + b).append("\n");
		}
		System.out.println(sb);
	}
}

package softeer.lv1.주행거리비교하기;

import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		if (a == b) System.out.println("same");
		else if (a > b) System.out.println("A");
		else System.out.println("B");
	}
}
package boj.ds_stack._10799;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int N = arr.length;
        int ans = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            char ch = arr[i];
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                stack.pop();
                if (arr[i - 1] == '(') {
                    ans += stack.size();
                } else ans++;
            }
        }
        System.out.println(ans);
    }

}

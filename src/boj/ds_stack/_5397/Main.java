package boj.ds_stack._5397;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] arr = br.readLine().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : arr) {
                switch (c) {
                    case '<':
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default: left.push(c);
                }
            }

            while (!left.isEmpty())
                right.push(left.pop());
            while (!right.isEmpty())
                sb.append(right.pop());
            sb.append('\n');
        }
        System.out.print(sb);
    }

}

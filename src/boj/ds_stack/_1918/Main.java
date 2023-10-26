package boj.ds_stack._1918;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if ('A' <= ch && ch <= 'Z' ) sb.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop == '(') break;
                    sb.append(pop);
                }
            } else { // 연산자
                while (!stack.isEmpty() && checkPriority(stack.peek()) >= checkPriority(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int checkPriority(char ch) {
        if (ch == '(' || ch == ')') return 0;
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return -1;
    }

}

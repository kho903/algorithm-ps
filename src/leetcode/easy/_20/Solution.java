package leetcode.easy._20;

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') stack.push(c);
            else if (stack.isEmpty()) return false;
            else if (c == ')') {
                if (stack.peek() != '(') return false;
                stack.pop();
            } else if (c == '}') {
                if (stack.peek() != '{') return false;
                stack.pop();
            } else if (c == ']') {
                if (stack.peek() != '[') return false;
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}

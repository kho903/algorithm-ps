package leetcode.medium._22;

import java.util.*;

class Solution {
    static List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        solve("(", n - 1, n);
        return ans;
    }

    void solve(String cur, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(cur);
            return;
        }

        if (open > 0) solve(cur + "(", open - 1, close);
        if (close > open) solve(cur + ")", open, close - 1);
    }
}
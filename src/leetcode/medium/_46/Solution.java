package leetcode.medium._46;

import java.util.*;

class Solution {

    static int N;
    static List<List<Integer>> ans;

    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        N = nums.length;
        backtrack(nums, new ArrayList<>());
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> tmp) {
        if (tmp.size() == N) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int x : nums) {
            if (tmp.contains(x)) continue;

            tmp.add(x);
            backtrack(nums, tmp);
            tmp.remove((Integer) x);
        }
    }
}

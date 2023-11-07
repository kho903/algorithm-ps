package leetcode.medium._78;

import java.util.*;

class Solution {

    static int N;
    static List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        N = nums.length;
        backtracking(nums, new ArrayList<Integer>(), 0);
        return ans;
    }

    void backtracking(int[] nums, List<Integer> arr, int s) {
        ans.add(new ArrayList<>(arr));
        for (int i = s; i < N; i++) {
            arr.add(nums[i]);
            backtracking(nums, arr, i + 1);
            arr.remove(arr.size() - 1);
        }
    }
}

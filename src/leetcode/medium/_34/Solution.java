package leetcode.medium._34;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int N = nums.length;
        int[] ans = {-1, -1};
        int l = 0;
        int r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                if (nums[m] == target) {
                    ans[0] = m;
                }
                r = m - 1;
            }
        }
        l = 0;
        r = N - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] > target) {
                r = m - 1;
            }  else {
                if (nums[m] == target) {
                    ans[1] = m;
                }
                l = m + 1;
            }
        }
        return ans;
    }
}

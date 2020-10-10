/*
 * @lc app=leetcode id=209 lang=java
 *
 * [209] Minimum Size Subarray Sum
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        int ans = nums.length;
        int sum = 0;
        // 1. 先求数组之和，如果小于s，则返回0；
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        if (sum < s) {
            return 0;
        }

        // 2. 然后找最短的和
        sum = 0;
        int left = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
            // 当sum>=s后，减去左侧的元素，直到sum < s。
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return ans;
    }
}
// @lc code=end


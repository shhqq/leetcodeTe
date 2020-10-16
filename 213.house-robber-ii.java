/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        return solution1(nums);
    }

    /**
     * 第一种方法：
     * 因为首尾相连构成环，所以分为包含首不包含尾、不包含首但包含尾两种。
     * 再求最大值就可以。
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        // 如果只有一个元素，那么就返回这个元素
        if (nums.length == 1) return nums[0];

        int prev1 = 0, prev2 = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }

        int ans1 = prev1;
        prev1 = 0;
        prev2 = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + nums[i]);
            prev2 = temp;
        }

        return prev1 > ans1 ? prev1 : ans1;

    }
}
// @lc code=end


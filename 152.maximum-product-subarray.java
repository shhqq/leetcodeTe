/*
 * @lc app=leetcode id=152 lang=java
 *
 * [152] Maximum Product Subarray
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        return solution1(nums);
    }
    private int solution1(int[] nums) {
        int r = nums[0];
        for (int i = 1, imax = r, imin = r; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            

            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);

            r = Math.max(r, imax);
        }
        return r;
    }
}
// @lc code=end


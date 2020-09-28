/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int middle = (left + right)/2;
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }
}
// @lc code=end


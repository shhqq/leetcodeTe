/*
 * @lc app=leetcode id=153 lang=java
 *
 * [153] Find Minimum in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) {
            return nums[0];
        }

        int left = 0, right = n-1;
        int middle = (left + right) / 2;
        while (left < middle) {
            if (nums[middle] < nums[left]) {
                right = middle;
            } else {
                left = middle;
            }

            middle = (left + right) / 2;
        }
        return nums[left] > nums[right] ? nums[right]: nums[left];
    }
}
// @lc code=end


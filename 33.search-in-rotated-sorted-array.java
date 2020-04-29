/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        } else {
            int left = 0;
            int right = nums.length - 1;
            int middle = (left + right) / 2;
            while (left < middle) {
                if (nums[middle] == target) {
                    return middle;
                } else if (nums[left] < nums[middle]) {     // 左侧是递增的
                    if (nums[middle] > target && nums[left] <= target) {
                        right = middle;
                        middle = (left + right) / 2;
                    } else {
                        left = middle;
                        middle = (left + right) / 2;
                    }
                } else if (nums[left] > nums[middle]) {     // 右侧是递增的
                    if (nums[middle] < target && nums[right] >= target) {
                        left = middle;
                        middle = (left + right) / 2;
                    } else {
                        right = middle;
                        middle = (left + right) / 2;
                    }
                }
            }
            if (nums[middle] == target) {
                return middle;
            } else if(nums[right] == target) {
                return right;
            } else {
                return -1;
            }
        }
    }
}
// @lc code=end

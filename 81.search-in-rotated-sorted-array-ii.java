/*
 * @lc app=leetcode id=81 lang=java
 *
 * [81] Search in Rotated Sorted Array II
 */

// @lc code=start
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0){
            return false;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (left != mid){
            if (nums[mid] == target || nums[left] == target || nums[right] == target){
                return true;
            } else if (nums[mid] > nums[0]){   // 左侧为递增数列，右侧的值要么>=nums[mid]，要么<=nums[left]
                if (target > nums[left] && target < nums[mid]){ // 如果在左侧递增的区间内
                    right = mid;
                    
                } else {                                        // 不在左侧递增区间内
                    left = mid;
                }
                mid = (left + right) / 2;
            } else if (nums[mid] < nums[right]){    // 右侧为递增，左侧的值要么<=nums[mid],要么>=nums[right]
                if (target > nums[mid] && target < nums[right]){    // 位于右侧递增区间内
                    left = mid;
                } else {                                            // 不位于右侧递增区间内。
                    right = mid;
                }
                mid = (left + right) / 2;
            } else {                                // 如果不能确定，那么就让两边缩进
                left++;
                right--;
            }
        }
        return nums[mid] == target || nums[right] == target;
    }
}
// @lc code=end


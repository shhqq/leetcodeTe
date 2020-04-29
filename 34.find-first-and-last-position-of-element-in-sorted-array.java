/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        /**
         * It can be divided to two steps:
         * Firstly, find the far left element.
         * Secondly, find the far right element.
         * 
         * The time complexity of every step is O(logn), so the whole time
         * complexity is also O(logn).
         */
        int[] ans = {-1, -1};
        if (nums.length == 0){
            return ans;
        } else {
            // 找到最左侧的
            int left = 0;
            int right = nums.length - 1;
            int middle = (left + right) / 2;
            while (left < middle){
                if(nums[middle] >= target){
                    right = middle;
                    middle = (left + right) / 2;
                } else {
                    left = middle;
                    middle = (left + right) / 2;
                }
            }
            if(nums[middle] == target){
                ans[0] = middle;
            } else if(nums[right] == target){
                ans[0] = right;
            } else {
                return ans;
            }

            // 找到最右侧的
            left = 0;
            right = nums.length - 1;
            middle = (left + right) / 2;
            while (left < middle){
                if(nums[middle] > target){
                    right = middle;
                    middle = (left + right) / 2;
                } else {
                    left = middle;
                    middle = (left + right) / 2;
                }
            }
            if(nums[right] == target){
                ans[1] = right;
            } else if(nums[middle] == target){
                ans[1] = middle;
            } else {
                return ans;
            }
            return ans;
        }
    }
}
// @lc code=end


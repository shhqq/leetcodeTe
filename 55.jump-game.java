/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
    /*
    // 递归太浪费时间了
        return canJump(nums, nums.length - 1);
    }
    private boolean canJump(int[] nums, int end){
        if(end == 0){
            return true;
        } else {
            for(int i = 0; i < end; i++){
                if(nums[i] >= end - i && canJump(nums, i)){
                    return true;
                }
            }
        }
        return false;
    }
    */

        /**
         * 使用动态规划，避免使用递归。
         * 使用一个数组来保存中间结果，可以避免使用递归
         * 
         */
        int lastPosition = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(i + nums[i] >= lastPosition){
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
// @lc code=end


import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

// @lc code=start
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * 1. 使用暴力法
         * 2. 遍历第一个元素，然后用两个指针指向该元素后面的元素前后，
         * 找到最接近的值。
         */
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int start = 1;
        int end = 2;

        for(int i = 0; i < nums.length - 2; i++){       // 遍历第一个元素
            start = i+1;
            end = nums.length-1;
            int t = target - nums[i];

            while(start < end){
                int d = t - nums[start] - nums[end];
                if(d < 0 && end - start > 1){           // 如果大了，就把右边的向左移动
                    end--;
                    int sum = nums[i] + nums[start] + nums[end];
                    ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
                } else if(d > 0 && end - start > 1){    // 小了，就把左边的向右移动
                    start++;
                    int sum = nums[i] + nums[start] + nums[end];
                    ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
                }else {
                    break;
                }
            }

            int sum = nums[i] + nums[start] + nums[end];
            ans = Math.abs(target - sum) < Math.abs(target - ans) ? sum : ans;
            if(ans == target){
                break;
            }
        }
        return ans;

        // brute force
        /*
        int distance = (int)Math.pow(2, 31);
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(Math.abs(target - nums[i] - nums[j] - nums[k]) < distance){
                        ans = nums[i] + nums[j] + nums[k];
                        distance = Math.abs(target - nums[i] - nums[j] - nums[k]);
                    }
                }
            }
        }
        return ans;
         // */
    }
}
// @lc code=end


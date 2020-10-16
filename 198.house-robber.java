/*
 * @lc app=leetcode id=198 lang=java
 *
 * [198] House Robber
 */

// @lc code=start
class Solution {
    public int rob(int[] nums) {
        return solution1(nums);
    }

    /**
     * 第一种方法：
     * 递归方法最为直接。
     * 使用递归，从后往前，即Top-down。
     * 需要一个帮助函数，来执行递归操作。
     * @param nums
     * @return
     */
    private int solution1(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int[] memo = new int[len + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;       // 全都初始化为-1，便于后续判断
        }
        return helper(memo, nums, len-1);
    }
    private int helper(int[] memo, int[] nums, int i) {
        if (i < 0) return 0;
        // 如果这个中间结果已经计算过了，那么就直接返回，避免重复计算
        if (memo[i] >= 0) return memo[i];       

        int result = Math.max(helper(memo, nums, i-1), helper(memo, nums, i-2) + nums[i]);
        memo[i] = result;
        return result;
    }

    /**
     * 第二种方法：
     * 在第一种方法基础上，因为递归需要额外的消耗，类似斐波那契数列，有一些重复计算。
     * 因此可以使用一个数组来记录中间结果。避免使用递归后，就是从前往后，即Bottom-up。
     * @param nums
     * @return
     */
    private int solution2(int[] nums) {
        if (nums.length == 0) return 0;

        int[] memo = new int[nums.length+1];
        // memo第一个元素设为0，表示初始，第二个元素开始表示nums的前i-1个元素的结果
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            memo[i+1] = Math.max(memo[i-1] + nums[i], memo[i]);
        }
        return memo[nums.length];
    }

    /**
     * 第三种方法：
     * 在第二种方法基础上，看到实际上只使用了数组的两个值，因此
     * 使用两个变量记录这两个值就可以，并不需要全部记录下来。
     * @param nums
     * @return
     */
    private int solution3(int[] nums) {
        int prev1 = 0, prev2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = prev1;
            prev1 = Math.max(prev2 + nums[i], prev1);
            prev2 = temp;
        }
        return prev1;
    }
}
// @lc code=end


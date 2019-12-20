#
# @lc app=leetcode id=198 lang=python3
#
# [198] House Robber
#

# @lc code=start
class Solution:
    def rob(self, nums: List[int]) -> int:
# Solution1 : use the recusion.
# time limit exceeded.
        if len(nums) == 3:
            return max(nums[0] + nums[2], nums[1])
        elif len(nums) == 2:
            return max(nums[0], nums[1])
        elif len(nums) == 1:
            return nums[0]
        elif len(nums) == 0:
            return 0
        else:
            temp1 = nums[0] + self.rob(nums[2: len(nums)])
            temp2 = nums[1] + self.rob(nums[3: len(nums)])
            return max(temp1, temp2)

# Solution2 : use dynamic programming.

# @lc code=end


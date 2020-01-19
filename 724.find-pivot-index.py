#
# @lc app=leetcode id=724 lang=python3
#
# [724] Find Pivot Index
#

# @lc code=start
class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
# Use a variable to record the sum of the first n terms.
        if len(nums) < 1:
            return -1
        sum_nums = sum(nums)
        sum_temp = 0
        for i in range(0, len(nums)):
            if sum_temp == (sum_nums - nums[i]) / 2:
                return i
            sum_temp += nums[i]
        return -1
# @lc code=end


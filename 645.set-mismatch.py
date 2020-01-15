#
# @lc app=leetcode id=645 lang=python3
#
# [645] Set Mismatch
#

# @lc code=start
class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        duplicated = 0
        missed = 0
        for i in nums:
            if nums[abs(i) - 1] < 0:
                duplicated = abs(i)
            else:
                nums[abs(i) - 1] *= -1
        for i in range(len(nums)):
            if nums[i] > 0:
                missed = i+1
        return [duplicated, missed]
# @lc code=end


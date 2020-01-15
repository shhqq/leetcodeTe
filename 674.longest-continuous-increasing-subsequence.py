#
# @lc app=leetcode id=674 lang=python3
#
# [674] Longest Continuous Increasing Subsequence
#

# @lc code=start
class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        max_length = 0
        temp = 0
        for i in range(len(nums)-1):
            if nums[i+1] > nums[i]:
                temp += 1
            else:
                max_length = max(max_length, temp + 1)
                temp = 0
        
        return max(max_length, temp + 1)
# @lc code=end


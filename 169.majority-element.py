#
# @lc app=leetcode id=169 lang=python3
#
# [169] Majority Element
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        singleNums = set(nums)
        maxCount = 0
        majorityNumber = 1
        for i in singleNums:
            temp = nums.count(i)
            if temp > maxCount:
                maxCount = temp
                majorityNumber = i
        return majorityNumber
# @lc code=end


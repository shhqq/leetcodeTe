#
# @lc app=leetcode id=136 lang=python3
#
# [136] Single Number
#

# @lc code=start
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
# solution 1
        # while True:
        #     if len(nums) == 1:
        #         return nums[0]
        #     i = nums[0]
        #     if not i in nums[1:len(nums)]:
        #         return i
        #     else:
        #         nums.remove(i)
        #         nums.remove(i)
# solution 2
        # if len(nums) == 1:
        #     return nums[0]
        # nums.sort()
        # i = 0
        # while True:
        #     if i == len(nums) - 1:
        #         return nums[i]
        #     if nums[i] == nums[i + 1]:
        #         i += 2
        #     else:
        #         return nums[i]
# solution 3
        # return 2 * sum(set(nums)) - sum(nums)
# solution 4
        a = 0
        for i in nums:
            a ^= i
        return a

# @lc code=end

